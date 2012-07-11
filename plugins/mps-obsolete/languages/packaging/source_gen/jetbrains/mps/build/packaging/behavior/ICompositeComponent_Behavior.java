package jetbrains.mps.build.packaging.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.smodel.runtime.BehaviorDescriptor;
import jetbrains.mps.smodel.language.ConceptRegistry;
import jetbrains.mps.smodel.behaviour.BehaviorManager;

public class ICompositeComponent_Behavior {
  private static Class[] PARAMETERS_1213877279373 = {SNode.class};
  private static Class[] PARAMETERS_1213877279430 = {SNode.class};

  public static void init(SNode thisNode) {
  }

  public static String virtual_getExcludes_1213877279373(SNode thisNode) {
    if (SNodeOperations.isInstanceOf(SNodeOperations.getParent(thisNode), "jetbrains.mps.build.packaging.structure.ICompositeComponent")) {
      return ((SPropertyOperations.getString(thisNode, "excludes") != null) && (!(SPropertyOperations.getString(thisNode, "excludes").equals(""))) ?
        (SPropertyOperations.getString(thisNode, "excludes") + ", ") :
        ""
      ) + ICompositeComponent_Behavior.call_getExcludes_1213877279373(SNodeOperations.cast(SNodeOperations.getParent(thisNode), "jetbrains.mps.build.packaging.structure.ICompositeComponent"));
    }
    return ((SPropertyOperations.getString(thisNode, "excludes") != null) ?
      (SPropertyOperations.getString(thisNode, "excludes")) :
      ""
    );
  }

  public static String virtual_getIncludes_1213877279430(SNode thisNode) {
    if (SNodeOperations.isInstanceOf(SNodeOperations.getParent(thisNode), "jetbrains.mps.build.packaging.structure.ICompositeComponent")) {
      return ((SPropertyOperations.getString(thisNode, "includes") != null) && (!(SPropertyOperations.getString(thisNode, "includes").equals(""))) ?
        (SPropertyOperations.getString(thisNode, "includes") + ", ") :
        ""
      ) + ICompositeComponent_Behavior.call_getIncludes_1213877279430(SNodeOperations.cast(SNodeOperations.getParent(thisNode), "jetbrains.mps.build.packaging.structure.ICompositeComponent"));
    }
    return ((SPropertyOperations.getString(thisNode, "includes") != null) ?
      (SPropertyOperations.getString(thisNode, "includes")) :
      ""
    );
  }

  public static String call_getExcludes_1213877279373(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (String) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.build.packaging.structure.ICompositeComponent"), "virtual_getExcludes_1213877279373", PARAMETERS_1213877279373, new Object[]{});
  }

  public static String call_getIncludes_1213877279430(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (String) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.build.packaging.structure.ICompositeComponent"), "virtual_getIncludes_1213877279430", PARAMETERS_1213877279430, new Object[]{});
  }

  public static String callSuper_getExcludes_1213877279373(SNode thisNode, String callerConceptFqName) {
    return (String) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.build.packaging.structure.ICompositeComponent"), callerConceptFqName, "virtual_getExcludes_1213877279373", PARAMETERS_1213877279373, new Object[]{});
  }

  public static String callSuper_getIncludes_1213877279430(SNode thisNode, String callerConceptFqName) {
    return (String) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.build.packaging.structure.ICompositeComponent"), callerConceptFqName, "virtual_getIncludes_1213877279430", PARAMETERS_1213877279430, new Object[]{});
  }
}
