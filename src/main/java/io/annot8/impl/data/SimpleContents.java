package io.annot8.impl.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;
import io.annot8.content.text.Text;
import io.annot8.core.data.Content;
import io.annot8.core.data.EditableContent;
import io.annot8.core.exceptions.AlreadyExistsException;
import io.annot8.core.exceptions.UnsupportedContentException;
import io.annot8.core.stores.Contents;
import io.annot8.impl.stores.TextAnnotationMemoryStore;

public class SimpleContents implements Contents {

  private final Map<String, Content<?>> contents = new HashMap<>();
  private String defaultContentName = DEFAULT_CONTENT;
  private static final String DEFAULT_CONTENT = "__default";

  @Override
  public void setDefaultContent(final String name) {
    defaultContentName = name;
  }

  @Override
  public Content<?> getDefaultContent() {
    return contents.get(defaultContentName);
  }

  @Override
  public Stream<String> listContents() {
    return contents.keySet().stream();
  }

  @Override
  public Optional<Content<?>> getContent(final String name) {
    return Optional.ofNullable(contents.get(name));
  }

  @Override
  public Stream<Content<?>> getContents() {
    return contents.values().stream();
  }

  @Override
  public <T extends Content<?>> Stream<T> getContents(final Class<T> clazz) {
    final List<T> ret = new ArrayList<>();

    contents.values().stream().filter(c -> clazz.isAssignableFrom(c.getClass()))
        .forEach(c -> ret.add(clazz.cast(c)));

    return ret.stream();
  }


  @Override
  public <D, C extends Content<D>, E extends EditableContent<D>> E create(final String name,
      final Class<C> contentClass, final D data)
      throws AlreadyExistsException, UnsupportedContentException {
    if (contents.containsKey(name))
      throw new AlreadyExistsException("Content with that name already exists");

    // TODO: This should occur via an abstract method so it can be replaced...
    E content = null;
    if (Text.class.equals(contentClass)) {
      // THis is correct in claiming unchecked.. we don't know the class of E...we hope its actually the
      // interface EditableText
      // so whatever impleemntation doesn't matter.
      content = (E) new SimpleEditableText(name, (String) data, new TextAnnotationMemoryStore(name));
    } else {
      throw new UnsupportedContentException(String.format("%s is not supported by this item",
          contentClass.getClass().getSimpleName()));
    }

    return content;
  }

}
