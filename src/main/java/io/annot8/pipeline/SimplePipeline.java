package io.annot8.pipeline;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import io.annot8.core.components.Annot8Component;
import io.annot8.core.components.DataSource;
import io.annot8.core.components.Processor;
import io.annot8.core.context.ConfiguringContext;
import io.annot8.core.context.ProcessingContext;
import io.annot8.core.data.DataItem;
import io.annot8.core.exceptions.Annot8Exception;
import io.annot8.core.exceptions.ProcessingException;
import io.annot8.core.stores.AnnotationStore;
import io.annot8.impl.context.SimpleConfiguringContext;
import io.annot8.impl.context.SimpleProcessingContext;
import io.annot8.impl.datasources.TxtDirectoryDataSource;
import io.annot8.impl.processors.Capitalise;
import io.annot8.impl.processors.Email;
import io.annot8.impl.processors.HashTag;
import io.annot8.impl.processors.PrintMentions;
import io.annot8.impl.stores.InMemoryStore;

/**
 * Simple proof of concept pipeline that assumes that data sources produce a finite number
 * of DataItems. Processors and DataSources are executed in the order they are added, and
 * this pipeline will terminate once it has processed all data items.
 */
public class SimplePipeline {

    private ConfiguringContext configuringContext;
    private Collection<DataSource> dataSources = new ArrayList<>();
    private Collection<Processor> processors = new ArrayList<>();

    private ProcessingContext processingContext = null;

    public SimplePipeline(ConfiguringContext context){
        this.configuringContext = context;
    }

    public void addDataSource(DataSource dataSource){
        dataSources.add(dataSource);
    }

    public void addProcessor(Processor processor){
        processors.add(processor);
    }

    public void run(){
        AnnotationStore store = new InMemoryStore();
        processingContext = SimpleProcessingContext.fromContext(store, configuringContext);

        //TODO: Really, each component should be initialised with it's own configuration (i.e. so we could have multiple data sources with different paths)
        dataSources = dataSources.stream().filter(ds -> configureComponent(ds)).collect(Collectors.toList());
        processors = processors.stream().filter(p -> configureComponent(p)).collect(Collectors.toList());

        for(DataSource dataSource : dataSources){
            dataSource.getDataItems().forEach(this::process);
        }
    }

    private void process(DataItem dataItem){
        for(Processor processor : processors){
            try {
                processor.process(dataItem, processingContext);
            }catch (ProcessingException pe){
                //TODO: Log this error - should we stop processing this dataItem or carry on?
                System.err.println("Failed to process data item with processor "+processor.getClass().getName());
            }
        }
    }

    private boolean configureComponent(Annot8Component component){
        try{
            component.configure(configuringContext);
        }catch (Annot8Exception e){
            //TODO: Log this error
            System.err.println("Failed to configure component "+component.getClass().getName());
            return false;
        }

        return true;
    }

    public static void main(String[] args){
        SimpleConfiguringContext context = new SimpleConfiguringContext();
        context.addConfiguration("path", args[0]);

        SimplePipeline pipeline = new SimplePipeline(context);

        pipeline.addDataSource(new TxtDirectoryDataSource());
        pipeline.addProcessor(new Capitalise());
        pipeline.addProcessor(new Email());
        pipeline.addProcessor(new HashTag());
        pipeline.addProcessor(new PrintMentions());

        pipeline.run();
    }
}
