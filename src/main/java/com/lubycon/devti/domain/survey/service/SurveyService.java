package com.lubycon.devti.domain.survey.service;

import com.lubycon.devti.domain.survey.dao.SurveyRepository;
import com.lubycon.devti.domain.survey.dto.SurveyPostDto.SurveyPostReqDto;
import com.lubycon.devti.domain.survey.dto.SurveyPostDto.SurveyPostResDto;
import com.lubycon.devti.domain.survey.entity.Survey;
import com.lubycon.devti.domain.user.dao.UserRepository;
import com.lubycon.devti.domain.user.dto.UserGetDto;
import com.lubycon.devti.domain.user.entity.User;
import com.lubycon.devti.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class SurveyService {

  private final SurveyRepository surveyRepository;
  private final UserRepository userRepository;
  private final UserService userService;

  @Transactional
  public SurveyPostResDto createSurvey(SurveyPostReqDto surveyPostReqDto) {
    UserGetDto userGetDto = userService.getUserByEmail(surveyPostReqDto.getEmail());
    if (userGetDto == null) {
      User user = User.builder()
          .email(surveyPostReqDto.getEmail())
          .build();
      User savedUser = userRepository.save(user);

      Survey survey = Survey.builder()
          .comment(surveyPostReqDto.getComment())
          .surveyType(surveyPostReqDto.getSurveyType())
          .user(user)
          .build();
      Survey savedSurvey = surveyRepository.save(survey);

      return SurveyPostResDto.builder()
          .id(savedSurvey.getId())
          .comment(savedSurvey.getComment())
          .userGetDto(savedUser.toDto())
          .build();
    }

    return null;
  }
}
