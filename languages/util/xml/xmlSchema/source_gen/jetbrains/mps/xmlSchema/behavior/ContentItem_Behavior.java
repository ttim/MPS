package jetbrains.mps.xmlSchema.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import java.util.List;
import java.util.Set;
import jetbrains.mps.smodel.runtime.BehaviorDescriptor;
import jetbrains.mps.smodel.language.ConceptRegistry;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.behaviour.BehaviorManager;

public class ContentItem_Behavior {
  private static Class[] PARAMETERS_1213877413538 = {SNode.class, List.class};
  private static Class[] PARAMETERS_1213877413543 = {SNode.class, Set.class};
  private static Class[] PARAMETERS_1213877413548 = {SNode.class};

  public static void init(SNode thisNode) {
  }

  public static void call_checkAttributes_1213877413538(SNode thisNode, List<SNode> attributeDeclarations) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.xmlSchema.structure.ContentItem"), "virtual_checkAttributes_1213877413538", PARAMETERS_1213877413538, new Object[]{attributeDeclarations});
  }

  public static void call_checkElements_1213877413543(SNode thisNode, Set<SNode> elementDeclarations) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.xmlSchema.structure.ContentItem"), "virtual_checkElements_1213877413543", PARAMETERS_1213877413543, new Object[]{elementDeclarations});
  }

  public static boolean call_isMixed_1213877413548(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (Boolean) descriptor.invoke(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.xmlSchema.structure.ContentItem"), "virtual_isMixed_1213877413548", PARAMETERS_1213877413548, new Object[]{});
  }

  public static void callSuper_checkAttributes_1213877413538(SNode thisNode, String callerConceptFqName, List<SNode> attributeDeclarations) {
    BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.xmlSchema.structure.ContentItem"), callerConceptFqName, "virtual_checkAttributes_1213877413538", PARAMETERS_1213877413538, new Object[]{attributeDeclarations});
  }

  public static void callSuper_checkElements_1213877413543(SNode thisNode, String callerConceptFqName, Set<SNode> elementDeclarations) {
    BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.xmlSchema.structure.ContentItem"), callerConceptFqName, "virtual_checkElements_1213877413543", PARAMETERS_1213877413543, new Object[]{elementDeclarations});
  }

  public static boolean callSuper_isMixed_1213877413548(SNode thisNode, String callerConceptFqName) {
    return (Boolean) BehaviorManager.getInstance().invokeSuper(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.xmlSchema.structure.ContentItem"), callerConceptFqName, "virtual_isMixed_1213877413548", PARAMETERS_1213877413548, new Object[]{});
  }
}
