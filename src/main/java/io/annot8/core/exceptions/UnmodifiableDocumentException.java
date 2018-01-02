package io.annot8.core.exceptions;

/**
 * Thrown if an attempt to modify a document is made whilst the document is in an unmodifiable state
 * (i.e. it has annotations associated with it).
 */
public class UnmodifiableDocumentException extends Annot8Exception {

  public UnmodifiableDocumentException(String message) {
    super(message);
  }

  public UnmodifiableDocumentException(String message, Throwable t) {
    super(message, t);
  }
}
