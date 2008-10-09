package jetbrains.mps.lang.editor.structure;

/*Generated by MPS */

import jetbrains.mps.lang.core.structure.BaseConcept;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class StyleSheetClassReference extends BaseConcept {
  public static final String concept = "jetbrains.mps.lang.editor.structure.StyleSheetClassReference";
  public static String STYLE_SHEET_CLASS = "styleSheetClass";

  public StyleSheetClassReference(SNode node) {
    super(node);
  }

  public StyleSheetClass getStyleSheetClass() {
    return (StyleSheetClass)this.getReferent(StyleSheetClassReference.STYLE_SHEET_CLASS);
  }

  public void setStyleSheetClass(StyleSheetClass node) {
    super.setReferent(StyleSheetClassReference.STYLE_SHEET_CLASS, node);
  }


  public static StyleSheetClassReference newInstance(SModel sm, boolean init) {
    return (StyleSheetClassReference)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.editor.structure.StyleSheetClassReference", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static StyleSheetClassReference newInstance(SModel sm) {
    return StyleSheetClassReference.newInstance(sm, false);
  }

}
