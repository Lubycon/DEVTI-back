package com.lubycon.devti.domain.answer.dao;

import com.lubycon.devti.domain.answer.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Long> {

}
