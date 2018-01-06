package io.annot8.core.data;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import io.annot8.core.content.Content;

public interface View<T extends Content<?>> {

  T getContent();
  default <U extends Content<?>> Optional<U> getContent(Class<U> clazz){
	  T content = getContent();
	  
	  if(clazz.isInstance(content)) {
		  return Optional.of(clazz.cast(content));
	  }else {
		  return Optional.empty();
	  }
  }

  default boolean hasTag(String tag) {
    return getTags().anyMatch(tag::equals);
  }

  Stream<String> getTags();

  default void setTags(Collection<String> tags) {
    removeAllTags(getTags().collect(Collectors.toList()));
    addAllTags(tags);
  }

  boolean addTag(String tag);

  default void addAllTags(Collection<String> tags) {
    tags.forEach(this::addTag);
  }

  boolean removeTag(String tag);

  default void removeAllTags(Collection<String> tags) {
    tags.forEach(this::removeTag);
  }
}
