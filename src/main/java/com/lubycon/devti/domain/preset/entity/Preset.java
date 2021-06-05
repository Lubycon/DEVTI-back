package com.lubycon.devti.domain.preset.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.lubycon.devti.domain.question.entity.Question;
import com.lubycon.devti.global.code.Bias;
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

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Preset extends BaseTimeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "preset_id")
  private Long id;

  @Column(name = "sequence", nullable = false)
  private Long sequence;

  @JsonBackReference
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "question_id")
  private Question question;

  @Column(length = 100)
  private String label;

  @Enumerated(EnumType.STRING)
  @Column(name = "bias", nullable = false)
  private Bias bias;

  @Column(name = "weight", nullable = false)
  private Float weight;
}