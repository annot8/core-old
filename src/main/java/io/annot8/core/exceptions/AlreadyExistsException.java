package io.annot8.core.exceptions;

/**
 * Exception indicating that an attempt has been made to create
 * something that already exists, i.e. has the same name or ID.
 */
public class AlreadyExistsException extends Annot8Exception {

  private static final long serialVersionUID = 1L;

  /**
   * Create an exception with the given message
   */
  public AlreadyExistsException(final String message) {
    super(message);
  }

  /**
   * Create an exception with the given message and a root cause
   */
  public AlreadyExistsException(final String message, final Throwable t) {
    super(message, t);
  }
}
