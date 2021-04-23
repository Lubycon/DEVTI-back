package com.lubycon.devti.domain.survey.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.lubycon.devti.domain.user.entity.User;
import com.lubycon.devti.global.code.SurveyType;
import com.lubycon.devti.global.entity.BaseTimeEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
public class Survey extends BaseTimeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "SURVEY_ID")
  private Long id;

  @Column(length = 500)
  private String comment;

  @Enumerated(EnumType.STRING)
  @Column
  private SurveyType surveyType;

  @JsonBackReference
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  private User user;

}