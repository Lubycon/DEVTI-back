package com.lubycon.devti.domain.preset.dto;


import lombok.Builder;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

@Getter
public class PresetResDto {

  @NotNull
  private long id;
  private String label;

  @Builder
  public PresetResDto(Long id, String label) {
    this.id = id;
    this.label = label;
  }
}