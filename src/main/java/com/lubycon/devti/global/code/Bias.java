package com.lubycon.devti.global.code;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Bias implements DevtiEnumerable {
  F(0),
  B(1),
  S(2),
  C(3),
  P(4),
  T(5),
  W(6),
  L(7),
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
