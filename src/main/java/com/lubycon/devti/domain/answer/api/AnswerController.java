package com.lubycon.devti.domain.answer.api;


import com.lubycon.devti.domain.answer.entity.Answer;
import com.lubycon.devti.domain.answer.entity.AnswerAttribute;
import com.lubycon.devti.domain.answer.service.AnswerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/answer")
@RequiredArgsConstructor
@Api(value = "Answer")
public class AnswerController {

  private final AnswerService answerService;

  @PostMapping
  @ApiOperation(value = "답변 저장하여 결과값 반환 받기")
  public ResponseEntity<Answer> create(
      @RequestBody List<AnswerAttribute> answerAttributeList) {
    return ResponseEntity
        .ok(answerService.createAnswer(answerAttributeList));
  }
}
 