package io.annot8.pipeline.processors;

import io.annot8.core.annotations.Annotation;
import io.annot8.core.components.Processor;
import io.annot8.core.content.Content;
import io.annot8.core.content.Text;
import io.annot8.core.context.ProcessingContext;
import io.annot8.core.data.Document;
import io.annot8.core.exceptions.ProcessingException;
import io.annot8.core.stores.AnnotationStore;
import io.annot8.simple.SimpleIntLineBounds;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractMultiViewTextProcessor extends AbstractMultiViewProcessor {

  protected boolean acceptsContent(Content content) {
    return content instanceof Text;
  }

  @Override
  protected void processContent(AnnotationStore annotationStore, Content content) {
    // Technically we don't need this as accepts Content has already checked it
    if(content instanceof Text) {
      processText(annotationStore, (Text)content);
    } else {
      // TODO; intellij todo
      // log.warn("Content is not text, this should have been filtered out by acceptsContent");
    }
  }


  protected abstract void processText(AnnotationStore annotationStore, Text content);
}
