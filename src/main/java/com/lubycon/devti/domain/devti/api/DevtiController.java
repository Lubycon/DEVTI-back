package com.lubycon.devti.domain.devti.api;


import com.lubycon.devti.domain.answer.entity.AnswerAttribute;
import com.lubycon.devti.domain.devti.dto.DevtiResDto;
import com.lubycon.devti.domain.devti.service.DevtiService;
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
@RequestMapping("/devti")
@RequiredArgsConstructor
@Api(value = "Devti")
public class DevtiController {

  private final DevtiService devtiService;

  @PostMapping
  @ApiOperation(value = "답변 저장하여 결과값 반환 받기")
  public ResponseEntity<DevtiResDto> getDevtiByAnswer(
      @RequestBody List<AnswerAttribute> answerAttributeList) {
    return ResponseEntity.ok(devtiService.getMockResultResponse());
  }
}
 