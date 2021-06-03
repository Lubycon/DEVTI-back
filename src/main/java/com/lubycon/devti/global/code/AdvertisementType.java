package com.lubycon.devti.global.code;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum AdvertisementType implements DevtiEnumerable {
  ALL(0),
  LECTURE(1),
  RECRUIT(2),
  ETC(999);

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
