package io.annot8.core.data;

import java.util.Collection;
import java.util.Set;

import io.annot8.core.content.Content;

public interface View {

  String getName();

  Content<?> getContent();

  default boolean hasTag(String tag) {
    return getTags().contains(tag);
  }

  Set<String> getTags();

  default void setTags(Collection<String> tags) {
    removeAllTags(getTags());
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
