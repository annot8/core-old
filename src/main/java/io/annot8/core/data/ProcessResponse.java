package io.annot8.core.data;

import java.util.Collection;
import java.util.Collections;

// TODO: Name me better
public class ProcessResponse {

  public enum Status {
    OK, ITEM_ERROR, PIPELINE_ERROR
  }

  private final Status status;

  // TODO: If you add a new item, are we processing from this point on in the pipeline, or back at
  // the start? NEed to do both??
  private final Collection<Item> items;

  private ProcessResponse(final Status status) {
    this(status, Collections.emptyList());
  }

  private ProcessResponse(final Status status, final Collection<Item> items) {
    this.status = status;
    this.items = items;

  }

  public Status getStatus() {
    return status;
  }

  public Collection<Item> getItems() {
    return items;
  }

  public static ProcessResponse ok() {
    return new ProcessResponse(Status.OK, Collections.emptyList());
  }

  public static ProcessResponse ok(final Item item) {
    return new ProcessResponse(Status.OK, Collections.singletonList(item));
  }

  public static ProcessResponse itemError() {
    return new ProcessResponse(Status.ITEM_ERROR);
  }

  public static ProcessResponse pipelineError() {
    return new ProcessResponse(Status.PIPELINE_ERROR);
  }
}
