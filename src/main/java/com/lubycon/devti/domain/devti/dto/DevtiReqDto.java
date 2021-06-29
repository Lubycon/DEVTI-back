package com.lubycon.devti.domain.devti.dto;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

@Getter
public class DevtiReqDto {

  @NotNull
  @ApiModelProperty(value = "희망 직무 (F,B)", example = "F")
  private String job;

  @NotNull
  @ApiModelProperty(value = "DEVTI 결과 HashMap String", example = "{W=90, A=60, P=60, V=35, T=40, S=75, L=0, C=15}")
  private String result;

  @Builder
  public DevtiReqDto(@NotNull String job, @NotNull String result) {
    this.job = job;
    this.result = result;
  }
}
