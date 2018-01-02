package io.annot8.core.exceptions;

/**
 * Thrown if an unacceptable configuration is provided to a component, or required configuration
 * information is missing.
 */
public class BadConfigurationException extends Annot8Exception {

  public BadConfigurationException(String message) {
    super(message);
  }

  public BadConfigurationException(String message, Throwable t) {
    super(message, t);
  }
}
