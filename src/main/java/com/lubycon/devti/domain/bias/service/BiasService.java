package com.lubycon.devti.domain.bias.service;

import com.lubycon.devti.domain.bias.dao.BiasRepository;
import com.lubycon.devti.domain.bias.entity.Bias;
import com.lubycon.devti.global.code.BiasType;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BiasService {

  private final BiasRepository biasRepository;

  public Bias findByBias(BiasType biasType) {
    return biasRepository.findByBias(biasType);
  }

  public List<Bias> findAll() {
    return biasRepository.findAll();
  }
}