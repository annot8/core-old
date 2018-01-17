package io.annot8.core.annotations;

import io.annot8.core.bounds.Bounds;
import io.annot8.core.helpers.Saveable;
import io.annot8.core.helpers.WithEditableProperties;
import io.annot8.core.helpers.WithEditableType;

public interface EditableAnnotation<B extends Bounds> extends AbstractAnnotation<B>,
    Saveable<Annotation<B>>, WithEditableProperties, WithEditableType {

  // TODO: Should this be a setter? Perhaps you have to ask the annotationStore?
  // that would be safer...
  void setBounds(B bounds);

}
