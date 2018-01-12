package io.annot8.impl.sources;

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
