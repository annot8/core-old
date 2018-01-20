package io.annot8.impl.processors;

import io.annot8.base.processors.AbstractTextAnnotator;
import io.annot8.content.text.Text;
import io.annot8.content.text.TextAnnotation;
import io.annot8.content.text.TextBounds;
import io.annot8.core.bounds.Bounds;
import io.annot8.core.data.Item;
import io.annot8.core.exceptions.Annot8Exception;
import io.annot8.core.stores.Annotations;

public class PrintMentions extends AbstractTextAnnotator {


  @Override
  protected void process(final Item item, final Text content) throws Annot8Exception {
    final Annotations<TextBounds, TextAnnotation> store = content.getAnnotations();

    store.getAll().forEach(a -> {
      final Bounds bounds = a.getBounds();

      final TextBounds lb = (TextBounds) bounds;
      final String value = content.getText(lb);

      System.out.println("Annotation from " + lb.getBegin() + " to " + lb.getEnd() + ": " + value);
    });
  }

}
