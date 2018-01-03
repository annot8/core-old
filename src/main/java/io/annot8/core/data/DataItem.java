package io.annot8.core.data;

import io.annot8.core.helpers.WithId;
import io.annot8.core.helpers.WithProperties;
import java.util.Optional;

public interface DataItem extends WithProperties, WithId {

  Optional<DataItem> getParent();
}
