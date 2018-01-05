package io.annot8.core.content;

import java.util.Optional;

public interface Content<T> {
  Optional<T> getContent();
}
