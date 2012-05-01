package jetbrains.mps.lang.editor.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.runtime.BehaviorDescriptor;
import jetbrains.mps.smodel.language.ConceptRegistry;
import jetbrains.mps.smodel.behaviour.BehaviorManager;

public class AbstractPaddingStyleClassItem_Behavior {
  private static Class[] PARAMETERS_1226492824000 = {SNode.class};

  public static void init(SNode thisNode) {
  }

  public static boolean virtual_isApplicableTo_1214304723440(SNode thisNode, SNode cellModel) {
    return SNodeOperations.isInstanceOf(cellModel, "jetbrains.mps.lang.editor.structure.CellModel_AbstractLabel");
  }

  public static boolean virtual_canUseSpaces_1226492824000(SNode thisNode) {
    return true;
  }

  public static boolean call_canUseSpaces_1226492824000(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (Boolean) descriptor.invoke(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.lang.editor.structure.AbstractPaddingStyleClassItem"), "virtual_canUseSpaces_1226492824000", PARAMETERS_1226492824000);
  }

  public static boolean callSuper_canUseSpaces_1226492824000(SNode thisNode, String callerConceptFqName) {
    return (Boolean) BehaviorManager.getInstance().invokeSuper(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.lang.editor.structure.AbstractPaddingStyleClassItem"), callerConceptFqName, "virtual_canUseSpaces_1226492824000", PARAMETERS_1226492824000);
  }
}
