package com.lubycon.devti.domain.devti.entity;

import com.lubycon.devti.global.code.BiasType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ResultAttribute {

  private BiasType bias;
  private Integer weight;

  @Builder
  public ResultAttribute(BiasType bias, Integer weight) {
    this.bias = bias;
    this.weight = weight;
  }
}
