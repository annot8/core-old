package io.annot8.base.processors;

import java.util.Collections;
import java.util.Set;

public class ContentAnnotatorSettings {
  /// List of tags that a view much have
  // null/empty implies all
  private final Set<String> tags = Collections.emptySet();

  // List of view name to consider
  // null/empty implies all
  private final Set<String> views = Collections.emptySet();


  // If true process default view only
  // note you can not set both views field and this. If this is true then only the default will be
  // even be considered.
  private final boolean defaultView = false;

  public Set<String> getTags() {
    return tags;
  }

  public Set<String> getViews() {
    return views;
  }

  public boolean isDefaultView() {
    return defaultView;
  }
}
