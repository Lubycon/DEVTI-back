package com.lubycon.devti.domain.preset.dto;


import com.lubycon.devti.global.code.BiasType;
import lombok.Builder;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

@Getter
public class PresetResDto {

  @NotNull
  private long key;
  private String label;
  private BiasType bias;
  private float weight;
  private long sequence;

  @Builder
  public PresetResDto(long key, String label, BiasType bias, float weight, long sequence) {
    this.key = key;
    this.label = label;
    this.bias = bias;
    this.weight = weight;
    this.sequence = sequence;
  }
}