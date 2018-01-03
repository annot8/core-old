package io.annot8.pipeline.services;

import java.util.List;

import io.annot8.core.components.Processor;
import io.annot8.core.context.ConfiguringContext;
import io.annot8.core.context.ProcessingContext;
import io.annot8.core.data.Document;
import io.annot8.core.exceptions.BadConfigurationException;
import io.annot8.core.exceptions.MissingResourceException;
import io.annot8.core.exceptions.ProcessingException;

public class MultiProcessor implements Processor {

  private final List<Processor> processors;

  public MultiProcessor(List<Processor> processors) {
    this.processors = processors;
  }

  @Override
  public void configure(ConfiguringContext context)
      throws BadConfigurationException, MissingResourceException {
    for (Processor p : processors) {
      p.configure(context);
    }
  }

  @Override
  public void process(ProcessingContext context, Document document) throws ProcessingException {
    for (Processor p : processors) {
      p.process(context, document);
    }
  }
}
