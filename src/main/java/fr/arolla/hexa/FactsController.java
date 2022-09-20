package fr.arolla.hexa;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class FactsController {
  private final Repository repository;

  FactsController(Repository repository) {
    this.repository = repository;
  }

  @GetMapping("/fact/{id}")
  String fact(@PathVariable("id") int factId) {
    try {
      return repository.getFactById(factId);
    } catch (NoSuchFactException e) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.toString());
    }
  }
}
