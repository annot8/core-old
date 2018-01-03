package io.annot8.simple;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;

import io.annot8.core.annotations.Annotation;
import io.annot8.core.stores.AnnotationStore;


// TODO: CF this is a lazy implementation using defaults... note we basically copy all the annotations all the time!
// since we use getAll() for everything. So every in-efficient...
public class SimpleAnnotationStore implements AnnotationStore {

  private final AtomicLong idGenerator = new AtomicLong();

  // Id to Annotation
  private final Map<String, SimpleAnnotation> annotations = new HashMap<>();

  @Override
  public Annotation create() {
    String id = generateId();
    // Note we don't add it... to the map until save...
    return new SimpleAnnotation(this, id);
  }

  private String generateId() {
    return "sa-" + Long.toString(idGenerator.incrementAndGet());
  }

  @Override
  public Annotation save(Annotation annotation) {
    // Convert to a simple annotation
    SimpleAnnotation sa;
    if (annotation instanceof SimpleAnnotation) {
      sa = (SimpleAnnotation) annotation;
    } else {
      String id = annotation.getId() != null && annotation.getId() != "" ? annotation.getId()
          : generateId();
      sa = new SimpleAnnotation(this, id, annotation);
    }

    annotations.put(annotation.getId(), sa);

    return sa;
  }

  @Override
  public void delete(Annotation annotation) {
    annotations.remove(annotation.getId());
  }

  @Override
  public Stream<Annotation> getAll() {
    // TODO: See copy issue above...
    return annotations.values().stream().map(SimpleAnnotation::copy);
  }
}
