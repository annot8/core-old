package simple;

import io.annot8.core.components.Resource;
import io.annot8.core.context.ProcessingContext;
import io.annot8.core.context.View;
import io.annot8.core.documents.Content;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

public class SimpleProcessingContext extends SimpleContext implements ProcessingContext {

  private final String defaultView;
  private final Map<String, View> views;

  public SimpleProcessingContext(Map<String, Object> configuration,
      Map<String, Resource> resources, String defaultView, Map<String, View> views) {
    super(configuration, resources);
    this.defaultView = defaultView;
    this.views = views;
  }

  @Override
  public View getDefaultView() {
    return views.get(defaultView);
  }

  @Override
  public Stream<String> listViews() {
    return views.keySet().stream();
  }

  @Override
  public Optional<View> getView(String name) {
    return Optional.ofNullable(views.get(name));
  }

  @Override
  public View createView(String name, Content content) {
    removeView(name);
    SimpleView view = new SimpleView(getRawConfiguration(), getRawResources(), content);
    views.put(name, view);
    return view;
  }

  @Override
  public Optional<View> removeView(String name) {
    return Optional.ofNullable(views.remove(name));
  }
}
