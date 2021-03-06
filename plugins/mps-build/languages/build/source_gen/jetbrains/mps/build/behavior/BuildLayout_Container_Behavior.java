package jetbrains.mps.build.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.build.util.Context;
import jetbrains.mps.smodel.runtime.BehaviorDescriptor;
import jetbrains.mps.smodel.language.ConceptRegistry;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.behaviour.BehaviorManager;

public class BuildLayout_Container_Behavior {
  private static Class[] PARAMETERS_4701820937132344011 = {SNode.class, Context.class};
  private static Class[] PARAMETERS_4701820937132344041 = {SNode.class};
  private static Class[] PARAMETERS_4701820937132344052 = {SNode.class};

  public static void init(SNode thisNode) {
  }

  public static String call_getChildrenOutputDir_WithMacro_4701820937132344011(SNode thisNode, Context context) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (String) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.build.structure.BuildLayout_Container"), "virtual_getChildrenOutputDir_WithMacro_4701820937132344011", PARAMETERS_4701820937132344011, new Object[]{context});
  }

  public static String call_getPrepareSubTaskId_4701820937132344041(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (String) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.build.structure.BuildLayout_Container"), "virtual_getPrepareSubTaskId_4701820937132344041", PARAMETERS_4701820937132344041, new Object[]{});
  }

  public static String call_getAssembleSubTaskId_4701820937132344052(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (String) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.build.structure.BuildLayout_Container"), "virtual_getAssembleSubTaskId_4701820937132344052", PARAMETERS_4701820937132344052, new Object[]{});
  }

  public static String callSuper_getChildrenOutputDir_WithMacro_4701820937132344011(SNode thisNode, String callerConceptFqName, Context context) {
    return (String) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.build.structure.BuildLayout_Container"), callerConceptFqName, "virtual_getChildrenOutputDir_WithMacro_4701820937132344011", PARAMETERS_4701820937132344011, new Object[]{context});
  }

  public static String callSuper_getPrepareSubTaskId_4701820937132344041(SNode thisNode, String callerConceptFqName) {
    return (String) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.build.structure.BuildLayout_Container"), callerConceptFqName, "virtual_getPrepareSubTaskId_4701820937132344041", PARAMETERS_4701820937132344041, new Object[]{});
  }

  public static String callSuper_getAssembleSubTaskId_4701820937132344052(SNode thisNode, String callerConceptFqName) {
    return (String) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.build.structure.BuildLayout_Container"), callerConceptFqName, "virtual_getAssembleSubTaskId_4701820937132344052", PARAMETERS_4701820937132344052, new Object[]{});
  }
}
