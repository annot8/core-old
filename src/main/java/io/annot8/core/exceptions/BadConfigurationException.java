package io.annot8.core.exceptions;

/**
 * Thrown if an unacceptable configuration is provided to a component, or required configuration
 * information is missing.
 */
public class BadConfigurationException extends Annot8Exception {

  private static final long serialVersionUID = 1L;

  public BadConfigurationException(final String message) {
    super(message);
  }

  public BadConfigurationException(final String message, final Throwable t) {
    super(message, t);
  }
}
