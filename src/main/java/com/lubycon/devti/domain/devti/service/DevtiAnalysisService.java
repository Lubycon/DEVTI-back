package com.lubycon.devti.domain.devti.service;

import com.lubycon.devti.domain.answer.entity.AnswerAttribute;
import com.lubycon.devti.global.code.Bias;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class DevtiAnalysisService {

  private final static float BIAS_CALIBRATION_VALUE = 0F;
  private final static float PILLAR_TOTAL_WEIGHT = 10F;

  public void analysisAnswer(List<AnswerAttribute> answerAttributeList) {

    HashMap<Bias, Float> weightMap = initBiasWeightMap();

    for (AnswerAttribute answer : answerAttributeList) {
      float newWeight = weightMap.get(answer.getBias()) + answer.getWeight();
      weightMap.replace(answer.getBias(), newWeight);
    }

    convertWeightToPercent(weightMap);
    log.info("{}", weightMap.toString());
  }

  public HashMap<Bias, Float> initBiasWeightMap() {

    Bias[] biasArray = Bias.values();

    HashMap<Bias, Float> weightMap = new HashMap<>(biasArray.length);
    for (Bias bias : biasArray) {
      weightMap.put(bias, BIAS_CALIBRATION_VALUE);
    }

    return weightMap;
  }

  public HashMap<Bias, Float> convertWeightToPercent(HashMap<Bias, Float> weightMap) {
    for (Map.Entry<Bias, Float> biasWeight : weightMap.entrySet()) {
      weightMap.replace(biasWeight.getKey(), biasWeight.getValue() / PILLAR_TOTAL_WEIGHT * 100);
    }
    return weightMap;
  }
}
