package com.lubycon.devti.domain.survey.dto;

import com.lubycon.devti.global.code.SurveyType;
import com.lubycon.devti.global.code.TestType;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
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

    @ApiModelProperty(value = "휴대폰 번호", example = "010-9594-8215")
    private String phone;

    @Enumerated(EnumType.STRING)
    @ApiModelProperty(value = "Bucket test type", example = "TYPE_COMMON_1")
    private TestType testType;
  }

  @Getter
  public static class SurveyPostResDto {

    private Long id;
    private String comment;
    private String email;
    private String phone;
    private TestType testType;

    @Builder
    public SurveyPostResDto(Long id, String comment, String email, String phone,
        TestType testType) {
      this.id = id;
      this.comment = comment;
      this.email = email;
      this.phone = phone;
      this.testType = testType;
    }

  }

}
