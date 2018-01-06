package io.annot8.impl.data;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import io.annot8.core.content.Content;
import io.annot8.core.data.DataItem;
import io.annot8.core.data.View;
import io.annot8.core.exceptions.AlreadyExistsException;

public class SimpleDataItem implements DataItem {

    private Map<String, View<?>> views = new HashMap<>();
    private Map<String, Object> properties = new HashMap<>();
    private String defaultViewName = DEFAULT_VIEW;

    private static final String DEFAULT_VIEW = "__default";

    public SimpleDataItem(View<?> defaultView){
        views.put(DEFAULT_VIEW, defaultView);
    }

    public SimpleDataItem(View<?> defaultView, String defaultViewName){
        views.put(defaultViewName, defaultView);
        this.defaultViewName = defaultViewName;
    }

    @Override
    public void setDefaultView(String name) {
        defaultViewName = name;
    }

    @Override
    public View<?> getDefaultView() {
        return views.get(defaultViewName);
    }

    @Override
    public Stream<String> listViews() {
        return views.keySet().stream();
    }

    @Override
    public Optional<View<?>> getView(String name) {
        return Optional.ofNullable(views.get(name));
    }

    @Override
    public Stream<View<?>> getViews() {
        return views.values().stream();
    }

    @Override
    public <T extends Content<?>> View<T> createView(String name, T content) throws AlreadyExistsException {
        if(views.containsKey(name))
            throw new AlreadyExistsException("View with that name already exists");

        View<T> view = new SimpleView<>(content);
        views.put(name, view);
        return view;
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
