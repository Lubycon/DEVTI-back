package com.lubycon.devti.domain.answer.entity;

import com.lubycon.devti.domain.answer.util.AnswerAttributeConverter;
import com.lubycon.devti.global.entity.BaseTimeEntity;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Answer extends BaseTimeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "answer_id")
  private Long id;

  @Lob
  @Convert(converter = AnswerAttributeConverter.class)
  @Column(name = "answer_list", nullable = false)
  private List<AnswerAttribute> answerList;

  @Builder
  public Answer(Long id, List<AnswerAttribute> answerList) {
    this.id = id;
    this.answerList = answerList;
  }
}
