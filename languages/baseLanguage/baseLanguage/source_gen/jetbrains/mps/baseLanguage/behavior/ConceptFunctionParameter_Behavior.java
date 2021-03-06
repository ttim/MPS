package jetbrains.mps.baseLanguage.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptPropertyOperations;
import java.util.List;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.smodel.runtime.BehaviorDescriptor;
import jetbrains.mps.smodel.language.ConceptRegistry;
import jetbrains.mps.smodel.behaviour.BehaviorManager;

public class ConceptFunctionParameter_Behavior {
  private static Class[] PARAMETERS_1213877522908 = {SNode.class};
  private static Class[] PARAMETERS_1213877522926 = {SNode.class};
  private static Class[] PARAMETERS_1236687728308 = {SNode.class};

  public static void init(SNode thisNode) {
  }

  public static boolean virtual_getFromParameterObject_1213877522908(SNode thisNode) {
    if (!(ConceptFunctionParameter_Behavior.call_isParameterObjectUsed_1213877522926(thisNode))) {
      return false;
    }
    return ConceptFunction_Behavior.call_usesParameterObjectFor_1213877374432(ConceptFunctionParameter_Behavior.call_findConceptFunction_1213877522934(thisNode), thisNode);
  }

  public static boolean virtual_isParameterObjectUsed_1213877522926(SNode thisNode) {
    return !(SConceptPropertyOperations.getBoolean(thisNode, "dontUseParameterObject"));
  }

  public static SNode call_findConceptFunction_1213877522934(SNode thisNode) {
    List<SNode> functions = SNodeOperations.getAncestors(thisNode, "jetbrains.mps.baseLanguage.structure.ConceptFunction", false);
    final SNode ourConcept = SNodeOperations.getConceptDeclaration(thisNode);
    return ListSequence.fromList(functions).where(new IWhereFilter<SNode>() {
      public boolean accept(SNode it) {
        return ListSequence.fromList(SLinkOperations.getConceptLinkTargets(it, "conceptFunctionParameter")).contains(ourConcept) || ListSequence.fromList(SLinkOperations.getConceptLinkTargets(it, "applicableConceptFunctionParameter")).contains(ourConcept);
      }
    }).first();
  }

  public static String virtual_getParameterName_1225280611056(SNode thisNode) {
    return SConceptPropertyOperations.getString(thisNode, "alias");
  }

  public static SNode virtual_getDeclaration_1225282371351(SNode thisNode) {
    return SNodeOperations.getConceptDeclaration(thisNode);
  }

  public static boolean virtual_needConceptFunction_1236687728308(SNode thisNode) {
    return true;
  }

  public static boolean call_getFromParameterObject_1213877522908(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (Boolean) descriptor.invoke(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.ConceptFunctionParameter"), "virtual_getFromParameterObject_1213877522908", PARAMETERS_1213877522908, new Object[]{});
  }

  public static boolean call_isParameterObjectUsed_1213877522926(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (Boolean) descriptor.invoke(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.ConceptFunctionParameter"), "virtual_isParameterObjectUsed_1213877522926", PARAMETERS_1213877522926, new Object[]{});
  }

  public static boolean call_needConceptFunction_1236687728308(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (Boolean) descriptor.invoke(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.ConceptFunctionParameter"), "virtual_needConceptFunction_1236687728308", PARAMETERS_1236687728308, new Object[]{});
  }

  public static boolean callSuper_getFromParameterObject_1213877522908(SNode thisNode, String callerConceptFqName) {
    return (Boolean) BehaviorManager.getInstance().invokeSuper(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.ConceptFunctionParameter"), callerConceptFqName, "virtual_getFromParameterObject_1213877522908", PARAMETERS_1213877522908, new Object[]{});
  }

  public static boolean callSuper_isParameterObjectUsed_1213877522926(SNode thisNode, String callerConceptFqName) {
    return (Boolean) BehaviorManager.getInstance().invokeSuper(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.ConceptFunctionParameter"), callerConceptFqName, "virtual_isParameterObjectUsed_1213877522926", PARAMETERS_1213877522926, new Object[]{});
  }

  public static boolean callSuper_needConceptFunction_1236687728308(SNode thisNode, String callerConceptFqName) {
    return (Boolean) BehaviorManager.getInstance().invokeSuper(Boolean.class, SNodeOperations.cast(thisNode, "jetbrains.mps.baseLanguage.structure.ConceptFunctionParameter"), callerConceptFqName, "virtual_needConceptFunction_1236687728308", PARAMETERS_1236687728308, new Object[]{});
  }
}
