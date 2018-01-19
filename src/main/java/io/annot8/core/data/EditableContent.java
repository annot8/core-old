package io.annot8.core.data;

import io.annot8.core.helpers.Saveable;
import io.annot8.core.helpers.WithEditableProperties;
import io.annot8.core.helpers.WithEditableTags;

public interface EditableContent<D>
    extends Content<D>, WithEditableTags, WithEditableProperties, Saveable<Content<D>> {

  // TODO: void setData(D data) throws NotSupported? Since this is a dedicated edit interface it feels
  // like that would be less problematic now. It would basically mean you needed to delete all the
  // nnoations those
  // so hardly any different to a replace content (utility function)

}
