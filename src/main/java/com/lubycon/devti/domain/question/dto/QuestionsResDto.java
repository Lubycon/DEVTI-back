package com.lubycon.devti.domain.question.dto;


import com.lubycon.devti.domain.preset.dto.PresetResDto;
import com.lubycon.devti.domain.question.entity.Question;
import com.lubycon.devti.global.code.AnswerType;
import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
public class QuestionsResDto {

  private Long id;
  private String title;
  private AnswerType answerType;
  private List<PresetResDto> presets;

  @Builder
  public QuestionsResDto(Long id, String title, AnswerType answerType,
      List<PresetResDto> presets) {

    this.id = id;
    this.title = title;
    this.answerType = answerType;
    this.presets = presets;
  }

  public static QuestionsResDto convertResponseDto(Question question,
      List<PresetResDto> presetResDtoList) {
    return QuestionsResDto.builder()
        .id(question.getId())
        .title(question.getTitle())
        .answerType(question.getAnswerType())
        .presets(presetResDtoList)
        .build();
  }

  public static QuestionsResDto convertResponseDto(Question question) {
    return QuestionsResDto.builder()
        .id(question.getId())
        .title(question.getTitle())
        .answerType(question.getAnswerType())
        .build();
  }


  public static boolean isPresetAnswerType(Question question) {

    return question.getAnswerType().equals(AnswerType.PRESET);
  }
}