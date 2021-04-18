package com.lubycon.devti.domain.user.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserGetDto {

  private Long id;
  private String name;
  private String email;
  private boolean newer;
  private String phone;

  @Builder
  public UserGetDto(Long id, String name, String email, boolean newer, String phone) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.newer = newer;
    this.phone = phone;
  }
}
