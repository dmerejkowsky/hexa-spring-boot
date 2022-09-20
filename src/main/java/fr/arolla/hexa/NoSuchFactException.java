package fr.arolla.hexa;

public class NoSuchFactException extends RuntimeException {
  private final int id;

  public NoSuchFactException(int id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return String.format("No fact found with id %d", this.id);
  }
}
