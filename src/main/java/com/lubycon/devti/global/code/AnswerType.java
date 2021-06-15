package com.lubycon.devti.global.code;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum AnswerType implements DevtiEnumerable {
  PRESET(0),
  GAGE(1),
  JOB(2),
  YEARS(3),
  ;

  private final int value;

  @Override
  public int getValue() {
    return value;
  }

  @Override
  public String getKey() {
    return name();
  }

}
