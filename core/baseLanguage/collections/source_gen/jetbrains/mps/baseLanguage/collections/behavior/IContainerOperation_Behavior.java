package jetbrains.mps.baseLanguage.collections.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.smodel.behaviour.BehaviorManager;

public class IContainerOperation_Behavior {
  private static Class[] PARAMETERS_2141797557973018589 = {SNode.class, SNode.class};

  public static void init(SNode thisNode) {
  }

  public static SNode virtual_expectedOperandType_2141797557973018589(SNode thisNode, SNode elementType) {
    SNode jt = SConceptOperations.createNewNode("jetbrains.mps.lang.typesystem.structure.JoinType", null);
    for (SNode et : SLinkOperations.getConceptLinkTargets(thisNode, "expectedOperandType")) {
      if ((et != null)) {
        SNode rt = SNodeOperations.copyNode(et);
        SNodeOperations.replaceWithAnother(ListSequence.fromList(SNodeOperations.getChildren(rt)).first(), SNodeOperations.copyNode(elementType));
        ListSequence.fromList(SLinkOperations.getTargets(jt, "argument", true)).addElement(rt);
      }
    }
    return jt;
  }

  public static SNode call_expectedOperandType_2141797557973018589(SNode thisNode, SNode elementType) {
    return (SNode) BehaviorManager.getInstance().invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.collections.structure.IContainerOperation"), "virtual_expectedOperandType_2141797557973018589", PARAMETERS_2141797557973018589, elementType);
  }

  public static SNode callSuper_expectedOperandType_2141797557973018589(SNode thisNode, String callerConceptFqName, SNode elementType) {
    return (SNode) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.collections.structure.IContainerOperation"), callerConceptFqName, "virtual_expectedOperandType_2141797557973018589", PARAMETERS_2141797557973018589, elementType);
  }
}
