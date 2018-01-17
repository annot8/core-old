package io.annot8.impl.bounds;

import io.annot8.content.text.TextBounds;

public class SimpleTextBounds implements TextBounds {

  private final int begin;
  private final int end;

  public SimpleTextBounds(final int begin, final int end) {
    this.begin = begin;
    this.end = end;
  }

  @Override
  public int getBegin() {
    return begin;
  }

  @Override
  public int getEnd() {
    return end;
  }


}
