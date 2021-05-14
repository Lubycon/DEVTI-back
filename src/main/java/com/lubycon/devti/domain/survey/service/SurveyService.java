package com.lubycon.devti.domain.survey.service;

import com.lubycon.devti.domain.survey.dao.SurveyRepository;
import com.lubycon.devti.domain.survey.dto.SurveyPostDto.SurveyPostReqDto;
import com.lubycon.devti.domain.survey.dto.SurveyPostDto.SurveyPostResDto;
import com.lubycon.devti.domain.survey.entity.Survey;
import com.lubycon.devti.global.error.ErrorCode;
import com.lubycon.devti.global.error.exception.InvalidValueException;
import com.lubycon.devti.global.util.SlackPusher;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class SurveyService {

  @Value("${constant.slack.survey-monitoring-channel-url}")
  private String slackSurveyMonitoringChannelUrl;
  @Value("${constant.slack.survey-monitoring-channel-name}")
  private String slackSurveyMonitoringChannelName;
  private final SurveyRepository surveyRepository;


  @Transactional
  public SurveyPostResDto createSurvey(SurveyPostReqDto surveyPostReqDto) {

    if (isFilledWithPhoneSurvey(surveyPostReqDto)) {
      checkDuplicatedSurveyByPhone(surveyPostReqDto.getPhone());
    } else {
      checkDuplicatedSurveyByEmail(surveyPostReqDto.getEmail());
    }

    Survey survey = Survey.builder()
        .comment(surveyPostReqDto.getComment())
        .surveyType(surveyPostReqDto.getSurveyType())
        .email(surveyPostReqDto.getEmail())
        .phone(surveyPostReqDto.getPhone())
        .testType(surveyPostReqDto.getTestType())
        .build();

    Survey savedSurvey = surveyRepository.save(survey);

    pushMessage(savedSurvey);

    return SurveyPostResDto.builder()
        .id(savedSurvey.getId())
        .comment(savedSurvey.getComment())
        .email(savedSurvey.getEmail())
        .phone(savedSurvey.getPhone())
        .testType(savedSurvey.getTestType())
        .build();
  }

  public boolean isFilledWithPhoneSurvey(SurveyPostReqDto surveyPostReqDto) {
    return surveyPostReqDto.getPhone() != null;
  }

  public void checkDuplicatedSurveyByPhone(String phone) {
    if (surveyRepository.findByPhone(phone).isPresent()) {
      throw new InvalidValueException(phone, ErrorCode.PHONE_DUPLICATION);
    }
  }

  public void checkDuplicatedSurveyByEmail(String email) {
    if (surveyRepository.findByEmail(email).isPresent()) {
      throw new InvalidValueException(email, ErrorCode.EMAIL_DUPLICATION);
    }
  }

  private void pushMessage(Survey registeredSurvey) {
    SlackPusher slackPusher = new SlackPusher(
        slackSurveyMonitoringChannelUrl,
        "#" + slackSurveyMonitoringChannelName);

    slackPusher.pushMessage(
        "*신규 사전 참여 신청이 들어왔습니다!*"
            + "\n- Comment : " + registeredSurvey.getComment()
            + "\n- Test Type: " + registeredSurvey.getTestType()
    );
  }
}
