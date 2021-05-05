package com.lubycon.devti.domain.bucket_test_type.dao;

import com.lubycon.devti.domain.bucket_test_type.entity.BucketTestType;
import com.lubycon.devti.global.code.TestType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BucketTestTypeRepository extends JpaRepository<BucketTestType, Long> {

  BucketTestType findByTestType(TestType testType);
}
