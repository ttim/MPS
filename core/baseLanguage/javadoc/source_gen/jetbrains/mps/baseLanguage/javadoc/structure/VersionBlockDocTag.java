package jetbrains.mps.baseLanguage.javadoc.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class VersionBlockDocTag extends BaseBlockDocTag {
  public static final String concept = "jetbrains.mps.baseLanguage.javadoc.structure.VersionBlockDocTag";
  public static final String TEXT = "text";

  public VersionBlockDocTag(SNode node) {
    super(node);
  }

  public String getText() {
    return this.getProperty(VersionBlockDocTag.TEXT);
  }

  public void setText(String value) {
    this.setProperty(VersionBlockDocTag.TEXT, value);
  }

  public static VersionBlockDocTag newInstance(SModel sm, boolean init) {
    return (VersionBlockDocTag)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.javadoc.structure.VersionBlockDocTag", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static VersionBlockDocTag newInstance(SModel sm) {
    return VersionBlockDocTag.newInstance(sm, false);
  }
}
