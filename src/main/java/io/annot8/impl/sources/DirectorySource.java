package io.annot8.impl.sources;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import io.annot8.core.components.Source;
import io.annot8.core.components.java.SettingsClass;
import io.annot8.core.data.Context;
import io.annot8.core.data.Item;
import io.annot8.core.data.SourceResponse;
import io.annot8.core.exceptions.AlreadyExistsException;
import io.annot8.core.exceptions.Annot8Exception;
import io.annot8.core.exceptions.UnsupportedContentException;

@SettingsClass(DirectorySourceSettings.class)
public abstract class DirectorySource implements Source {

  private Path rootFolder;
  private Context context;

  @Override
  public void configure(final Context context) {
    final DirectorySourceSettings settings =
        context.getConfiguration(DirectorySourceSettings.class);
    rootFolder = Paths.get(settings.getRootFolder());
    this.context = context;
  }

  protected Item createItem() {
    return context.createItem();
  }

  @Override
  public SourceResponse read() {
    try {
      return SourceResponse
          .ok(Files.walk(rootFolder).filter(Files::isRegularFile).filter(this::accept).map(f -> {
            try {
              return createDataItem(f);
            } catch (final Annot8Exception e) {
              // TODO: This should return a itemError().. but to do that we'd need to convert this
              // to a for loop...
              e.printStackTrace();
              return null;
            }
          }).filter(Objects::nonNull));
    } catch (final IOException ioe) {
      // TODO: Log error
      ioe.printStackTrace();
      return SourceResponse.sourceError();
    }
  }

  public abstract boolean accept(Path p);

  public abstract Item createDataItem(Path p)
      throws AlreadyExistsException, UnsupportedContentException;
}
