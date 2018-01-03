package io.annot8.core.data;

import io.annot8.core.helpers.WithId;
import io.annot8.core.helpers.WithProperties;
import io.annot8.core.helpers.WithViews;

public interface Document extends WithId, WithViews, WithProperties {

  DataItem getDataItem();

}
