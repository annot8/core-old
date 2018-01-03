package io.annot8.pipeline.processors;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.annot8.core.annotations.Annotation;
import io.annot8.core.content.Text;
import io.annot8.core.stores.AnnotationStore;
import io.annot8.simple.SimpleIntLineBounds;

public class HashtagProcessor extends AbstractMultiViewTextProcessor {

  private final Pattern REGEX = Pattern.compile("#[a-zA-Z0-9]+");

  @Override
  protected void processText(final AnnotationStore annotationStore, final Text content) {
    final String text = content.getContent();

    final Matcher matcher = REGEX.matcher(text);

    while (matcher.find()) {
      final Annotation annotation = annotationStore.create();
      // TODO: no setType... should it be on the annotation or on create()
      final int left = matcher.start();
      final int right = matcher.end();

      annotation.setBounds(new SimpleIntLineBounds(left, right));
      annotation.getProperties().setProperty("value", matcher.group());
      annotation.save();
    }
  }
}
