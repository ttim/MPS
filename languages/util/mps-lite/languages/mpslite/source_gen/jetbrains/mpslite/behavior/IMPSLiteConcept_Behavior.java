package jetbrains.mpslite.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import java.util.Map;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.smodel.runtime.BehaviorDescriptor;
import jetbrains.mps.smodel.language.ConceptRegistry;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.behaviour.BehaviorManager;

public class IMPSLiteConcept_Behavior {
  private static Class[] PARAMETERS_1239714833738 = {SNode.class};
  private static Class[] PARAMETERS_1239715026284 = {SNode.class};
  private static Class[] PARAMETERS_1239891562930 = {SNode.class, SNode.class, Map.class, Map.class};
  private static Class[] PARAMETERS_1239890004879 = {SNode.class, Map.class, Map.class};
  private static Class[] PARAMETERS_1239817368042 = {SNode.class, Map.class, Map.class};
  private static Class[] PARAMETERS_1239891670850 = {SNode.class, Map.class, Map.class};

  public static void init(SNode thisNode) {
  }

  public static boolean virtual_isRootable_1239714833738(SNode thisNode) {
    return SPropertyOperations.getBoolean(thisNode, "root");
  }

  public static boolean virtual_isAbstract_1239715026284(SNode thisNode) {
    return SPropertyOperations.getBoolean(thisNode, "abstract");
  }

  public static SNode virtual_createAdditionalConcept_1239817368042(SNode thisNode, Map<SNode, SNode> conceptsToTargets, Map<SNode, SNode> partsToLinks) {
    return null;
  }

  public static SNode virtual_createAdditionalEditor_1239891670850(SNode thisNode, Map<SNode, SNode> conceptsToTargets, Map<SNode, SNode> partsToLinks) {
    return null;
  }

  public static boolean call_isRootable_1239714833738(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (Boolean) descriptor.invoke(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mpslite.structure.IMPSLiteConcept"), "virtual_isRootable_1239714833738", PARAMETERS_1239714833738, new Object[]{});
  }

  public static boolean call_isAbstract_1239715026284(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (Boolean) descriptor.invoke(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mpslite.structure.IMPSLiteConcept"), "virtual_isAbstract_1239715026284", PARAMETERS_1239715026284, new Object[]{});
  }

  public static void call_fillConcept_1239891562930(SNode thisNode, SNode concept, Map<SNode, SNode> conceptsToTargets, Map<SNode, SNode> partsToLinks) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mpslite.structure.IMPSLiteConcept"), "virtual_fillConcept_1239891562930", PARAMETERS_1239891562930, new Object[]{concept, conceptsToTargets, partsToLinks});
  }

  public static SNode call_createEditor_1239890004879(SNode thisNode, Map<SNode, SNode> conceptsToTargets, Map<SNode, SNode> partsToLinks) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (SNode) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mpslite.structure.IMPSLiteConcept"), "virtual_createEditor_1239890004879", PARAMETERS_1239890004879, new Object[]{conceptsToTargets, partsToLinks});
  }

  public static SNode call_createAdditionalConcept_1239817368042(SNode thisNode, Map<SNode, SNode> conceptsToTargets, Map<SNode, SNode> partsToLinks) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (SNode) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mpslite.structure.IMPSLiteConcept"), "virtual_createAdditionalConcept_1239817368042", PARAMETERS_1239817368042, new Object[]{conceptsToTargets, partsToLinks});
  }

  public static SNode call_createAdditionalEditor_1239891670850(SNode thisNode, Map<SNode, SNode> conceptsToTargets, Map<SNode, SNode> partsToLinks) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (SNode) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mpslite.structure.IMPSLiteConcept"), "virtual_createAdditionalEditor_1239891670850", PARAMETERS_1239891670850, new Object[]{conceptsToTargets, partsToLinks});
  }

  public static boolean callSuper_isRootable_1239714833738(SNode thisNode, String callerConceptFqName) {
    return (Boolean) BehaviorManager.getInstance().invokeSuper(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mpslite.structure.IMPSLiteConcept"), callerConceptFqName, "virtual_isRootable_1239714833738", PARAMETERS_1239714833738, new Object[]{});
  }

  public static boolean callSuper_isAbstract_1239715026284(SNode thisNode, String callerConceptFqName) {
    return (Boolean) BehaviorManager.getInstance().invokeSuper(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mpslite.structure.IMPSLiteConcept"), callerConceptFqName, "virtual_isAbstract_1239715026284", PARAMETERS_1239715026284, new Object[]{});
  }

  public static void callSuper_fillConcept_1239891562930(SNode thisNode, String callerConceptFqName, SNode concept, Map<SNode, SNode> conceptsToTargets, Map<SNode, SNode> partsToLinks) {
    BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mpslite.structure.IMPSLiteConcept"), callerConceptFqName, "virtual_fillConcept_1239891562930", PARAMETERS_1239891562930, new Object[]{concept, conceptsToTargets, partsToLinks});
  }

  public static SNode callSuper_createEditor_1239890004879(SNode thisNode, String callerConceptFqName, Map<SNode, SNode> conceptsToTargets, Map<SNode, SNode> partsToLinks) {
    return (SNode) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mpslite.structure.IMPSLiteConcept"), callerConceptFqName, "virtual_createEditor_1239890004879", PARAMETERS_1239890004879, new Object[]{conceptsToTargets, partsToLinks});
  }

  public static SNode callSuper_createAdditionalConcept_1239817368042(SNode thisNode, String callerConceptFqName, Map<SNode, SNode> conceptsToTargets, Map<SNode, SNode> partsToLinks) {
    return (SNode) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mpslite.structure.IMPSLiteConcept"), callerConceptFqName, "virtual_createAdditionalConcept_1239817368042", PARAMETERS_1239817368042, new Object[]{conceptsToTargets, partsToLinks});
  }

  public static SNode callSuper_createAdditionalEditor_1239891670850(SNode thisNode, String callerConceptFqName, Map<SNode, SNode> conceptsToTargets, Map<SNode, SNode> partsToLinks) {
    return (SNode) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mpslite.structure.IMPSLiteConcept"), callerConceptFqName, "virtual_createAdditionalEditor_1239891670850", PARAMETERS_1239891670850, new Object[]{conceptsToTargets, partsToLinks});
  }
}
