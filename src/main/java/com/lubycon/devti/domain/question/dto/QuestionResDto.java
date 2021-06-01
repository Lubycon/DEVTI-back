package com.lubycon.devti.domain.question.dto;


import com.lubycon.devti.global.code.AnswerType;
import lombok.Builder;
import lombok.Getter;

@Getter
public class QuestionResDto {

  private Long id;
  private String title;
  private AnswerType answerType;

  @Builder
  public QuestionResDto(Long id, String title, AnswerType answerType) {
    this.id = id;
    this.title = title;
    this.answerType = answerType;
  }
}