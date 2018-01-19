package io.annot8.impl.data;

import java.util.Optional;
import java.util.stream.Stream;
import io.annot8.core.components.Resource;
import io.annot8.core.data.Context;
import io.annot8.core.data.EditableItem;
import io.annot8.impl.stores.SimpleAnnotationCollections;
import io.annot8.impl.stores.SimpleContents;

public class SimpleComponentContext implements Context {

  private final SimpleGlobalContext context;
  private final Object configuration;

  public SimpleComponentContext(final SimpleGlobalContext context, final Object configuration) {
    this.context = context;
    this.configuration = configuration;
  }

  @Override
  public Optional<Object> getConfiguration() {
    return Optional.ofNullable(configuration);
  }

  @Override
  public <T extends Resource> Optional<T> getResource(final String key, final Class<T> clazz) {
    return context.getResource(key, clazz);
  }

  @Override
  public <T extends Resource> Stream<T> getResources(final Class<T> clazz) {
    return context.getResources(clazz);
  }

  @Override
  public EditableItem createItem() {
    final SimpleAnnotationCollections annotationCollections = new SimpleAnnotationCollections();
    final EditableItem item = new SimpleEditableItem(annotationCollections, new SimpleContents());
    annotationCollections.setItem(item);
    return item;
  }

  @Override
  public Stream<String> listResourceKeys() {
    return context.listResourceKeys();
  }

}
