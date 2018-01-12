package io.annot8.core.data;

import java.util.Collection;
import java.util.Collections;

// TODO: Name me better
public class Response {

  public static enum Status {
    OK, ITEM_ERROR, PIPELINE_ERROR
  }

  private final Status status;

  // TODO: If you add a new item, are we processing from this point on in the pipeline, or back at
  // the start? NEed to do both??
  private final Collection<Item> items;

  private Response(final Status status) {
    this(status, Collections.emptyList());
  }

  private Response(final Status status, final Collection<Item> items) {
    this.status = status;
    this.items = items;

  }

  public Status getStatus() {
    return status;
  }

  public Collection<Item> getItems() {
    return items;
  }

  public static Response ok() {
    return new Response(Status.OK, Collections.emptyList());
  }

  public static Response ok(final Item item) {
    return new Response(Status.OK, Collections.singletonList(item));
  }

  public static Response itemError() {
    return new Response(Status.ITEM_ERROR);
  }

  public static Response pipelineError() {
    return new Response(Status.PIPELINE_ERROR);
  }
}
