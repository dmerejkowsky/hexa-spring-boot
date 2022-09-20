package fr.arolla.hexa;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FakeRepositoryTests {
  private FakeRepository fakeRepository;

  @BeforeEach
  void resetFakeRepository() {
    fakeRepository = new FakeRepository();
  }

  @Test
  void canGetFactByIdWhenProperlySetUp() {
    fakeRepository.addFact(100, "one hundred");

    assertEquals("one hundred", fakeRepository.getFactById(100));
  }

  @Test
  void throwsWhenUsingInvalidId() {
    fakeRepository.addFact(1, "one");

    assertThrows(NoSuchFactException.class, () -> {
      fakeRepository.getFactById(100);
    });
  }
}