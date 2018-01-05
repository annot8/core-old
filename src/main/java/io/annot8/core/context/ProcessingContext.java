package io.annot8.core.context;

import io.annot8.core.stores.AnnotationStore;

/**
 * An extended version of {@link Context} which is passed to processors in the process() function to
 * provide them with the annotation store and any other additional runtime information.
 */
public interface ProcessingContext extends Context {
    AnnotationStore getAnnotationStore();
    void setAnnotationStore(AnnotationStore store);
}
