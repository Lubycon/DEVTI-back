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

  private long id;
  private AnswerType answerType;
  private long sequence;
  private Bias bias;
  @Min(0)
  private float weight;

  @Builder
  public AnswerAttribute(long id, AnswerType answerType, long sequence,
      Bias bias, @Min(0) float weight) {
    this.id = id;
    this.answerType = answerType;
    this.sequence = sequence;
    this.bias = bias;
    this.weight = weight;
  }
}
