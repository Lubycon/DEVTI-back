package com.lubycon.devti.global.code;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum TestType implements DevtiEnumerable {
  TYPE_COMMON_1(0), //Common type 1
  TYPE_COMMON_2(1), //Common type 2
  TYPE_COMMON_3(2), //Common type 3
  TYPE_MOM_CAFE_1(3), //Mom cafe type
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
