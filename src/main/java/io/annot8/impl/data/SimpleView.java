package io.annot8.impl.data;

import io.annot8.core.content.Content;
import io.annot8.core.data.View;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Stream;

public class SimpleView<T> implements View<T>{
    private Content<T> content;
    private Set<String> tags = new HashSet<>();

    public SimpleView(Content<T> content){
        this.content = content;
    }

    @Override
    public Content<T> getContent() {
        return content;
    }

    @Override
    public Stream<String> getTags() {
        return tags.stream();
    }

    @Override
    public boolean addTag(String tag) {
        return tags.add(tag);
    }

    @Override
    public boolean removeTag(String tag) {
        return tags.remove(tag);
    }
    
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof SimpleView))
           return false;

        SimpleView sv = (SimpleView) obj;

        //TODO: Ought to check for null here
        return sv.getContent().equals(getContent())
                && sv.getTags().equals(getTags());
    }

    @Override
    public int hashCode() {
        return Objects.hash(content, tags);
    }
}
