package io.annot8.impl.sources;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Instant;
import io.annot8.content.text.Text;
import io.annot8.core.data.Item;
import io.annot8.impl.data.SimpleItem;
import io.annot8.impl.data.SimpleText;

public class TxtDirectoryDataSource extends DirectoryDataSource {
  @Override
  public boolean accept(final Path p) {
    return p.toString().toLowerCase().endsWith(".txt");
  }

  @Override
  public Item createDataItem(final Path p) {
    // TODO: Really we perhaps want a bespoke FileDataItem here?

    Text content;

    try {
      content = new SimpleText(new String(Files.readAllBytes(p)));
    } catch (final IOException e) {
      // TODO: Log error
      return null;
    }
    content.setLanguage("x-unknown");

    final Item dataItem = new SimpleItem(content);
    dataItem.getProperties().setProperty("source", p);
    dataItem.getProperties().setProperty("accessedAt", Instant.now().getEpochSecond());

    return dataItem;
  }
}
