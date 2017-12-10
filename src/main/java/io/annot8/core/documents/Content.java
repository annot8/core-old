package io.annot8.core.documents;

import io.annot8.core.exceptions.UnmodifiableDocumentException;
import java.util.Optional;

public interface Content<T> {

  Optional<T> getContent();

  void setContent(T content) throws UnmodifiableDocumentException;

  boolean canModifyContent();
}
