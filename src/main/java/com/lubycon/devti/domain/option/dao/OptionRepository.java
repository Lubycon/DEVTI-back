package com.lubycon.devti.domain.option.dao;

import com.lubycon.devti.domain.option.entity.Option;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)
public interface OptionRepository extends JpaRepository<Option, Long> {

}
