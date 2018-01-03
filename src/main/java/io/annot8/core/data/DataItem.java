package io.annot8.core.data;

import java.util.Optional;

import io.annot8.core.helpers.WithId;
import io.annot8.core.helpers.WithProperties;

public interface DataItem extends WithProperties, WithId {

  Optional<DataItem> getParent();
}
