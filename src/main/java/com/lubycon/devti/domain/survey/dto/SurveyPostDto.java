package com.lubycon.devti.domain.survey.dto;

import com.lubycon.devti.global.code.SurveyType;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class SurveyPostDto {

  @Getter
  @NoArgsConstructor
  public static class SurveyPostReqDto {

    @NotBlank(message = "SurveyType을 입력하세요. (ex. DEVTI)")
    @ApiModelProperty(value = "사전 참여 조사 타입(현재는 DEVTI만 존재)", example = "DEVTI")
    private SurveyType surveyType;

    @ApiModelProperty(value = "사전 참여 조사 comment", example = "FE, BE그것이 문제로다")
    private String comment;

    @ApiModelProperty(value = "이메일", example = "abc@devti.com")
    private String email;

    @ApiModelProperty(value = "휴대폰 번", example = "010-9594-8215")
    private String phone;
  }

  @Getter
  @Builder
  @AllArgsConstructor
  @NoArgsConstructor
  public static class SurveyPostResDto {

    private Long id;
    private String comment;
    private String email;
    private String phone;
  }

}
