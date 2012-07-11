package jetbrains.mps.build.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.build.util.Context;
import jetbrains.mps.build.util.MacroHelper;
import org.jetbrains.annotations.Nullable;
import jetbrains.mps.smodel.runtime.BehaviorDescriptor;
import jetbrains.mps.smodel.language.ConceptRegistry;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.behaviour.BehaviorManager;

public class BuildSourcePath_Behavior {
  private static Class[] PARAMETERS_5481553824944787364 = {SNode.class, Context.class};
  private static Class[] PARAMETERS_5481553824944787371 = {SNode.class};
  private static Class[] PARAMETERS_1368030936106771141 = {SNode.class, MacroHelper.class};
  private static Class[] PARAMETERS_8654221991637145399 = {SNode.class};

  public static void init(SNode thisNode) {
  }

  @Nullable
  public static String virtual_getLocalPath_5481553824944787364(SNode thisNode, Context context) {
    return null;
  }

  public static String virtual_getRelativePath_5481553824944787371(SNode thisNode) {
    return null;
  }

  public static String virtual_getLastSegment_1368030936106771141(SNode thisNode, MacroHelper helper) {
    return null;
  }

  public static SNode virtual_getParent_8654221991637145399(SNode thisNode) {
    return null;
  }

  public static String call_getLocalPath_5481553824944787364(SNode thisNode, Context context) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (String) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.build.structure.BuildSourcePath"), "virtual_getLocalPath_5481553824944787364", PARAMETERS_5481553824944787364, new Object[]{context});
  }

  public static String call_getRelativePath_5481553824944787371(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (String) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.build.structure.BuildSourcePath"), "virtual_getRelativePath_5481553824944787371", PARAMETERS_5481553824944787371, new Object[]{});
  }

  public static String call_getLastSegment_1368030936106771141(SNode thisNode, MacroHelper helper) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (String) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.build.structure.BuildSourcePath"), "virtual_getLastSegment_1368030936106771141", PARAMETERS_1368030936106771141, new Object[]{helper});
  }

  public static SNode call_getParent_8654221991637145399(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (SNode) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.build.structure.BuildSourcePath"), "virtual_getParent_8654221991637145399", PARAMETERS_8654221991637145399, new Object[]{});
  }

  public static String callSuper_getLocalPath_5481553824944787364(SNode thisNode, String callerConceptFqName, Context context) {
    return (String) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.build.structure.BuildSourcePath"), callerConceptFqName, "virtual_getLocalPath_5481553824944787364", PARAMETERS_5481553824944787364, new Object[]{context});
  }

  public static String callSuper_getRelativePath_5481553824944787371(SNode thisNode, String callerConceptFqName) {
    return (String) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.build.structure.BuildSourcePath"), callerConceptFqName, "virtual_getRelativePath_5481553824944787371", PARAMETERS_5481553824944787371, new Object[]{});
  }

  public static String callSuper_getLastSegment_1368030936106771141(SNode thisNode, String callerConceptFqName, MacroHelper helper) {
    return (String) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.build.structure.BuildSourcePath"), callerConceptFqName, "virtual_getLastSegment_1368030936106771141", PARAMETERS_1368030936106771141, new Object[]{helper});
  }

  public static SNode callSuper_getParent_8654221991637145399(SNode thisNode, String callerConceptFqName) {
    return (SNode) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.build.structure.BuildSourcePath"), callerConceptFqName, "virtual_getParent_8654221991637145399", PARAMETERS_8654221991637145399, new Object[]{});
  }
}
