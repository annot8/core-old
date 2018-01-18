package io.annot8.impl.data;

import io.annot8.core.data.EditableItem;
import io.annot8.core.data.Item;
import io.annot8.core.data.Properties;
import io.annot8.core.stores.AnnotationCollections;
import io.annot8.core.stores.Contents;

public class SimpleItem implements Item {

  private final SimpleProperties properties = new SimpleProperties();
  private final AnnotationCollections annotationCollections;
  private final Contents contents;

  public SimpleItem(final AnnotationCollections collections, final SimpleEditableItem editable) {
    this.annotationCollections = collections;
    this.contents = editable.getContents();
  }

  @Override
  public Contents getContents() {
    return contents;
  }

  @Override
  public Properties getProperties() {
    return properties;
  }

  @Override
  public AnnotationCollections getAnnotationCollections() {
    return annotationCollections;
  }

  @Override
  public EditableItem edit() {
    // TODO Auto-generated method stub
    return null;
  }



}
