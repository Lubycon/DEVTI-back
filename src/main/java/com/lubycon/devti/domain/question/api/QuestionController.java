package com.lubycon.devti.domain.question.api;


import com.lubycon.devti.domain.question.dto.QuestionsResDto;
import com.lubycon.devti.domain.question.service.QuestionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/question")
@RequiredArgsConstructor
@Api(value = "Question")
public class QuestionController {

  private final QuestionService questionService;

  @GetMapping(value = "/all")
  @ApiOperation(value = "모든 질문 및 선택 가져오기")
  public ResponseEntity<List<QuestionsResDto>> getAllQuestionAndPreset() {
    return ResponseEntity.ok(questionService.findAllQuestionAndPreset());
  }

}
