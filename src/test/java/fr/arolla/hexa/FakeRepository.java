package fr.arolla.hexa;

import org.springframework.stereotype.Service;

import java.util.HashMap;


@Service
public class FakeRepository implements Repository {
  private final HashMap<Integer, String> facts;

  public FakeRepository() {
    facts = new HashMap<Integer, String>();
  }

  @Override
  public String getFactById(int id) {
    String res = facts.get(id);
    if (res == null) {
      throw new NoSuchFactException(id);
    }
    return res;
  }

  public void addFact(int id, String fact) {
    facts.put(id, fact);
  }

  public void reset() {
    this.facts.clear();
  }
}
