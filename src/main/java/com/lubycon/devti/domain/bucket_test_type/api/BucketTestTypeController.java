package com.lubycon.devti.domain.bucket_test_type.api;


import com.lubycon.devti.domain.bucket_test_type.dto.BucketTestTypeGetResDto;
import com.lubycon.devti.domain.bucket_test_type.service.BucketTestTypeService;
import com.lubycon.devti.global.code.EntryPoint;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/bucket-test-type")
@RequiredArgsConstructor
@Api(value = "BucketTestType")
public class BucketTestTypeController {

  private final BucketTestTypeService bucketTestTypeService;

  @GetMapping(value = "/{entryPoint}")
  @ApiOperation(value = "Bucket test 문구 가져오기")
  public ResponseEntity<BucketTestTypeGetResDto> getBucketTestTypeAndCreateTraffic(
      @PathVariable final EntryPoint entryPoint) {
    return ResponseEntity.ok(bucketTestTypeService.getBucketTestTypeAndCreateTraffic(entryPoint));
  }
}
 