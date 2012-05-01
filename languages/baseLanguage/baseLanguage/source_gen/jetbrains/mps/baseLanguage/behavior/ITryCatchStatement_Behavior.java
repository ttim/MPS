package jetbrains.mps.baseLanguage.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import java.util.List;
import jetbrains.mps.smodel.runtime.BehaviorDescriptor;
import jetbrains.mps.smodel.language.ConceptRegistry;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.behaviour.BehaviorManager;

public class ITryCatchStatement_Behavior {
  private static Class[] PARAMETERS_3718132079121388582 = {SNode.class};

  public static void init(SNode thisNode) {
  }

  public static List<SNode> call_getCatchClauses_3718132079121388582(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (List<SNode>) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.ITryCatchStatement"), "virtual_getCatchClauses_3718132079121388582", PARAMETERS_3718132079121388582);
  }

  public static List<SNode> callSuper_getCatchClauses_3718132079121388582(SNode thisNode, String callerConceptFqName) {
    return (List<SNode>) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.ITryCatchStatement"), callerConceptFqName, "virtual_getCatchClauses_3718132079121388582", PARAMETERS_3718132079121388582);
  }
}
