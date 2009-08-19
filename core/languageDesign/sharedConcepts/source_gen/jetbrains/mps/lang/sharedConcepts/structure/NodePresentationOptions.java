package jetbrains.mps.lang.sharedConcepts.structure;

/*Generated by MPS */

import java.util.List;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.internal.collections.runtime.backports.LinkedList;

public enum NodePresentationOptions {
  default_("default", null),
  referent_("referent", "default_referent"),
  custom_("custom", "custom");

  private String myName;
  private String myValue;

  NodePresentationOptions(String name, String value) {
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


  public static List<NodePresentationOptions> getConstants() {
    List<NodePresentationOptions> list = ListSequence.fromList(new LinkedList<NodePresentationOptions>());
    ListSequence.fromList(list).addElement(NodePresentationOptions.default_);
    ListSequence.fromList(list).addElement(NodePresentationOptions.referent_);
    ListSequence.fromList(list).addElement(NodePresentationOptions.custom_);
    return list;
  }

  public static NodePresentationOptions getDefault() {
    return NodePresentationOptions.default_;
  }

  public static NodePresentationOptions parseValue(String value) {
    if (value == null) {
      return NodePresentationOptions.getDefault();
    }
    if (value.equals(NodePresentationOptions.default_.getValueAsString())) {
      return NodePresentationOptions.default_;
    }
    if (value.equals(NodePresentationOptions.referent_.getValueAsString())) {
      return NodePresentationOptions.referent_;
    }
    if (value.equals(NodePresentationOptions.custom_.getValueAsString())) {
      return NodePresentationOptions.custom_;
    }
    return NodePresentationOptions.getDefault();
  }
}
