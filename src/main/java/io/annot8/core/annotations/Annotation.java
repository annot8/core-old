package io.annot8.core.annotations;


import io.annot8.core.bounds.Bounds;
import io.annot8.core.helpers.Deletable;
import io.annot8.core.helpers.Editable;
import io.annot8.core.helpers.WithId;
import io.annot8.core.helpers.WithProperties;
import io.annot8.core.helpers.WithType;

/**
 * Base annotation interface from which all other annotations extend.
 *
 * This class provides the common functionality required to track the history of an annotation (i.e.
 * which processor created it, which ones modified it, etc.)
 */
public interface Annotation<B extends Bounds>
    extends WithId, WithType, WithProperties, Editable<EditableAnnotation<B>>, Deletable {
  B getBounds();

  // The content against which this annotation was created
  String getContentName();

}
