package io.annot8.impl.datasources;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Instant;

import io.annot8.core.content.Text;
import io.annot8.core.data.DataItem;
import io.annot8.impl.content.SimpleText;
import io.annot8.impl.data.SimpleDataItem;
import io.annot8.impl.data.SimpleView;

public class TxtDirectoryDataSource extends DirectoryDataSource {
    @Override
    public boolean accept(Path p) {
        return p.toString().toLowerCase().endsWith(".txt");
    }

    @Override
    public DataItem createDataItem(Path p) {
        //TODO: Really we perhaps want a bespoke FileDataItem here?

        Text content;

        try {
            content = new SimpleText(new String(Files.readAllBytes(p)));
        }catch (IOException e){
            //TODO: Log error
            return null;
        }
        content.setLanguage("x-unknown");

        DataItem dataItem = new SimpleDataItem(new SimpleView<Text>(content));
        dataItem.setProperty("source", p);
        dataItem.setProperty("accessedAt", Instant.now().getEpochSecond());

        return dataItem;
    }
}
