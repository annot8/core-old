package io.annot8.core.data;

import java.util.Collection;
import java.util.stream.Collectors;

public interface EditableTags extends Tags {

  default void set(final Collection<String> tags) {
    remove(stream().collect(Collectors.toList()));
    add(tags);
  }

  boolean add(String tag);

  default void add(final Collection<String> tags) {
    tags.forEach(this::add);
  }

  boolean remove(String tag);

  default void remove(final Collection<String> tags) {
    tags.forEach(this::remove);
  }
}
