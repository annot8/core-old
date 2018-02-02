package io.annot8.impl.data;

import java.util.Optional;
import java.util.stream.Stream;
import io.annot8.core.components.Resource;
import io.annot8.core.context.Context;
import io.annot8.core.data.Item;

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
  public Item createItem() {
    final SimpleAnnotationCollections annotationCollections = new SimpleAnnotationCollections();
    final SimpleItem item = new SimpleItem(annotationCollections);
    annotationCollections.setItem(item);
    return item;
  }

}
