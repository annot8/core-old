package io.annot8.simple;

import io.annot8.core.annotations.Annotation;
import io.annot8.core.bounds.Bounds;
import io.annot8.core.stores.AnnotationStore;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class SimpleAnnotation extends SimpleProperties implements Annotation {

  private final AnnotationStore annotationStore;

  private final String id;

  private String type;

  private Bounds bounds;

  public SimpleAnnotation(AnnotationStore annotationStore, String id) {
    this.annotationStore = annotationStore;
    this.id = id;
  }

  public SimpleAnnotation(SimpleAnnotationStore annotationStore, String id, Annotation annotation) {
    this(annotationStore, id);
  }

  protected AnnotationStore getAnnotationStore() {
    return annotationStore;
  }


  protected void setType(String type) {
    this.type = type;
  }

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
    SimpleAnnotation copy = new SimpleAnnotation(getAnnotationStore(), getId());
    copy.setType(getType());
    copy.setBounds(getBounds().copy());
    copy.setProperties(getProperties());
    return copy;

  }
}
