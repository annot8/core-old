package io.annot8.impl.content;

import io.annot8.core.content.Text;

import java.util.Objects;
import java.util.Optional;

public class SimpleText implements Text {

    private String language = null;
    private String content;

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
    public Optional<String> getContent() {
        return Optional.ofNullable(content);
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof SimpleText))
            return false;

        SimpleText st = (SimpleText) obj;

        //TODO: Ought to check for null here
        return st.getContent().equals(getContent())
                && st.getLanguage().equals(getLanguage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(content, language);
    }
}
