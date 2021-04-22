package com.lubycon.devti.domain.option.dao;

import com.lubycon.devti.domain.question.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OptionRepository extends JpaRepository<Question, Long> {

}
