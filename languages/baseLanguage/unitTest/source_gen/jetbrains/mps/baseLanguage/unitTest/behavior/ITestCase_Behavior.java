package jetbrains.mps.baseLanguage.unitTest.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import java.util.List;
import java.util.ArrayList;
import jetbrains.mps.smodel.runtime.BehaviorDescriptor;
import jetbrains.mps.smodel.language.ConceptRegistry;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.behaviour.BehaviorManager;

public class ITestCase_Behavior {
  private static Class[] PARAMETERS_1216130724401 = {SNode.class};
  private static Class[] PARAMETERS_1216136193905 = {SNode.class};
  private static Class[] PARAMETERS_1229278847513 = {SNode.class};
  private static Class[] PARAMETERS_2148145109766218395 = {SNode.class};

  public static void init(SNode thisNode) {
  }

  public static String virtual_getClassName_1216136193905(SNode thisNode) {
    return thisNode.getModel().getLongName() + "." + ITestCase_Behavior.call_getSimpleClassName_1229278847513(thisNode);
  }

  public static String virtual_getSimpleClassName_1229278847513(SNode thisNode) {
    return SPropertyOperations.getString(thisNode, "name") + "_Test";
  }

  public static List<SNode> virtual_getTestMethods_2148145109766218395(SNode thisNode) {
    return new ArrayList<SNode>();
  }

  public static List<SNode> call_getTestSet_1216130724401(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (List<SNode>) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.unitTest.structure.ITestCase"), "virtual_getTestSet_1216130724401", PARAMETERS_1216130724401);
  }

  public static String call_getClassName_1216136193905(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (String) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.unitTest.structure.ITestCase"), "virtual_getClassName_1216136193905", PARAMETERS_1216136193905);
  }

  public static String call_getSimpleClassName_1229278847513(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (String) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.unitTest.structure.ITestCase"), "virtual_getSimpleClassName_1229278847513", PARAMETERS_1229278847513);
  }

  public static List<SNode> call_getTestMethods_2148145109766218395(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (List<SNode>) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.unitTest.structure.ITestCase"), "virtual_getTestMethods_2148145109766218395", PARAMETERS_2148145109766218395);
  }

  public static List<SNode> callSuper_getTestSet_1216130724401(SNode thisNode, String callerConceptFqName) {
    return (List<SNode>) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.unitTest.structure.ITestCase"), callerConceptFqName, "virtual_getTestSet_1216130724401", PARAMETERS_1216130724401);
  }

  public static String callSuper_getClassName_1216136193905(SNode thisNode, String callerConceptFqName) {
    return (String) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.unitTest.structure.ITestCase"), callerConceptFqName, "virtual_getClassName_1216136193905", PARAMETERS_1216136193905);
  }

  public static String callSuper_getSimpleClassName_1229278847513(SNode thisNode, String callerConceptFqName) {
    return (String) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.unitTest.structure.ITestCase"), callerConceptFqName, "virtual_getSimpleClassName_1229278847513", PARAMETERS_1229278847513);
  }

  public static List<SNode> callSuper_getTestMethods_2148145109766218395(SNode thisNode, String callerConceptFqName) {
    return (List<SNode>) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.unitTest.structure.ITestCase"), callerConceptFqName, "virtual_getTestMethods_2148145109766218395", PARAMETERS_2148145109766218395);
  }
}
