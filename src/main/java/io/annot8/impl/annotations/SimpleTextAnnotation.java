package io.annot8.impl.annotations;

import java.util.UUID;
import io.annot8.content.text.TextAnnotation;
import io.annot8.content.text.TextBounds;
import io.annot8.core.data.Properties;
import io.annot8.impl.data.SimpleProperties;

public class SimpleTextAnnotation implements TextAnnotation {
	private final String contentName;
	private final String id;
	private String type;

	private TextBounds bounds;
	private final Properties properties;

	public SimpleTextAnnotation(final String contentName, final TextBounds bounds) {
		this.contentName = contentName;
		this.id = UUID.randomUUID().toString();
		this.bounds = bounds;
		this.properties = new SimpleProperties();
	}
	
	private SimpleTextAnnotation(SimpleTextAnnotationBuilder builder) {
		this.contentName = builder.contentName;
		this.id = builder.id;
		this.bounds = builder.bounds;
		this.properties = builder.properties;
		this.type = builder.type;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public String getContentName() {
		return contentName;
	}

	@Override
	public String getType() {
		return type;
	}

	@Override
	public TextBounds getBounds() {
		return bounds;
	}

	@Override
	public Properties getProperties() {
		return properties;
	}

	public static class SimpleTextAnnotationBuilder implements TextAnnotation.TextAnnotationBuilder {
		private String contentName;
		private String id = UUID.randomUUID().toString();
		private String type;

		private TextBounds bounds;	//FIXME: Potential for NPE here?
		private Properties properties = new SimpleProperties();

		@Override
		public Builder<TextAnnotation, TextBounds> fromAnnotation(TextAnnotation annotation) {
			this.contentName = annotation.getContentName();
			this.id = annotation.getId();
			this.type = annotation.getType();
			this.bounds = annotation.getBounds();
			this.properties = annotation.getProperties();
			return this;
		}

		@Override
		public Builder<TextAnnotation, TextBounds> newId() {
			id = UUID.randomUUID().toString();
			return this;
		}

		@Override
		public Builder<TextAnnotation, TextBounds> onContent(String contentName) {
			this.contentName = contentName;
			return this;
		}

		@Override
		public Builder<TextAnnotation, TextBounds> setBounds(TextBounds bounds) {
			this.bounds = bounds;
			return this;
		}

		@Override
		public Builder<TextAnnotation, TextBounds> setType(String type) {
			this.type = type;
			return this;
		}

		@Override
		public Builder<TextAnnotation, TextBounds> setProperty(String key, Object value) {
			properties.set(key, value);
			return this;
		}

		@Override
		public Builder<TextAnnotation, TextBounds> setProperties(Properties properties) {
			this.properties = properties;
			return this;
		}

		@Override
		public SimpleTextAnnotation build() {
			return new SimpleTextAnnotation(this);
		}
	}
}
