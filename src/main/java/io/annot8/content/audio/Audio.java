package io.annot8.core.content;

import io.annot8.core.annotations.AudioAnnotation;
import io.annot8.core.bounds.LinearBounds;
import io.annot8.core.stores.AudioAnnotationStore;

public interface Audio
    extends TypedContent<LinearBounds, AudioAnnotation, AudioAnnotationStore, byte[]> {


}
