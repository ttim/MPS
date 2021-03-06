package jetbrains.mps.build.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.build.util.UnpackHelper;
import jetbrains.mps.build.util.DependenciesHelper;
import jetbrains.mps.smodel.runtime.BehaviorDescriptor;
import jetbrains.mps.smodel.language.ConceptRegistry;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.behaviour.BehaviorManager;

public class BuildLayout_PathElement_Behavior {
  private static Class[] PARAMETERS_7128123785277710736 = {SNode.class, UnpackHelper.class, Iterable.class};
  private static Class[] PARAMETERS_1368030936106665465 = {SNode.class, SNode.class, StringBuilder.class};
  private static Class[] PARAMETERS_7117056644539862594 = {SNode.class, DependenciesHelper.class, Object.class};

  public static void init(SNode thisNode) {
  }

  public static void call_unpack_7128123785277710736(SNode thisNode, UnpackHelper helper, Iterable<Object> artifacts) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.build.structure.BuildLayout_PathElement"), "virtual_unpack_7128123785277710736", PARAMETERS_7128123785277710736, new Object[]{helper, artifacts});
  }

  public static void call_appendName_1368030936106665465(SNode thisNode, SNode parent, StringBuilder sb) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.build.structure.BuildLayout_PathElement"), "virtual_appendName_1368030936106665465", PARAMETERS_1368030936106665465, new Object[]{parent, sb});
  }

  public static String call_location_7117056644539862594(SNode thisNode, DependenciesHelper helper, Object artifactId) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (String) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.build.structure.BuildLayout_PathElement"), "virtual_location_7117056644539862594", PARAMETERS_7117056644539862594, new Object[]{helper, artifactId});
  }

  public static void callSuper_unpack_7128123785277710736(SNode thisNode, String callerConceptFqName, UnpackHelper helper, Iterable<Object> artifacts) {
    BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.build.structure.BuildLayout_PathElement"), callerConceptFqName, "virtual_unpack_7128123785277710736", PARAMETERS_7128123785277710736, new Object[]{helper, artifacts});
  }

  public static void callSuper_appendName_1368030936106665465(SNode thisNode, String callerConceptFqName, SNode parent, StringBuilder sb) {
    BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.build.structure.BuildLayout_PathElement"), callerConceptFqName, "virtual_appendName_1368030936106665465", PARAMETERS_1368030936106665465, new Object[]{parent, sb});
  }

  public static String callSuper_location_7117056644539862594(SNode thisNode, String callerConceptFqName, DependenciesHelper helper, Object artifactId) {
    return (String) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.build.structure.BuildLayout_PathElement"), callerConceptFqName, "virtual_location_7117056644539862594", PARAMETERS_7117056644539862594, new Object[]{helper, artifactId});
  }
}
