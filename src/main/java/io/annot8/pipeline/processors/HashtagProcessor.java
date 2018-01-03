package io.annot8.pipeline.processors;

import io.annot8.core.annotations.Annotation;
import io.annot8.core.components.Processor;
import io.annot8.core.context.ProcessingContext;
import io.annot8.core.content.Content;
import io.annot8.core.content.Text;
import io.annot8.core.data.Document;
import io.annot8.core.exceptions.ProcessingException;
import io.annot8.core.stores.AnnotationStore;
import io.annot8.simple.SimpleIntLineBounds;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class HashtagProcessor extends AbstractMultiViewTextProcessor {

  private final Pattern REGEX = Pattern.compile("#[a-zA-Z0-9]+");

  protected void processText(AnnotationStore annotationStore, Text content) {
    String text = content.getContent();

    Matcher matcher = REGEX.matcher(text);

    while(matcher.find()) {
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
