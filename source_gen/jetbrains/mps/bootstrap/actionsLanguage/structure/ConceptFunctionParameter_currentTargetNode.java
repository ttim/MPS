package jetbrains.mps.bootstrap.actionsLanguage.structure;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.structure.ConceptFunctionParameter;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class ConceptFunctionParameter_currentTargetNode extends ConceptFunctionParameter {
  public static final String concept = "jetbrains.mps.bootstrap.actionsLanguage.structure.ConceptFunctionParameter_currentTargetNode";

  public  ConceptFunctionParameter_currentTargetNode(SNode node) {
    super(node);
  }

  public static ConceptFunctionParameter_currentTargetNode newInstance(SModel sm, boolean init) {
    return (ConceptFunctionParameter_currentTargetNode)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.bootstrap.actionsLanguage.structure.ConceptFunctionParameter_currentTargetNode", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static ConceptFunctionParameter_currentTargetNode newInstance(SModel sm) {
    return ConceptFunctionParameter_currentTargetNode.newInstance(sm, false);
  }

}
