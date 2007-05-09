package webr.xml.structure;

/*Generated by MPS */

import jetbrains.mps.core.structure.BaseConcept;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class Content extends BaseConcept {
  public static String CPR_IsComplex = "isComplex";
  public static String CLNK_CorrespondingElement = "correspondingElement";
  public static String CLNK_ElementForChildren = "elementForChildren";

  public  Content(SNode node) {
    super(node);
  }

  public static Content newInstance(SModel sm, boolean init) {
    return (Content)SModelUtil_new.instantiateConceptDeclaration("webr.xml.Content", sm, GlobalScope.getInstance(), init).getAdapter();
  }
  public static Content newInstance(SModel sm) {
    return Content.newInstance(sm, false);
  }
}
