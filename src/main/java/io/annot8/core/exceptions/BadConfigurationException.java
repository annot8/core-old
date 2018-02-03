package io.annot8.core.exceptions;

/**
 * Exception indicating that an unacceptable configuration has been
 * provided to a component, or required configuration information is missing.
 */
public class BadConfigurationException extends Annot8Exception {

  private static final long serialVersionUID = 1L;

  /**
   * Create an exception with the given message
   */
  public BadConfigurationException(final String message) {
    super(message);
  }

  /**
   * Create an exception with the given message and a root cause
   */
  public BadConfigurationException(final String message, final Throwable t) {
    super(message, t);
  }
}
