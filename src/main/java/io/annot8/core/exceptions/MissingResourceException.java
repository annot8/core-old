package io.annot8.core.exceptions;

/**
 * Thrown if a required resource is not provided to a component.
 */
public class MissingResourceException extends Annot8Exception {

  private static final long serialVersionUID = 1L;

  public MissingResourceException(final String message) {
    super(message);
  }

  public MissingResourceException(final String message, final Throwable t) {
    super(message, t);
  }
}
