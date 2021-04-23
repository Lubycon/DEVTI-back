package com.lubycon.devti.domain.survey.api;


import com.lubycon.devti.domain.survey.service.SurveyService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/survey")
@RequiredArgsConstructor
@Api(value = "Survey")
public class SurveyController {

  private final SurveyService surveyService;

}
