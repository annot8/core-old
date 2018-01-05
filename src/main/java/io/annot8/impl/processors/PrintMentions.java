package io.annot8.impl.processors;

import io.annot8.core.bounds.Bounds;
import io.annot8.core.components.Processor;
import io.annot8.core.content.Content;
import io.annot8.core.content.Text;
import io.annot8.core.context.ProcessingContext;
import io.annot8.core.data.DataItem;
import io.annot8.core.exceptions.ProcessingException;
import io.annot8.impl.bounds.SimpleLinearBounds;

public class PrintMentions implements Processor {
    @Override
    public void process(DataItem dataItem, ProcessingContext context) throws ProcessingException {
        context.getAnnotationStore().getAll().forEach(a -> {
            Content c = a.getView().getContent();
            Bounds b = a.getBounds();
            if(c instanceof Text && b instanceof SimpleLinearBounds){   //TODO: Generally, we need better methods so we don't have to do this all the time
                Text t = (Text) c;
                SimpleLinearBounds slb = (SimpleLinearBounds) b;

                if(t.getContent().isPresent()){
                    String value = t.getContent().get().substring(slb.getBegin(), slb.getEnd());

                    System.out.println("Annotation from " + slb.getBegin() + " to " + slb.getEnd()+": "+value);
                }
            }
        });
    }
}
