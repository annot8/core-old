package io.annot8.impl.sources;

import io.annot8.core.components.java.ConfigurationParameter;

@ConfigurationParameter(key = "rootFolder", defaultValue = ".", description = "The folder to process (folder is processed recursively)")
public class DirectorySourceSettings {

  private String rootFolder = ".";

  public DirectorySourceSettings() {
    // Do nothing
  }

  public DirectorySourceSettings(final String rootFolder) {
    this.rootFolder = rootFolder;
  }

  public String getRootFolder() {
    return rootFolder;
  }

  public void setRootFolder(final String rootFolder) {
    this.rootFolder = rootFolder;
  }

}
