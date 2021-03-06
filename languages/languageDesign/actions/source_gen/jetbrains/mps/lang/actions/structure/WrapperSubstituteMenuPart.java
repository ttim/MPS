package jetbrains.mps.lang.actions.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.structure.structure.AbstractConceptDeclaration;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class WrapperSubstituteMenuPart extends SubstituteMenuPart {
  public static final String concept = "jetbrains.mps.lang.actions.structure.WrapperSubstituteMenuPart";
  public static final String WRAPPED_CONCEPT = "wrappedConcept";
  public static final String WRAPPER_BLOCK = "wrapperBlock";
  public static final String RETURN_SMALL_PART = "returnSmallPart";

  public WrapperSubstituteMenuPart(SNode node) {
    super(node);
  }

  public AbstractConceptDeclaration getWrappedConcept() {
    return (AbstractConceptDeclaration) this.getReferent(AbstractConceptDeclaration.class, WrapperSubstituteMenuPart.WRAPPED_CONCEPT);
  }

  public void setWrappedConcept(AbstractConceptDeclaration node) {
    super.setReferent(WrapperSubstituteMenuPart.WRAPPED_CONCEPT, node);
  }

  public QueryFunction_SubstituteWrapper getWrapperBlock() {
    return (QueryFunction_SubstituteWrapper) this.getChild(QueryFunction_SubstituteWrapper.class, WrapperSubstituteMenuPart.WRAPPER_BLOCK);
  }

  public void setWrapperBlock(QueryFunction_SubstituteWrapper node) {
    super.setChild(WrapperSubstituteMenuPart.WRAPPER_BLOCK, node);
  }

  public QueryFunction_ReturnSmallPart getReturnSmallPart() {
    return (QueryFunction_ReturnSmallPart) this.getChild(QueryFunction_ReturnSmallPart.class, WrapperSubstituteMenuPart.RETURN_SMALL_PART);
  }

  public void setReturnSmallPart(QueryFunction_ReturnSmallPart node) {
    super.setChild(WrapperSubstituteMenuPart.RETURN_SMALL_PART, node);
  }

  public static WrapperSubstituteMenuPart newInstance(SModel sm, boolean init) {
    return (WrapperSubstituteMenuPart) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.actions.structure.WrapperSubstituteMenuPart", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static WrapperSubstituteMenuPart newInstance(SModel sm) {
    return WrapperSubstituteMenuPart.newInstance(sm, false);
  }
}
