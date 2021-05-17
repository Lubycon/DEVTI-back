package com.lubycon.devti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class DevtiApplication {

  static {
    System.setProperty("spring.config.location",
        "classpath:/application.yml, file:" + System.getenv("DEVTI_ROOT_PATH") + "/config.yml");
  }

  public static void main(String[] args) {
    SpringApplication.run(DevtiApplication.class, args);
  }

}
