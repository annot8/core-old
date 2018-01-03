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

public abstract class AbstractMultiViewProcessor implements Processor {

  // TODO: get which tags out of configuration

  @Override
  public void process(ProcessingContext context, Document document) throws ProcessingException {

    document.listViews().forEach(view -> {

      if(acceptsTag(view.getTags()) && acceptsContent(view.getContent())) {

        AnnotationStore annotationStore = context.getResource(AnnotationStore.class).get();
        processContent(annotationStore, (Text)view.getContent());
      }
    });
  }

  protected boolean acceptsTag(Set<String> tags) {
    return true;
  }

  protected boolean acceptsContent(Content content) {
    return true;
  }

  protected abstract void processContent(AnnotationStore annotationStore, Content content);
}
