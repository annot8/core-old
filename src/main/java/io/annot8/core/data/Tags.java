package io.annot8.core.data;

import java.util.stream.Stream;

public interface Tags {
  default boolean has(final String tag) {
    return get().anyMatch(tag::equals);
  }

  Stream<String> get();
}
