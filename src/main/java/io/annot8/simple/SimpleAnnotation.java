package io.annot8.simple;

import io.annot8.core.annotations.Annotation;
import io.annot8.core.bounds.Bounds;
import io.annot8.core.stores.AnnotationStore;
import lombok.Data;

@Data
public class SimpleAnnotation implements Annotation {

  private final AnnotationStore annotationStore;

  private final String id;

  private String type;

  private Bounds bounds;

  private SimpleProperties properties = new SimpleProperties();

  public SimpleAnnotation(final AnnotationStore annotationStore, final String id) {
    this.annotationStore = annotationStore;
    this.id = id;
  }

  public SimpleAnnotation(final SimpleAnnotationStore annotationStore, final String id,
      final Annotation annotation) {
    this(annotationStore, id);
  }

  protected AnnotationStore getAnnotationStore() {
    return annotationStore;
  }


  protected void setType(final String type) {
    this.type = type;
  }

  @Override
  public String getType() {
    return type;
  }

  @Override
  public void save() {
    annotationStore.save(this);
  }

  @Override
  public void delete() {
    annotationStore.save(this);
  }

  @Override
  public Annotation copy() {
    final SimpleAnnotation copy = new SimpleAnnotation(getAnnotationStore(), getId());
    copy.setType(getType());
    copy.setBounds(getBounds().copy());
    copy.setProperties(getProperties());
    return copy;

  }
}
