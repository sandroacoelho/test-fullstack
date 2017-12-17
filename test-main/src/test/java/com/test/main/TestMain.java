package com.test.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Start da aplicação
 *
 * @author esdrastavares
 */
@ComponentScan({
        "com.test.model.domain.user",
        "com.test.model.user",
        "com.test.api"
})
@EntityScan("com.test.model.domain.user")
@EnableJpaRepositories("com.test.model.user")
@SpringBootApplication
public class TestMain {

  public static void main(String[] args) {
    SpringApplication.run(TestMain.class, args);
  }

}
