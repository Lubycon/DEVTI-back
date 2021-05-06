package com.lubycon.devti.domain.survey.dao;

import com.lubycon.devti.domain.survey.entity.Survey;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveyRepository extends JpaRepository<Survey, Long> {

  Optional<Survey> findByPhone(String phone);

  Optional<Survey> findByEmail(String email);
}
