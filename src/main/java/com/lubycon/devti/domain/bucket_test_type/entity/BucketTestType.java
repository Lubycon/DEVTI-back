package com.lubycon.devti.domain.bucket_test_type.entity;

import com.lubycon.devti.global.code.TestType;
import com.lubycon.devti.global.entity.BaseTimeEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BucketTestType extends BaseTimeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "BUCKET_TEST_TYPE_ID")
  private Long id;

  @Enumerated(EnumType.STRING)
  @Column(name = "test_type", nullable = false, insertable = false, updatable = false)
  private TestType testType;

  @Column(name = "description")
  private String description;

  @Column(name = "phrases")
  private String phrases;

  @Builder
  public BucketTestType(TestType testType, String description, String phrases) {
    this.testType = testType;
    this.description = description;
    this.phrases = phrases;
  }
}