package io.annot8.core.context;

import io.annot8.core.components.Resource;

public interface Context {
	public Object getConfiguration(String key);
	public <T> T getConfiguration(String key, Class<?> T);
	
	public <T extends Resource> T getResource(String key, Class<? extends Resource> T);
}
