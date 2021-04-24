package com.lubycon.devti.domain.user.entity;

import com.lubycon.devti.domain.user.dto.UserGetDto;
import com.lubycon.devti.global.annotation.PhoneNumber;
import com.lubycon.devti.global.entity.BaseTimeEntity;
import com.lubycon.devti.global.util.ModelMapperUtils;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User extends BaseTimeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "USER_ID")
  private Long id;

  @Column(length = 100)
  private String name;

  @Email
  @Column(length = 100, unique = true)
  private String email;

  private Boolean newer;

  @PhoneNumber
  @Column(unique = true)
  private String phone;

  public UserGetDto toDto() {
    return ModelMapperUtils.getInstance().map(this, UserGetDto.class);
  }
}