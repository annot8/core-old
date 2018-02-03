package io.annot8.core.data;

import java.util.Optional;
import java.util.stream.Stream;
import io.annot8.core.exceptions.AlreadyExistsException;
import io.annot8.core.exceptions.UnsupportedException;
import io.annot8.core.helpers.WithGroups;
import io.annot8.core.helpers.WithMutableProperties;

/**
 * Base item interface from which all item implementations extend.
 */
public interface Item extends WithMutableProperties, WithGroups {

  /**
   * Set the default content object for this item
   */
  void setDefaultContent(final String name);

  /**
   * Return the default content object for this item
   */
  Content<?> getDefaultContent();

  /**
   * Return true if this item has a content object with the specified name
   */
  default boolean hasContent(final String name) {
    return listContents().anyMatch(name::equals);
  }

  /**
   * Return the names of the content objects currently held within this item
   */
  Stream<String> listContents();

  /**
   * Return the content object for the specified name
   */
  Optional<Content<?>> getContent(final String name);

  /**
   * Return all content objects contained within this item
   */
  Stream<Content<?>> getContents();

  /**
   * Return all content objects of the specified class contained within this item
   */
  <T extends Content<?>> Stream<T> getContents(final Class<T> clazz);
  
  /**
   * Return all content objects whose data is of the specified class
   */
  <T> Stream<Content<T>> getContentsByDataClass(final Class<T> clazz);

  /**
   * Create a new content object from the given content builder (the name should be taken from the builder object)
   */
  <C extends Content<?>> C create(final C.Builder builder) throws AlreadyExistsException, UnsupportedException;

  /**
   * Remove the specified content object from this item
   */
  void removeContent(final String name);

}
