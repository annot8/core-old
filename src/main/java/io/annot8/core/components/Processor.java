package io.annot8.core.components;

import io.annot8.core.components.responses.ProcessorResponse;
import io.annot8.core.data.Item;
import io.annot8.core.exceptions.ProcessingException;

/**
 * Base processor interface from which all processors extend.
 * 
 * Processors do work on an item, such as adding new annotations, or
 * creating new content.
 */
public interface Processor extends Annot8Component {

	/**
	 * Process the given item
	 */
  ProcessorResponse process(final Item item) throws ProcessingException;
}
