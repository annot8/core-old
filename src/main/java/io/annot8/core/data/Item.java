package io.annot8.core.data;

import java.util.Optional;
import java.util.stream.Stream;
import io.annot8.core.exceptions.AlreadyExistsException;
import io.annot8.core.exceptions.UnsupportedContentException;
import io.annot8.core.helpers.WithAnnotationCollections;
import io.annot8.core.helpers.WithEditableProperties;

// TODO: WithEditableProperties to make things work ... until we decide if this needs a save?
public interface Item extends WithEditableProperties, WithAnnotationCollections {

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

  // TODO: note this isn't as safe as it looks we want to return for EditableText from Text.class
  <D, C extends Content<D>, E extends C> E create(String name, Class<C> contentClass, D data)
      throws AlreadyExistsException, UnsupportedContentException;

  void deleteContent(String name);

  public <D, C extends Content<D>, E extends C> C saveContent(final E content);

}
