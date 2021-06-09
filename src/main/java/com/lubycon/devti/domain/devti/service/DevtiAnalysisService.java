package com.lubycon.devti.domain.devti.service;

import com.lubycon.devti.domain.answer.entity.AnswerAttribute;
import com.lubycon.devti.global.code.Bias;
import com.lubycon.devti.global.code.Pillar;
import java.util.HashMap;
import java.util.LinkedHashMap;
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

  public Map<Bias, Float> analysisAnswer(List<AnswerAttribute> answerAttributeList) {

    HashMap<Bias, Float> weightMap = initBiasWeightMap();

    for (AnswerAttribute answer : answerAttributeList) {
      float newWeight = weightMap.get(answer.getBias()) + answer.getWeight();
      weightMap.replace(answer.getBias(), newWeight);
    }

    return classifyDevtiByPillar(convertWeightToPercent(weightMap));
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

  public Map<Bias, Float> classifyDevtiByPillar(HashMap<Bias, Float> biasResult) {
    Map<Bias, Float> resultMap = new LinkedHashMap<>();

    for (Pillar pillar : Pillar.values()) {
      Float firstValue = biasResult.get(Bias.valueOf(pillar.biasList.get(0)));
      Float secondValue = biasResult.get(Bias.valueOf(Pillar.ROLE.biasList.get(1)));

      //TODO: 5:5일경우
      String key = firstValue > secondValue ? pillar.biasList.get(0) : pillar.biasList.get(1);
      Float value = firstValue > secondValue ? firstValue : secondValue;
      resultMap.put(Bias.valueOf(key), value);
    }

    return resultMap;
  }
}
