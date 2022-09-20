package fr.arolla.hexa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SqliteRepositoryTests {
  private SqliteRepository sqliteRepository;

  @BeforeEach
  void setupRepository() {
    sqliteRepository = new SqliteRepository();
  }

  @Test
  void getFactById() {
    var fact = sqliteRepository.getFactById(3);
    assertNotNull(fact);
  }
}
