package io.annot8.impl.processors;

import io.annot8.core.annotations.Annotation;
import io.annot8.core.bounds.LinearBounds;
import io.annot8.core.components.Processor;
import io.annot8.core.components.javaannotations.OutputAnnotation;
import io.annot8.core.content.Text;
import io.annot8.core.data.DataItem;
import io.annot8.core.exceptions.ProcessingException;
import io.annot8.core.stores.AnnotationStore;
import io.annot8.impl.bounds.SimpleLinearBounds;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@OutputAnnotation("HASHTAG")
public class HashTag implements Processor {
    private static final Pattern HASHTAG = Pattern.compile("#[a-z0-9]+", Pattern.CASE_INSENSITIVE);

    public void process(DataItem dataItem, AnnotationStore store) throws ProcessingException {
        dataItem.getContents(Text.class).forEach(c -> processText(c, store));
    }

    private void processText(Text content, AnnotationStore store) {
        Matcher matcher = HASHTAG.matcher(content.getContent());
        while(matcher.find()) {
            LinearBounds bounds = new SimpleLinearBounds(matcher.start(), matcher.end());
            Annotation<LinearBounds> annot = store.createNew(content, bounds);
            annot.setType("HASHTAG");
            store.save(annot);
        }
    }
}
