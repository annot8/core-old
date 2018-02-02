package io.annot8.core.components;

import io.annot8.core.data.Content;

import java.util.stream.Stream;

public interface Capabilities {
    default Stream<String> getRequiredInputAnnotations(){
        return Stream.empty();
    }

    default Stream<String> getOptionalInputAnnotations(){
        return Stream.empty();
    }

    Stream<String> getOutputAnnotations();

    default Stream<String> getAcceptedTags(){
        return Stream.empty();
    }

    default Stream<Class<? extends Content>> getCreatedContent(){
        return Stream.empty();
    }

    default Stream<Class<? extends Resource>> getRequiredResources(){
        return Stream.empty();
    }
}
