package com.lubycon.devti.domain.preset.dto;


import lombok.Builder;
import lombok.Getter;

@Getter
public class PresetResDto {

  private Long id;
  private String label;

  @Builder
  public PresetResDto(Long id, String label) {
    this.id = id;
    this.label = label;
  }
}