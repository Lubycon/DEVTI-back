package com.lubycon.devti.domain.preset.dao;

import com.lubycon.devti.domain.preset.entity.Preset;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PresetRepository extends JpaRepository<Preset, Long> {

}
