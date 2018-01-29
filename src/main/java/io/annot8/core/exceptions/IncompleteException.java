package io.annot8.core.exceptions;

public class IncompleteException extends Annot8Exception {

  private static final long serialVersionUID = 1L;

  public IncompleteException(final String message) {
    super(message);
  }

  public IncompleteException(final String message, final Throwable t) {
    super(message, t);
  }
}
