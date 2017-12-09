package io.annot8.core.components;

import io.annot8.core.context.Context;
import io.annot8.core.context.ProcessingContext;
import io.annot8.core.documents.Document;
import io.annot8.core.exceptions.BadConfigurationException;
import io.annot8.core.exceptions.MissingResourceException;
import io.annot8.core.exceptions.ProcessingException;
import io.annot8.core.stores.AnnotationStore;

/**
 * Processes a {@link Document}, which may include adding annotations
 * (via the {@link AnnotationStore}) or persisting the results of other
 * processors out to an external database.
 */
@FunctionalInterface
public interface Processor extends Annot8Component {
	void process(Document document, ProcessingContext context) throws ProcessingException;
}
