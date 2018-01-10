package io.annot8.impl.data;

import io.annot8.core.content.Content;
import io.annot8.core.data.DataItem;
import io.annot8.core.exceptions.AlreadyExistsException;

import java.util.*;
import java.util.stream.Stream;

public class SimpleDataItem implements DataItem {

    private Map<String, Content<?>> contents = new HashMap<>();
    private Map<String, Object> properties = new HashMap<>();
    private String defaultContentName = DEFAULT_CONTENT;

    private static final String DEFAULT_CONTENT = "__default";

    public SimpleDataItem(Content<?> defaultContent){
        contents.put(DEFAULT_CONTENT, defaultContent);
    }

    public SimpleDataItem(Content<?> defaultContent, String defaultContentName){
        contents.put(defaultContentName, defaultContent);
        this.defaultContentName = defaultContentName;
    }

    @Override
    public void setDefaultContent(String name) {
        defaultContentName = name;
    }

    @Override
    public Content<?> getDefaultContent() {
        return contents.get(defaultContentName);
    }

    @Override
    public Stream<String> listContents() {
        return contents.keySet().stream();
    }

    @Override
    public Optional<Content<?>> getContent(String name) {
        return Optional.ofNullable(contents.get(name));
    }

    @Override
    public Stream<Content<?>> getContents() {
        return contents.values().stream();
    }

    @Override
    public <T extends Content> Stream<T> getContents(Class<T> clazz) {
        List<T> ret = new ArrayList<>();

        contents.values().stream().filter(c -> clazz.isAssignableFrom(c.getClass())).forEach(c -> ret.add(clazz.cast(c)));

        return ret.stream();
    }

    @Override
    public <T> void addContent(String name, Content<T> content) throws AlreadyExistsException {
        if(contents.containsKey(name))
            throw new AlreadyExistsException("Content with that name already exists");

        contents.put(name, content);
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
