package io.annot8.core.helpers;

import io.annot8.core.annotations.Group;
import io.annot8.core.stores.Groups;

public interface WithGroups<A extends Group> {

  Groups<A> getGroups();
}
