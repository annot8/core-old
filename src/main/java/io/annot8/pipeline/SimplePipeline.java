package io.annot8.pipeline;

import io.annot8.core.components.Annot8Component;
import io.annot8.core.components.Processor;
import io.annot8.core.components.Resource;
import io.annot8.core.components.Source;
import io.annot8.core.data.Item;
import io.annot8.core.components.responses.ProcessorResponse;
import io.annot8.core.components.responses.SourceResponse;
import io.annot8.core.exceptions.Annot8Exception;
import io.annot8.core.exceptions.ProcessingException;
import io.annot8.impl.data.SimpleComponentContext;
import io.annot8.impl.data.SimpleGlobalContext;
import io.annot8.impl.processors.Capitalise;
import io.annot8.impl.processors.Email;
import io.annot8.impl.processors.HashTag;
import io.annot8.impl.processors.PrintMentions;
import io.annot8.impl.sources.DirectorySourceSettings;
import io.annot8.impl.sources.PipelineSource;
import io.annot8.impl.sources.TxtDirectorySource;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Simple proof of concept pipeline that assumes that data sources produce a finite number of
 * DataItems. Processors and DataSources are executed in the order they are added, and this pipeline
 * will terminate once it has processed all data items.
 */
public class SimplePipeline {

  private final Map<Source, Object> sourcesToConfiguration = new HashMap<>();
  private final Map<Processor, Object> processorToConfiguration = new HashMap<>();
  private final Map<Resource, Object> resourcesToConfiguration = new HashMap<>();

  private final Map<String, Resource> resources = new HashMap<>();
  private Collection<Source> sources;
  private Collection<Processor> processors;

  private final PipelineSource pipelineSource = new PipelineSource();

  public void addResource(final String id, final Resource resource) {
    addResource(id, resource, null);
  }

  public void addDataSource(final Source source) {
    addDataSource(source, null);
  }

  public void addProcessor(final Processor processor) {
    addProcessor(processor, null);
  }

  public void addResource(final String id, final Resource resource, final Object configuration) {
    resourcesToConfiguration.put(resource, configuration);
    resources.put(id, resource);
  }

  public void addDataSource(final Source source, final Object configuration) {
    sourcesToConfiguration.put(source, configuration);
  }

  public void addProcessor(final Processor processor, final Object configuration) {
    processorToConfiguration.put(processor, configuration);
  }

  public void run() {


    final SimpleGlobalContext globalContext = new SimpleGlobalContext();


    // TODO: Resources need to be set up in order!
    resourcesToConfiguration.entrySet().stream()
        .filter(e -> configureComponent(globalContext, e.getKey(), e.getValue()));

    // TODO: Failed resource are just included here anyway
    resources.forEach(globalContext::addResource);


    // TODO: Really, each component should be initialised with it's own configuration (i.e. so we
    // could have multiple data sources with different paths)
    // TODO: Failed


    sources = sourcesToConfiguration.entrySet().stream()
        .filter(e -> configureComponent(globalContext, e.getKey(), e.getValue())).map(Entry::getKey)
        .collect(Collectors.toList());
    processors = processorToConfiguration.entrySet().stream()
        .filter(e -> configureComponent(globalContext, e.getKey(), e.getValue())).map(Entry::getKey)
        .collect(Collectors.toList());

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

    SourceResponse response;
    while ((response = pipelineSource.read()).getStatus() == SourceResponse.Status.OK) {
      response.getItems().forEach(this::processItem);
    }
  }

  private void processItem(final Item item) {
    for (final Processor processor : processors) {
      try {
        final ProcessorResponse response = processor.process(item);

        final ProcessorResponse.Status status = response.getStatus();
        if (status == ProcessorResponse.Status.OK) {
          final Stream<Item> items = response.getItems();

          items.filter(i -> i != item).forEach(pipelineSource::add);

          //TODO: JB: Personally, I think we should ignore the case where item is included in the output and use the status to control whether we continue or not
          // If we decide otherwise, then that needs implementing here

        } else if (status == ProcessorResponse.Status.PIPELINE_ERROR) {
          // TODO: Would do something nicer here but
          System.err.println("Pipeline problem, exiting");

          System.exit(1);
        } else if (status == ProcessorResponse.Status.ITEM_ERROR) {
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

  private boolean configureComponent(final SimpleGlobalContext globalContext,
      final Annot8Component component, final Object configuration) {


    try {
      final SimpleComponentContext context =
          new SimpleComponentContext(globalContext, configuration);
      component.configure(context);
    } catch (final Annot8Exception e) {
      // TODO: Log this error
      System.err.println("Failed to configure component " + component.getClass().getName());
      return false;
    }

    return true;
  }

  public static void main(final String[] args) {

    final SimplePipeline pipeline = new SimplePipeline();

    pipeline.addDataSource(new TxtDirectorySource(), new DirectorySourceSettings(args[0]));
    pipeline.addProcessor(new Capitalise());
    pipeline.addProcessor(new Email());
    pipeline.addProcessor(new HashTag());
    pipeline.addProcessor(new PrintMentions());

    pipeline.run();
  }
}
