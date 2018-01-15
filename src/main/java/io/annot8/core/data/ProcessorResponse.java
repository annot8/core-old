package io.annot8.core.data;

import java.util.Collection;
import java.util.stream.Stream;

public class ProcessorResponse {

  public enum Status {
    OK, ITEM_ERROR, PIPELINE_ERROR
  }

  private final Status status;

  private final Stream<Item> items;

  private ProcessorResponse(final Status status) {
    this(status, Stream.empty());
  }

  private ProcessorResponse(final Status status, final Stream<Item> items) {
    this.status = status;
    this.items = items;

  }

  public Status getStatus() {
    return status;
  }

  public Stream<Item> getItems() {
    return items;
  }

  public static ProcessorResponse ok() {
    return new ProcessorResponse(Status.OK, Stream.empty());
  }

  public static ProcessorResponse ok(final Item... item) {
    return new ProcessorResponse(Status.OK, Stream.of(item));
  }

  public static ProcessorResponse ok(final Collection<Item> items) {
    return new ProcessorResponse(Status.OK, items.stream());
  }

  public static ProcessorResponse ok(final Stream<Item> items) {
    return new ProcessorResponse(Status.OK, items);
  }

  public static ProcessorResponse itemError() {
    return new ProcessorResponse(Status.ITEM_ERROR);
  }

  public static ProcessorResponse pipelineError() {
    return new ProcessorResponse(Status.PIPELINE_ERROR);
  }
}
