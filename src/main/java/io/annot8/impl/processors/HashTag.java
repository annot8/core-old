package io.annot8.impl.processors;

import io.annot8.core.components.Processor;
import io.annot8.core.components.javaannotations.OutputAnnotation;
import io.annot8.core.content.Text;
import io.annot8.core.context.ProcessingContext;
import io.annot8.core.data.View;
import io.annot8.core.data.DataItem;
import io.annot8.core.exceptions.ProcessingException;
import io.annot8.impl.annotations.TextMention;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@OutputAnnotation("HASHTAG")
public class HashTag implements Processor {
    private static final Pattern HASHTAG = Pattern.compile("#[a-z0-9]+", Pattern.CASE_INSENSITIVE);

    public void process(DataItem dataItem, ProcessingContext context) throws ProcessingException {
        processView(dataItem.getDefaultView(), context);    //TODO: Process all views
        dataItem.getViews().forEach(v -> processView(v, context));
    }

    private void processView(View view, ProcessingContext context) {
        if(view.getContent() instanceof Text){
            Text doc = (Text) view.getContent();

            if(!doc.getContent().isPresent())
                return;

            Matcher matcher = HASHTAG.matcher(doc.getContent().get());
            while(matcher.find()) {
                context.getAnnotationStore().save(new TextMention(view, "HASHTAG", matcher.start(), matcher.end()));
            }
        }
    }
}
