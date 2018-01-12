package io.annot8.core.components;

import io.annot8.content.text.Text;
import io.annot8.core.data.Annotations;
import io.annot8.core.data.Item;
import io.annot8.core.data.ProcessResponse;
import io.annot8.core.exceptions.ProcessingException;

/**
 * Processes a {@link Text}, which may include adding annotations (via the {@link Annotations})
 * or persisting the results of other processors out to an external database.
 */
@FunctionalInterface
public interface Processor extends Annot8Component {

  ProcessResponse process(Item item) throws ProcessingException;
}
