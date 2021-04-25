package com.lubycon.devti.domain.user.dao;

import com.lubycon.devti.domain.user.entity.User;
import java.util.List;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

  User findByEmail(String email);

  @EntityGraph(attributePaths = "surveyList")
  @Query("select u from User u")
  List<User> findAllEntityGraph();
}
