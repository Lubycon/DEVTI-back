package com.lubycon.devti.domain.bucket_test_type.service;

import com.lubycon.devti.domain.bucket_test_type.dao.BucketTestTypeRepository;
import com.lubycon.devti.domain.bucket_test_type.dto.BucketTestTypeGetResDto;
import com.lubycon.devti.domain.bucket_test_type.entity.BucketTestType;
import com.lubycon.devti.domain.traffic.entity.Traffic;
import com.lubycon.devti.domain.traffic.service.TrafficService;
import com.lubycon.devti.global.code.EntryPoint;
import com.lubycon.devti.global.code.TestType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class BucketTestTypeService {

  private final TrafficService trafficService;
  private final BucketTestTypeRepository bucketTestTypeRepository;


  @Transactional
  public BucketTestTypeGetResDto getBucketTestTypeAndCreateTraffic(EntryPoint entryPoint) {
    TestType testType = getNextTestType(entryPoint);

    Traffic newTraffic = Traffic.builder()
        .testType(testType)
        .build();

    trafficService.saveTraffic(newTraffic);
    BucketTestType bucketTestType = bucketTestTypeRepository.findByTestType(testType);

    return BucketTestTypeGetResDto.builder()
        .testType(bucketTestType.getTestType())
        .phrases(bucketTestType.getPhrases())
        .build();
  }

  public TestType getNextTestType(EntryPoint entryPoint) {
    if (entryPoint.getValue().equals("mom")) {
      return TestType.TYPE_MOM_CAFE_1;
    }
    TestType lastTrafficType = trafficService.getLastTraffic().getTestType();

    return lastTrafficType.getNext();
  }
}
