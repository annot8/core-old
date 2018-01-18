package io.annot8.impl.processors;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import io.annot8.base.processors.AbstractTextAnnotator;
import io.annot8.content.text.EditableTextAnnotation;
import io.annot8.content.text.Text;
import io.annot8.content.text.TextAnnotations;
import io.annot8.core.components.java.OutputAnnotation;
import io.annot8.core.data.Item;
import io.annot8.core.exceptions.Annot8Exception;

@OutputAnnotation("HASHTAG")
public class HashTag extends AbstractTextAnnotator {
  private static final Pattern HASHTAG_PATTERN = Pattern.compile("#[a-z0-9]+", Pattern.CASE_INSENSITIVE);

  @Override
  protected void process(final Item item, final Text content) throws Annot8Exception {
    final TextAnnotations store = content.getAnnotations();

    final Matcher matcher = HASHTAG_PATTERN.matcher(content.getData());
    while (matcher.find()) {
      final EditableTextAnnotation annot = store.create(matcher.start(), matcher.end());
      annot.setType("HASHTAG");
      annot.save();
    }
  }
}
