package io.annot8.core.data;

import java.util.Set;
import java.util.stream.Stream;

public interface Tags {
  default boolean has(final String tag) {
    return asSet().contains(tag);
  }

  // TODO: hasAll(tags), hasAny(tags), isEquals(tags)

  default Stream<String> stream() {
    return asSet().stream();
  }

  Set<String> asSet();
}
