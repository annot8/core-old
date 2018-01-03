package io.annot8.core.exceptions;

/**
 * Base class for all Annot8 exceptions, so that they can be easily caught by lazy developers.
 */
public class Annot8Exception extends Exception {

  private static final long serialVersionUID = 1L;

  public Annot8Exception(final String message) {
    super(message);
  }

  public Annot8Exception(final String message, final Throwable t) {
    super(message, t);
  }
}
