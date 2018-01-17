package io.annot8.core.data;

import java.util.Collection;
import java.util.stream.Collectors;

public interface EditableTags extends Tags {

  default void set(final Collection<String> tags) {
    removeAll(get().collect(Collectors.toList()));
    addAll(tags);
  }

  boolean add(String tag);

  default void addAll(final Collection<String> tags) {
    tags.forEach(this::add);
  }

  boolean remove(String tag);

  default void removeAll(final Collection<String> tags) {
    tags.forEach(this::remove);
  }
}
