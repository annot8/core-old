package io.annot8.core.data;

import io.annot8.core.exceptions.IncompleteException;
import io.annot8.core.helpers.WithProperties;
import io.annot8.core.helpers.WithTags;
import io.annot8.core.stores.Annotations;

public interface Content<D> extends WithTags, WithProperties {

  D getData();

  Annotations<?, ?> getAnnotations();

  String getName();

  interface Builder<A extends Content<D>, D> {
    Content.Builder<A, D> fromContent(Content content);

    Content.Builder<A, D> setName(String name);
    Content.Builder<A, D> setData(D content);

    Content.Builder<A, D> setTag(String tag);
    Content.Builder<A, D> setTags(Tags tags);

    Content.Builder<A, D> setProperty(String key, Object value);
    Content.Builder<A, D> setProperties(Properties properties);

    Content.Builder<A, D> setAnnotations(Annotations<?, ?> annotations);

    A build() throws IncompleteException;
  }
}