package com.lubycon.devti.domain.preset.dao;

import com.lubycon.devti.domain.preset.entity.Preset;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PresetRepository extends JpaRepository<Preset, Long> {

  List<Preset> findAllByQuestionId(Long questionId);
}
