package io.annot8.impl.processors;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.annot8.core.annotations.Annotation;
import io.annot8.core.bounds.LinearBounds;
import io.annot8.core.components.Processor;
import io.annot8.core.components.javaannotations.OutputAnnotation;
import io.annot8.core.content.Text;
import io.annot8.core.data.DataItem;
import io.annot8.core.data.View;
import io.annot8.core.exceptions.ProcessingException;
import io.annot8.core.stores.AnnotationStore;
import io.annot8.impl.bounds.SimpleLinearBounds;

@OutputAnnotation("HASHTAG")
public class HashTag implements Processor {
    private static final Pattern HASHTAG = Pattern.compile("#[a-z0-9]+", Pattern.CASE_INSENSITIVE);

    public void process(DataItem dataItem, AnnotationStore store) throws ProcessingException {
        dataItem.getViews().forEach(v -> processView(v, store));
    }

    private void processView(View<?> view, AnnotationStore store) {
        if(view.getContent() instanceof Text){
            Text doc = (Text) view.getContent();

            if(!doc.getContent().isPresent())
                return;

            Matcher matcher = HASHTAG.matcher(doc.getContent().get());
            while(matcher.find()) {
	            	LinearBounds bounds = new SimpleLinearBounds(matcher.start(), matcher.end());
	        		Annotation<LinearBounds> annot = store.createNew(view, bounds);
	        		annot.setType("HASHTAG");
	        		store.save(annot);
            }
        }
    }
}
