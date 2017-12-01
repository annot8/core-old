package io.annot8.core.stores;

import java.util.Set;

import io.annot8.core.annotations.Annotation;
import io.annot8.core.documents.Document;

public class DocumentAnnotationStore<T extends Annotation> {
	private final AnnotationStore<T> annotationStore;
	private final Document document;
	
	public DocumentAnnotationStore(AnnotationStore<T> annotationStore, Document document) {
		this.annotationStore = annotationStore;
		this.document = document;
	}
	
	public void addAnnotation(T annotation) {
		annotationStore.addAnnotation(document, annotation);
	}
	public void removeAnnotation(T annotation) {
		annotationStore.removeAnnotation(document, annotation);
	}

	public void addAnnotations(Set<T> annotations) {
		annotationStore.addAnnotations(document, annotations);
	}
	public void removeAnnotations(Set<T> annotations) {
		annotationStore.removeAnnotations(document, annotations);
	}
	
	public Set<T> getAnnotations(){
		return annotationStore.getAnnotations(document);
	}
	public <U extends T> Set<U> getAnnotations(Class<U> annotationClass){
		return annotationStore.getAnnotations(document, annotationClass);
	}
}
