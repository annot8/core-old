package io.annot8.core.helpers;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface WithTags {
  default boolean hasTag(final String tag) {
    return getTags().anyMatch(tag::equals);
  }

  Stream<String> getTags();

  default void setTags(final Collection<String> tags) {
    removeAllTags(getTags().collect(Collectors.toList()));
    addAllTags(tags);
  }

  boolean addTag(String tag);

  default void addAllTags(final Collection<String> tags) {
    tags.forEach(this::addTag);
  }

  boolean removeTag(String tag);

  default void removeAllTags(final Collection<String> tags) {
    tags.forEach(this::removeTag);
  }
}
