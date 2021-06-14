package com.lubycon.devti.domain.devti.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.lubycon.devti.domain.answer.entity.Answer;
import com.lubycon.devti.global.entity.BaseTimeEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
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

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Devti extends BaseTimeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "devti_id")
  private Long id;

  @JsonBackReference
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "answer_id")
  private Answer answer;

  @Column(name = "devti")
  private String devti;

  @Column(name = "devti_result")
  private String devtiResult;
}