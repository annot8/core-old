package io.annot8.core.exceptions;

public class Annot8RuntimeException extends RuntimeException {

  public Annot8RuntimeException(String message) {
    super(message);
  }

  public Annot8RuntimeException(String message, Throwable t) {
    super(message, t);
  }
}
