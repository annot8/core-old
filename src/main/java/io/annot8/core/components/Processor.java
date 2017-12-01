package io.annot8.core.components;

import java.util.Map;

import io.annot8.core.annotations.Annotation;
import io.annot8.core.documents.Document;
import io.annot8.core.exceptions.BadConfigurationException;
import io.annot8.core.exceptions.MissingResourceException;
import io.annot8.core.exceptions.ProcessingException;
import io.annot8.core.stores.AnnotationStore;

public interface Processor {
	public void configure(Map<String, Object> configuration, Map<String, Resource> resources, AnnotationStore<? extends Annotation> annotationStore) throws BadConfigurationException, MissingResourceException;
	public void process(Document document) throws ProcessingException;
	
	//TODO: Need a way of declaring processor capabilities and dependencies
	//TODO: Need a way of declaring processor configuration and resources
}
