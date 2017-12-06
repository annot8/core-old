package io.annot8.core.semantic;

import io.annot8.core.annotations.Mention;
import io.annot8.core.helpers.WithMentions;
import io.annot8.core.helpers.WithProperties;

/**
 * An Entity groups together one or more {@link Mention} that refer
 * to the same physical (or conceptual) item, for example a Person.
 */
public interface Entity extends WithMentions, WithProperties {
	public String getType();
	public void setType(String type);
	
	public String getValue();
	public void setValue(String value);
}
