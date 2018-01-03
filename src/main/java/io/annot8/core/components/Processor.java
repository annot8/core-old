package io.annot8.core.components;

import io.annot8.core.content.Text;
import io.annot8.core.context.ProcessingContext;
import io.annot8.core.data.Document;
import io.annot8.core.exceptions.ProcessingException;
import io.annot8.core.stores.AnnotationStore;

/**
 * Processes a {@link Text}, which may include adding annotations (via the {@link
 * AnnotationStore}) or persisting the results of other processors out to an external database.
 */
@FunctionalInterface
public interface Processor extends Annot8Component {

  void process(ProcessingContext context, Document document) throws ProcessingException;
}
