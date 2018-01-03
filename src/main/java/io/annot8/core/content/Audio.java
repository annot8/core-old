package io.annot8.core.content;

public interface Audio extends Content<byte[]> {


  default Class<byte[]> getContentClass() {
    return byte[].class;
  }


}
