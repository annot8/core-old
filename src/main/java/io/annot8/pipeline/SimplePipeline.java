package io.annot8.pipeline;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;
import io.annot8.core.components.Annot8Component;
import io.annot8.core.components.Processor;
import io.annot8.core.components.Response;
import io.annot8.core.components.Response.Status;
import io.annot8.core.components.Source;
import io.annot8.core.context.Context;
import io.annot8.core.data.Item;
import io.annot8.core.exceptions.Annot8Exception;
import io.annot8.core.exceptions.ProcessingException;
import io.annot8.core.stores.AnnotationStore;
import io.annot8.impl.context.SimpleContext;
import io.annot8.impl.processors.Capitalise;
import io.annot8.impl.processors.Email;
import io.annot8.impl.processors.HashTag;
import io.annot8.impl.processors.PrintMentions;
import io.annot8.impl.sources.PipelineSource;
import io.annot8.impl.sources.TxtDirectoryDataSource;
import io.annot8.impl.stores.InMemoryStore;

/**
 * Simple proof of concept pipeline that assumes that data sources produce a finite number of
 * DataItems. Processors and DataSources are executed in the order they are added, and this pipeline
 * will terminate once it has processed all data items.
 */
public class SimplePipeline {

  private final Context context;
  private final AnnotationStore store = new InMemoryStore();
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

    for (final Source dataSource : sources) {
      dataSource.getDataItems().forEach(this::process);
    }

  }

  private void process(final Item item) {

    processItem(item);

    // TODO: PipelineSource is not a dataSource so this is a bit of a hack
    // it should probably be a DataSource which is the first to be cleared out each time

    while (pipelineSource.hasItems()) {
      final Item i = pipelineSource.next();
      processItem(i);
    }

  }

  private void processItem(final Item item) {
    for (final Processor processor : processors) {
      try {
        final Response response = processor.process(item, store);

        final Status status = response.getStatus();
        if (status == Status.OK) {
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
        } else if (status == Status.PIPELINE_ERROR) {
          // TODO: Would do something nicer here but
          System.err.println("Pipeline problem, exiting");

          System.exit(1);
        } else if (status == Status.ITEM_ERROR) {
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
