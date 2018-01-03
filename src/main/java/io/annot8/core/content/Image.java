package io.annot8.core.content;

public interface Image extends Content<byte[]> {

  int getWidth();

  int getHeight();

  @Override
  default Class<byte[]> getContentClass() {
    return byte[].class;
  }
}
