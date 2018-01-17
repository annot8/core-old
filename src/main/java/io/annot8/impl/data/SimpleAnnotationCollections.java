package io.annot8.impl.data;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;
import io.annot8.core.annotations.AnnotationCollection;
import io.annot8.core.annotations.EditableAnnotationCollection;
import io.annot8.core.data.Item;
import io.annot8.core.stores.AnnotationCollections;
import io.annot8.impl.annotations.SimpleAnnotationCollection;
import io.annot8.impl.annotations.SimpleEditableAnnotationCollection;

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
  public EditableAnnotationCollection create() {
    return new SimpleEditableAnnotationCollection(item,
        Long.toString(idGenerator.incrementAndGet()));
  }

  @Override
  public AnnotationCollection save(final EditableAnnotationCollection annotation) {
    final AnnotationCollection collection = new SimpleAnnotationCollection(item, annotation);
    collections.put(collection.getId(), collection);
    return collection;
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
