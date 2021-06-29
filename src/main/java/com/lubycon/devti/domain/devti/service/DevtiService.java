package com.lubycon.devti.domain.devti.service;

import com.lubycon.devti.domain.advertisement.service.AdvertisementService;
import com.lubycon.devti.domain.answer.entity.Answer;
import com.lubycon.devti.domain.answer.entity.AnswerAttribute;
import com.lubycon.devti.domain.answer.service.AnswerService;
import com.lubycon.devti.domain.bias.entity.Bias;
import com.lubycon.devti.domain.bias.service.BiasService;
import com.lubycon.devti.domain.devti.dao.DevtiRepository;
import com.lubycon.devti.domain.devti.dto.BiasReviewResult;
import com.lubycon.devti.domain.devti.dto.DevtiReqDto;
import com.lubycon.devti.domain.devti.dto.DevtiResDto;
import com.lubycon.devti.domain.devti.entity.Devti;
import com.lubycon.devti.domain.review.dto.ReviewResDto;
import com.lubycon.devti.domain.review.entity.Review;
import com.lubycon.devti.domain.review.service.ReviewService;
import com.lubycon.devti.global.code.BiasType;
import com.lubycon.devti.global.code.Pillar;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class DevtiService {

  private final AnswerService answerService;
  private final DevtiRepository devtiRepository;
  private final DevtiAnalysisService devtiAnalysisService;
  private final AdvertisementService advertisementService;
  private final BiasService biasService;
  private final ReviewService reviewService;

  private final Integer SCALE_PILLAR_REVIEW_TYPE_THRESHOLD = 50;
  private final String SCALE_PILLAR_REVIEW_TYPE_1 = "1";
  private final String SCALE_PILLAR_REVIEW_TYPE_2 = "2";
  private final String DESIRED_JOB_F = "F";
  private final String DESIRED_JOB_B = "B";

  public DevtiReqDto analysisAndCreateDevti(List<AnswerAttribute> answerAttributeList) {
    Answer answer = answerService.createAnswer(answerAttributeList);
    HashMap<BiasType, Integer> biasResult = devtiAnalysisService.analysisAnswer(answerAttributeList);
    HashMap<BiasType, Integer> winBiasResult = devtiAnalysisService.classifyDevtiByPillar(biasResult);
    String job = answerAttributeList.get(40).getSequence() == 0 ? DESIRED_JOB_F : DESIRED_JOB_B;
    createDevti(answer, winBiasResult, biasResult);
    return DevtiReqDto.builder()
        .job(job)
        .result(biasResult.toString())
        .build();
  }

  public DevtiResDto getDevtiByAnswer(HashMap<BiasType, Integer> biasResult, String job) {

    HashMap<BiasType, Integer> winBiasResult = devtiAnalysisService.classifyDevtiByPillar(biasResult);
    String devtiString = getDevtiString(winBiasResult);

    Map<BiasType, String> reviewTypeMap = new HashMap<>();
    Entry<BiasType, String> roleReivewType = getRolePillarReviewType(winBiasResult, job);
    Entry<BiasType, String> scalePillarReviewType = getScalePillarReviewType(winBiasResult);
    reviewTypeMap.put(roleReivewType.getKey(), roleReivewType.getValue());
    reviewTypeMap.put(scalePillarReviewType.getKey(), scalePillarReviewType.getValue());

    Review generalReview = reviewService.findByReviewType(devtiString);

    return DevtiResDto.builder()
        .devti(devtiString)
        .devtiTitle(generalReview.getHeadline())
        .generalReview(new ReviewResDto().toResDto(generalReview))
        .biasResults(getBiasResults(devtiString, biasResult, reviewTypeMap))
        .advertisementList(advertisementService.findAll())
        .build();
  }

  public Entry<BiasType, String> getRolePillarReviewType(HashMap<BiasType, Integer> winBiasResult, String job) {

    Map.Entry<BiasType, Integer> rolePillarBias = winBiasResult.entrySet().stream()
        .filter(bias -> Pillar.ROLE.biasList.contains(bias.getKey())).findFirst()
        .orElse(new AbstractMap.SimpleEntry<>(BiasType.V, 75));

    return new AbstractMap.SimpleEntry<>(rolePillarBias.getKey(), rolePillarBias.getKey() + job);
  }

  public Entry<BiasType, String> getScalePillarReviewType(HashMap<BiasType, Integer> winBiasResult) {

    Map.Entry<BiasType, Integer> scalePillarBias = winBiasResult.entrySet().stream()
        .filter(bias -> Pillar.SCALE.biasList.contains(bias.getKey())).findFirst()
        .orElse(new AbstractMap.SimpleEntry<>(BiasType.S, 75));

    Integer weight = scalePillarBias.getValue();
    String weightType = weight <= SCALE_PILLAR_REVIEW_TYPE_THRESHOLD ? SCALE_PILLAR_REVIEW_TYPE_1 : SCALE_PILLAR_REVIEW_TYPE_2;

    return new AbstractMap.SimpleEntry<>(scalePillarBias.getKey(), scalePillarBias.getKey() + weightType);
  }

  public String getDevtiString(HashMap<BiasType, Integer> biasResult) {

    String devtiString = "";
    for (Map.Entry<BiasType, Integer> biasMap : biasResult.entrySet()) {
      devtiString += biasMap.getKey().toString();
    }

    return devtiString;
  }

  public Devti createDevti(Answer answer, HashMap<BiasType, Integer> winBiasResult, HashMap<BiasType, Integer> biasResult) {
    Devti devti = Devti.builder()
        .answer(answer)
        .devti(getDevtiString(winBiasResult))
        .devtiResult(biasResult.toString())
        .build();

    return devtiRepository.save(devti);
  }

  public List<BiasReviewResult> getBiasResults(String devti, HashMap<BiasType, Integer> biasResult,
      Map<BiasType, String> reviewTypeMap) {

    List<Bias> biasList = biasService.findBiasListByBiasIsNotIn(Pillar.REFERENCE.biasList);
    List<BiasReviewResult> biasReviewResults = new ArrayList<>(8);

    for (Bias bias : biasList) {
      BiasType biasType = bias.getBias();

      boolean winnerBias = devti.indexOf(biasType.toString()) > -1;
      ReviewResDto reviewResDto = null;
      if (winnerBias) {
        String reviewType = reviewTypeMap.get(biasType) == null ? bias.getBias().toString() : reviewTypeMap.get(biasType);
        Review review = reviewService.findByReviewType(reviewType);
        reviewResDto = new ReviewResDto().toResDto(review);
      }

      BiasReviewResult biasReviewResult = BiasReviewResult.builder()
          .bias(bias)
          .review(reviewResDto)
          .weight(biasResult.get(biasType))
          .build();

      biasReviewResults.add(biasReviewResult);
    }

    return biasReviewResults;
  }

}
