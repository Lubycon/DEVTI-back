package com.lubycon.devti.domain.devti.api;


import com.lubycon.devti.domain.answer.entity.AnswerAttribute;
import com.lubycon.devti.domain.devti.dto.DevtiReqDto;
import com.lubycon.devti.domain.devti.dto.DevtiResDto;
import com.lubycon.devti.domain.devti.service.DevtiService;
import com.lubycon.devti.global.code.BiasType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.HashMap;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/devti")
@RequiredArgsConstructor
@Api(value = "Devti")
public class DevtiController {

  private final DevtiService devtiService;

  @PostMapping
  @ApiOperation(value = "답변 저장하여 결과 요청값 반환 받기")
  public ResponseEntity<DevtiReqDto> getDevtiByAnswer(@RequestBody List<AnswerAttribute> answerAttributeList) {

    return ResponseEntity.ok(devtiService.analysisAndCreateDevti(answerAttributeList));
  }

  @GetMapping("/result")
  @ApiOperation(value = "결과 요청값으로 결과 반환 받기")
  public ResponseEntity<DevtiResDto> getDevtiByQueryString(
      @RequestParam("V") Integer v,
      @RequestParam("A") Integer a,
      @RequestParam("S") Integer s,
      @RequestParam("C") Integer c,
      @RequestParam("P") Integer p,
      @RequestParam("T") Integer t,
      @RequestParam("W") Integer w,
      @RequestParam("L") Integer l,
      @RequestParam("job") String job) {
    
    HashMap<BiasType, Integer> biasResult = new HashMap<>();
    biasResult.put(BiasType.V, v);
    biasResult.put(BiasType.A, a);
    biasResult.put(BiasType.S, s);
    biasResult.put(BiasType.C, c);
    biasResult.put(BiasType.P, p);
    biasResult.put(BiasType.T, t);
    biasResult.put(BiasType.W, w);
    biasResult.put(BiasType.L, l);

    return ResponseEntity.ok(devtiService.getDevtiByAnswer(biasResult, job));
  }
}
 