package jetbrains.mps.lang.editor.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class TextBackgroundColorSelectedStyleClassItem extends jetbrains.mps.lang.editor.structure.ColorStyleClassItem {
  public static final String concept = "jetbrains.mps.lang.editor.structure.TextBackgroundColorSelectedStyleClassItem";

  public TextBackgroundColorSelectedStyleClassItem(SNode node) {
    super(node);
  }

  public static TextBackgroundColorSelectedStyleClassItem newInstance(SModel sm, boolean init) {
    return (TextBackgroundColorSelectedStyleClassItem)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.editor.structure.TextBackgroundColorSelectedStyleClassItem", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static TextBackgroundColorSelectedStyleClassItem newInstance(SModel sm) {
    return TextBackgroundColorSelectedStyleClassItem.newInstance(sm, false);
  }

}
