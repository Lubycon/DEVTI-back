package com.lubycon.devti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class DevtiApplication {

  public static void main(String[] args) {
    SpringApplication.run(DevtiApplication.class, args);
  }

}
