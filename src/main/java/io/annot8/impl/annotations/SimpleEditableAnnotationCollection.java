package io.annot8.impl.annotations;

import java.util.HashSet;
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

public class SimpleEditableAnnotationCollection implements EditableAnnotationCollection {
  private final String id;
  private final SimpleProperties properties;

  private final Set<SimpleAnnotationReference> references;
  private final Item item;

  private String type;


  public SimpleEditableAnnotationCollection(final Item item, final String id) {
    this.item = item;
    this.id = id;
    this.properties = new SimpleProperties();
    this.references = new HashSet<>();;
  }

  public SimpleEditableAnnotationCollection(final Item item,
      final AnnotationCollection collection) {
    this.item = item;
    this.id = collection.getId();
    this.type = collection.getType();
    // TODO: I think getting the references is valid on the AnnotationCollection interface as it
    // saves this silliness
    this.references = new HashSet<>(collection.getAnnotations().map(SimpleAnnotationReference::new)
        .collect(Collectors.toList()));
    // TODO: Mutable
    this.properties = new SimpleProperties();
    this.properties.set(collection.getProperties().getAll());
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
  public Stream<Annotation<?>> getAnnotations() {
    return references.stream().map(r -> r.toAnnotation(item)).filter(Optional::isPresent)
        .map(Optional::get);
  }

  @Override
  public void addAnnotation(final Annotation<?> annotation) {
    references.add(new SimpleAnnotationReference(annotation));

  }

  @Override
  public void removeAnnotation(final Annotation<?> annotation) {
    references.remove(new SimpleAnnotationReference(annotation));
  }

  @Override
  public boolean containsAnnotation(final Annotation<?> annotation) {
    return references.contains(new SimpleAnnotationReference(annotation));
  }

  @Override
  public AnnotationCollection save() {
    return item.getAnnotationCollections().save(this);
  }



}