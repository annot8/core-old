/**
 * This package contains the core interface for components.
 * 
 * There are three main types of components in Annot8:
 * 
 * 1) Source - these produce new items for processing
 * 2) Processor - these process items, for example by adding annotations
 * 3) Resource - these are reusable classes that can be used by other components
 * 
 * Components are required to declare their capabilities with a Capabilities object,
 * which may be configuration dependent.
 */
package io.annot8.core.components;