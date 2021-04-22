package com.lubycon.devti.domain.option.api;


import com.lubycon.devti.domain.option.service.OptionService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/option")
@RequiredArgsConstructor
@Api(value = "Option")
public class OptionController {

  private final OptionService optionService;


}
