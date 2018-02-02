/**
 * This package contains the core data objects used by Annot8
 * 
 * Content objects contain the actual data, or more specifically
 * a view on the data. For example, you might have a Content object
 * containing French text, and a Content object containing a translated
 * version of that text. Annotations are stored within the Content objects.
 * 
 * Content objects have Tags, which describe the type of content contained
 * within it and what processing has been done to it. These are used by processors
 * to decide whether they are able to process it or not.
 * 
 * Content objects are stored within Item objects, which are the object that is
 * passed around between components. Groups are stored within the Item object,
 * as a group may contain annotations from more than one content object.
 */
package io.annot8.core.data;