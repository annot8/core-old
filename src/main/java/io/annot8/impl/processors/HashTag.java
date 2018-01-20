package io.annot8.impl.processors;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import io.annot8.base.processors.AbstractTextAnnotator;
import io.annot8.content.text.Text;
import io.annot8.content.text.TextAnnotation;
import io.annot8.content.text.TextBounds;
import io.annot8.core.components.java.OutputAnnotation;
import io.annot8.core.data.Item;
import io.annot8.core.exceptions.Annot8Exception;
import io.annot8.core.stores.Annotations;
import io.annot8.impl.bounds.SimpleTextBounds;

@OutputAnnotation("HASHTAG")
public class HashTag extends AbstractTextAnnotator {
  private static final Pattern HASHTAG = Pattern.compile("#[a-z0-9]+", Pattern.CASE_INSENSITIVE);

  @Override
  protected void process(final Item item, final Text content) throws Annot8Exception {
    final Annotations<TextBounds, TextAnnotation> store = content.getAnnotations();

    final Matcher matcher = HASHTAG.matcher(content.getData());
    while (matcher.find()) {
      final TextBounds bounds = new SimpleTextBounds(matcher.start(), matcher.end());
      store.save(store.getBuilder().onContent(content.getName()).setBounds(bounds).setType("HASHTAG"));
    }
  }
}
