package io.annot8.pipeline.services;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Stream;

import io.annot8.core.data.DataItem;

public class RecursiveDataItemAtomizer implements Function<DataItem, Stream<DataItem>> {

  private final DataItemAtomizer atomizer;

  public RecursiveDataItemAtomizer(DataItemAtomizer atomizer) {
    this.atomizer = atomizer;
  }

  @Override
  public Stream<DataItem> apply(DataItem dataItem) {
    // TODO: I cant think of a nice way of doing this with Streams
    // I bet this would be much nicer in Flux
    // all I can think of here is just retaining all the dataitems we've processed
    // and buffering up a stream immediately for all the sub dataitems.


    // We need to atomize the stuff we generate:
    // A single data item as a parameters
    // atomize it we create a stream from it.
    // we retain a list of all the data items we've atomized so far
    // we don't reatomized anything we've already processed

    List<DataItem> output = new LinkedList<>();

    LinkedList<Stream<DataItem>> streamsToProcess = new LinkedList<>();
    streamsToProcess.add(Stream.of(dataItem));
    Set<DataItem> processedItems = new HashSet<>();

    // With a listiterator we can add new stream as we as we go...
    ListIterator<Stream<DataItem>> iterator = streamsToProcess.listIterator();
    while (iterator.hasNext()) {
      Stream<DataItem> nextStream = iterator.next();

      nextStream
          // Don't process if we've already processed
          .filter(i -> !processedItems.contains(i))
          .forEach(i -> {
            // Move every data item over to the output
            output.add(i);
            // Record as processed
            processedItems.add(i);

            // Atomize the output
            Stream<DataItem> out = atomizer.apply(i);
            // Add 'out' to our streamsToProcess at the current location
            iterator.add(out);
            // but in order to actually process it we need to go backwards to make it the next
            iterator.previous();
          });
    }

    return output.stream();
  }
}
