package com.lubycon.devti.domain.user.dto;

import com.lubycon.devti.global.annotation.PhoneNumber;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class UserPostDto {

  @Getter
  @Setter
  @NoArgsConstructor
  public static class UserPostReqDto {

    @NotNull
    @ApiModelProperty(value = "이름. 필수", example = "김개발")
    private String name;

    @NotNull
    @ApiModelProperty(value = "이메일. 필수", example = "abc@devti.com")
    private String email;

    @NotNull
    @PhoneNumber
    @ApiModelProperty(value = "전화번호. 필수", example = "010-1234-1234")
    private String phone;

    @Builder
    public UserPostReqDto(String name, String email, String phone) {
      this.name = name;
      this.email = email;
      this.phone = phone;
    }
  }

}
