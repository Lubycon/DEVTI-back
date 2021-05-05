package com.lubycon.devti.domain.traffic.service;

import com.lubycon.devti.domain.traffic.dao.TrafficRepository;
import com.lubycon.devti.domain.traffic.entity.Traffic;
import com.lubycon.devti.global.code.TestType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TrafficService {

  private final TrafficRepository trafficRepository;

  public Traffic getLastTraffic() {
    Traffic lastTraffic = trafficRepository.findTopByOrderByIdDesc();
    if (lastTraffic == null) {
      return Traffic.builder()
          .testType(TestType.TYPE_MOM_CAFE_1)
          .build();
    }
    return lastTraffic;
  }

  public Traffic saveTraffic(Traffic traffic) {
    return trafficRepository.save(traffic);
  }
}
