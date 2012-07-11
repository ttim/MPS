package jetbrains.mps.baseLanguage.unitTest.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.runtime.BehaviorDescriptor;
import jetbrains.mps.smodel.language.ConceptRegistry;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.behaviour.BehaviorManager;

public class ITestMethod_Behavior {
  private static Class[] PARAMETERS_1216134500045 = {SNode.class};
  private static Class[] PARAMETERS_1216136419751 = {SNode.class};

  public static void init(SNode thisNode) {
  }

  public static SNode call_getTestCase_1216134500045(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (SNode) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.unitTest.structure.ITestMethod"), "virtual_getTestCase_1216134500045", PARAMETERS_1216134500045, new Object[]{});
  }

  public static String call_getTestName_1216136419751(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (String) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.unitTest.structure.ITestMethod"), "virtual_getTestName_1216136419751", PARAMETERS_1216136419751, new Object[]{});
  }

  public static SNode callSuper_getTestCase_1216134500045(SNode thisNode, String callerConceptFqName) {
    return (SNode) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.unitTest.structure.ITestMethod"), callerConceptFqName, "virtual_getTestCase_1216134500045", PARAMETERS_1216134500045, new Object[]{});
  }

  public static String callSuper_getTestName_1216136419751(SNode thisNode, String callerConceptFqName) {
    return (String) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.unitTest.structure.ITestMethod"), callerConceptFqName, "virtual_getTestName_1216136419751", PARAMETERS_1216136419751, new Object[]{});
  }
}
