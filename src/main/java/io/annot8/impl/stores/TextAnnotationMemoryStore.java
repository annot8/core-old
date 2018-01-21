package io.annot8.impl.stores;

import io.annot8.content.text.TextAnnotation;
import io.annot8.content.text.TextBounds;
import io.annot8.core.annotations.Annotation.Builder;
import io.annot8.core.exceptions.IncompleteAnnotationException;
import io.annot8.impl.annotations.SimpleTextAnnotation.SimpleTextAnnotationBuilder;

public class TextAnnotationMemoryStore extends AbstractMemoryStore<TextBounds, TextAnnotation> {

	public TextAnnotationMemoryStore(final String contentName) {
		super(contentName);
	}

	@Override
	public TextAnnotation save(Builder<TextAnnotation, TextBounds> annotationBuilder) throws IncompleteAnnotationException {
		return super.save(annotationBuilder);
	}

	@Override
	public TextAnnotation.TextAnnotationBuilder getBuilder() {
		return new SimpleTextAnnotationBuilder();
	}

}
