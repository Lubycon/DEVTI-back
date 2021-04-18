package com.lubycon.devti.domain.user.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class UserPostDto {

  @Getter
  @Setter
  @NoArgsConstructor
  public static class UserPostReqDto {

    private String name;
    private String email;
    private String phone;

    @Builder
    public UserPostReqDto(String name, String email, String phone) {
      this.name = name;
      this.email = email;
      this.phone = phone;
    }
  }

}
