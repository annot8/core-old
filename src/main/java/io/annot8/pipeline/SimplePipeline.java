package io.annot8.pipeline;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;
import io.annot8.core.components.Annot8Component;
import io.annot8.core.components.Source;
import io.annot8.core.components.Processor;
import io.annot8.core.context.Context;
import io.annot8.core.data.Item;
import io.annot8.core.exceptions.Annot8Exception;
import io.annot8.core.exceptions.ProcessingException;
import io.annot8.core.stores.AnnotationStore;
import io.annot8.impl.context.SimpleContext;
import io.annot8.impl.datasources.TxtDirectoryDataSource;
import io.annot8.impl.processors.Capitalise;
import io.annot8.impl.processors.Email;
import io.annot8.impl.processors.HashTag;
import io.annot8.impl.processors.PrintMentions;
import io.annot8.impl.stores.InMemoryStore;

/**
 * Simple proof of concept pipeline that assumes that data sources produce a finite number of
 * DataItems. Processors and DataSources are executed in the order they are added, and this pipeline
 * will terminate once it has processed all data items.
 */
public class SimplePipeline {

  private final Context context;
  private final AnnotationStore store = new InMemoryStore();
  private Collection<Source> dataSources = new ArrayList<>();
  private Collection<Processor> processors = new ArrayList<>();


  public SimplePipeline(final Context context) {
    this.context = context;
  }

  public void addDataSource(final Source dataSource) {
    dataSources.add(dataSource);
  }

  public void addProcessor(final Processor processor) {
    processors.add(processor);
  }

  public void run() {

    // TODO: Really, each component should be initialised with it's own configuration (i.e. so we
    // could have multiple data sources with different paths)
    dataSources =
        dataSources.stream().filter(ds -> configureComponent(ds)).collect(Collectors.toList());
    processors =
        processors.stream().filter(p -> configureComponent(p)).collect(Collectors.toList());

    for (final Source dataSource : dataSources) {
      dataSource.getDataItems().forEach(this::process);
    }
  }

  private void process(final Item dataItem) {
    for (final Processor processor : processors) {
      try {
        processor.process(dataItem, store);
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
