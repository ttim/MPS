package jetbrains.mps.baseLanguage.closures.generator.baseLanguage.template.helper;

/*Generated by MPS */


public enum Keys {
  ALL_NEEDS_ADAPTED("all_needs_adapted"),
  NEEDS_ADAPTER("needs_adapted"),
  NEEDS_WEAVING_CLASS("needs_weaving_class");

  private String name;

  Keys(String name) {
    this.name = PREFIX(name);
  }

  public String compose(Object o) {
    return this.name + "." + String.valueOf(o);
  }


  private static String PREFIX(String str) {
    return "jetbrains.mps.baselanguage.closures.generator." + str;
  }

}
