/**
 * This module contains the core interfaces for use within Annot8.
 * It does not contain any implementations of the interfaces described. 
 *
 * The basic premise of how Annot8 works is as follows:
 * 
 * You have an Item, which is your container and holds information about the
 * data you wish to process. This Item contains one or more Content objects,
 * which are essentially views on the data - for instance, if the data you wished
 * to process was a HTML page, you might have a plain text 'view' of the data
 * as well as a formatted view.
 * 
 * On to these Content objects, you create Annotations. Annotations indicate that
 * a certain part of the Content has some special meaning (e.g. it is a mention of
 * a person). These Annotations are stored in an AnnotationStore, which is held by
 * each Content object. An Annotation has Bounds associated with it, which indicate
 * the extent of the Annotation. The type of Bounds will vary depending on the Content.
 * 
 * You can link Annotations together with Groups. When adding an Annotation to a
 * Group, you must assign it a role. This allows Groups to be used for a wide range
 * of use cases, such as creating relationships or event, and indicating co-reference
 * between Annotations. Groups are stored in a GroupStore, which is held on the Item
 * object so that a Group may contain Annotations from multiple Content objects.
 * 
 * Most of the objects above support Properties, which allow you to attach additional
 * information to an object. Many objects also have a type and an ID, and Content objects
 * can also have Tags associated with them.
 * 
 * There are three types of 'component' which are used to create and manipulate the above
 * objects. A Source will create new Items from some external source, for example a file
 * system or a database. The Items created by a Source will be passed to one or more
 * Processors, which will manipulate the Items by adding new Content objects to it,
 * manipulating the Annotations within these Content objects, and creating Groups of
 * Annotations.
 * 
 * Both the Sources and Processors can use the third type of component - a Resource - to
 * access common or external resources (e.g. a database connection, or reference dataset).
 * 
 * It is envisaged that Sources, Processors and Resources will generally be corralled together
 * to form a processing pipeline which will read data in from one or more sources and do some
 * processing on it. However, the pipeline concept is not defined in this module so as to leave
 * users free to combine the components in any manner they wish. 
 */
module io.annot8.core {
  exports io.annot8.core.annotations;
  exports io.annot8.core.bounds;
  exports io.annot8.core.components;
  exports io.annot8.core.components.responses;
  exports io.annot8.core.context;
  exports io.annot8.core.data;
  exports io.annot8.core.exceptions;
  //io.annot8.core.helpers is not exported
  exports io.annot8.core.properties;
  exports io.annot8.core.settings;
  exports io.annot8.core.stores;
}