package io.annot8.impl.data;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;
import io.annot8.core.annotations.AnnotationCollection;
import io.annot8.core.data.AnnotationCollections;
import io.annot8.core.data.Item;
import io.annot8.impl.annotations.SimpleAnnotationCollection;

public class SimpleAnnotationCollections implements AnnotationCollections {

  private final Map<String, AnnotationCollection> collections = new HashMap<>();
  private final AtomicLong idGenerator = new AtomicLong();
  private Item item;


  public SimpleAnnotationCollections() {

  }

  public SimpleAnnotationCollections(final Item item) {
    this.item = item;
  }


  // TODO: Ugliness as you need this to create item, but need item to create this...
  public void setItem(final Item item) {
    this.item = item;
  }


  @Override
  public AnnotationCollection create() {
    return new SimpleAnnotationCollection(item, Long.toString(idGenerator.incrementAndGet()));
  }

  @Override
  public void save(final AnnotationCollection annotation) {
    collections.put(annotation.getId(), annotation);
  }

  @Override
  public void delete(final AnnotationCollection annotation) {
    collections.remove(annotation.getId());
  }

  @Override
  public Stream<AnnotationCollection> getAll() {
    return collections.values().stream();
  }

}
