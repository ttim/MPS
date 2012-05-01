package jetbrains.mps.baseLanguage.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.project.IModule;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptPropertyOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.runtime.BehaviorDescriptor;
import jetbrains.mps.smodel.language.ConceptRegistry;
import jetbrains.mps.smodel.behaviour.BehaviorManager;

public class Expression_Behavior {
  private static Class[] PARAMETERS_1213877519769 = {SNode.class, IModule.class};
  private static Class[] PARAMETERS_1213877519781 = {SNode.class};
  private static Class[] PARAMETERS_1213877519786 = {SNode.class};
  private static Class[] PARAMETERS_1238860258777 = {SNode.class};
  private static Class[] PARAMETERS_1238860310638 = {SNode.class, IModule.class};
  private static Class[] PARAMETERS_1239211900844 = {SNode.class};

  public static void init(SNode thisNode) {
  }

  public static Object virtual_eval_1213877519769(SNode thisNode, IModule module) {
    throw new UnsupportedOperationException(thisNode.getDebugText());
  }

  public static String virtual_getVariableExpectedName_1213877519781(SNode thisNode) {
    return null;
  }

  public static boolean virtual_isLValue_1213877519786(SNode thisNode) {
    return SConceptPropertyOperations.getBoolean(thisNode, "lvalue");
  }

  public static boolean virtual_isCompileTimeConstant_1238860258777(SNode thisNode) {
    return SConceptPropertyOperations.getBoolean(thisNode, "constant");
  }

  public static Object virtual_getCompileTimeConstantValue_1238860310638(SNode thisNode, IModule module) {
    throw new UnsupportedOperationException();
  }

  public static boolean virtual_isLegalAsStatement_1239211900844(SNode thisNode) {
    if (SNodeOperations.isInstanceOf(SNodeOperations.getParent(thisNode), "jetbrains.mps.baseLanguage.structure.CommentPart")) {
      return true;
    }
    return SConceptPropertyOperations.getBoolean(thisNode, "legalAsStatement");
  }

  public static Object call_eval_1213877519769(SNode thisNode, IModule module) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (Object) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.Expression"), "virtual_eval_1213877519769", PARAMETERS_1213877519769, module);
  }

  public static String call_getVariableExpectedName_1213877519781(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (String) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.Expression"), "virtual_getVariableExpectedName_1213877519781", PARAMETERS_1213877519781);
  }

  public static boolean call_isLValue_1213877519786(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (Boolean) descriptor.invoke(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.Expression"), "virtual_isLValue_1213877519786", PARAMETERS_1213877519786);
  }

  public static boolean call_isCompileTimeConstant_1238860258777(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (Boolean) descriptor.invoke(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.Expression"), "virtual_isCompileTimeConstant_1238860258777", PARAMETERS_1238860258777);
  }

  public static Object call_getCompileTimeConstantValue_1238860310638(SNode thisNode, IModule module) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (Object) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.Expression"), "virtual_getCompileTimeConstantValue_1238860310638", PARAMETERS_1238860310638, module);
  }

  public static boolean call_isLegalAsStatement_1239211900844(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (Boolean) descriptor.invoke(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.Expression"), "virtual_isLegalAsStatement_1239211900844", PARAMETERS_1239211900844);
  }

  public static Object callSuper_eval_1213877519769(SNode thisNode, String callerConceptFqName, IModule module) {
    return (Object) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.Expression"), callerConceptFqName, "virtual_eval_1213877519769", PARAMETERS_1213877519769, module);
  }

  public static String callSuper_getVariableExpectedName_1213877519781(SNode thisNode, String callerConceptFqName) {
    return (String) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.Expression"), callerConceptFqName, "virtual_getVariableExpectedName_1213877519781", PARAMETERS_1213877519781);
  }

  public static boolean callSuper_isLValue_1213877519786(SNode thisNode, String callerConceptFqName) {
    return (Boolean) BehaviorManager.getInstance().invokeSuper(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.Expression"), callerConceptFqName, "virtual_isLValue_1213877519786", PARAMETERS_1213877519786);
  }

  public static boolean callSuper_isCompileTimeConstant_1238860258777(SNode thisNode, String callerConceptFqName) {
    return (Boolean) BehaviorManager.getInstance().invokeSuper(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.Expression"), callerConceptFqName, "virtual_isCompileTimeConstant_1238860258777", PARAMETERS_1238860258777);
  }

  public static Object callSuper_getCompileTimeConstantValue_1238860310638(SNode thisNode, String callerConceptFqName, IModule module) {
    return (Object) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.Expression"), callerConceptFqName, "virtual_getCompileTimeConstantValue_1238860310638", PARAMETERS_1238860310638, module);
  }

  public static boolean callSuper_isLegalAsStatement_1239211900844(SNode thisNode, String callerConceptFqName) {
    return (Boolean) BehaviorManager.getInstance().invokeSuper(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.Expression"), callerConceptFqName, "virtual_isLegalAsStatement_1239211900844", PARAMETERS_1239211900844);
  }
}
