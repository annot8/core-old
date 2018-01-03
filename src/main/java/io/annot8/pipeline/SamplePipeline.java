package io.annot8.pipeline;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import io.annot8.core.components.DataSource;
import io.annot8.core.components.Processor;
import io.annot8.core.components.Resource;
import io.annot8.core.context.ConfiguringContext;
import io.annot8.core.context.ProcessingContext;
import io.annot8.core.data.DataItem;
import io.annot8.core.data.Document;
import io.annot8.pipeline.atomizers.Atomizer;
import io.annot8.pipeline.atomizers.DirectoryAtomizer;
import io.annot8.pipeline.converters.Converter;
import io.annot8.pipeline.converters.FileConverter;
import io.annot8.pipeline.datasources.FileSystemDataSource;
import io.annot8.pipeline.processors.HashtagProcessor;
import io.annot8.pipeline.services.DataItemAtomizer;
import io.annot8.pipeline.services.DataSourceMerger;
import io.annot8.pipeline.services.DocumentConverter;
import io.annot8.pipeline.services.MultiProcessor;
import io.annot8.pipeline.services.RecursiveDataItemAtomizer;
import io.annot8.simple.SimpleAnnotationStore;
import io.annot8.simple.SimpleConfiguringContext;
import io.annot8.simple.SimpleProcessingContext;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SamplePipeline {


  private final List<DataSource> dataSources;
  private final List<Atomizer> atomizers;
  private final List<Converter> converters;
  private final List<Processor> processors;

  public SamplePipeline(final File rootDirectory) {

    final FileSystemDataSource dataSource = new FileSystemDataSource(rootDirectory);

    dataSources = Collections.singletonList(dataSource);

    atomizers = Arrays.asList(
        new DirectoryAtomizer());

    converters = Arrays.asList(
        new FileConverter());

    processors = Arrays.asList(
        new HashtagProcessor());

  }

  public void run() {

    // Take datasources and create a single stream of DataItems
    final DataSourceMerger merger = new DataSourceMerger(dataSources);
    final Stream<DataItem> merged = merger.merge();


    // Take dataitems and recurively spilt them
    final DataItemAtomizer atomizer = new DataItemAtomizer(atomizers);
    final RecursiveDataItemAtomizer recursiveaAtomizer = new RecursiveDataItemAtomizer(atomizer);
    final Stream<DataItem> atomized = merged.flatMap(recursiveaAtomizer);

    // Convert dataitem to documents
    final DocumentConverter converter = new DocumentConverter(this.converters);
    final Stream<Document> documents = atomized.map(converter::convert)
        .filter(Optional::isPresent)
        .map(Optional::get);


    // Create the the context

    final Map<String, Object> configuration = new HashMap<>();
    final Map<String, Resource> resources = new HashMap<>();
    resources.put("annotationStore", new SimpleAnnotationStore());
    final ConfiguringContext configuringContext =
        new SimpleConfiguringContext(configuration, resources);
    final ProcessingContext processingContext =
        new SimpleProcessingContext(configuration, resources);

    // Process the document through the pipeline
    try (MultiProcessor processor = new MultiProcessor(this.processors)) {
      processor.configure(configuringContext);
      documents.forEach(d -> {
        try {
          processor.process(processingContext, d);
        } catch (final Exception e) {
          log.error("Unable to process document");
        }
      });
    } catch (final Exception e) {
      log.error("Failed to process", e);
    }
  }

  public static void main(final String[] args) {
    final SamplePipeline pipeline = new SamplePipeline(new File(args[0]));

    pipeline.run();
  }


}
