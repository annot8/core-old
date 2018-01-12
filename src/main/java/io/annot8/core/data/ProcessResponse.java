package io.annot8.core.data;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// TODO: Name me better
public class ProcessResponse {

  public enum Status {
    OK, ITEM_ERROR, PIPELINE_ERROR
  }

  private final Status status;

  // TODO: If you add a new item, are we processing from this point on in the pipeline, or back at
  // the start? Do we need both to avoid limitations/complexity in pipelines?
  // TODO: Stream or collection? DIfference being that a stream could be created lazily (eg lazies
  // from a zip file, whereas a colleciton will probably eat up memory asap). The SourceResponse has
  // a stream..
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

  public static ProcessResponse ok(final Item... item) {
    return new ProcessResponse(Status.OK, Arrays.asList(item));
  }

  public static ProcessResponse ok(final Collection<Item> items) {
    return new ProcessResponse(Status.OK, items);
  }

  public static ProcessResponse ok(final Stream<Item> items) {
    return new ProcessResponse(Status.OK, items.collect(Collectors.toList()));
  }

  public static ProcessResponse itemError() {
    return new ProcessResponse(Status.ITEM_ERROR);
  }

  public static ProcessResponse pipelineError() {
    return new ProcessResponse(Status.PIPELINE_ERROR);
  }
}
