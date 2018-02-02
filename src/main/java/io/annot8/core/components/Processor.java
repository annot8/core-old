package io.annot8.core.components;

import io.annot8.core.components.responses.ProcessorResponse;
import io.annot8.core.data.Item;
import io.annot8.core.exceptions.ProcessingException;


public interface Processor extends Annot8Component {

  ProcessorResponse process(Item item) throws ProcessingException;
}
