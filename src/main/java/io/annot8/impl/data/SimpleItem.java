package io.annot8.impl.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;
import io.annot8.content.text.Text;
import io.annot8.core.data.Content;
import io.annot8.core.data.EditableProperties;
import io.annot8.core.data.Item;
import io.annot8.core.exceptions.AlreadyExistsException;
import io.annot8.core.exceptions.UnsupportedContentException;
import io.annot8.core.stores.AnnotationCollections;
import io.annot8.impl.stores.TextAnnotationMemoryStore;

public class SimpleItem implements Item {

  private final Map<String, Content<?>> contents = new HashMap<>();
  private String defaultContentName = DEFAULT_CONTENT;

  private final SimpleProperties properties = new SimpleProperties();
  private final AnnotationCollections annotationCollections;

  private static final String DEFAULT_CONTENT = "__default";

  public SimpleItem(final AnnotationCollections collections) {
    this.annotationCollections = collections;
  }

  public SimpleItem(final AnnotationCollections collections, final Content<?> defaultContent) {
    this(collections);
    contents.put(DEFAULT_CONTENT, defaultContent);
  }

  public SimpleItem(final AnnotationCollections collections, final Content<?> defaultContent,
      final String defaultContentName) {
    this(collections);
    contents.put(defaultContentName, defaultContent);
    this.defaultContentName = defaultContentName;
  }

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
  public <D, C extends Content<D>, E extends C> E create(final String name, final Class<C> contentClass,
      final D data) throws AlreadyExistsException, UnsupportedContentException {
    if (contents.containsKey(name))
      throw new AlreadyExistsException("Content with that name already exists");

    // TODO: This should occur via an abstract method so it can be replaced...
    E content = null;
    if (Text.class.equals(contentClass)) {
      // This is actually checked by thes Text.class... as is the String cast
      content = (E) new SimpleEditableText(name, (String) data, new TextAnnotationMemoryStore(name));
    } else {
      throw new UnsupportedContentException(String.format("%s is not supported by this item",
          contentClass.getClass().getSimpleName()));
    }

    return content;
  }


  @Override
  public <D, C extends Content<D>, E extends C> C saveContent(final E content) {
    contents.put(content.getName(), content);
    // TODO: Not correct... how to convert E to C...
    // will be responsibility of the content soon, not this item
    return content;
  }

  @Override
  public void deleteContent(final String name) {
    contents.remove(name);
  }

  @Override
  public EditableProperties getProperties() {
    return properties;
  }

  @Override
  public AnnotationCollections getAnnotationCollections() {
    return annotationCollections;
  }



}
