package jetbrains.mps.platform.conf.structure;

/*Generated by MPS */

import java.util.List;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.internal.collections.runtime.backports.LinkedList;

public enum Level {
  application("application", "APPLICATION"),
  project("project", "PROJECT"),
  module("module", "MODULE");

  private String myName;
  private String myValue;

  Level(String name, String value) {
    this.myName = name;
    this.myValue = value;
  }

  public String getName() {
    return this.myName;
  }

  public String getValueAsString() {
    return this.myValue;
  }

  public String getValue() {
    return this.myValue;
  }

  public static List<Level> getConstants() {
    List<Level> list = ListSequence.fromList(new LinkedList<Level>());
    ListSequence.fromList(list).addElement(Level.application);
    ListSequence.fromList(list).addElement(Level.project);
    ListSequence.fromList(list).addElement(Level.module);
    return list;
  }

  public static Level getDefault() {
    return Level.application;
  }

  public static Level parseValue(String value) {
    if (value == null) {
      return Level.getDefault();
    }
    if (value.equals(Level.application.getValueAsString())) {
      return Level.application;
    }
    if (value.equals(Level.project.getValueAsString())) {
      return Level.project;
    }
    if (value.equals(Level.module.getValueAsString())) {
      return Level.module;
    }
    return Level.getDefault();
  }
}
