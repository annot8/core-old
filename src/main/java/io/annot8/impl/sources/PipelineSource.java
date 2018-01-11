package io.annot8.impl.sources;

import java.util.ArrayDeque;
import java.util.Deque;
import io.annot8.core.data.Item;

public class PipelineSource {

  private final Deque<Item> items = new ArrayDeque<>();


  public boolean hasItems() {
    return items.isEmpty();
  }

  public Item next() {
    return items.pop();
  }

  public void add(final Item item) {
    items.addLast(item);
  }

  // TODO: Stream is not really compatible with this... so its not a Source



}
