package com.lubycon.devti.domain.question.dao;

import com.lubycon.devti.domain.question.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)
public interface QuestionRepository extends JpaRepository<Question, Long> {

}
