package jetbrains.mps.lang.plugin.structure;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.structure.ConceptFunctionParameter;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class ConceptFunctionParameter_OutputRootNode extends ConceptFunctionParameter {
  public static final String concept = "jetbrains.mps.lang.plugin.structure.ConceptFunctionParameter_OutputRootNode";

  public ConceptFunctionParameter_OutputRootNode(SNode node) {
    super(node);
  }

  public static ConceptFunctionParameter_OutputRootNode newInstance(SModel sm, boolean init) {
    return (ConceptFunctionParameter_OutputRootNode)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.plugin.structure.ConceptFunctionParameter_OutputRootNode", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static ConceptFunctionParameter_OutputRootNode newInstance(SModel sm) {
    return ConceptFunctionParameter_OutputRootNode.newInstance(sm, false);
  }
}
