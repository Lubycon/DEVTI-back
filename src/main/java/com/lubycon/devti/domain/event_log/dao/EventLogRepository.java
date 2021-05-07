package com.lubycon.devti.domain.event_log.dao;

import com.lubycon.devti.domain.event_log.entity.EventLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventLogRepository extends JpaRepository<EventLog, Long> {

}
