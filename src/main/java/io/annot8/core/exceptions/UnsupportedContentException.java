package io.annot8.core.exceptions;

/**
 * Exception indicating that the content type is not supported
 */
public class UnsupportedContentException extends Annot8Exception {

  private static final long serialVersionUID = 1L;

  /**
   * Create an exception with the given message
   */
  public UnsupportedContentException(final String message) {
    super(message);
  }

  /**
   * Create an exception with the given message and a root cause
   */
  public UnsupportedContentException(final String message, final Throwable t) {
    super(message, t);
  }
}
