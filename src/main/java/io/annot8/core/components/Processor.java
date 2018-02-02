package io.annot8.core.components;

import io.annot8.content.text.Text;
import io.annot8.core.data.Item;
import io.annot8.core.components.responses.ProcessorResponse;
import io.annot8.core.exceptions.ProcessingException;
import io.annot8.core.stores.Annotations;

/**
 * Processes a {@link Text}, which may include adding annotations (via the {@link Annotations})
 * or persisting the results of other processors out to an external database.
 */
public interface Processor extends Annot8Component {

  ProcessorResponse process(Item item) throws ProcessingException;
}
