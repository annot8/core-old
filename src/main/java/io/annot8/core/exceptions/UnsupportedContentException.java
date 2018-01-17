package io.annot8.core.exceptions;

public class UnsupportedContentException extends Annot8Exception {

  private static final long serialVersionUID = 1L;

  public UnsupportedContentException(final String message) {
    super(message);
  }

  public UnsupportedContentException(final String message, final Throwable t) {
    super(message, t);
  }
}
