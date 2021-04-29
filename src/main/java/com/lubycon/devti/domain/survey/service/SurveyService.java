package com.lubycon.devti.domain.survey.service;

import com.lubycon.devti.domain.survey.dao.SurveyRepository;
import com.lubycon.devti.domain.survey.dto.SurveyPostDto.SurveyPostReqDto;
import com.lubycon.devti.domain.survey.dto.SurveyPostDto.SurveyPostResDto;
import com.lubycon.devti.domain.survey.entity.Survey;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class SurveyService {

  private final SurveyRepository surveyRepository;

  @Transactional
  public SurveyPostResDto createSurvey(SurveyPostReqDto surveyPostReqDto) {

    Survey survey = Survey.builder()
        .comment(surveyPostReqDto.getComment())
        .surveyType(surveyPostReqDto.getSurveyType())
        .email(surveyPostReqDto.getEmail())
        .build();
    Survey savedSurvey = surveyRepository.save(survey);

    return SurveyPostResDto.builder()
        .id(savedSurvey.getId())
        .comment(savedSurvey.getComment())
        .email(savedSurvey.getEmail())
        .build();
  }

}
