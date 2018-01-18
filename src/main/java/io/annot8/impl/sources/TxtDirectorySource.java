package io.annot8.impl.sources;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Instant;
import io.annot8.content.text.EditableText;
import io.annot8.content.text.Text;
import io.annot8.core.data.Item;
import io.annot8.core.exceptions.AlreadyExistsException;
import io.annot8.core.exceptions.UnsupportedContentException;

public class TxtDirectorySource extends DirectorySource {
  @Override
  public boolean accept(final Path p) {
    return p.toString().toLowerCase().endsWith(".txt");
  }

  @Override
  public Item createDataItem(final Path p)
      throws AlreadyExistsException, UnsupportedContentException {
    // TODO: Really we perhaps want a bespoke FileDataItem here?

    final Item item = createItem();
    item.getProperties().set("source", p);
    item.getProperties().set("accessedAt", Instant.now().getEpochSecond());


    try {
      final String data = new String(Files.readAllBytes(p));
      final EditableText content = item.create("raw", Text.class, data);
      content.setLanguage("x-unknown");
    } catch (final IOException e) {
      // TODO: Log error
      return null;
    }

    return item;
  }


}
