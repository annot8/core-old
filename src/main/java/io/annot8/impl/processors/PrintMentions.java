package io.annot8.impl.processors;

import java.util.Optional;
import io.annot8.core.bounds.Bounds;
import io.annot8.core.bounds.LinearBounds;
import io.annot8.core.components.Processor;
import io.annot8.core.content.Text;
import io.annot8.core.data.DataItem;
import io.annot8.core.exceptions.ProcessingException;
import io.annot8.core.stores.AnnotationStore;

public class PrintMentions implements Processor {
  @Override
  public void process(final DataItem dataItem, final AnnotationStore store)
      throws ProcessingException {
    store.getAll().forEach(a -> {
      final Optional<Text> text = a.getContent(Text.class);
      final Bounds bounds = a.getBounds();

      if (text.isPresent() && bounds instanceof LinearBounds) {
        final LinearBounds lb = (LinearBounds) bounds;
        final String value = text.get().getContent().substring(lb.getBegin(), lb.getEnd());

        System.out
            .println("Annotation from " + lb.getBegin() + " to " + lb.getEnd() + ": " + value);
      }
    });
  }
}
