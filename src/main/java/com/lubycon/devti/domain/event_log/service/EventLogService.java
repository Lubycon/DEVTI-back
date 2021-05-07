package com.lubycon.devti.domain.event_log.service;

import com.lubycon.devti.domain.event_log.dao.EventLogRepository;
import com.lubycon.devti.domain.event_log.dto.EventLogPostDto.EventLogPostReqDto;
import com.lubycon.devti.domain.event_log.dto.EventLogPostDto.EventLogPostResDto;
import com.lubycon.devti.domain.event_log.entity.EventLog;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventLogService {

  private final EventLogRepository eventLogRepository;

  public EventLogPostResDto createEventLog(EventLogPostReqDto eventLogPostReqDto) {\
    EventLog eventLog = EventLog.builder()
        .eventType(eventLogPostReqDto.getEventType())
        .testType(eventLogPostReqDto.getTestType())
        .build();

    EventLog saved = eventLogRepository.save(eventLog);
    return saved.toDto();
  }

}
