package io.annot8.core.context;

import io.annot8.core.documents.Document;
import java.util.Collection;
import java.util.Set;

public interface ViewContext extends Context {

  Document getDocument();

  boolean hasTag(String tag);
  Set<String> getTags();
  void setTags(Set<String> tags);
  boolean addTag(String tag);
  void addAllTags(Collection<String> tags);
  boolean removeTag(String tag);
  void removeAllTags(Collection<String> tags);
}
