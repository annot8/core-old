package io.annot8.impl.processors;

import io.annot8.content.text.Text;
import io.annot8.content.text.TextAnnotations;
import io.annot8.content.text.TextBounds;
import io.annot8.core.bounds.Bounds;
import io.annot8.core.components.Processor;
import io.annot8.core.components.Response;
import io.annot8.core.data.Item;
import io.annot8.core.exceptions.ProcessingException;

public class PrintMentions implements Processor {
  @Override
  public Response process(final Item item) throws ProcessingException {
    item.getContents(Text.class).forEach(this::processText);
    return Response.ok(item);
  }

  private void processText(final Text content) {

    final TextAnnotations store = content.getAnnotations();

    store.getAll().forEach(a -> {
      final Bounds bounds = a.getBounds();

      final TextBounds lb = (TextBounds) bounds;
      final String value = content.getText(lb);

      System.out.println("Annotation from " + lb.getBegin() + " to " + lb.getEnd() + ": " + value);
    });

  }

}
