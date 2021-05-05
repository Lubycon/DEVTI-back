package com.lubycon.devti.domain.traffic.service;

import com.lubycon.devti.domain.traffic.dao.TrafficRepository;
import com.lubycon.devti.domain.traffic.entity.Traffic;
import com.lubycon.devti.global.code.TestType;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TrafficService {

  private final TrafficRepository trafficRepository;

  public Traffic getLastTraffic() {
    Optional<Traffic> lastTraffic = trafficRepository.findTopByOrderByIdDesc();

    return lastTraffic.orElseGet(
        () -> Traffic.builder()
            .testType(TestType.TYPE_COMMON_3)
            .build());
  }

  public Traffic saveTraffic(Traffic traffic) {
    return trafficRepository.save(traffic);
  }
}
