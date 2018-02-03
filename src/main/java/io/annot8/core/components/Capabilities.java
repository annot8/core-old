package io.annot8.core.components;

import java.util.stream.Stream;
import io.annot8.core.data.Content;

/**
 * Base capabilities interface used to describe the capabilities of a component
 */
public interface Capabilities {
  /**
   * Return the type of any required input annotations (i.e. annotations that
   * must be present before a component can work)
   */
  default Stream<String> getRequiredInputAnnotations(){
    return Stream.empty();
  }

  /**
   * Return the type of any optional input annotations (i.e. annotations that
   * should be present if possible before a component can work)
   */
  default Stream<String> getOptionalInputAnnotations(){
    return Stream.empty();
  }

  /**
   * Return the type of any output annotations produced by this component
   */
  Stream<String> getOutputAnnotations();

  /**
   * Return the content tags that this component will act on, or an empty
   * stream if this component will act on all content
   */
  default Stream<String> getAcceptedTags(){
    return Stream.empty();
  }

  /**
   * Return the content classes produced by this component, or an empty
   * stream if no new content will be produced
   */
  default Stream<Class<? extends Content<?>>> getCreatedContent(){
    return Stream.empty();
  }

  /**
   * Return the resource classes required by this component
   */
  default Stream<Class<? extends Resource>> getRequiredResources(){
    return Stream.empty();
  }
}
