package jetbrains.mps.lang.generator.generationContext.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.smodel.runtime.BehaviorDescriptor;
import jetbrains.mps.smodel.language.ConceptRegistry;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.behaviour.BehaviorManager;

public class GenerationContextOp_PropertyPatternRef_Behavior {
  private static Class[] PARAMETERS_1758784108620115432 = {SNode.class};
  private static Class[] PARAMETERS_1758784108620254578 = {SNode.class, SNode.class};

  public static void init(SNode thisNode) {
  }

  public static SNode virtual_getTarget_1758784108620114792(SNode thisNode) {
    return SLinkOperations.getTarget(thisNode, "propertyPatternVar", false);
  }

  public static void virtual_setTarget_1758784108620254533(SNode thisNode, SNode target) {
    SLinkOperations.setTarget(thisNode, "propertyPatternVar", null, false);
  }

  public static SNode call_getTarget_1758784108620115432(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (SNode) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.lang.generator.generationContext.structure.GenerationContextOp_PropertyPatternRef"), "virtual_getTarget_1758784108620114792", PARAMETERS_1758784108620115432, new Object[]{});
  }

  public static void call_setTarget_1758784108620254578(SNode thisNode, SNode target) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.lang.generator.generationContext.structure.GenerationContextOp_PropertyPatternRef"), "virtual_setTarget_1758784108620254533", PARAMETERS_1758784108620254578, new Object[]{target});
  }

  public static SNode callSuper_getTarget_1758784108620115432(SNode thisNode, String callerConceptFqName) {
    return (SNode) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.lang.generator.generationContext.structure.GenerationContextOp_PropertyPatternRef"), callerConceptFqName, "virtual_getTarget_1758784108620114792", PARAMETERS_1758784108620115432, new Object[]{});
  }

  public static void callSuper_setTarget_1758784108620254578(SNode thisNode, String callerConceptFqName, SNode target) {
    BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.lang.generator.generationContext.structure.GenerationContextOp_PropertyPatternRef"), callerConceptFqName, "virtual_setTarget_1758784108620254533", PARAMETERS_1758784108620254578, new Object[]{target});
  }
}
