package io.annot8.core.components.responses;

import java.util.Collection;
import java.util.stream.Stream;
import io.annot8.core.data.Item;

/**
 * Class to hold the response from a processor.
 * 
 * The response consists of a status, and optionally any new items
 * which should be processed by the pipeline.
 */
public final class ProcessorResponse {

  /**
   * Response status returned by the processor
   */
  public enum Status {
    /**
     * Indicates that the processor has worked successfully
     */
    OK,

    /**
     * Indicates that the processor has worked successfully,
     * but that the current item should not be processed further
     */
    ITEM_STOP,

    /**
     * Indicates that an error happened whilst processing this
     * item, but that it should be possible to process other items.
     */
    ITEM_ERROR,

    /**
     * Indicates that an error happened whilst processing this
     * item, and that it will prevent other items from being processed.
     */
    PIPELINE_ERROR
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
   * Create an OK response with no new items
   */
  public static ProcessorResponse ok() {
    return new ProcessorResponse(Status.OK, Stream.empty());
  }

  /**
   * Create an OK response with the specified items
   */
  public static ProcessorResponse ok(final Item... item) {
    return new ProcessorResponse(Status.OK, Stream.of(item));
  }

  /**
   * Create an OK response with the specified items
   */
  public static ProcessorResponse ok(final Collection<Item> items) {
    return new ProcessorResponse(Status.OK, items.stream());
  }

  /**
   * Create an OK response with the specified items
   */
  public static ProcessorResponse ok(final Stream<Item> items) {
    return new ProcessorResponse(Status.OK, items);
  }

  /**
   * Create an ITEM_STOP response with no new items
   */
  public static ProcessorResponse itemStop() {
    return new ProcessorResponse(Status.ITEM_STOP, Stream.empty());
  }

  /**
   * Create an ITEM_STOP response with the specified items
   */
  public static ProcessorResponse itemStop(final Item... item) {
    return new ProcessorResponse(Status.ITEM_STOP, Stream.of(item));
  }

  /**
   * Create an ITEM_STOP response with the specified items
   */
  public static ProcessorResponse itemStop(final Collection<Item> items) {
    return new ProcessorResponse(Status.ITEM_STOP, items.stream());
  }

  /**
   * Create an ITEM_STOP response with the specified items
   */
  public static ProcessorResponse itemStop(final Stream<Item> items) {
    return new ProcessorResponse(Status.ITEM_STOP, items);
  }

  /**
   * Create an ITEM_ERROR response
   */
  public static ProcessorResponse itemError() {
    return new ProcessorResponse(Status.ITEM_ERROR);
  }

  /**
   * Create a PIPELINE_ERROR response
   */
  public static ProcessorResponse pipelineError() {
    return new ProcessorResponse(Status.PIPELINE_ERROR);
  }
}
