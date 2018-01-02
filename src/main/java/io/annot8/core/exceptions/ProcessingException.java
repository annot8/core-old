package io.annot8.core.exceptions;

/**
 * Generic exception thrown if there is an error during processing of a document.
 */
public class ProcessingException extends Annot8Exception {

  public ProcessingException(String message) {
    super(message);
  }

  public ProcessingException(String message, Throwable t) {
    super(message, t);
  }
}
