package io.annot8.impl.content;

import io.annot8.core.content.Text;

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
}
