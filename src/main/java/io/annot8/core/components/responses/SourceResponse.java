package io.annot8.core.components.responses;

import java.util.Collection;
import java.util.stream.Stream;
import io.annot8.core.data.Item;

/**
 * Class to hold the response from a source.
 * 
 * The response consists of a status, and optionally any new items
 * which should be processed by the pipeline.
 */
public final class SourceResponse {

  /**
   * Response status returned by the source
   */
  public enum Status {
    /**
     * Indicates that the source found new items,
     * and that the pipeline may ask the source for
     * new items again as soon as it is ready.
     */
    OK,

    /**
     * Indicates that an error occurred with the source.
     * It is up to the pipeline to decide whether to try
     * again or not.
     */
    SOURCE_ERROR,

    /**
     * Indicates that the source has been exhausted, and
     * will never return any new items. The pipeline
     * should stop asking for new items and terminate.
     */
    DONE,

    /**
     * Indicates that the source is temporarily empty,
     * but that it may have new items in the future.
     */
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

  /**
   * Return the status associated with this response
   */
  public Status getStatus() {
    return status;
  }

  /**
   * Return any new items to be processed
   */
  public Stream<Item> getItems() {
    return items;
  }

  /**
   * Create a DONE response
   */
  public static SourceResponse done() {
    return new SourceResponse(Status.DONE);
  }

  /**
   * Create an OK response with the specified items
   */
  public static SourceResponse ok(final Stream<Item> items) {
    return new SourceResponse(Status.OK, items);
  }

  /**
   * Create an OK response with the specified items
   */
  public static SourceResponse ok(final Item... items) {
    return new SourceResponse(Status.OK, Stream.of(items));
  }

  /**
   * Create an OK response with the specified items
   */
  public static SourceResponse ok(final Collection<Item> items) {
    return new SourceResponse(Status.OK, items.stream());
  }

  /**
   * Create a SOURCE_ERROR response
   */
  public static SourceResponse sourceError() {
    return new SourceResponse(Status.SOURCE_ERROR);
  }

  /**
   * Create an EMPTY response
   */
  public static SourceResponse empty() {
    return new SourceResponse(Status.EMPTY);
  }

}
