package jetbrains.mps.lang.checkedName.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import java.util.List;
import java.util.ArrayList;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.checkedName.PropertyReference;
import jetbrains.mps.smodel.runtime.BehaviorDescriptor;
import jetbrains.mps.smodel.language.ConceptRegistry;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.behaviour.BehaviorManager;

public class ICheckedNamePolicy_Behavior {
  private static Class[] PARAMETERS_4844813484172611413 = {SNode.class};
  private static Class[] PARAMETERS_4844813484172611439 = {SNode.class};
  private static Class[] PARAMETERS_4844813484172611445 = {SNode.class};
  private static Class[] PARAMETERS_4844813484172611473 = {SNode.class};

  public static void init(SNode thisNode) {
  }

  public static List<SNode> virtual_getDescendantsToCheck_4844813484172611413(SNode thisNode) {
    List<SNode> result = new ArrayList<SNode>();
    SNode dsc = ICheckedNamePolicy_Behavior.call_getDescendantToCheck_4844813484172611439(thisNode);
    if (dsc != null) {
      ListSequence.fromList(result).addElement(dsc);
    }
    return result;
  }

  public static SNode virtual_getDescendantToCheck_4844813484172611439(SNode thisNode) {
    return null;
  }

  public static List<PropertyReference> virtual_getPropertiesToCheck_4844813484172611445(SNode thisNode) {
    List<PropertyReference> result = ListSequence.fromList(new ArrayList<PropertyReference>());
    PropertyReference property = ICheckedNamePolicy_Behavior.call_getPropertyToCheck_4844813484172611473(thisNode);
    if (property != null) {
      ListSequence.fromList(result).addElement(property);
    }
    return result;
  }

  public static PropertyReference virtual_getPropertyToCheck_4844813484172611473(SNode thisNode) {
    return null;
  }

  public static List<SNode> call_getDescendantsToCheck_4844813484172611413(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (List<SNode>) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.lang.checkedName.structure.ICheckedNamePolicy"), "virtual_getDescendantsToCheck_4844813484172611413", PARAMETERS_4844813484172611413, new Object[]{});
  }

  public static SNode call_getDescendantToCheck_4844813484172611439(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (SNode) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.lang.checkedName.structure.ICheckedNamePolicy"), "virtual_getDescendantToCheck_4844813484172611439", PARAMETERS_4844813484172611439, new Object[]{});
  }

  public static List<PropertyReference> call_getPropertiesToCheck_4844813484172611445(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (List<PropertyReference>) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.lang.checkedName.structure.ICheckedNamePolicy"), "virtual_getPropertiesToCheck_4844813484172611445", PARAMETERS_4844813484172611445, new Object[]{});
  }

  public static PropertyReference call_getPropertyToCheck_4844813484172611473(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (PropertyReference) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.lang.checkedName.structure.ICheckedNamePolicy"), "virtual_getPropertyToCheck_4844813484172611473", PARAMETERS_4844813484172611473, new Object[]{});
  }

  public static List<SNode> callSuper_getDescendantsToCheck_4844813484172611413(SNode thisNode, String callerConceptFqName) {
    return (List<SNode>) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.lang.checkedName.structure.ICheckedNamePolicy"), callerConceptFqName, "virtual_getDescendantsToCheck_4844813484172611413", PARAMETERS_4844813484172611413, new Object[]{});
  }

  public static SNode callSuper_getDescendantToCheck_4844813484172611439(SNode thisNode, String callerConceptFqName) {
    return (SNode) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.lang.checkedName.structure.ICheckedNamePolicy"), callerConceptFqName, "virtual_getDescendantToCheck_4844813484172611439", PARAMETERS_4844813484172611439, new Object[]{});
  }

  public static List<PropertyReference> callSuper_getPropertiesToCheck_4844813484172611445(SNode thisNode, String callerConceptFqName) {
    return (List<PropertyReference>) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.lang.checkedName.structure.ICheckedNamePolicy"), callerConceptFqName, "virtual_getPropertiesToCheck_4844813484172611445", PARAMETERS_4844813484172611445, new Object[]{});
  }

  public static PropertyReference callSuper_getPropertyToCheck_4844813484172611473(SNode thisNode, String callerConceptFqName) {
    return (PropertyReference) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.lang.checkedName.structure.ICheckedNamePolicy"), callerConceptFqName, "virtual_getPropertyToCheck_4844813484172611473", PARAMETERS_4844813484172611473, new Object[]{});
  }
}
