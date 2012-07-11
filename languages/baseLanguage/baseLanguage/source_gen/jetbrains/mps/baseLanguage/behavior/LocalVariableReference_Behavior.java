package jetbrains.mps.baseLanguage.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.smodel.runtime.BehaviorDescriptor;
import jetbrains.mps.smodel.language.ConceptRegistry;
import jetbrains.mps.smodel.behaviour.BehaviorManager;

public class LocalVariableReference_Behavior {
  private static Class[] PARAMETERS_3262277503800835478 = {SNode.class};

  public static void init(SNode thisNode) {
  }

  public static boolean call_isVariableDefinedInThisMethod_1225456272518(SNode thisNode) {
    SNode anchor = thisNode;
    if ((SNodeOperations.getAncestor(thisNode, "jetbrains.mps.lang.quotation.structure.AbstractAntiquotation", false, false) != null)) {
      anchor = SNodeOperations.getAncestor(thisNode, "jetbrains.mps.lang.quotation.structure.Quotation", false, false);
    }
    if (SNodeOperations.getAncestor(anchor, "jetbrains.mps.baseLanguage.structure.BaseMethodDeclaration", false, false) == SNodeOperations.getAncestor(SLinkOperations.getTarget(thisNode, "variableDeclaration", false), "jetbrains.mps.baseLanguage.structure.BaseMethodDeclaration", false, false)) {
      if (SNodeOperations.getAncestor(anchor, "jetbrains.mps.baseLanguage.structure.Closureoid", false, false) == SNodeOperations.getAncestor(SLinkOperations.getTarget(thisNode, "variableDeclaration", false), "jetbrains.mps.baseLanguage.structure.Closureoid", false, false)) {
        return true;
      }
    }
    return false;
  }

  public static SNode virtual_getDeclaration_3262277503800831941(SNode thisNode) {
    return SLinkOperations.getTarget(thisNode, "variableDeclaration", false);
  }

  public static SNode call_getDeclaration_3262277503800835478(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (SNode) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.LocalVariableReference"), "virtual_getDeclaration_3262277503800831941", PARAMETERS_3262277503800835478, new Object[]{});
  }

  public static SNode callSuper_getDeclaration_3262277503800835478(SNode thisNode, String callerConceptFqName) {
    return (SNode) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.LocalVariableReference"), callerConceptFqName, "virtual_getDeclaration_3262277503800831941", PARAMETERS_3262277503800835478, new Object[]{});
  }
}
