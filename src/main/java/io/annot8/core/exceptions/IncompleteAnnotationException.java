package io.annot8.core.exceptions;

public class IncompleteAnnotationException extends Annot8Exception {

  private static final long serialVersionUID = 1L;

  public IncompleteAnnotationException(final String message) {
    super(message);
  }

  public IncompleteAnnotationException(final String message, final Throwable t) {
    super(message, t);
  }
}
