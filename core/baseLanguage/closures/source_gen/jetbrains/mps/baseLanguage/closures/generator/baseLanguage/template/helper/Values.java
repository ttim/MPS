package jetbrains.mps.baseLanguage.closures.generator.baseLanguage.template.helper;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;

public enum Values {
  CHUNK_OF_STATEMENTS("chunk_of_statements"),
  RETURN_TYPE("return_type"),
  LITERAL("literal"),
  LITERAL_TARGET("literal_target"),
  TYPE_MAP("type_map"),
  ADAPTABLE("adaptable"),
  CLOSURE_DATA("closure_data"),
  PREP_DATA("prep_data"),
  POST_DATA("post_data");

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
    return "jetbrains.mps.baselanguage.closures.generator." + str;
  }
}
