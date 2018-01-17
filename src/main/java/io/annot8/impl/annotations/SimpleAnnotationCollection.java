package io.annot8.impl.annotations;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import io.annot8.core.annotations.Annotation;
import io.annot8.core.annotations.AnnotationCollection;
import io.annot8.core.annotations.EditableAnnotationCollection;
import io.annot8.core.data.Item;
import io.annot8.core.data.Properties;
import io.annot8.impl.data.SimpleProperties;

public class SimpleAnnotationCollection implements AnnotationCollection {
  private final String id;
  private final String type;
  private final Properties properties;
  private final Set<SimpleAnnotationReference> references;
  private final Item item;


  public SimpleAnnotationCollection(final Item item, final String id, final String type) {
    this.item = item;
    this.id = id;
    this.type = type;
    this.references = Collections.emptySet();
    // TODO: immutable
    this.properties = new SimpleProperties();
  }

  public SimpleAnnotationCollection(final Item item,
      final EditableAnnotationCollection annotation) {
    this.item = item;
    this.id = annotation.getId();
    this.type = annotation.getType();
    this.references =
        annotation.getAnnotations().map(SimpleAnnotationReference::new).collect(Collectors.toSet());
    // TODO: immutable
    this.properties = annotation.getProperties();
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
  public Properties getProperties() {
    return properties;
  }

  @Override
  public Stream<Annotation<?>> getAnnotations() {
    return references.stream().map(r -> r.toAnnotation(item)).filter(Optional::isPresent)
        .map(Optional::get);
  }

  @Override
  public boolean containsAnnotation(final Annotation<?> annotation) {
    return references.contains(new SimpleAnnotationReference(annotation));
  }

  @Override
  public EditableAnnotationCollection edit() {
    return new SimpleEditableAnnotationCollection(item, this);
  }

  @Override
  public void delete() {
    item.getAnnotationCollections().delete(this);
  }


}
