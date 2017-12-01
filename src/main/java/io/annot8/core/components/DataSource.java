package io.annot8.core.components;

import java.util.Iterator;
import java.util.Map;

import io.annot8.core.annotations.Annotation;
import io.annot8.core.documents.Document;
import io.annot8.core.exceptions.BadConfigurationException;
import io.annot8.core.exceptions.MissingResourceException;
import io.annot8.core.stores.AnnotationStore;

public interface DataSource extends AutoCloseable, Iterator<Document>{
	public void configure(Map<String, Object> configuration, Map<String, Resource> resources, AnnotationStore<? extends Annotation> annotationStore) throws BadConfigurationException, MissingResourceException;
	
	//TODO: Need a way of declaring data source configuration and resources
}
