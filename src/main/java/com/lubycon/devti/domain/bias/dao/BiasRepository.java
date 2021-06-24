package com.lubycon.devti.domain.bias.dao;

import com.lubycon.devti.domain.bias.entity.Bias;
import com.lubycon.devti.global.code.BiasType;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BiasRepository extends JpaRepository<Bias, Long> {

  List<Bias> findAllByBiasIsNotIn(List<BiasType> biasTypes);
}
