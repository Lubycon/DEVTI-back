package com.lubycon.devti.domain.event_log.entity;

import com.lubycon.devti.domain.event_log.dto.EventLogPostDto.EventLogPostResDto;
import com.lubycon.devti.global.code.EventType;
import com.lubycon.devti.global.code.TestType;
import com.lubycon.devti.global.entity.BaseTimeEntity;
import com.lubycon.devti.global.util.ModelMapperUtils;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class EventLog extends BaseTimeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "event_log_id")
  private Long id;

  @Enumerated(EnumType.STRING)
  @Column(name = "event_type", nullable = false)
  private EventType eventType;

  @Enumerated(EnumType.STRING)
  @Column(name = "test_type", nullable = false)
  private TestType testType;

  @Builder
  public EventLog(EventType eventType, TestType testType) {
    this.eventType = eventType;
    this.testType = testType;
  }

  public EventLogPostResDto toDto() {
    return ModelMapperUtils.getInstance().map(this, EventLogPostResDto.class);
  }
}