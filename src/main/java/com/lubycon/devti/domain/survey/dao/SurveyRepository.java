package com.lubycon.devti.domain.survey.dao;

import com.lubycon.devti.domain.survey.entity.Survey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)
public interface SurveyRepository extends JpaRepository<Survey, Long> {

}
