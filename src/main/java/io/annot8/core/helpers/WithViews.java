package io.annot8.core.helpers;

import java.util.Optional;
import java.util.stream.Stream;

import io.annot8.core.content.Content;
import io.annot8.core.data.View;

public interface WithViews {

  // Views

  Optional<View> getDefaultView();

  void setDefaultView(String name);

  default boolean hasView(String name) {
    return listViews().anyMatch(name::equals);
  }

  Stream<View> listViews();

  Optional<View> getView(String name);

  View createView(String name, Content<?> content);

  Optional<View> removeView(String name);
}
