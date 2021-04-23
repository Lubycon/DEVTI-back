package com.lubycon.devti.global.code;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum SurveyType implements DevtiEnumerable {
  DEVTI(0);

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
