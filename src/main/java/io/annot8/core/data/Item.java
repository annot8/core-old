package io.annot8.core.data;

import io.annot8.core.exceptions.AlreadyExistsException;
import io.annot8.core.exceptions.UnsupportedContentException;
import io.annot8.core.helpers.WithGroups;
import io.annot8.core.helpers.WithMutableProperties;

import java.util.Optional;
import java.util.stream.Stream;

public interface Item extends WithMutableProperties, WithGroups {

  // Contents
  void setDefaultContent(String name);

  Content<?> getDefaultContent();

  default boolean hasContent(final String name) {
    return listContents().anyMatch(name::equals);
  }

  Stream<String> listContents();

  Optional<Content<?>> getContent(String name);

  Stream<Content<?>> getContents();

  <T extends Content<?>> Stream<T> getContents(Class<T> clazz);

  <C extends Content<?>> C create(String name, C.Builder builder) throws AlreadyExistsException, UnsupportedContentException;

  void removeContent(String name);

}
