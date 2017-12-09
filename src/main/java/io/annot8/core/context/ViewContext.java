package io.annot8.core.context;

import io.annot8.core.documents.Document;
import java.util.Collection;
import java.util.Set;

public interface ViewContext extends Context {

  Document getDocument();

  default boolean hasTag(String tag) {
    return getTags().contains(tag);
  }
  Set<String> getTags();
  default  void setTags(Set<String> tags) {
    removeAllTags(getTags());
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
