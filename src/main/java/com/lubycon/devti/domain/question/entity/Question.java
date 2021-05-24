package com.lubycon.devti.domain.question.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.lubycon.devti.domain.preset.entity.Preset;
import com.lubycon.devti.global.code.AnswerType;
import com.lubycon.devti.global.entity.BaseTimeEntity;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Question extends BaseTimeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "QUESTION_ID")
  private Long id;

  @Column(length = 100)
  private String title;

  @Enumerated(EnumType.STRING)
  @Column(name = "answer_type", nullable = false)
  private AnswerType answerType;

  @JsonManagedReference
  @OneToMany(mappedBy = "preset", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<Preset> presets = new HashSet<>();
}