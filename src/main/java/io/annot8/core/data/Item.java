package io.annot8.core.data;

import io.annot8.core.helpers.Editable;
import io.annot8.core.helpers.WithAnnotationCollections;
import io.annot8.core.helpers.WithContents;
import io.annot8.core.helpers.WithProperties;

public interface Item extends WithProperties, WithContents, WithAnnotationCollections, Editable<EditableItem> {

}
