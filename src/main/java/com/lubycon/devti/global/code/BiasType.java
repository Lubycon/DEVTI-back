package com.lubycon.devti.global.code;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum BiasType implements DevtiEnumerable {
  V(0),
  A(1),
  S(2),
  C(3),
  P(4),
  T(5),
  W(6),
  L(7),
  ETC(8),
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
