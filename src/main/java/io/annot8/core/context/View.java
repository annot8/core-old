package io.annot8.core.context;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import io.annot8.core.documents.Content;

public interface View<T> extends Context {

  Content<T> getContent();

  default boolean hasTag(String tag) {
    return getTags().anyMatch(tag::equals);
  }

  Stream<String> getTags();

  default void setTags(Collection<String> tags) {
    removeAllTags(getTags().collect(Collectors.toList()));
    addAllTags(tags);
  }

  boolean addTag(String tag);

  default void addAllTags(Collection<String> tags) {
    tags.forEach(this::addTag);
  }

  boolean removeTag(String tag);

  default void removeAllTags(Collection<String> tags) {
    tags.forEach(this::removeTag);
  }
}
