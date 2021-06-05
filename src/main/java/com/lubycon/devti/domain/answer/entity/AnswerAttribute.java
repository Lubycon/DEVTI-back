package com.lubycon.devti.domain.answer.entity;

import com.lubycon.devti.global.code.AnswerType;
import javax.validation.constraints.Min;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AnswerAttribute {

  long id;
  AnswerType answerType;
  @Min(0)
  long value;

  @Builder
  public AnswerAttribute(long id, AnswerType answerType, long value) {
    this.id = id;
    this.answerType = answerType;
    this.value = value;
  }

}
