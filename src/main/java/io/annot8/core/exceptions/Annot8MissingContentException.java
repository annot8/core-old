package io.annot8.core.exceptions;

public class Annot8MissingContentException extends Annot8Exception {


  private static final long serialVersionUID = 1L;

  public Annot8MissingContentException(final String message) {
    super(message);
  }

  public Annot8MissingContentException(final String message, final Throwable t) {
    super(message, t);
  }

}
