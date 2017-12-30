package io.annot8.core.documents;

public interface Image extends Content<byte[]> {

  int getWidth();

  int getHeight();
}
