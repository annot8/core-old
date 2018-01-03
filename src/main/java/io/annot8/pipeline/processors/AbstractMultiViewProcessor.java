package io.annot8.pipeline.processors;

import java.util.Set;

import io.annot8.core.components.Processor;
import io.annot8.core.content.Content;
import io.annot8.core.context.ProcessingContext;
import io.annot8.core.data.Document;
import io.annot8.core.exceptions.ProcessingException;
import io.annot8.core.stores.AnnotationStore;

public abstract class AbstractMultiViewProcessor implements Processor {

  // TODO: get which tags out of configuration

  @Override
  public void process(final ProcessingContext context, final Document document)
      throws ProcessingException {

    document.listViews().forEach(view -> {

      if (acceptsTag(view.getTags()) && acceptsContent(view.getContent())) {

        final AnnotationStore annotationStore = context.getResource(AnnotationStore.class).get();
        processContent(annotationStore, view.getContent());
      }
    });
  }

  protected boolean acceptsTag(final Set<String> tags) {
    return true;
  }

  protected boolean acceptsContent(final Content<?> content) {
    return true;
  }

  protected abstract void processContent(AnnotationStore annotationStore, Content<?> content);
}
