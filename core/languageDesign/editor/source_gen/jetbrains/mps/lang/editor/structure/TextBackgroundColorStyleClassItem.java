package jetbrains.mps.lang.editor.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class TextBackgroundColorStyleClassItem extends jetbrains.mps.lang.editor.structure.ColorStyleClassItem {
  public static final String concept = "jetbrains.mps.lang.editor.structure.TextBackgroundColorStyleClassItem";

  public TextBackgroundColorStyleClassItem(SNode node) {
    super(node);
  }

  public static TextBackgroundColorStyleClassItem newInstance(SModel sm, boolean init) {
    return (TextBackgroundColorStyleClassItem)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.editor.structure.TextBackgroundColorStyleClassItem", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static TextBackgroundColorStyleClassItem newInstance(SModel sm) {
    return TextBackgroundColorStyleClassItem.newInstance(sm, false);
  }

}
