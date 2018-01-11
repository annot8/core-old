package io.annot8.impl.bounds;

import io.annot8.core.bounds.LinearBounds;

public class SimpleLinearBounds implements LinearBounds {

  private int begin;
  private int end;

  public SimpleLinearBounds(final int begin, final int end) {
    this.begin = begin;
    this.end = end;
  }

  @Override
  public int getBegin() {
    return begin;
  }

  @Override
  public void setBegin(final int begin) {
    this.begin = begin;
  }

  @Override
  public int getEnd() {
    return end;
  }

  @Override
  public void setEnd(final int end) {
    this.end = end;
  }

}
