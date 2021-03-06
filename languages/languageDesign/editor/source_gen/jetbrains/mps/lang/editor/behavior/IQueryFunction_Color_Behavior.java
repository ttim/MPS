package jetbrains.mps.lang.editor.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.runtime.BehaviorDescriptor;
import jetbrains.mps.smodel.language.ConceptRegistry;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.behaviour.BehaviorManager;

public class IQueryFunction_Color_Behavior {
  private static Class[] PARAMETERS_1225463329531 = {SNode.class};
  private static Class[] PARAMETERS_1225468086082 = {SNode.class};

  public static void init(SNode thisNode) {
  }

  public static boolean virtual_isFunction_1225463329531(SNode thisNode) {
    return true;
  }

  public static String virtual_getRGBValue_1225468086082(SNode thisNode) {
    return null;
  }

  public static boolean call_isFunction_1225463329531(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (Boolean) descriptor.invoke(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.lang.editor.structure.IQueryFunction_Color"), "virtual_isFunction_1225463329531", PARAMETERS_1225463329531, new Object[]{});
  }

  public static String call_getRGBValue_1225468086082(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (String) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.lang.editor.structure.IQueryFunction_Color"), "virtual_getRGBValue_1225468086082", PARAMETERS_1225468086082, new Object[]{});
  }

  public static boolean callSuper_isFunction_1225463329531(SNode thisNode, String callerConceptFqName) {
    return (Boolean) BehaviorManager.getInstance().invokeSuper(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.lang.editor.structure.IQueryFunction_Color"), callerConceptFqName, "virtual_isFunction_1225463329531", PARAMETERS_1225463329531, new Object[]{});
  }

  public static String callSuper_getRGBValue_1225468086082(SNode thisNode, String callerConceptFqName) {
    return (String) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.lang.editor.structure.IQueryFunction_Color"), callerConceptFqName, "virtual_getRGBValue_1225468086082", PARAMETERS_1225468086082, new Object[]{});
  }
}
