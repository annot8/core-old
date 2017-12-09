package io.annot8.core.annotations;

/**
 * This interface is identical to the {@link TextSpan} interface, but is
 * used to specifically refer to mentions of an {@link io.annot8.core.semantic.Entity}
 * or {@link io.annot8.core.semantic.Relation} within the text.
 * 
 * The separate interface is useful for querying just these, and not
 * other types of TextSpan that might be used for, as an example, grammatical properties.
 */
public interface Mention extends TextSpan {

}
