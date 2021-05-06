package com.lubycon.devti.domain.survey.api;


import com.lubycon.devti.domain.survey.dto.SurveyPostDto.SurveyPostReqDto;
import com.lubycon.devti.domain.survey.dto.SurveyPostDto.SurveyPostResDto;
import com.lubycon.devti.domain.survey.service.SurveyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/survey")
@RequiredArgsConstructor
@Api(value = "Survey")
public class SurveyController {

  private final SurveyService surveyService;

  @PostMapping
  @ApiOperation(value = "사전 참여 신청")
  public ResponseEntity<SurveyPostResDto> create(
      @RequestBody @Valid SurveyPostReqDto surveyPostReqDto) {
    return ResponseEntity.ok(surveyService.createSurvey(surveyPostReqDto));
  }

}
