package jetbrains.mps.baseLanguage.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.runtime.BehaviorDescriptor;
import jetbrains.mps.smodel.language.ConceptRegistry;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.behaviour.BehaviorManager;

public class ILocalReference_Behavior {
  private static Class[] PARAMETERS_3262277503800831941 = {SNode.class};

  public static void init(SNode thisNode) {
  }

  public static SNode call_getDeclaration_3262277503800831941(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (SNode) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.ILocalReference"), "virtual_getDeclaration_3262277503800831941", PARAMETERS_3262277503800831941, new Object[]{});
  }

  public static SNode callSuper_getDeclaration_3262277503800831941(SNode thisNode, String callerConceptFqName) {
    return (SNode) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.ILocalReference"), callerConceptFqName, "virtual_getDeclaration_3262277503800831941", PARAMETERS_3262277503800831941, new Object[]{});
  }
}
