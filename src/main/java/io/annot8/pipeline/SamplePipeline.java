package io.annot8.pipeline;

import io.annot8.core.components.DataSource;
import io.annot8.core.data.DataItem;
import io.annot8.pipeline.atomizers.Atomizer;
import io.annot8.pipeline.atomizers.DirectoryAtomizer;
import io.annot8.pipeline.atomizers.KeepAllAtomizer;
import io.annot8.pipeline.datasources.FileSystemDataSource;
import io.annot8.pipeline.services.DataItemAtomizer;
import io.annot8.pipeline.services.DataSourceMerger;
import io.annot8.pipeline.services.RecursiveDataItemAtomizer;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class SamplePipeline {


  private final List<DataSource> dataSources;
  private final List<Atomizer> atomizers;

  public SamplePipeline(File rootDirectory) {

    FileSystemDataSource dataSource = new FileSystemDataSource(rootDirectory);

    dataSources = Collections.singletonList(dataSource);

    atomizers = Arrays.asList(
        new DirectoryAtomizer()
    );

  }

  public void run() {

    // Take datasources and create a single stream of DataItems
    DataSourceMerger merger = new DataSourceMerger(dataSources);
    Stream<DataItem> merged = merger.merge();


    // Take dataitems and recurively spilt them
    DataItemAtomizer atomizer = new DataItemAtomizer(atomizers);
    RecursiveDataItemAtomizer recursiveaAtomizer = new RecursiveDataItemAtomizer(atomizer);
    Stream<DataItem> atomized = merged.flatMap(recursiveaAtomizer);

    // Convert dataitem to documents


  }

  public static void main(String[] args) {
    SamplePipeline pipeline = new SamplePipeline(new File(args[0]));

    pipeline.run();
  }


}
