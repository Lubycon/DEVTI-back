package com.lubycon.devti.domain.answer.entity;

import com.lubycon.devti.global.code.AnswerType;
import com.lubycon.devti.global.code.Bias;
import javax.validation.constraints.Min;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AnswerAttribute {

  long id;
  AnswerType answerType;
  long sequence;
  Bias bias;
  @Min(0)
  float weight;

  @Builder
  public AnswerAttribute(long id, AnswerType answerType, long sequence,
      Bias bias, @Min(0) long weight) {
    this.id = id;
    this.answerType = answerType;
    this.sequence = sequence;
    this.bias = bias;
    this.weight = weight;
  }
}
