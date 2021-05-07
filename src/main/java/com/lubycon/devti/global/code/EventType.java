package com.lubycon.devti.global.code;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum EventType implements DevtiEnumerable {
  CLICK_CTA_BUTTON(0),
  CLICK_SHARE_BUTTON(1),
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
