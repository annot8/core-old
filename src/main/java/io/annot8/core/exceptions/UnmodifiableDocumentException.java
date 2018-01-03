package io.annot8.core.exceptions;

/**
 * Thrown if an attempt to modify a document is made whilst the document is in an unmodifiable state
 * (i.e. it has annotations associated with it).
 */
public class UnmodifiableDocumentException extends Annot8Exception {

  private static final long serialVersionUID = 1L;

  public UnmodifiableDocumentException(final String message) {
    super(message);
  }

  public UnmodifiableDocumentException(final String message, final Throwable t) {
    super(message, t);
  }
}
