package com.lubycon.devti.domain.bucket_test_type.dto;

import com.lubycon.devti.global.code.TestType;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BucketTestTypeGetResDto {

  @NotNull
  private TestType testType;
  @NotNull
  private String phrases;

}
