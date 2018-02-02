package io.annot8.core.exceptions;

/**
 * Base class for all Annot8 exceptions
 */
public class Annot8Exception extends Exception {

  private static final long serialVersionUID = 1L;

  /**
   * Create an exception with the given message
   */
  public Annot8Exception(final String message) {
    super(message);
  }

  /**
   * Create an exception with the given message and a root cause
   */
  public Annot8Exception(final String message, final Throwable t) {
    super(message, t);
  }
}
