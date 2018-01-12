package io.annot8.impl.processors;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import io.annot8.content.text.TextBounds;
import io.annot8.content.text.Text;
import io.annot8.content.text.TextAnnotation;
import io.annot8.content.text.TextAnnotationStore;
import io.annot8.core.components.Processor;
import io.annot8.core.components.Response;
import io.annot8.core.components.javaannotations.OutputAnnotation;
import io.annot8.core.data.Item;
import io.annot8.core.exceptions.ProcessingException;
import io.annot8.impl.bounds.SimpleLinearBounds;

@OutputAnnotation("HASHTAG")
public class HashTag implements Processor {
  private static final Pattern HASHTAG = Pattern.compile("#[a-z0-9]+", Pattern.CASE_INSENSITIVE);

  @Override
  public Response process(final Item item) throws ProcessingException {
    item.getContents(Text.class).forEach(c -> processText(c));

    return Response.ok(item);
  }

  private void processText(final Text content) {

    final TextAnnotationStore store = content.getAnnotationStore();

    final Matcher matcher = HASHTAG.matcher(content.getData());
    while (matcher.find()) {
      final TextBounds bounds = new SimpleLinearBounds(matcher.start(), matcher.end());
      final TextAnnotation annot = store.createNew(bounds);
      annot.setType("HASHTAG");
      store.save(annot);
    }
  }
}
