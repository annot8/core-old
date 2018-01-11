package io.annot8.core.exceptions;

public class Annot8RuntimeException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public Annot8RuntimeException(final String message) {
    super(message);
  }

  public Annot8RuntimeException(final String message, final Throwable t) {
    super(message, t);
  }
}
