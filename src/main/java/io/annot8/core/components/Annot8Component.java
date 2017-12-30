package io.annot8.core.components;

import io.annot8.core.context.ConfiguringContext;
import io.annot8.core.exceptions.BadConfigurationException;
import io.annot8.core.exceptions.MissingResourceException;

public interface Annot8Component extends AutoCloseable {

  default void configure(ConfiguringContext context)
      throws BadConfigurationException, MissingResourceException {
    // Do nothing
  }

  @Override
  default void close() throws Exception {
    // Do nothing
  }
}
