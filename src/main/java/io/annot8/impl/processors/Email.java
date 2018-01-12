package io.annot8.impl.processors;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import io.annot8.base.processors.AbstractTextAnnotator;
import io.annot8.content.text.Text;
import io.annot8.content.text.TextAnnotation;
import io.annot8.content.text.TextAnnotations;
import io.annot8.content.text.TextBounds;
import io.annot8.core.components.java.OutputAnnotation;
import io.annot8.core.data.Item;
import io.annot8.impl.bounds.SimpleTextBounds;

@OutputAnnotation("EMAIL")
public class Email extends AbstractTextAnnotator {
  private static final Pattern EMAIL =
      Pattern.compile("[A-Z0-9._%+-]+@([A-Z0-9.-]+[.][A-Z]{2,6})", Pattern.CASE_INSENSITIVE);


  @Override
  protected void process(final Item item, final Text content) throws Exception {
    final TextAnnotations store = content.getAnnotations();
    final Matcher matcher = EMAIL.matcher(content.getData());
    while (matcher.find()) {
      final TextBounds bounds = new SimpleTextBounds(matcher.start(), matcher.end());
      final TextAnnotation annot = store.createNew(bounds);
      annot.setType("EMAIL");
      store.save(annot);
    }
  }
}
