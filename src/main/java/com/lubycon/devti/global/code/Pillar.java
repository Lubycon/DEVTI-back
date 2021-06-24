package com.lubycon.devti.global.code;

import java.util.Arrays;
import java.util.List;

public enum Pillar {
  ROLE("직군", Arrays.asList(BiasType.V, BiasType.A)),
  SCALE("규모", Arrays.asList(BiasType.S, BiasType.C)),
  INTEREST("관심사", Arrays.asList(BiasType.P, BiasType.T)),
  PRIORITY("우선순위", Arrays.asList(BiasType.W, BiasType.L)),
  REFERENCE("참고정보", Arrays.asList(BiasType.J, BiasType.Y)),
  ;

  private final String pillar;
  public final List<BiasType> biasList;

  Pillar(String pillar, List<BiasType> biasList) {
    this.pillar = pillar;
    this.biasList = biasList;
  }


}
