package com.lubycon.devti.domain.survey.entity;

import com.lubycon.devti.global.code.SurveyType;
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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Survey extends BaseTimeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "survey_id")
  private Long id;

  @Column(length = 500)
  private String comment;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false)
  private SurveyType surveyType;

  @Column(length = 100, unique = true)
  private String email;

  @Column(length = 50, unique = true)
  private String phone;

  @Enumerated(EnumType.STRING)
  @Column(name = "test_type", nullable = false)
  private TestType testType;
}