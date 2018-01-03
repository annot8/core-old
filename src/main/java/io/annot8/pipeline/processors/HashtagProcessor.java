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
  protected void processText(AnnotationStore annotationStore, Text content) {
    String text = content.getContent();

    Matcher matcher = REGEX.matcher(text);

    while (matcher.find()) {
      Annotation annotation = annotationStore.create();
      // TODO: no setType... should it be on the annotation or on create()
      int left = matcher.start();
      int right = matcher.end();

      annotation.setBounds(new SimpleIntLineBounds(left, right));
      annotation.setProperty("value", matcher.group());
      annotation.save();
    }
  }
}
