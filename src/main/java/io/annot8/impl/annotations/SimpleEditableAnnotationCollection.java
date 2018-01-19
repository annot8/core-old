package io.annot8.impl.annotations;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;
import io.annot8.core.annotations.Annotation;
import io.annot8.core.annotations.AnnotationCollection;
import io.annot8.core.annotations.AnnotationReference;
import io.annot8.core.annotations.EditableAnnotationCollection;
import io.annot8.core.data.Properties;
import io.annot8.impl.data.SimpleProperties;
import io.annot8.impl.stores.SimpleAnnotationCollections;

public class SimpleEditableAnnotationCollection implements EditableAnnotationCollection {
  private final String id;
  private final SimpleProperties properties;
  private final SimpleAnnotationCollections annotationCollections;
  private final Set<AnnotationReference> references;

  private String type;

  public SimpleEditableAnnotationCollection(final SimpleAnnotationCollections simpleAnnotationCollections,
      final String id) {
    this.annotationCollections = simpleAnnotationCollections;
    this.id = id;
    this.properties = new SimpleProperties();
    this.references = new HashSet<>();
  }

  public SimpleEditableAnnotationCollection(final SimpleAnnotationCollections simpleAnnotationCollections,
      final AnnotationCollection collection) {
    this.annotationCollections = simpleAnnotationCollections;
    this.id = collection.getId();
    this.type = collection.getType();
    this.references = collection.asSet();
    this.properties = new SimpleProperties(collection.getProperties());
  }

  @Override
  public String getId() {
    return id;
  }

  @Override
  public String getType() {
    return type;
  }

  @Override
  public void setType(final String type) {
    this.type = type;
  }

  @Override
  public Properties getProperties() {
    return properties;
  }


  @Override
  public void add(final Annotation<?> annotation) {
    references.add(new SimpleAnnotationReference(annotation));
  }

  @Override
  public void remove(final Annotation<?> annotation) {
    references.remove(new SimpleAnnotationReference(annotation));
  }

  @Override
  public boolean contains(final Annotation<?> annotation) {
    return contains(annotationCollections.toReference(annotation));
  }

  @Override
  public Set<AnnotationReference> asSet() {
    return references;
  }

  @Override
  public AnnotationCollection save() {
    final SimpleAnnotationCollection collection = new SimpleAnnotationCollection(annotationCollections, this);
    annotationCollections.save(collection);
    return collection;
  }

  @Override
  public void delete() {
    annotationCollections.delete(this);
  }

  @Override
  public Stream<Annotation<?>> stream() {
    return annotationCollections.toAnnotations(streamReferences());
  }

}
