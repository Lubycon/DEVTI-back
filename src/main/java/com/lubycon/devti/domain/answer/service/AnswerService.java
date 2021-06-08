package com.lubycon.devti.domain.answer.service;

import com.lubycon.devti.domain.answer.dao.AnswerRepository;
import com.lubycon.devti.domain.answer.entity.Answer;
import com.lubycon.devti.domain.answer.entity.AnswerAttribute;
import com.lubycon.devti.domain.devti.service.DevtiAnalysisService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AnswerService {

  private final AnswerRepository answerRepository;
  private final DevtiAnalysisService devtiAnalysisService;

  public Answer createAnswer(List<AnswerAttribute> answerAttributeList) {
    Answer answer = Answer.builder().answerList(answerAttributeList).build();
    answerRepository.save(answer);

    devtiAnalysisService.analysisAnswer(answerAttributeList);

    return null;
  }
}