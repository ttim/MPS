package jetbrains.mps.buildlanguage.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.smodel.runtime.BehaviorDescriptor;
import jetbrains.mps.smodel.language.ConceptRegistry;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.behaviour.BehaviorManager;

public class IDeclaration_Behavior {
  private static Class[] PARAMETERS_5699548131010533031 = {SNode.class};
  private static Class[] PARAMETERS_5699548131010535048 = {SNode.class};
  private static Class[] PARAMETERS_5699548131010535069 = {SNode.class, SNode.class};
  private static Class[] PARAMETERS_5699548131010535105 = {SNode.class, List.class};

  public static void init(SNode thisNode) {
  }

  public static SNode virtual_getParent_5699548131010535048(SNode thisNode) {
    return null;
  }

  public static boolean virtual_isHeirOf_5699548131010535069(SNode thisNode, SNode probableParent) {
    if (thisNode == probableParent) {
      return true;
    }
    if (IDeclaration_Behavior.call_getParent_5699548131010535048(thisNode) == null) {
      return false;
    }
    return IDeclaration_Behavior.call_isHeirOf_5699548131010535069(IDeclaration_Behavior.call_getParent_5699548131010535048(thisNode), probableParent);
  }

  public static boolean virtual_isHeirOf_5699548131010535105(SNode thisNode, List<SNode> parents) {
    for (SNode parent : ListSequence.fromList(parents)) {
      if (IDeclaration_Behavior.call_isHeirOf_5699548131010535069(thisNode, parent)) {
        return true;
      }
    }
    return false;
  }

  public static boolean call_isAbstract_5699548131010533031(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (Boolean) descriptor.invoke(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.buildlanguage.structure.IDeclaration"), "virtual_isAbstract_5699548131010533031", PARAMETERS_5699548131010533031, new Object[]{});
  }

  public static SNode call_getParent_5699548131010535048(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (SNode) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.buildlanguage.structure.IDeclaration"), "virtual_getParent_5699548131010535048", PARAMETERS_5699548131010535048, new Object[]{});
  }

  public static boolean call_isHeirOf_5699548131010535069(SNode thisNode, SNode probableParent) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (Boolean) descriptor.invoke(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.buildlanguage.structure.IDeclaration"), "virtual_isHeirOf_5699548131010535069", PARAMETERS_5699548131010535069, new Object[]{probableParent});
  }

  public static boolean call_isHeirOf_5699548131010535105(SNode thisNode, List<SNode> parents) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (Boolean) descriptor.invoke(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.buildlanguage.structure.IDeclaration"), "virtual_isHeirOf_5699548131010535105", PARAMETERS_5699548131010535105, new Object[]{parents});
  }

  public static boolean callSuper_isAbstract_5699548131010533031(SNode thisNode, String callerConceptFqName) {
    return (Boolean) BehaviorManager.getInstance().invokeSuper(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.buildlanguage.structure.IDeclaration"), callerConceptFqName, "virtual_isAbstract_5699548131010533031", PARAMETERS_5699548131010533031, new Object[]{});
  }

  public static SNode callSuper_getParent_5699548131010535048(SNode thisNode, String callerConceptFqName) {
    return (SNode) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.buildlanguage.structure.IDeclaration"), callerConceptFqName, "virtual_getParent_5699548131010535048", PARAMETERS_5699548131010535048, new Object[]{});
  }

  public static boolean callSuper_isHeirOf_5699548131010535069(SNode thisNode, String callerConceptFqName, SNode probableParent) {
    return (Boolean) BehaviorManager.getInstance().invokeSuper(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.buildlanguage.structure.IDeclaration"), callerConceptFqName, "virtual_isHeirOf_5699548131010535069", PARAMETERS_5699548131010535069, new Object[]{probableParent});
  }

  public static boolean callSuper_isHeirOf_5699548131010535105(SNode thisNode, String callerConceptFqName, List<SNode> parents) {
    return (Boolean) BehaviorManager.getInstance().invokeSuper(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.buildlanguage.structure.IDeclaration"), callerConceptFqName, "virtual_isHeirOf_5699548131010535105", PARAMETERS_5699548131010535105, new Object[]{parents});
  }
}
