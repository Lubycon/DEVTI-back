package com.lubycon.devti.global.code;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Pillar implements DevtiEnumerable {
  ROLE(0),
  SCALE(1),
  INTEREST(2),
  PRIORITY(3),
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
