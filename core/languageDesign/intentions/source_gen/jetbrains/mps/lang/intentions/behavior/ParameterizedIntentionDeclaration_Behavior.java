package jetbrains.mps.lang.intentions.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;

public class ParameterizedIntentionDeclaration_Behavior {
  public static void init(SNode thisNode) {
    SNode parameter = SConceptOperations.createNewNode("jetbrains.mps.lang.intentions.structure.IntentionParameter", null);
    ListSequence.fromList(SLinkOperations.getConceptLinkTargets(SLinkOperations.getTarget(thisNode, "executeFunction", true), "applicableConceptFunctionParameter")).addElement((SNode) parameter.getConceptDeclarationAdapter().getNode());
    ListSequence.fromList(SLinkOperations.getConceptLinkTargets(SLinkOperations.getTarget(thisNode, "descriptionFunction", true), "applicableConceptFunctionParameter")).addElement((SNode) parameter.getConceptDeclarationAdapter().getNode());
  }

  public static boolean virtual_isParameterized_6263518417926802310(SNode thisNode) {
    return true;
  }
}
