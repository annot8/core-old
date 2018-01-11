package io.annot8.core.exceptions;

/**
 * Generic exception thrown if there is an error during processing of a document.
 */
public class ProcessingException extends Annot8Exception {

  private static final long serialVersionUID = 1L;

  public ProcessingException(final String message) {
    super(message);
  }

  public ProcessingException(final String message, final Throwable t) {
    super(message, t);
  }
}
