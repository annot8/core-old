package io.annot8.base.processors;

import io.annot8.core.data.Content;
import io.annot8.core.data.Context;
import io.annot8.core.data.Item;
import io.annot8.core.exceptions.BadConfigurationException;
import io.annot8.core.exceptions.MissingResourceException;

import java.util.Optional;
import java.util.stream.Stream;

public abstract class AbstractContentAnnotator extends AbstractAnnotator {

  private ContentAnnotatorSettings settings;

  @Override
  public void configure(final Context context)
      throws BadConfigurationException, MissingResourceException {
    super.configure(context);

    settings = context.getConfiguration(ContentAnnotatorSettings.class);
  }

  @Override
  protected boolean processItem(final Item item) {

    if (settings.isDefaultView()) {
      // If processing default view then jump to that
      checkTagsAndProcessContent(item.getDefaultContent());
    } else {
      // Otherwise get the views the config wanted

      Stream<Content> requestedViews;
      // Did we limit the views?
      if (settings.getViews() == null || settings.getViews().isEmpty()) {
        requestedViews = item.getContents();
      } else {
        requestedViews = settings.getViews().stream().map(item::getContent)
            .filter(Optional::isPresent).map(Optional::get);
      }

      requestedViews.forEach(this::checkTagsAndProcessContent);
    }



    // Always pass on...
    return true;
  }


  private void checkTagsAndProcessContent(final Content content) {

  }

  protected boolean acceptsContent(final Content content) {
    // TODO: One match / all match?

    if (settings.getTags() == null || settings.getTags().isEmpty()) {
      return true;
    } else {
      return content.getTags().get().allMatch(settings.getTags()::contains);
    }
  }

  protected abstract void processContent(final Item item, final Content content) throws Exception;

}
