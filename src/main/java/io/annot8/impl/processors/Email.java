package io.annot8.impl.processors;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.annot8.core.components.Processor;
import io.annot8.core.components.javaannotations.OutputAnnotation;
import io.annot8.core.content.Text;
import io.annot8.core.context.ProcessingContext;
import io.annot8.core.data.DataItem;
import io.annot8.core.data.View;
import io.annot8.core.exceptions.ProcessingException;
import io.annot8.impl.annotations.TextMention;

@OutputAnnotation("EMAIL")
public class Email implements Processor {
    private static final Pattern EMAIL = Pattern.compile("[A-Z0-9._%+-]+@([A-Z0-9.-]+[.][A-Z]{2,6})", Pattern.CASE_INSENSITIVE);

    public void process(DataItem dataItem, ProcessingContext context) throws ProcessingException {
        dataItem.getViews().forEach(v -> processView(v, context));
    }

    private void processView(View<?> view, ProcessingContext context) {
        if(view.getContent() instanceof Text){
            Text doc = (Text) view.getContent();

            if(!doc.getContent().isPresent())
                return;

            Matcher matcher = EMAIL.matcher(doc.getContent().get());
            while(matcher.find()) {
                context.getAnnotationStore().save(new TextMention(view, "EMAIL", matcher.start(), matcher.end()));
            }
        }
    }
}