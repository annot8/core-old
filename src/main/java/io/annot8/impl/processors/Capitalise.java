package io.annot8.impl.processors;

import io.annot8.base.processors.AbstractTextAnnotator;
import io.annot8.content.text.Text;
import io.annot8.core.components.java.CreatesContent;
import io.annot8.core.data.Item;
import io.annot8.core.exceptions.AlreadyExistsException;
import io.annot8.core.exceptions.UnsupportedContentException;

@CreatesContent(Text.class)
public class Capitalise extends AbstractTextAnnotator {

  @Override
  protected void process(final Item item, final Text content)
      throws AlreadyExistsException, UnsupportedContentException {
    item.create("CAPITALISED", Text.class, content.getData().toUpperCase());
  }
}
