package io.annot8.core.stores;

import java.util.Set;

import io.annot8.core.annotations.Annotation;
import io.annot8.core.context.Context;
import io.annot8.core.documents.Document;
import io.annot8.core.exceptions.BadConfigurationException;
import io.annot8.core.exceptions.MissingResourceException;

/**
 * Stores {@link Annotation} objects against {@link Document}s,
 * and allows retrieval of annotations associated with a given
 * document.
 * 
 * @param <T>
 * 		The type of {@link Annotation} stored by this store
 */
public interface AnnotationStore<T extends Annotation> extends AutoCloseable{
	public void configure(Context context) throws BadConfigurationException, MissingResourceException;
	
	public void addAnnotation(Document document, T annotation);
	public void updateAnnotation(Document document, T annotation);
	public void removeAnnotation(Document document, T annotation);

	public void addAnnotations(Document document, Set<T> annotations);
	public void updateAnnotations(Document document, Set<T> annotations);
	public void removeAnnotations(Document document, Set<T> annotations);
	public void removeAnnotations(Document document);
	
	public void clear();
	
	public Set<Document> getDocuments();
	
	public Set<T> getAnnotations(Document document);
	public <U extends T> Set<U> getAnnotations(Document document, Class<U> annotationClass);
}
