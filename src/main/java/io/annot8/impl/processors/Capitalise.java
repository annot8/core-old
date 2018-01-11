package io.annot8.impl.processors;

import io.annot8.core.components.Processor;
import io.annot8.core.components.javaannotations.CreatesContent;
import io.annot8.core.content.Content;
import io.annot8.core.content.Text;
import io.annot8.core.data.DataItem;
import io.annot8.core.exceptions.AlreadyExistsException;
import io.annot8.core.exceptions.ProcessingException;
import io.annot8.core.stores.AnnotationStore;
import io.annot8.impl.content.SimpleText;

@CreatesContent
public class Capitalise implements Processor{
	@Override
	public void process(DataItem dataItem, AnnotationStore store) throws ProcessingException {
		Content<?> content = dataItem.getDefaultContent();

		if(content instanceof Text) {
			Text doc = (Text) content;
			try {
				dataItem.addContent("CAPITALISED", new SimpleText(doc.getContent().toUpperCase()));
			}catch (AlreadyExistsException aee){
				//TODO: Log error
			}
		}
	}
}
