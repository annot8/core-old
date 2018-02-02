package io.annot8.impl.sources;

import java.util.ArrayDeque;
import java.util.Deque;
import io.annot8.core.components.Source;
import io.annot8.core.data.Item;
import io.annot8.core.components.responses.SourceResponse;

public class PipelineSource implements Source {

  private final Deque<Item> items = new ArrayDeque<>();

  public synchronized void add(final Item item) {
    items.addLast(item);
  }

  @Override
  public synchronized SourceResponse read() {
    if (!hasItems()) {
      return SourceResponse.empty();
    } else {
      return SourceResponse.ok(next());
    }
  }


  private boolean hasItems() {
    return items.isEmpty();
  }

  private Item next() {
    return items.pop();
  }



}
