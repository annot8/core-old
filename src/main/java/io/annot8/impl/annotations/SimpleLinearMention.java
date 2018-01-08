package io.annot8.impl.annotations;


import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import io.annot8.core.annotations.Annotation;
import io.annot8.core.bounds.LinearBounds;
import io.annot8.core.data.View;

public class SimpleLinearMention implements Annotation<LinearBounds>{
	private String id;
	private String type;
	
    private Map<String, Object> properties = new HashMap<>();
    
    private View<?> view;
    private LinearBounds bounds;

	
	public SimpleLinearMention(View<?> view, LinearBounds bounds) {
		this.id = UUID.randomUUID().toString();
		this.bounds = bounds;
		this.view = view;
	}
	
	@Override
	public String getId() {
		return id;
	}
	
	@Override
	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String getType() {
		return type;
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
	public void setView(View<?> view) {
		this.view = view;
	}

	@Override
	public View<?> getView() {
		return view;
	}

	@Override
	public LinearBounds getBounds() {
		return bounds;
	}

	@Override
	public void setBounds(LinearBounds bounds) {
		this.bounds = bounds;
	}

}
