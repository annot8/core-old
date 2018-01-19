package io.annot8.impl.stores;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;
import io.annot8.core.annotations.Annotation;
import io.annot8.core.annotations.AnnotationCollection;
import io.annot8.core.annotations.AnnotationReference;
import io.annot8.core.annotations.EditableAnnotationCollection;
import io.annot8.core.data.Item;
import io.annot8.core.stores.AnnotationCollections;
import io.annot8.impl.annotations.SimpleAnnotationCollection;
import io.annot8.impl.annotations.SimpleAnnotationReference;
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
  public Optional<AnnotationCollection> getById(final String id) {
    return Optional.ofNullable(collections.get(id));
  }

  @Override
  public EditableAnnotationCollection create() {
    return new SimpleEditableAnnotationCollection(this,
        Long.toString(idGenerator.incrementAndGet()));
  }

  @Override
  public Stream<AnnotationCollection> stream() {
    return collections.values().stream();
  }

  public void save(final SimpleAnnotationCollection collection) {
    collections.put(collection.getId(), collection);
  }

  public void delete(final AnnotationCollection annotation) {
    collections.remove(annotation.getId());
  }

  @Override
  public Optional<Annotation<?>> toAnnotation(
      final AnnotationReference reference) {
    if (reference instanceof SimpleAnnotationReference) {
      final SimpleAnnotationReference sar = (SimpleAnnotationReference) reference;
      // TODO: Not really use what the issue is here... diffrerent <?> ??
      return (Optional<Annotation<?>>) item.getContents().get(sar.getContentId())
          .flatMap(c -> c.getAnnotations().getById(sar.getAnnotationId()));
    }

    return Optional.empty();
  }

  @Override
  public AnnotationReference toReference(final Annotation<?> annotation) {
    return new SimpleAnnotationReference(annotation);
  }



}
