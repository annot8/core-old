package io.annot8.impl.data;

import io.annot8.core.content.Content;
import io.annot8.core.data.DataItem;
import io.annot8.core.data.View;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

public class SimpleDataItem implements DataItem {

    private View<?> defaultView;
    private Map<String, View<?>> views = new HashMap<>();
    private Map<String, Object> properties = new HashMap<>();

    public SimpleDataItem(View<?> defaultView){
        this.defaultView = defaultView;
    }

    @Override
    public void setDefaultView(View<?> view, String newKeyForOldView) {
        views.put(newKeyForOldView, defaultView);
        this.defaultView = view;
    }

    @Override
    public View<?> getDefaultView() {
        return defaultView;
    }

    @Override
    public Stream<String> listViews() {
        return views.keySet().stream(); //TODO: Should the default view be included here?
    }

    @Override
    public Optional<View<?>> getView(String name) {
        return Optional.ofNullable(views.get(name));
    }

    @Override
    public <T> View<T> createView(String name, Content<T> content) {
        View<T> view = new SimpleView<>(content);
        views.put(name, view);
        return view;
    }

    @Override
    public Optional<View<?>> removeView(String name) {
        return Optional.ofNullable(views.remove(name));
    }

    @Override
    public void setProperty(String key, Object value) {
        properties.put(key, value);
    }

    @Override
    public Optional<Object> removeProperty(String key) {
        return Optional.ofNullable(properties.remove(key));
    }

    @Override
    public Map<String, Object> getProperties() {
        return properties;
    }
}
