package io.annot8.impl.datasources;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

import io.annot8.core.components.DataSource;
import io.annot8.core.components.javaannotations.ConfigurationParameter;
import io.annot8.core.context.Context;
import io.annot8.core.data.DataItem;

@ConfigurationParameter(key = "path", defaultValue = ".", description = "The folder to process (folder is processed recursively)")
public abstract class DirectoryDataSource implements DataSource {

    private Path rootFolder;

    @Override
    public void configure(Context context) {
        Optional<Object> root = context.getConfiguration("path");
        if(root.isPresent()){
            rootFolder = Paths.get(root.get().toString());
        }else{
            rootFolder = Paths.get(".");
        }
    }

    @Override
    public Stream<DataItem> getDataItems() {
        try {
            return Files.walk(rootFolder)
                    .filter(Files::isRegularFile)
                    .filter(this::accept)
                    .map(this::createDataItem)
                    .filter(Objects::nonNull);
        }catch (IOException ioe){
            //TODO: Log error
            return Stream.empty();
        }
    }

    public abstract boolean accept(Path p);
    public abstract DataItem createDataItem(Path p);
}
