package com.lubycon.devti.domain.devti.service;

import com.lubycon.devti.domain.answer.entity.AnswerAttribute;
import com.lubycon.devti.global.code.BiasType;
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

  public Map<BiasType, Float> analysisAnswer(List<AnswerAttribute> answerAttributeList) {

    HashMap<BiasType, Float> weightMap = initBiasWeightMap();

    for (AnswerAttribute answer : answerAttributeList) {
      float newWeight = weightMap.get(answer.getBiasType()) + answer.getWeight();
      weightMap.replace(answer.getBiasType(), newWeight);
    }

    return classifyDevtiByPillar(convertWeightToPercent(weightMap));
  }

  public HashMap<BiasType, Float> initBiasWeightMap() {

    BiasType[] biasTypeArray = BiasType.values();

    HashMap<BiasType, Float> weightMap = new HashMap<>(biasTypeArray.length);
    for (BiasType biasType : biasTypeArray) {
      weightMap.put(biasType, BIAS_CALIBRATION_VALUE);
    }

    return weightMap;
  }

  public HashMap<BiasType, Float> convertWeightToPercent(HashMap<BiasType, Float> weightMap) {
    for (Map.Entry<BiasType, Float> biasWeight : weightMap.entrySet()) {
      weightMap.replace(biasWeight.getKey(), biasWeight.getValue() / PILLAR_TOTAL_WEIGHT * 100);
    }
    return weightMap;
  }

  public Map<BiasType, Float> classifyDevtiByPillar(HashMap<BiasType, Float> biasResult) {
    Map<BiasType, Float> resultMap = new LinkedHashMap<>();

    for (Pillar pillar : Pillar.values()) {
      Float firstValue = biasResult.get(BiasType.valueOf(pillar.biasList.get(0)));
      Float secondValue = biasResult.get(BiasType.valueOf(Pillar.ROLE.biasList.get(1)));

      //TODO: 5:5일경우
      String key = firstValue > secondValue ? pillar.biasList.get(0) : pillar.biasList.get(1);
      Float value = firstValue > secondValue ? firstValue : secondValue;
      resultMap.put(BiasType.valueOf(key), value);
    }

    return resultMap;
  }
}
