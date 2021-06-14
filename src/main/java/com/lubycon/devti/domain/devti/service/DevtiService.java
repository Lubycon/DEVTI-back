package com.lubycon.devti.domain.devti.service;

import com.lubycon.devti.domain.answer.entity.Answer;
import com.lubycon.devti.domain.answer.entity.AnswerAttribute;
import com.lubycon.devti.domain.answer.service.AnswerService;
import com.lubycon.devti.domain.devti.dao.DevtiRepository;
import com.lubycon.devti.domain.devti.entity.Devti;
import com.lubycon.devti.global.code.Bias;
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

  public void getDevtiByAnswer(List<AnswerAttribute> answerAttributeList) {
    Answer answer = answerService.createAnswer(answerAttributeList);
    Map<Bias, Float> biasResult = devtiAnalysisService.analysisAnswer(answerAttributeList);
    String devtiString = "";
    for (Map.Entry<Bias, Float> biasMap : biasResult.entrySet()) {
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

  public Devti createDevti(Devti devti) {
    return devtiRepository.save(devti);
  }

}
