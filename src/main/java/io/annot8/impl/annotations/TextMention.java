package io.annot8.impl.annotations;

import io.annot8.core.annotations.Annotation;
import io.annot8.core.bounds.Bounds;
import io.annot8.core.bounds.LinearBounds;
import io.annot8.core.bounds.NoBounds;
import io.annot8.core.exceptions.Annot8RuntimeException;
import io.annot8.impl.bounds.SimpleLinearBounds;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class TextMention implements Annotation {
    private Bounds bounds = NoBounds.NO_BOUNDS;
    private final String type;
    private final String id;
    private Map<String, Object> properties = new HashMap<>();

    public TextMention(String type){
        this.type = type;
        this.id = UUID.randomUUID().toString();
    }

    public TextMention(String type, int start, int end){
        this(type);
        this.bounds = new SimpleLinearBounds(start, end);
    }

    @Override
    public Bounds getBounds() {
        return bounds;
    }

    @Override
    public void setBounds(Bounds bounds) {
        if(bounds instanceof LinearBounds || bounds instanceof NoBounds){
            this.bounds = bounds;
        }else{
            throw new Annot8RuntimeException("Bounds must be LinearBounds for a TextMention");
        }
    }

    @Override
    public String getId() {
        return id;
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

    @Override
    public String getType() {
        return type;
    }
}