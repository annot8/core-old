package io.annot8.impl.processors;

import io.annot8.core.bounds.Bounds;
import io.annot8.core.bounds.LinearBounds;
import io.annot8.core.components.Processor;
import io.annot8.core.content.Text;
import io.annot8.core.data.DataItem;
import io.annot8.core.exceptions.ProcessingException;
import io.annot8.core.stores.AnnotationStore;

import java.util.Optional;

public class PrintMentions implements Processor {
	@Override
	public void process(DataItem dataItem, AnnotationStore store) throws ProcessingException {
		store.getAll().forEach(a -> {
			Optional<Text> text = a.getContent(Text.class);
			Bounds bounds = a.getBounds();

			if(text.isPresent() && bounds instanceof LinearBounds){
				LinearBounds lb = (LinearBounds) bounds;
				String value = text.get().getContent().substring(lb.getBegin(), lb.getEnd());

				System.out.println("Annotation from " + lb.getBegin() + " to " + lb.getEnd()+": "+value);
			}
		});
	}
}
