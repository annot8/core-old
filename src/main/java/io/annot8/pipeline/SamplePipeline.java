package io.annot8.pipeline;

import io.annot8.core.components.DataSource;
import io.annot8.core.data.DataItem;
import io.annot8.pipeline.atomizers.Atomizer;
import io.annot8.pipeline.atomizers.DirectoryAtomizer;
import io.annot8.pipeline.atomizers.KeepAllAtomizer;
import io.annot8.pipeline.datasources.FileSystemDataSource;
import io.annot8.pipeline.services.DataItemAtomizer;
import io.annot8.pipeline.services.DataSourceMerger;
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
        new DirectoryAtomizer(),
        new KeepAllAtomizer()
    );

  }

  public void run() {

    DataSourceMerger merger = new DataSourceMerger(dataSources);
    DataItemAtomizer atomizer = new DataItemAtomizer(atomizers);


    // Combined all the data sources
    Stream<DataItem> merged = merger.merge();
    Stream<DataItem> atomized = merged.flatMap(atomizer);



    // TODO: every time to create new content (eg in a view... we should run the Content convertors???)
  }

  public static void main(String[] args) {
    SamplePipeline pipeline = new SamplePipeline(new File(args[0]));

    pipeline.run();
  }


}
