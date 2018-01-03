package io.annot8.simple;

import io.annot8.core.content.Content;
import io.annot8.core.data.DataItem;
import io.annot8.core.data.Document;
import io.annot8.core.data.View;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;
import lombok.Data;

@Data
public class SimpleDocument extends SimpleProperties implements Document {

  private final DataItem dataItem;
  private final String id;
  private final Map<String, View> views = new HashMap<>();
  private String defaultView;

  public SimpleDocument(DataItem dataItem, String id) {
    this.dataItem = dataItem;
    this.id = id;
  }

  // View
  public Optional<View> getDefaultView() {
    if (defaultView != null) {
      return getView(defaultView);
    } else {
      return listViews().findFirst();
    }
  }


  @Override
  public Stream<View> listViews() {
    return views.values().stream();
  }

  @Override
  public Optional<View> getView(String name) {
    return Optional.ofNullable(views.get(name));
  }

  @Override
  public View createView(String name, Content content) {
    removeView(name);
    SimpleView view = new SimpleView(name, content);
    views.put(name, view);
    return view;
  }

  @Override
  public Optional<View> removeView(String name) {
    return Optional.ofNullable(views.remove(name));
  }
}
