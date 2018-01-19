package io.annot8.impl.annotations;

import io.annot8.core.annotations.Annotation;
import io.annot8.core.annotations.AnnotationReference;

public class SimpleAnnotationReference implements AnnotationReference {

  private String contentId;

  private String annotationId;

  public SimpleAnnotationReference(final String contentId, final String annotationId) {
    this.contentId = contentId;
    this.annotationId = annotationId;
  }

  public SimpleAnnotationReference(final Annotation<?> annotation) {
    this.contentId = annotation.getContentName();
    this.annotationId = annotation.getId();
  }


  public String getContentId() {
    return contentId;
  }

  public void setContentId(final String contentId) {
    this.contentId = contentId;
  }

  public String getAnnotationId() {
    return annotationId;
  }

  public void setAnnotationId(final String annotationId) {
    this.annotationId = annotationId;
  }

}
