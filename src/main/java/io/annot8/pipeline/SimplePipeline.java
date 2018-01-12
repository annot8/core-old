package io.annot8.pipeline;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;
import io.annot8.core.components.Annot8Component;
import io.annot8.core.components.Processor;
import io.annot8.core.components.Source;
import io.annot8.core.data.Context;
import io.annot8.core.data.Item;
import io.annot8.core.data.ProcessResponse;
import io.annot8.core.data.SourceResponse;
import io.annot8.core.exceptions.Annot8Exception;
import io.annot8.core.exceptions.ProcessingException;
import io.annot8.impl.data.SimpleContext;
import io.annot8.impl.processors.Capitalise;
import io.annot8.impl.processors.Email;
import io.annot8.impl.processors.HashTag;
import io.annot8.impl.processors.PrintMentions;
import io.annot8.impl.sources.PipelineSource;
import io.annot8.impl.sources.TxtDirectoryDataSource;

/**
 * Simple proof of concept pipeline that assumes that data sources produce a finite number of
 * DataItems. Processors and DataSources are executed in the order they are added, and this pipeline
 * will terminate once it has processed all data items.
 */
public class SimplePipeline {

  private final Context context;
  private Collection<Source> sources = new ArrayList<>();
  private Collection<Processor> processors = new ArrayList<>();

  private final PipelineSource pipelineSource = new PipelineSource();


  public SimplePipeline(final Context context) {
    this.context = context;
  }

  public void addDataSource(final Source source) {
    sources.add(source);
  }

  public void addProcessor(final Processor processor) {
    processors.add(processor);
  }

  public void run() {

    // TODO: Really, each component should be initialised with it's own configuration (i.e. so we
    // could have multiple data sources with different paths)
    sources = sources.stream().filter(s -> configureComponent(s)).collect(Collectors.toList());
    processors =
        processors.stream().filter(p -> configureComponent(p)).collect(Collectors.toList());

    for (final Source source : sources) {
      process(source);
    }

  }

  private void process(final Source source) {
    SourceResponse.Status status;
    do {
      final SourceResponse response = source.read();
      status = response.getStatus();
      if (status == SourceResponse.Status.OK) {
        response.getItems().forEach(this::process);
      }
    } while (status == SourceResponse.Status.OK);

  }

  private void process(final Item item) {

    processItem(item);

    // TODO: PipelineSource is not a dataSource so this is a bit of a hack
    // it should probably be a DataSource which is the first to be cleared out each time

    SourceResponse response;
    while ((response = pipelineSource.read()).getStatus() == SourceResponse.Status.OK) {
      response.getItems().forEach(this::processItem);
    }
  }

  private void processItem(final Item item) {
    for (final Processor processor : processors) {
      try {
        final ProcessResponse response = processor.process(item);

        final ProcessResponse.Status status = response.getStatus();
        if (status == ProcessResponse.Status.OK) {
          final Collection<Item> items = response.getItems();

          if (items == null || items.isEmpty()) {
            // If we have nothing to continue processing, we stop
            return;
          } else {

            // Add all the items (which aren't the one we are currently processing to our
            // PipelineQueue)
            for (final Item i : items) {
              if (i != item) {
                pipelineSource.add(i);
              }
            }

            // If we don't have this time in our list then we stop, and move to the next pipeline
            if (!items.contains(item)) {
              return;
            }


          }
        } else if (status == ProcessResponse.Status.PIPELINE_ERROR) {
          // TODO: Would do something nicer here but
          System.err.println("Pipeline problem, exiting");

          System.exit(1);
        } else if (status == ProcessResponse.Status.ITEM_ERROR) {
          System.err.println("Item problem, skipping rest of pipeline");
          return;
        }

      } catch (final ProcessingException pe) {
        // TODO: Log this error - should we stop processing this dataItem or carry on?
        System.err.println(
            "Failed to process data item with processor " + processor.getClass().getName());
      }
    }
  }

  private boolean configureComponent(final Annot8Component component) {
    try {
      component.configure(context);
    } catch (final Annot8Exception e) {
      // TODO: Log this error
      System.err.println("Failed to configure component " + component.getClass().getName());
      return false;
    }

    return true;
  }

  public static void main(final String[] args) {
    final SimpleContext context = new SimpleContext();
    context.addConfiguration("path", args[0]);

    final SimplePipeline pipeline = new SimplePipeline(context);

    pipeline.addDataSource(new TxtDirectoryDataSource());
    pipeline.addProcessor(new Capitalise());
    pipeline.addProcessor(new Email());
    pipeline.addProcessor(new HashTag());
    pipeline.addProcessor(new PrintMentions());

    pipeline.run();
  }
}
