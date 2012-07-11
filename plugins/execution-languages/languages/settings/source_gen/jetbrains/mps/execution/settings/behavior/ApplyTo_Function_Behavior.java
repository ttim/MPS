package jetbrains.mps.execution.settings.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.runtime.BehaviorDescriptor;
import jetbrains.mps.smodel.language.ConceptRegistry;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.behaviour.BehaviorManager;

public class ApplyTo_Function_Behavior {
  private static Class[] PARAMETERS_946964771156066981 = {SNode.class};
  private static Class[] PARAMETERS_203908296139519015 = {SNode.class};

  public static void init(SNode thisNode) {
  }

  public static SNode virtual_getJavaMethod_946964771156066991(SNode thisNode) {
    return EditorOperationDeclaration_Behavior.call_getMethodbyName_946964771156066997(thisNode, "applyEditorTo");
  }

  public static SNode virtual_getPublicJavaMethod_203908296139519011(SNode thisNode) {
    return EditorOperationDeclaration_Behavior.call_getMethodbyName_946964771156066997(thisNode, "apply");
  }

  public static SNode call_getJavaMethod_946964771156066981(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (SNode) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.execution.settings.structure.ApplyTo_Function"), "virtual_getJavaMethod_946964771156066991", PARAMETERS_946964771156066981, new Object[]{});
  }

  public static SNode call_getPublicJavaMethod_203908296139519015(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (SNode) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.execution.settings.structure.ApplyTo_Function"), "virtual_getPublicJavaMethod_203908296139519011", PARAMETERS_203908296139519015, new Object[]{});
  }

  public static SNode callSuper_getJavaMethod_946964771156066981(SNode thisNode, String callerConceptFqName) {
    return (SNode) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.execution.settings.structure.ApplyTo_Function"), callerConceptFqName, "virtual_getJavaMethod_946964771156066991", PARAMETERS_946964771156066981, new Object[]{});
  }

  public static SNode callSuper_getPublicJavaMethod_203908296139519015(SNode thisNode, String callerConceptFqName) {
    return (SNode) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.execution.settings.structure.ApplyTo_Function"), callerConceptFqName, "virtual_getPublicJavaMethod_203908296139519011", PARAMETERS_203908296139519015, new Object[]{});
  }
}
