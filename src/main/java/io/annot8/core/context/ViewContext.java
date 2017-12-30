package io.annot8.core.context;

import io.annot8.core.documents.Document;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface ViewContext extends Context {

  Document getDocument();

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
