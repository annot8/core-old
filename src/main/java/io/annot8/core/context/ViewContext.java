package io.annot8.core.context;

import io.annot8.core.documents.Document;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface ViewContext extends Context {

  Document getDocument();

  default boolean hasTag(String tag) {
    return getTags().anyMatch(s -> tag.equals(s));
  }
  Stream<String> getTags();
  default  void setTags(Collection<String> tags) {
    removeAllTags(getTags().collect(Collectors.toList()));
    addAllTags(tags);
  }
  boolean addTag(String tag);
  default void addAllTags(Collection<String> tags) {
    tags.stream().forEach(this::addTag);
  }
  boolean removeTag(String tag);
  default void removeAllTags(Collection<String> tags) {
    tags.stream().forEach(this::removeTag);
  }
}
