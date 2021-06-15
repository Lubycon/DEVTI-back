package com.lubycon.devti.domain.bias.dao;

import com.lubycon.devti.domain.bias.entity.Bias;
import com.lubycon.devti.global.code.BiasType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BiasRepository extends JpaRepository<Bias, Long> {

  Bias findByBias(BiasType biasType);
}
