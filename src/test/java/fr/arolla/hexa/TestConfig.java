package fr.arolla.hexa;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class TestConfig {

  @Bean
  Repository repository() {
    return new FakeRepository();
  }
}
