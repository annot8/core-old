package io.annot8.impl.processors;

import java.util.Optional;

import io.annot8.core.components.Processor;
import io.annot8.core.components.javaannotations.CreatesViews;
import io.annot8.core.content.Text;
import io.annot8.core.data.DataItem;
import io.annot8.core.data.View;
import io.annot8.core.exceptions.AlreadyExistsException;
import io.annot8.core.exceptions.ProcessingException;
import io.annot8.core.stores.AnnotationStore;
import io.annot8.impl.content.SimpleText;

@CreatesViews
public class Capitalise implements Processor{
	@Override
	public void process(DataItem dataItem, AnnotationStore store) throws ProcessingException {
		View<?> v = dataItem.getDefaultView();
		Optional<Text> content = v.getContent(Text.class);
		if(content.isPresent() && content.get().getContent().isPresent()) {
			try {
				dataItem.createView("CAPITALISED", new SimpleText(content.get().getContent().get().toUpperCase()));
			}catch (AlreadyExistsException aee){
				//TODO: Log error
			}
		}
	}
}
