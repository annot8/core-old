package io.annot8.core.documents;

import io.annot8.core.exceptions.UnmodifiableDocumentException;
import java.util.Optional;

// TODO: CF: I Don't think this generic T is worth it...?
public interface Content<T> {

  Optional<T> getContent();

  void setContent(T content) throws UnmodifiableDocumentException;

  boolean canModifyContent();
}
