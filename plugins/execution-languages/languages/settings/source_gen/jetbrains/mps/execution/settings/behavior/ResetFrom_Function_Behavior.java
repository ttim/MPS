package jetbrains.mps.execution.settings.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.runtime.BehaviorDescriptor;
import jetbrains.mps.smodel.language.ConceptRegistry;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.behaviour.BehaviorManager;

public class ResetFrom_Function_Behavior {
  private static Class[] PARAMETERS_946964771156067021 = {SNode.class};
  private static Class[] PARAMETERS_203908296139519720 = {SNode.class};

  public static void init(SNode thisNode) {
  }

  public static SNode virtual_getJavaMethod_946964771156066991(SNode thisNode) {
    return EditorOperationDeclaration_Behavior.call_getMethodbyName_946964771156066997(thisNode, "resetEditorFrom");
  }

  public static SNode virtual_getPublicJavaMethod_203908296139519011(SNode thisNode) {
    return EditorOperationDeclaration_Behavior.call_getMethodbyName_946964771156066997(thisNode, "resetFrom");
  }

  public static SNode call_getJavaMethod_946964771156067021(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (SNode) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.execution.settings.structure.ResetFrom_Function"), "virtual_getJavaMethod_946964771156066991", PARAMETERS_946964771156067021, new Object[]{});
  }

  public static SNode call_getPublicJavaMethod_203908296139519720(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (SNode) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.execution.settings.structure.ResetFrom_Function"), "virtual_getPublicJavaMethod_203908296139519011", PARAMETERS_203908296139519720, new Object[]{});
  }

  public static SNode callSuper_getJavaMethod_946964771156067021(SNode thisNode, String callerConceptFqName) {
    return (SNode) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.execution.settings.structure.ResetFrom_Function"), callerConceptFqName, "virtual_getJavaMethod_946964771156066991", PARAMETERS_946964771156067021, new Object[]{});
  }

  public static SNode callSuper_getPublicJavaMethod_203908296139519720(SNode thisNode, String callerConceptFqName) {
    return (SNode) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.execution.settings.structure.ResetFrom_Function"), callerConceptFqName, "virtual_getPublicJavaMethod_203908296139519011", PARAMETERS_203908296139519720, new Object[]{});
  }
}
