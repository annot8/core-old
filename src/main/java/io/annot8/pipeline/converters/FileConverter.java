package io.annot8.pipeline.converters;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Optional;
import java.util.stream.Stream;

import io.annot8.core.content.Text;
import io.annot8.core.data.Document;
import io.annot8.core.data.Properties;
import io.annot8.pipeline.dataitems.FileDataItem;
import io.annot8.simple.SimpleDocument;
import io.annot8.simple.SimpleText;

public class FileConverter extends AbstractClassConverter<FileDataItem> {

  public FileConverter() {
    super(FileDataItem.class);
  }

  @Override
  protected Optional<Document> convertItem(final FileDataItem item) {
    final File f = item.getFile();

    final Document d = new SimpleDocument(item, item.getId());

    d.setDefaultView("default");
    d.createView("default", toText(item.getFile()));

    final Properties properties = d.getProperties();
    properties.set("file.path", f.getAbsolutePath());
    properties.set("file.size", f.length());
    // TODO: lots of other stuff like d.set("file.extension", f.getName());
    try {
      properties.set("file.contentType", Files.probeContentType(f.toPath()));
    } catch (final IOException e) {
      // ignore...
    }

    return Optional.of(d);
  }

  private Text toText(final File file) {
    // TODO: ContentExtractor (ie Tika goes here)
    final StringBuilder sb = new StringBuilder();
    try (Stream<String> stream = Files.lines(file.toPath(), StandardCharsets.UTF_8)) {
      stream.forEach(s -> {
        sb.append(s);
        sb.append('\n');
      });
    } catch (final Exception e) {
      // Do nothing...
    }
    return new SimpleText("en", sb.toString());
  }
}
