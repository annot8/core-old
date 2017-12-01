package io.annot8.core.stores;

import java.util.Set;

import io.annot8.core.annotations.Annotation;
import io.annot8.core.documents.Document;

public interface AnnotationStore<T extends Annotation> {
	public void addAnnotation(Document document, T annotation);
	public void removeAnnotation(Document document, T annotation);

	public void addAnnotations(Document document, Set<T> annotations);
	public void removeAnnotations(Document document, Set<T> annotations);
	
	public Set<T> getAnnotations(Document document);
	public <U extends T> Set<U> getAnnotations(Document document, Class<U> annotationClass);
}
