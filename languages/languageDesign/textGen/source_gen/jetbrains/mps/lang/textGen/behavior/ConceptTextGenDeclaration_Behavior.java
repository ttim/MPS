package jetbrains.mps.lang.textGen.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import java.util.List;
import java.util.ArrayList;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.smodel.runtime.BehaviorDescriptor;
import jetbrains.mps.smodel.language.ConceptRegistry;
import jetbrains.mps.smodel.behaviour.BehaviorManager;

public class ConceptTextGenDeclaration_Behavior {
  private static Class[] PARAMETERS_8952337903384725606 = {SNode.class};
  private static Class[] PARAMETERS_6261424444345979603 = {SNode.class, SNode.class};

  public static void init(SNode thisNode) {
  }

  public static List<SNode> virtual_getAvailableOperations_1234781444746(SNode thisNode) {
    List<SNode> result = new ArrayList<SNode>();
    List<SNode> roots = SModelOperations.getRoots(SNodeOperations.getModel(thisNode), "jetbrains.mps.lang.textGen.structure.LanguageTextGenDeclaration");
    for (SNode langTextGen : roots) {
      ListSequence.fromList(result).addSequence(ListSequence.fromList(SLinkOperations.getTargets(langTextGen, "operation", true)));
    }
    return result;
  }

  public static String virtual_getTextGenNode_1234784577703(SNode thisNode) {
    return "this";
  }

  public static SNode virtual_getBaseConcept_2621449412040133768(SNode thisNode) {
    return SLinkOperations.getTarget(thisNode, "conceptDeclaration", false);
  }

  public static void virtual_setBaseConcept_6261424444345963020(SNode thisNode, SNode baseConcept) {
    SLinkOperations.setTarget(thisNode, "conceptDeclaration", baseConcept, false);
  }

  public static SNode call_getBaseConcept_8952337903384725606(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (SNode) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.lang.textGen.structure.ConceptTextGenDeclaration"), "virtual_getBaseConcept_2621449412040133768", PARAMETERS_8952337903384725606, new Object[]{});
  }

  public static void call_setBaseConcept_6261424444345979603(SNode thisNode, SNode baseConcept) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.lang.textGen.structure.ConceptTextGenDeclaration"), "virtual_setBaseConcept_6261424444345963020", PARAMETERS_6261424444345979603, new Object[]{baseConcept});
  }

  public static SNode callSuper_getBaseConcept_8952337903384725606(SNode thisNode, String callerConceptFqName) {
    return (SNode) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.lang.textGen.structure.ConceptTextGenDeclaration"), callerConceptFqName, "virtual_getBaseConcept_2621449412040133768", PARAMETERS_8952337903384725606, new Object[]{});
  }

  public static void callSuper_setBaseConcept_6261424444345979603(SNode thisNode, String callerConceptFqName, SNode baseConcept) {
    BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.lang.textGen.structure.ConceptTextGenDeclaration"), callerConceptFqName, "virtual_setBaseConcept_6261424444345963020", PARAMETERS_6261424444345979603, new Object[]{baseConcept});
  }
}
