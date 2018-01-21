package io.annot8.impl.stores;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;
import io.annot8.core.annotations.Annotation;
import io.annot8.core.annotations.Annotation.Builder;
import io.annot8.core.bounds.Bounds;
import io.annot8.core.exceptions.IncompleteAnnotationException;
import io.annot8.core.stores.Annotations;

public abstract class AbstractMemoryStore<B extends Bounds, A extends Annotation<B>>
implements Annotations<B, A> {
	private final Map<String, A> annotations = new HashMap<>();

	private final String contentName;

	public AbstractMemoryStore(final String contentName) {
		this.contentName = contentName;
	}

	@Override
	public A save(Builder<A, B> annotationBuilder) throws IncompleteAnnotationException {
		A annotation = annotationBuilder.build();
		annotations.put(annotation.getId(), annotation);
		return annotation;
	}

	@Override
	public void delete(final A annotation) {
		annotations.remove(annotation.getId());
	}

	@Override
	public Stream<A> getAll() {
		return annotations.values().stream();
	}

	@Override
	public Optional<A> getById(final String annotationId) {
		return Optional.ofNullable(annotations.get(annotationId));
	}

	public String getContentName() {
		return contentName;
	}
}
