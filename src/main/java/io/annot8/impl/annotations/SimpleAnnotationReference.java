package io.annot8.impl.annotations;

import java.util.Optional;
import java.util.stream.Stream;
import io.annot8.core.annotations.Annotation;
import io.annot8.core.annotations.AnnotationReference;
import io.annot8.core.data.Item;

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


  @Override
  public String getContentId() {
    return contentId;
  }

  public void setContentId(final String contentId) {
    this.contentId = contentId;
  }

  @Override
  public String getAnnotationId() {
    return annotationId;
  }

  public void setAnnotationId(final String annotationId) {
    this.annotationId = annotationId;
  }

  // TODO: These are really the only implementation... so wonder if they should be on the interface as
  // defaults? Or if the interface isnt good! ie should just be an annotationId managed internally. no
  // reference to content
  public static Optional<? extends Annotation<?>> toAnnotation(final Item item,
      final AnnotationReference reference) {
    return item.getContents().getContent(reference.getContentId())
        .flatMap(c -> c.getAnnotations().getById(reference.getAnnotationId()));
  }

  public static Stream<Annotation<?>> toAnnotations(final Item item,
      final Stream<AnnotationReference> streamReferences) {
    return streamReferences.map(r -> SimpleAnnotationReference.toAnnotation(item, r))
        .filter(Optional::isPresent).map(Optional::get);
  }

}
