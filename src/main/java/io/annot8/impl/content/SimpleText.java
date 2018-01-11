package io.annot8.impl.content;

import io.annot8.core.content.Text;

import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

public class SimpleText implements Text {

    private String language = null;
    private String content;

    private Set<String> tags = new HashSet<>();

    public SimpleText(String content){
        this.content = content;
    }

    @Override
    public Optional<String> getLanguage() {
        return Optional.ofNullable(language);
    }

    @Override
    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String getContent() {
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
        if(!(obj instanceof SimpleText))
            return false;

        SimpleText st = (SimpleText) obj;

        return Objects.equals(getContent(), st.getContent())
                && Objects.equals(getLanguage(), st.getLanguage())
                && Objects.equals(getTags(), st.getTags());
    }

    @Override
    public int hashCode() {
        return Objects.hash(content, language);
    }
}
