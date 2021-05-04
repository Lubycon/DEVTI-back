package com.lubycon.devti.domain.traffic.dao;

import com.lubycon.devti.domain.traffic.entity.Traffic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrafficRepository extends JpaRepository<Traffic, Long> {

  Traffic findTopByOrderByIdDesc();
}
