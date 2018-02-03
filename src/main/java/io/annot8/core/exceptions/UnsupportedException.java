package io.annot8.core.exceptions;

/**
 * Exception indicating that the class is not supported
 */
public class UnsupportedException extends Annot8Exception {

  private static final long serialVersionUID = 1L;

  /**
   * Create an exception with the given message
   */
  public UnsupportedException(final String message) {
    super(message);
  }

  /**
   * Create an exception with the given message and a root cause
   */
  public UnsupportedException(final String message, final Throwable t) {
    super(message, t);
  }
}
