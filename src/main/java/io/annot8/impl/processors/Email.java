package io.annot8.impl.processors;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import io.annot8.core.annotations.Annotation;
import io.annot8.core.bounds.LinearBounds;
import io.annot8.core.components.Processor;
import io.annot8.core.components.Response;
import io.annot8.core.components.javaannotations.OutputAnnotation;
import io.annot8.core.content.Text;
import io.annot8.core.data.Item;
import io.annot8.core.exceptions.ProcessingException;
import io.annot8.core.stores.AnnotationStore;
import io.annot8.impl.bounds.SimpleLinearBounds;

@OutputAnnotation("EMAIL")
public class Email implements Processor {
  private static final Pattern EMAIL =
      Pattern.compile("[A-Z0-9._%+-]+@([A-Z0-9.-]+[.][A-Z]{2,6})", Pattern.CASE_INSENSITIVE);

  @Override
  public Response process(final Item item) throws ProcessingException {
    item.getContents(Text.class).forEach(c -> processText(c));

    return Response.ok(item);

  }

  private void processText(final Text content) {
    final AnnotationStore<LinearBounds> store = content.getAnnotationStore();
    final Matcher matcher = EMAIL.matcher(content.getData());
    while (matcher.find()) {
      final LinearBounds bounds = new SimpleLinearBounds(matcher.start(), matcher.end());
      final Annotation<LinearBounds> annot = store.createNew(bounds);
      annot.setType("EMAIL");
      store.save(annot);
    }
  }
}
