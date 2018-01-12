package io.annot8.base.processors;

import io.annot8.content.text.Text;

public abstract class AbstractTextAnnotator extends AbstractContentClassAnnotator<Text> {

  protected AbstractTextAnnotator() {
    super(Text.class);
  }


}
