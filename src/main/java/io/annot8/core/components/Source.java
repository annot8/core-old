package io.annot8.core.components;

import io.annot8.core.components.responses.SourceResponse;

/**
 * Base processor interface from which all sources extend.
 * 
 * Sources read data from somewhere (e.g. a file system, or a database)
 * and produce items that will be processed by other components.
 */
public interface Source extends Annot8Component {

  SourceResponse read();

}
