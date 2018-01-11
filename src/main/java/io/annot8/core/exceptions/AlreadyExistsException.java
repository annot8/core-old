package io.annot8.core.exceptions;

public class AlreadyExistsException extends Annot8Exception {

  private static final long serialVersionUID = 1L;

  public AlreadyExistsException(final String message) {
    super(message);
  }

  public AlreadyExistsException(final String message, final Throwable t) {
    super(message, t);
  }
}
