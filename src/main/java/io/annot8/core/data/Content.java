package io.annot8.core.data;

import io.annot8.core.helpers.WithProperties;
import io.annot8.core.helpers.WithTags;
import io.annot8.core.helpers.builders.*;
import io.annot8.core.stores.Annotations;

public interface Content<D> extends WithTags, WithProperties {

  D getData();

  Annotations<?, ?> getAnnotations();

  String getName();

  interface Builder<A extends Content<D>, D> extends
          WithPropertiesBuilder<Builder<A, D>>,
          WithTagsBuilder<Builder<A, D>>,
          WithFrom<Builder<A, D>, A>,
          WithBuild<A>
  {
    Content.Builder<A, D> withName(String name);
    Content.Builder<A, D> withData(D content);
    Content.Builder<A, D> withAnnotations(Annotations<?, ?> annotations);
  }
}