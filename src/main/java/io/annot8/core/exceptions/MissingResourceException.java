package io.annot8.core.exceptions;

/**
 * Thrown if a required resource is not provided to a component.
 */
public class MissingResourceException extends Annot8Exception {

  public MissingResourceException(String message) {
    super(message);
  }

  public MissingResourceException(String message, Throwable t) {
    super(message, t);
  }
}
