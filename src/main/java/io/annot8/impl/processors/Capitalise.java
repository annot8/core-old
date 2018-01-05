package io.annot8.impl.processors;

import io.annot8.core.components.Processor;
import io.annot8.core.components.javaannotations.CreatesViews;
import io.annot8.core.content.Content;
import io.annot8.core.content.Text;
import io.annot8.core.context.ProcessingContext;
import io.annot8.core.data.DataItem;
import io.annot8.core.data.View;
import io.annot8.core.exceptions.ProcessingException;
import io.annot8.impl.content.SimpleText;

@CreatesViews
public class Capitalise implements Processor{
    @Override
    public void process(DataItem dataItem, ProcessingContext context) throws ProcessingException {
        View v = dataItem.getDefaultView();
        Content c = v.getContent();
        if(c instanceof Text){
            if(c.getContent().isPresent()) {
                dataItem.createView("CAPITALISED", new SimpleText(((Text) c).getContent().get().toUpperCase()));
            }
        }
    }
}
