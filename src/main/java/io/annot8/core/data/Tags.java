package io.annot8.core.data;

import java.util.stream.Stream;

public interface Tags {
  default boolean has(final String tag) {
    return stream().anyMatch(tag::equals);
  }

  Stream<String> stream();

  // TODO: Should this have a asSet() interface...?
}
