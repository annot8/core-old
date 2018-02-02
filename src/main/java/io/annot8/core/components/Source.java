package io.annot8.core.components;

import io.annot8.core.components.responses.SourceResponse;


public interface Source extends Annot8Component {

  SourceResponse read();

}
