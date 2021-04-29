package com.lubycon.devti.domain.question.api;


import com.lubycon.devti.domain.question.service.QuestionService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/question")
@RequiredArgsConstructor
@Api(value = "Question")
public class QuestionController {

  private final QuestionService questionService;


}
