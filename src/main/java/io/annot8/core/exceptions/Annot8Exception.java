package io.annot8.core.exceptions;

/**
 * Base class for all Annot8 exceptions, so that they can be easily caught by lazy developers.
 */
public class Annot8Exception extends Exception {

  public Annot8Exception(String message) {
    super(message);
  }

  public Annot8Exception(String message, Throwable t) {
    super(message, t);
  }
}
