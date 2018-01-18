package io.annot8.core.data;

import io.annot8.core.helpers.Saveable;
import io.annot8.core.helpers.WithEditableProperties;
import io.annot8.core.helpers.WithEditableTags;

public interface EditableContent<D>
    extends Content<D>, WithEditableTags, WithEditableProperties, Saveable<Content<D>> {

  // TODO: void setData(D data) throws NotSupported? could add it back now..

}
