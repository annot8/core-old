package io.annot8.core.context;

import io.annot8.core.annotations.Annotation;
import io.annot8.core.documents.Document;
import io.annot8.core.stores.AnnotationStore;
import io.annot8.core.stores.DocumentAnnotationStore;

/**
 * An extended version of {@link Context} which is passed to processors in the
 * process() function to provide them with the annotation store and any other
 * additional runtime information.
 */
public interface ProcessingContext extends Context {
	public AnnotationStore<Annotation> getAnnotationStore();
	public <T extends Annotation> AnnotationStore<T> getAnnotationStore(Class<? extends Annotation> T);
	
	default DocumentAnnotationStore<Annotation> getDocumentAnnotationStore(Document document){
		return new DocumentAnnotationStore<>(getAnnotationStore(), document);
	}
	default <T extends Annotation> DocumentAnnotationStore<T> getDocumentAnnotationStore(Document document, Class<? extends Annotation> T){
		return new DocumentAnnotationStore<>(getAnnotationStore(T), document);
	}
}
