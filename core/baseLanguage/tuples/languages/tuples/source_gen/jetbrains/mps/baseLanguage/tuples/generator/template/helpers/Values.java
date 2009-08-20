package jetbrains.mps.baseLanguage.tuples.generator.template.helpers;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;

public enum Values {
  RVALUE("rvalue"),
  NUMBER("number");

  private String name;

  Values(String name) {
    this.name = PREFIX(name);
  }

  public void set(SNode node, Object value) {
    node.putUserObject(this, value);
  }

  public Object get(SNode node) {
    return node.getUserObject(this);
  }

  public boolean isSet(SNode node) {
    return node.getUserObject(this) != null;
  }


  private static String PREFIX(String str) {
    return "jetbrains.mps.baselanguage.tuples.generator." + str;
  }
}
