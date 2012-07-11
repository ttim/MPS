package jetbrains.mps.baseLanguage.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import java.util.List;
import jetbrains.mps.smodel.runtime.BehaviorDescriptor;
import jetbrains.mps.smodel.language.ConceptRegistry;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.behaviour.BehaviorManager;

public class ILocalVariableElementList_Behavior {
  private static Class[] PARAMETERS_1238805763253 = {SNode.class};

  public static void init(SNode thisNode) {
  }

  public static List<SNode> call_getLocalVariableElements_1238805763253(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (List<SNode>) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.ILocalVariableElementList"), "virtual_getLocalVariableElements_1238805763253", PARAMETERS_1238805763253, new Object[]{});
  }

  public static List<SNode> callSuper_getLocalVariableElements_1238805763253(SNode thisNode, String callerConceptFqName) {
    return (List<SNode>) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.ILocalVariableElementList"), callerConceptFqName, "virtual_getLocalVariableElements_1238805763253", PARAMETERS_1238805763253, new Object[]{});
  }
}
