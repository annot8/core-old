package io.annot8.core.data;

import java.util.Optional;
import java.util.stream.Stream;
import io.annot8.core.content.Content;
import io.annot8.core.exceptions.AlreadyExistsException;
import io.annot8.core.helpers.WithProperties;

public interface Item extends WithProperties {

  // Contents
  void setDefaultContent(String name);

  Content<?, ?, ?, ?> getDefaultContent();

  default boolean hasContent(final String name) {
    return listContents().anyMatch(name::equals);
  }

  Stream<String> listContents();

  Optional<Content<?, ?, ?, ?>> getContent(String name);

  Stream<Content<?, ?, ?, ?>> getContents();

  <T extends Content<?, ?, ?, ?>> Stream<T> getContents(Class<T> clazz);

  void addContent(String name, Content<?, ?, ?, ?> content) throws AlreadyExistsException;

  void removeContent(String name);

}
