package com.lubycon.devti.domain.preset.service;

import com.lubycon.devti.domain.preset.dao.PresetRepository;
import com.lubycon.devti.domain.preset.dto.PresetResDto;
import com.lubycon.devti.domain.preset.entity.Preset;
import com.lubycon.devti.global.error.ErrorCode;
import com.lubycon.devti.global.error.exception.BusinessException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PresetService {

  private final PresetRepository presetRepository;

  public List<PresetResDto> findAllPresetByQuestionId(Long questionId) {
    List<Preset> presets = presetRepository.findAllByQuestionId(questionId);
    if (presets.isEmpty()) {
      throw new BusinessException(questionId.toString(), ErrorCode.PRESET_NOT_FOUND);
    }

    List<PresetResDto> presetResDtos = new ArrayList<>(presets.size());
    AtomicLong index = new AtomicLong();

    presets.stream().forEach((preset) -> {
      presetResDtos.add(PresetResDto.builder()
          .key(preset.getSequence())
          .label(preset.getLabel())
          .build());
    });

    return presetResDtos;
  }
}
