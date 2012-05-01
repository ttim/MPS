package jetbrains.mps.xmlSchema.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import java.util.List;
import java.util.Set;
import jetbrains.mps.smodel.runtime.BehaviorDescriptor;
import jetbrains.mps.smodel.language.ConceptRegistry;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.behaviour.BehaviorManager;

public class TypeExpression_Behavior {
  private static Class[] PARAMETERS_1213877382373 = {SNode.class, List.class};
  private static Class[] PARAMETERS_1213877382378 = {SNode.class, Set.class};
  private static Class[] PARAMETERS_1213877382383 = {SNode.class};
  private static Class[] PARAMETERS_1213877382388 = {SNode.class};

  public static void init(SNode thisNode) {
  }

  public static void virtual_checkAttributes_1213877382373(SNode thisNode, List<SNode> attributeDeclarations) {
  }

  public static void virtual_checkElements_1213877382378(SNode thisNode, Set<SNode> elementDeclarations) {
  }

  public static boolean virtual_hasElementReferences_1213877382383(SNode thisNode) {
    return false;
  }

  public static boolean virtual_isMixed_1213877382388(SNode thisNode) {
    return false;
  }

  public static void call_checkAttributes_1213877382373(SNode thisNode, List<SNode> attributeDeclarations) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.xmlSchema.structure.TypeExpression"), "virtual_checkAttributes_1213877382373", PARAMETERS_1213877382373, attributeDeclarations);
  }

  public static void call_checkElements_1213877382378(SNode thisNode, Set<SNode> elementDeclarations) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.xmlSchema.structure.TypeExpression"), "virtual_checkElements_1213877382378", PARAMETERS_1213877382378, elementDeclarations);
  }

  public static boolean call_hasElementReferences_1213877382383(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (Boolean) descriptor.invoke(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.xmlSchema.structure.TypeExpression"), "virtual_hasElementReferences_1213877382383", PARAMETERS_1213877382383);
  }

  public static boolean call_isMixed_1213877382388(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (Boolean) descriptor.invoke(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.xmlSchema.structure.TypeExpression"), "virtual_isMixed_1213877382388", PARAMETERS_1213877382388);
  }

  public static void callSuper_checkAttributes_1213877382373(SNode thisNode, String callerConceptFqName, List<SNode> attributeDeclarations) {
    BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.xmlSchema.structure.TypeExpression"), callerConceptFqName, "virtual_checkAttributes_1213877382373", PARAMETERS_1213877382373, attributeDeclarations);
  }

  public static void callSuper_checkElements_1213877382378(SNode thisNode, String callerConceptFqName, Set<SNode> elementDeclarations) {
    BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.xmlSchema.structure.TypeExpression"), callerConceptFqName, "virtual_checkElements_1213877382378", PARAMETERS_1213877382378, elementDeclarations);
  }

  public static boolean callSuper_hasElementReferences_1213877382383(SNode thisNode, String callerConceptFqName) {
    return (Boolean) BehaviorManager.getInstance().invokeSuper(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.xmlSchema.structure.TypeExpression"), callerConceptFqName, "virtual_hasElementReferences_1213877382383", PARAMETERS_1213877382383);
  }

  public static boolean callSuper_isMixed_1213877382388(SNode thisNode, String callerConceptFqName) {
    return (Boolean) BehaviorManager.getInstance().invokeSuper(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.xmlSchema.structure.TypeExpression"), callerConceptFqName, "virtual_isMixed_1213877382388", PARAMETERS_1213877382388);
  }
}
