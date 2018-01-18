package io.annot8.impl.data;

import io.annot8.core.data.EditableItem;
import io.annot8.core.data.EditableProperties;
import io.annot8.core.data.Item;
import io.annot8.core.stores.AnnotationCollections;
import io.annot8.core.stores.Contents;

public class SimpleEditableItem implements EditableItem {

  private final EditableProperties properties;
  private final AnnotationCollections annotationCollections;
  private final Contents contents;

  public SimpleEditableItem(final AnnotationCollections collections, final Contents contents) {
    this.annotationCollections = collections;
    this.contents = contents;
    this.properties = new SimpleEditableProperties();
  }

  public SimpleEditableItem(final AnnotationCollections collections, final Item item) {
    this.annotationCollections = collections;
    this.contents = item.getContents();
    this.properties = new SimpleEditableProperties(item.getProperties());
  }

  @Override
  public EditableProperties getProperties() {
    return properties;
  }

  @Override
  public AnnotationCollections getAnnotationCollections() {
    return annotationCollections;
  }

  @Override
  public Contents getContents() {
    return contents;
  }

  @Override
  public Item save() {
    return new SimpleItem(annotationCollections, this);
  }



}
