package io.annot8.core.data;

import io.annot8.core.helpers.builders.WithBuild;
import io.annot8.core.helpers.builders.WithFrom;
import io.annot8.core.helpers.builders.WithPropertiesBuilder;

public interface ImmutableProperties extends Properties {

    interface Builder extends
            WithFrom<Builder, Properties>,
            WithPropertiesBuilder<Builder>,
            WithBuild<ImmutableProperties>
    {

    }

}
