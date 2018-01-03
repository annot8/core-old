package io.annot8.pipeline.processors;

import io.annot8.core.content.Content;
import io.annot8.core.content.Text;
import io.annot8.core.stores.AnnotationStore;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractMultiViewTextProcessor extends AbstractMultiViewProcessor {

  @Override
  protected boolean acceptsContent(final Content<?> content) {
    return content instanceof Text;
  }

  @Override
  protected void processContent(final AnnotationStore annotationStore, final Content<?> content) {
    // Technically we don't need this as accepts Content has already checked it
    if (content instanceof Text) {
      processText(annotationStore, (Text) content);
    } else {
      log.warn("Content is not text, this should have been filtered out by acceptsContent");
    }
  }


  protected abstract void processText(AnnotationStore annotationStore, Text content);
}
