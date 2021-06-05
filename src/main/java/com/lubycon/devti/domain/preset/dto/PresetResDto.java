package com.lubycon.devti.domain.preset.dto;


import lombok.Builder;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

@Getter
public class PresetResDto {

  @NotNull
  private long key;
  private String label;

  @Builder
  public PresetResDto(Long key, String label) {
    this.key = key;
    this.label = label;
  }
}