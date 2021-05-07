package com.lubycon.devti.domain.event_log.api;


import static com.lubycon.devti.domain.event_log.dto.EventLogPostDto.EventLogPostReqDto;
import static com.lubycon.devti.domain.event_log.dto.EventLogPostDto.EventLogPostResDto;

import com.lubycon.devti.domain.event_log.service.EventLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/event-log")
@RequiredArgsConstructor
@Api(value = "EventLog")
public class EventLogController {

  private final EventLogService eventLogService;

  @PostMapping
  @ApiOperation(value = "Event log 저장")
  public ResponseEntity<EventLogPostResDto> create(
      @RequestBody @Valid EventLogPostReqDto eventLogPostReqDto) {
    return ResponseEntity.ok(eventLogService.createEventLog(eventLogPostReqDto));
  }
}
