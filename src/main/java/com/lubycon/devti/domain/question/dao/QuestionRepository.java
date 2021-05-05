package com.lubycon.devti.domain.question.dao;

import com.lubycon.devti.domain.question.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {

}
