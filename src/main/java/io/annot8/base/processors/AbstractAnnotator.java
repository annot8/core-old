package io.annot8.base.processors;

import io.annot8.core.components.Processor;
import io.annot8.core.data.Item;
import io.annot8.core.data.ProcessResponse;
import io.annot8.core.exceptions.ProcessingException;

public abstract class AbstractAnnotator implements Processor {

  @Override
  public final ProcessResponse process(final Item item) throws ProcessingException {
    try {
      if (acceptsItem(item)) {
        final boolean passOn = processItem(item);
        if (!passOn) {
          // Don't allow to continue
          return ProcessResponse.ok();
        }
      }
      return ProcessResponse.ok(item);
    } catch (final Exception e) {
      return ProcessResponse.itemError();
    }
  }

  protected boolean acceptsItem(final Item item) {
    return true;
  }

  protected abstract boolean processItem(final Item item);


}
