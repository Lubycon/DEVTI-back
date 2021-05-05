package com.lubycon.devti.global.code;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum EntryPoint {
  COMMON_ENTRY_POINT("common"), //Common type 1
  MOM_ENTRY_POINT("mom"), //Common type 2
  ;

  private final String value;

  public String getValue() {
    return value;
  }

  public String getKey() {
    return name();
  }

}
