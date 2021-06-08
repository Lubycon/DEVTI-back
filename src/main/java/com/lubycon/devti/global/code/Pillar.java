package com.lubycon.devti.global.code;

import java.util.Arrays;
import java.util.List;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public enum Pillar {
  ROLE("직군", Arrays.asList("F", "B")),
  SCALE("규모", Arrays.asList("S", "C")),
  INTEREST("관심사", Arrays.asList("P", "T")),
  PRIORITY("우선순위", Arrays.asList("W", "L")),
  ;


  Pillar(String pillar, List<String> biasList) {
  }
}
