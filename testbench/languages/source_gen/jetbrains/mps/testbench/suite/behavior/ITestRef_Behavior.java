package jetbrains.mps.testbench.suite.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.runtime.BehaviorDescriptor;
import jetbrains.mps.smodel.language.ConceptRegistry;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.behaviour.BehaviorManager;

public class ITestRef_Behavior {
  private static Class[] PARAMETERS_2956932267233324537 = {SNode.class};
  private static Class[] PARAMETERS_4089647634160960707 = {SNode.class};

  public static void init(SNode thisNode) {
  }

  public static String call_fqClassName_2956932267233324537(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (String) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.testbench.suite.structure.ITestRef"), "virtual_fqClassName_2956932267233324537", PARAMETERS_2956932267233324537);
  }

  public static Iterable<String> call_testNames_4089647634160960707(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (Iterable<String>) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.testbench.suite.structure.ITestRef"), "virtual_testNames_4089647634160960707", PARAMETERS_4089647634160960707);
  }

  public static String callSuper_fqClassName_2956932267233324537(SNode thisNode, String callerConceptFqName) {
    return (String) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.testbench.suite.structure.ITestRef"), callerConceptFqName, "virtual_fqClassName_2956932267233324537", PARAMETERS_2956932267233324537);
  }

  public static Iterable<String> callSuper_testNames_4089647634160960707(SNode thisNode, String callerConceptFqName) {
    return (Iterable<String>) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.testbench.suite.structure.ITestRef"), callerConceptFqName, "virtual_testNames_4089647634160960707", PARAMETERS_4089647634160960707);
  }
}
