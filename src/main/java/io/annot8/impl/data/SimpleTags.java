package io.annot8.impl.data;

import io.annot8.core.data.Tags;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class SimpleTags implements Tags {
    private Set<String> tags;

    public SimpleTags(){
        this.tags = new HashSet<>();
    }

    public SimpleTags(String... tags){
        this.tags = new HashSet<>(Arrays.asList(tags));
    }

    public SimpleTags(Set<String> tags){
        this.tags = tags;
    }

    @Override
    public Stream<String> get() {
        return tags.stream();
    }

    @Override
    public boolean add(String tag) {
        return tags.add(tag);
    }

    @Override
    public boolean remove(String tag) {
        return tags.remove(tag);
    }
}
