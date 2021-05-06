package com.lubycon.devti.domain.traffic.dao;

import com.lubycon.devti.domain.traffic.entity.Traffic;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrafficRepository extends JpaRepository<Traffic, Long> {

  Optional<Traffic> findTopByOrderByIdDesc();
}
