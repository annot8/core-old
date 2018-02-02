package io.annot8.core.components.responses;

import io.annot8.core.data.Item;

import java.util.Collection;
import java.util.stream.Stream;

// TODO: For consistency with rest of core, should this be an interface? Not sure
public class SourceResponse {

  public enum Status {
    // Ok, ask again asap
    OK,
    // Error occured with the source. up to the caller where they'll try again
    SOURCE_ERROR,
    // Never going to return anything, stop asking
    DONE,
    // Temporarily empty, so nothing to return. caller might wait before trying again
    EMPTY
  }

  private final Status status;

  private final Stream<Item> items;

  private SourceResponse(final Status status) {
    this(status, Stream.empty());
  }

  private SourceResponse(final Status status, final Stream<Item> items) {
    this.status = status;
    this.items = items;

  }

  public Status getStatus() {
    return status;
  }

  public Stream<Item> getItems() {
    return items;
  }

  public static SourceResponse done() {
    return new SourceResponse(Status.DONE);
  }

  public static SourceResponse ok(final Stream<Item> items) {
    return new SourceResponse(Status.OK, items);
  }

  public static SourceResponse ok(final Item... items) {
    return new SourceResponse(Status.OK, Stream.of(items));
  }

  public static SourceResponse ok(final Collection<Item> items) {
    return new SourceResponse(Status.OK, items.stream());
  }

  public static SourceResponse sourceError() {
    return new SourceResponse(Status.SOURCE_ERROR);
  }

  public static SourceResponse empty() {
    return new SourceResponse(Status.EMPTY);
  }

}
