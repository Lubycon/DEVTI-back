package com.lubycon.devti.domain.question.service;

import com.lubycon.devti.domain.preset.service.PresetService;
import com.lubycon.devti.domain.question.dao.QuestionRepository;
import com.lubycon.devti.domain.question.dto.QuestionsResDto;
import com.lubycon.devti.domain.question.entity.Question;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class QuestionService {

  private final QuestionRepository questionRepository;
  private final PresetService presetService;

  public List<QuestionsResDto> findAllQuestionAndPreset() {

    List<Question> questions = questionRepository.findAll();
    List<QuestionsResDto> allQuestionAndPresetResDtos = new ArrayList<>(questions.size());
    for (Question question : questions) {
      allQuestionAndPresetResDtos.add(setQuestionResDto(question));
    }
    return allQuestionAndPresetResDtos;
  }

  private QuestionsResDto setQuestionResDto(Question question) {
    
    if (QuestionsResDto.isPresetAnswerType(question)) {
      return QuestionsResDto.convertResponseDto(question,
          presetService.findAllPresetByQuestionId(question.getId()));
    }
    return QuestionsResDto.convertResponseDto(question);
  }
}
