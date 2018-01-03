package io.annot8.core.content;

import io.annot8.core.exceptions.UnmodifiableDocumentException;

public interface Content<T> {

  T getContent();

  default void setContent(T content) throws UnmodifiableDocumentException {
    throw new UnmodifiableDocumentException("Not able to change content");
  }

  Class<T> getContentClass();

  default boolean canModifyContent() {
    return false;
  }
}
