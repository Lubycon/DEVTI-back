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

  public HashMap<BiasType, Float> analysisAnswer(List<AnswerAttribute> answerAttributeList) {

    HashMap<BiasType, Float> weightMap = initBiasWeightMap();

    for (AnswerAttribute answer : answerAttributeList) {
      if (!Pillar.REFERENCE.biasList.contains(answer.getBias())) {
        float newWeight = weightMap.get(answer.getBias()) + answer.getWeight();
        weightMap.replace(answer.getBias(), newWeight);
      }
    }

    return convertWeightToPercent(weightMap);
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

    log.info("{}", weightMap.toString());
    return weightMap;
  }

  public HashMap<BiasType, Float> classifyDevtiByPillar(HashMap<BiasType, Float> biasResult) {

    HashMap<BiasType, Float> resultMap = new LinkedHashMap<>();

    for (Pillar pillar : Pillar.values()) {

      if (pillar.equals(Pillar.REFERENCE)) {
        continue;
      }
      Float firstValue = biasResult.get(pillar.biasList.get(0));
      Float secondValue = biasResult.get(pillar.biasList.get(1));

      BiasType key = firstValue > secondValue ? pillar.biasList.get(0) : pillar.biasList.get(1);
      Float value = firstValue > secondValue ? firstValue : secondValue;
      resultMap.put(key, value);

    }

    return resultMap;
  }

}
