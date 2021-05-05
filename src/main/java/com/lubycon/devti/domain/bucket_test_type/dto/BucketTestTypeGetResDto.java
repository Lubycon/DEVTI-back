package com.lubycon.devti.domain.bucket_test_type.dto;

import com.lubycon.devti.global.code.TestType;
import lombok.Builder;
import lombok.Getter;

@Getter
public class BucketTestTypeGetResDto {

  private TestType testType;
  private String phrases;

  @Builder
  public BucketTestTypeGetResDto(TestType testType, String phrases) {
    this.testType = testType;
    this.phrases = phrases;
  }
}
