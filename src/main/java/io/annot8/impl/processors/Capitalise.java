package io.annot8.impl.processors;

import io.annot8.core.components.Processor;
import io.annot8.core.components.javaannotations.CreatesContent;
import io.annot8.core.content.Content;
import io.annot8.core.content.Text;
import io.annot8.core.data.DataItem;
import io.annot8.core.exceptions.AlreadyExistsException;
import io.annot8.core.exceptions.ProcessingException;
import io.annot8.core.stores.AnnotationStore;
import io.annot8.impl.content.SimpleText;

@CreatesContent(Text.class)
public class Capitalise implements Processor {
  @Override
  public void process(final DataItem dataItem, final AnnotationStore store)
      throws ProcessingException {
    final Content<?> content = dataItem.getDefaultContent();

    if (content instanceof Text) {
      final Text doc = (Text) content;
      try {
        dataItem.addContent("CAPITALISED", new SimpleText(doc.getContent().toUpperCase()));
      } catch (final AlreadyExistsException aee) {
        // TODO: Log error
      }
    }
  }
}
