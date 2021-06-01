package com.lubycon.devti.domain.preset.dto;


import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

@Getter
public class PresetResDto {

  @NotNull
  private Long id;
  private String label;

  @Builder
  public PresetResDto(Long id, String label) {
    this.id = id;
    this.label = label;
  }
}