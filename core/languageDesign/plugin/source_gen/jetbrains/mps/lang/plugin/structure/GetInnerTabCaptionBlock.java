package jetbrains.mps.lang.plugin.structure;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.structure.ConceptFunction;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class GetInnerTabCaptionBlock extends ConceptFunction {
  public static final String concept = "jetbrains.mps.lang.plugin.structure.GetInnerTabCaptionBlock";

  public GetInnerTabCaptionBlock(SNode node) {
    super(node);
  }

  public static GetInnerTabCaptionBlock newInstance(SModel sm, boolean init) {
    return (GetInnerTabCaptionBlock)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.plugin.structure.GetInnerTabCaptionBlock", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static GetInnerTabCaptionBlock newInstance(SModel sm) {
    return GetInnerTabCaptionBlock.newInstance(sm, false);
  }
}
