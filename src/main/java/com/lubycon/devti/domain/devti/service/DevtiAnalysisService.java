package com.lubycon.devti.domain.devti.service;

import com.lubycon.devti.domain.answer.entity.AnswerAttribute;
import com.lubycon.devti.domain.bias.entity.Bias;
import com.lubycon.devti.domain.bias.service.BiasService;
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
  private final static Integer PILLAR_TOTAL_WEIGHT = 10;
  private final BiasService biasService;

  public HashMap<BiasType, Integer> analysisAnswer(List<AnswerAttribute> answerAttributeList) {

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

    List<Bias> biasList = biasService.findBiasListByBiasIsNotIn(Pillar.REFERENCE.biasList);

    HashMap<BiasType, Float> weightMap = new HashMap<>(biasList.size());
    for (Bias bias : biasList) {
      weightMap.put(bias.getBias(), BIAS_CALIBRATION_VALUE);
    }

    return weightMap;
  }

  public HashMap<BiasType, Integer> convertWeightToPercent(HashMap<BiasType, Float> weightMap) {

    HashMap<BiasType, Integer> result = new HashMap<>();
    for (Map.Entry<BiasType, Float> biasWeight : weightMap.entrySet()) {
      result.put(biasWeight.getKey(), Math.round(biasWeight.getValue() / PILLAR_TOTAL_WEIGHT * 100));
    }
    return result;
  }

  public HashMap<BiasType, Integer> classifyDevtiByPillar(HashMap<BiasType, Integer> biasResult) {

    HashMap<BiasType, Integer> resultMap = new LinkedHashMap<>();

    for (Pillar pillar : Pillar.values()) {

      if (pillar.equals(Pillar.REFERENCE)) {
        continue;
      }
      Integer firstValue = biasResult.get(pillar.biasList.get(0));
      Integer secondValue = biasResult.get(pillar.biasList.get(1));

      BiasType key = firstValue > secondValue ? pillar.biasList.get(0) : pillar.biasList.get(1);
      Integer value = firstValue > secondValue ? firstValue : secondValue;
      resultMap.put(key, value);

    }

    return resultMap;
  }

}
