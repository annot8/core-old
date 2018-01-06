package io.annot8.impl.processors;

import java.util.Optional;

import io.annot8.core.components.Processor;
import io.annot8.core.content.Text;
import io.annot8.core.context.ProcessingContext;
import io.annot8.core.data.DataItem;
import io.annot8.core.exceptions.ProcessingException;
import io.annot8.impl.bounds.SimpleLinearBounds;

public class PrintMentions implements Processor {
	@Override
	public void process(DataItem dataItem, ProcessingContext context) throws ProcessingException {
		context.getAnnotationStore().getAll().forEach(a -> {

			Optional<Text> text = a.getView().getContent(Text.class);
			Optional<SimpleLinearBounds> bounds = a.getBounds(SimpleLinearBounds.class);

			if(text.isPresent() && bounds.isPresent() && text.get().getContent().isPresent()){
				String value = text.get().getContent().get().substring(bounds.get().getBegin(), bounds.get().getEnd());

				System.out.println("Annotation from " + bounds.get().getBegin() + " to " + bounds.get().getEnd()+": "+value);
			}
		});
	}
}
