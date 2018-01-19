package io.annot8.core.stores;

import java.util.Optional;
import java.util.stream.Stream;
import io.annot8.core.data.Content;
import io.annot8.core.data.EditableContent;
import io.annot8.core.exceptions.AlreadyExistsException;
import io.annot8.core.exceptions.Annot8MissingContentException;
import io.annot8.core.exceptions.UnsupportedContentException;

public interface Contents {
  // Contents
  // TODO: Assume defaults are on the Contents, nots on the Item... could be either

  default void setDefault(final Content<?> content) throws Annot8MissingContentException {
    setDefaultByName(content.getName());
  }

  Content<?> getDefault();

  void setDefaultByName(String name) throws Annot8MissingContentException;

  default boolean has(final String name) {
    return listContents().anyMatch(name::equals);
  }

  Stream<String> listContents();

  Optional<Content<?>> get(String name);

  Stream<Content<?>> stream();

  <T extends Content<?>> Stream<T> stream(Class<T> clazz);

  // TODO: note this isn't as safe as it looks, we want to allow for a return of EditableText from
  // Text.class
  // but the develoepr might say MongoContent when return SimpleContent... both would pass
  // compilation. It would be nice to param Content<D, E extends EditableContent<D>> but as
  // EditableContent extends Content<D> it gets messy
  <D, C extends Content<D>, E extends EditableContent<D>> E create(String name, Class<C> contentClass, D data)
      throws AlreadyExistsException, UnsupportedContentException;

}
