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
  Stream<String> getRequiredInputAnnotations();

  /**
   * Return the type of any optional input annotations (i.e. annotations that
   * should be present if possible before a component can work)
   */
  Stream<String> getOptionalInputAnnotations();

  /**
   * Return the type of any output annotations produced by this component
   */
  Stream<String> getOutputAnnotations();

  /**
   * Return the content tags that this component will act on, or an empty
   * stream if this component will act on all content
   */
  Stream<String> getAcceptedTags();

  /**
   * Return the content classes produced by this component, or an empty
   * stream if no new content will be produced
   */
  Stream<Class<? extends Content<?>>> getCreatedContent();

  /**
   * Return the resource classes required by this component
   */
  Stream<Class<? extends Resource>> getRequiredResources();
}
