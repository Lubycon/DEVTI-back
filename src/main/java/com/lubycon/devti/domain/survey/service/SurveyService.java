package com.lubycon.devti.domain.survey.service;

import com.lubycon.devti.domain.survey.dao.SurveyRepository;
import com.lubycon.devti.domain.survey.dto.SurveyPostDto.SurveyPostReqDto;
import com.lubycon.devti.domain.survey.dto.SurveyPostDto.SurveyPostResDto;
import com.lubycon.devti.domain.survey.entity.Survey;
import com.lubycon.devti.global.error.ErrorCode;
import com.lubycon.devti.global.error.exception.InvalidValueException;
import java.util.Optional;
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
    Optional<Survey> checkSurvey = null;

    if (null != surveyPostReqDto.getPhone()) {
      checkSurvey = surveyRepository.findByPhone(surveyPostReqDto.getPhone());
      if (checkSurvey.isPresent()) {
        throw new InvalidValueException(surveyPostReqDto.getEmail(), ErrorCode.PHONE_DUPLICATION);
      }
    } else {
      checkSurvey = surveyRepository.findByEmail(surveyPostReqDto.getEmail());
      if (checkSurvey.isPresent()) {
        throw new InvalidValueException(surveyPostReqDto.getEmail(), ErrorCode.EMAIL_DUPLICATION);
      }
    }

    Survey survey = Survey.builder()
        .comment(surveyPostReqDto.getComment())
        .surveyType(surveyPostReqDto.getSurveyType())
        .email(surveyPostReqDto.getEmail())
        .phone(surveyPostReqDto.getPhone())
        .testType(surveyPostReqDto.getTestType())
        .build();

    Survey savedSurvey = surveyRepository.save(survey);

    return SurveyPostResDto.builder()
        .id(savedSurvey.getId())
        .comment(savedSurvey.getComment())
        .email(savedSurvey.getEmail())
        .phone(savedSurvey.getPhone())
        .testType(savedSurvey.getTestType())
        .build();

  }
}
