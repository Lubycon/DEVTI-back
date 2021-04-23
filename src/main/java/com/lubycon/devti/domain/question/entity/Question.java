package com.lubycon.devti.domain.question.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.lubycon.devti.domain.option.entity.Option;
import com.lubycon.devti.global.entity.BaseTimeEntity;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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

  @JsonManagedReference
  @OneToMany(mappedBy = "option", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<Option> optionList = new HashSet<>();
}