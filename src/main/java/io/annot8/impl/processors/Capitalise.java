package io.annot8.impl.processors;

import io.annot8.content.text.Text;
import io.annot8.core.components.Processor;
import io.annot8.core.components.Response;
import io.annot8.core.components.javaannotations.CreatesContent;
import io.annot8.core.content.Content;
import io.annot8.core.data.Item;
import io.annot8.core.exceptions.AlreadyExistsException;
import io.annot8.core.exceptions.ProcessingException;
import io.annot8.impl.content.SimpleText;

@CreatesContent(Text.class)
public class Capitalise implements Processor {
  @Override
  public Response process(final Item item) throws ProcessingException {
    final Content content = item.getDefaultContent();

    if (content instanceof Text) {
      final Text doc = (Text) content;
      try {
        item.addContent("CAPITALISED", new SimpleText(doc.getData().toUpperCase()));
      } catch (final AlreadyExistsException aee) {
        // TODO: Log error
      }
    }

    return Response.ok(item);
  }
}
