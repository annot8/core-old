package io.annot8.impl.annotations;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;
import io.annot8.core.annotations.Annotation;
import io.annot8.core.annotations.AnnotationCollection;
import io.annot8.core.data.Item;
import io.annot8.core.data.Properties;
import io.annot8.impl.data.SimpleProperties;

public class SimpleAnnotationCollection implements AnnotationCollection {
  private final String id;
  private String type;
  private final SimpleProperties properties = new SimpleProperties();

  private final Set<SimpleAnnotationReference> references = new HashSet<>();
  private final Item item;


  public SimpleAnnotationCollection(final Item item, final String id) {
    this.item = item;
    this.id = id;
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



}
