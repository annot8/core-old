package io.annot8.impl.sources;

import io.annot8.core.components.Source;
import io.annot8.core.components.java.SettingsClass;
import io.annot8.core.data.Context;
import io.annot8.core.data.Item;
import io.annot8.core.data.SourceResponse;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

@SettingsClass(DirectorySourceSettings.class)
public abstract class DirectorySource implements Source {

  private Path rootFolder;

  @Override
  public void configure(final Context context) {
    final DirectorySourceSettings settings =
        context.getConfiguration(DirectorySourceSettings.class);
    rootFolder = Paths.get(settings.getRootFolder());
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
