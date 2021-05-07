package com.lubycon.devti.global.code;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum TestType implements DevtiEnumerable {
  TYPE_COMMON_1(0), //Common type 1
  TYPE_COMMON_2(1), //Common type 2
  TYPE_COMMON_3(2), //Common type 3
  TYPE_COMMON_4(3), //Common type 4
  TYPE_MOM_CAFE_1(4), //Mom cafe type
  ;

  private final int value;
  private static TestType[] testTypes = values();

  @Override
  public int getValue() {
    return value;
  }

  @Override
  public String getKey() {
    return name();
  }

  public TestType getNext() {
    if ((this.ordinal() + 1) % testTypes.length == testTypes.length - 1) {
      return testTypes[0];
    }
    return testTypes[(this.ordinal() + 1) % testTypes.length];
  }

}
