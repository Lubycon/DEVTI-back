package com.lubycon.devti.domain.survey.dao;

import com.lubycon.devti.domain.survey.entity.Survey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SurveyRepository extends JpaRepository<Survey, Long> {

}
