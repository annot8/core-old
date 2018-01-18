package io.annot8.core.annotations;

import io.annot8.core.bounds.Bounds;
import io.annot8.core.helpers.Saveable;
import io.annot8.core.helpers.WithEditableProperties;
import io.annot8.core.helpers.WithEditableType;

public interface EditableAnnotation<B extends Bounds>
    extends Annotation<B>, Saveable<Annotation<B>>, WithEditableProperties, WithEditableType {

  void setBounds(B bounds);


}
