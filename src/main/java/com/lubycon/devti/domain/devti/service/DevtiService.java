package com.lubycon.devti.domain.devti.service;

import com.lubycon.devti.domain.advertisement.service.AdvertisementService;
import com.lubycon.devti.domain.answer.entity.Answer;
import com.lubycon.devti.domain.answer.entity.AnswerAttribute;
import com.lubycon.devti.domain.answer.service.AnswerService;
import com.lubycon.devti.domain.bias.entity.Bias;
import com.lubycon.devti.domain.bias.service.BiasService;
import com.lubycon.devti.domain.devti.dao.DevtiRepository;
import com.lubycon.devti.domain.devti.dto.BiasResult;
import com.lubycon.devti.domain.devti.dto.DevtiResDto;
import com.lubycon.devti.domain.devti.dto.Review;
import com.lubycon.devti.domain.devti.entity.Devti;
import com.lubycon.devti.global.code.BiasType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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

  public void getDevtiByAnswer(List<AnswerAttribute> answerAttributeList) {
    Answer answer = answerService.createAnswer(answerAttributeList);
    Map<BiasType, Float> biasResult = devtiAnalysisService.analysisAnswer(answerAttributeList);
    String devtiString = "";
    for (Map.Entry<BiasType, Float> biasMap : biasResult.entrySet()) {
      devtiString += biasMap.getKey().toString();
    }

    log.info("{}", devtiString);

    Devti devti = Devti.builder()
        .answer(answer)
        .devti(devtiString)
        .devtiResult(biasResult.toString())
        .build();

    createDevti(devti);
  }

  public DevtiResDto getMockResultResponse() {

    Review review = Review.builder()
        .title("한치의 비뚤어짐도 용납하지 않는 당신!")
        .contents("주위에서 평소 미적인 감각이 탁월하다는 칭찬 또는 평가를 받은 경험이 있습니다.")
        .build();

    List<Bias> biasList = biasService.findAll();
    List<BiasResult> biasResults = new ArrayList<>(8);

    for (Bias bias : biasList) {
      BiasResult biasResult = BiasResult.builder()
          .bias(bias)
          .review("ACLT".indexOf(bias.getBias().toString()) > -1 ? review : null)
          .weight(60)
          .build();

      biasResults.add(biasResult);
    }

    return DevtiResDto.builder()
        .id(1L)
        .devti("ACTL")
        .devtiTitle("열정적인 꿈을 가진 당신은 야망가!")
        .generalReview(review)
        .biasResults(biasResults)
        .advertisementList(advertisementService.findAll())
        .build();
  }

  public Devti createDevti(Devti devti) {
    return devtiRepository.save(devti);
  }

}
