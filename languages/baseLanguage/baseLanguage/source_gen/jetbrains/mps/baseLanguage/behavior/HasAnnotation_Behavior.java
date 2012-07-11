package jetbrains.mps.baseLanguage.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import java.util.List;
import java.util.ArrayList;
import jetbrains.mps.smodel.runtime.BehaviorDescriptor;
import jetbrains.mps.smodel.language.ConceptRegistry;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.behaviour.BehaviorManager;

public class HasAnnotation_Behavior {
  private static Class[] PARAMETERS_1233076312117 = {SNode.class};
  private static Class[] PARAMETERS_4025276038182319200 = {SNode.class};

  public static void init(SNode thisNode) {
  }

  public static boolean virtual_canBeAnnotated_1233076312117(SNode thisNode) {
    return true;
  }

  public static List<SNode> virtual_getChildrenToDisplayIntention_4025276038182319200(SNode thisNode) {
    return new ArrayList<SNode>();
  }

  public static boolean call_canBeAnnotated_1233076312117(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (Boolean) descriptor.invoke(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.HasAnnotation"), "virtual_canBeAnnotated_1233076312117", PARAMETERS_1233076312117, new Object[]{});
  }

  public static List<SNode> call_getChildrenToDisplayIntention_4025276038182319200(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (List<SNode>) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.HasAnnotation"), "virtual_getChildrenToDisplayIntention_4025276038182319200", PARAMETERS_4025276038182319200, new Object[]{});
  }

  public static boolean callSuper_canBeAnnotated_1233076312117(SNode thisNode, String callerConceptFqName) {
    return (Boolean) BehaviorManager.getInstance().invokeSuper(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.HasAnnotation"), callerConceptFqName, "virtual_canBeAnnotated_1233076312117", PARAMETERS_1233076312117, new Object[]{});
  }

  public static List<SNode> callSuper_getChildrenToDisplayIntention_4025276038182319200(SNode thisNode, String callerConceptFqName) {
    return (List<SNode>) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.HasAnnotation"), callerConceptFqName, "virtual_getChildrenToDisplayIntention_4025276038182319200", PARAMETERS_4025276038182319200, new Object[]{});
  }
}
