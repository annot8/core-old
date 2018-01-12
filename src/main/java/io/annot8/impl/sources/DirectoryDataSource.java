package io.annot8.impl.sources;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Optional;
import io.annot8.core.components.Source;
import io.annot8.core.components.java.ConfigurationParameter;
import io.annot8.core.data.Context;
import io.annot8.core.data.Item;
import io.annot8.core.data.SourceResponse;

@ConfigurationParameter(key = "path", defaultValue = ".",
    description = "The folder to process (folder is processed recursively)")
public abstract class DirectoryDataSource implements Source {

  private Path rootFolder;

  @Override
  public void configure(final Context context) {
    final Optional<Object> root = context.getConfiguration("path");
    if (root.isPresent()) {
      rootFolder = Paths.get(root.get().toString());
    } else {
      rootFolder = Paths.get(".");
    }
  }

  @Override
  public SourceResponse read() {
    try {
      return SourceResponse.ok(Files.walk(rootFolder).filter(Files::isRegularFile)
          .filter(this::accept).map(this::createDataItem).filter(Objects::nonNull));
    } catch (final IOException ioe) {
      // TODO: Log error
      return SourceResponse.sourceError();
    }
  }

  public abstract boolean accept(Path p);

  public abstract Item createDataItem(Path p);
}
