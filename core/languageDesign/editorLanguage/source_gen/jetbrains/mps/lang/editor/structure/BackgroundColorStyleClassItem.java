package jetbrains.mps.lang.editor.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class BackgroundColorStyleClassItem extends ColorStyleClassItem {
  public static final String concept = "jetbrains.mps.lang.editor.structure.BackgroundColorStyleClassItem";

  public BackgroundColorStyleClassItem(SNode node) {
    super(node);
  }

  public static BackgroundColorStyleClassItem newInstance(SModel sm, boolean init) {
    return (BackgroundColorStyleClassItem)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.editor.structure.BackgroundColorStyleClassItem", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static BackgroundColorStyleClassItem newInstance(SModel sm) {
    return BackgroundColorStyleClassItem.newInstance(sm, false);
  }

}
