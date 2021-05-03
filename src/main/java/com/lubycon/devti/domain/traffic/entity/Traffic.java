package com.lubycon.devti.domain.traffic.entity;

import com.lubycon.devti.global.code.TestType;
import com.lubycon.devti.global.entity.BaseTimeEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Traffic extends BaseTimeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "TRAFFIC_ID")
  private Long id;

  @Enumerated(EnumType.STRING)
  @Column(name = "test_type", nullable = false)
  private TestType testType;

  @Builder
  public Traffic(TestType testType) {
    this.testType = testType;
  }
}