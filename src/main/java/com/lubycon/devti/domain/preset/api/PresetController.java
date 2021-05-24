package com.lubycon.devti.domain.preset.api;


import com.lubycon.devti.domain.preset.service.PresetService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/preset")
@RequiredArgsConstructor
@Api(value = "Preset")
public class PresetController {

  private final PresetService presetService;


}
