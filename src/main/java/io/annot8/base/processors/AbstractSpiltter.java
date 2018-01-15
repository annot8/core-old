package io.annot8.base.processors;

import java.util.stream.Stream;
import io.annot8.core.components.Processor;
import io.annot8.core.data.Item;
import io.annot8.core.data.ProcessorResponse;
import io.annot8.core.exceptions.ProcessingException;

public abstract class AbstractSpiltter implements Processor {

  @Override
  public final ProcessorResponse process(final Item item) throws ProcessingException {
    try {
      if (acceptsItem(item)) {
        Stream<Item> items = splitItem(item);

        // SHould we include the original item too?
        if (includeProcessedItem(item)) {
          items = Stream.concat(Stream.of(item), items);
        }

        return ProcessorResponse.ok(items);
      } else {
        // If we don't accept the item assume we aren't discarding it...
        return ProcessorResponse.ok(item);
      }

    } catch (final Exception e) {
      return ProcessorResponse.itemError();
    }
  }

  protected boolean includeProcessedItem(final Item item) {
    // by default assuming that if an item is accepted its probably going to be divided
    return false;
  }

  protected boolean acceptsItem(final Item item) {
    return false;
  }

  protected abstract Stream<Item> splitItem(final Item item);

}
