package io.annot8.impl.processors;

import io.annot8.core.bounds.Bounds;
import io.annot8.core.bounds.LinearBounds;
import io.annot8.core.components.Processor;
import io.annot8.core.components.Response;
import io.annot8.core.content.Text;
import io.annot8.core.data.Item;
import io.annot8.core.exceptions.ProcessingException;
import io.annot8.core.stores.AnnotationStore;

public class PrintMentions implements Processor {
  @Override
  public Response process(final Item item) throws ProcessingException {
    item.getContents(Text.class).forEach(this::processText);
    return Response.ok(item);
  }

  private void processText(final Text content) {

    final AnnotationStore<LinearBounds> store = content.getAnnotationStore();

    store.getAll().forEach(a -> {
      final Bounds bounds = a.getBounds();

      final LinearBounds lb = (LinearBounds) bounds;
      final String value = content.getText(lb);

      System.out.println("Annotation from " + lb.getBegin() + " to " + lb.getEnd() + ": " + value);
    });

  }

}
