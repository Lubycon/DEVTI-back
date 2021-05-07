package com.lubycon.devti.domain.event_log.dto;

import com.lubycon.devti.global.code.EventType;
import com.lubycon.devti.global.code.TestType;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class EventLogPostDto {

  @Getter
  @NoArgsConstructor
  public static class EventLogPostReqDto {

    @NotNull
    @ApiModelProperty(value = "event type", example = "CLICK_CTA_BUTTON")
    private EventType eventType;

    @NotNull
    @ApiModelProperty(value = "Bucket test type", example = "TYPE_COMMON_1")
    private TestType testType;
  }

  @Getter
  @Setter
  @NoArgsConstructor
  public static class EventLogPostResDto {

    private Long id;

    @org.jetbrains.annotations.NotNull
    private TestType testType;

    @org.jetbrains.annotations.NotNull
    private EventType eventType;

    @Builder
    public EventLogPostResDto(Long id, TestType testType, EventType eventType) {
      this.id = id;
      this.testType = testType;
      this.eventType = eventType;
    }
  }

}
