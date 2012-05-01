package jetbrains.mps.lang.textGen.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptPropertyOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.runtime.BehaviorDescriptor;
import jetbrains.mps.smodel.language.ConceptRegistry;
import jetbrains.mps.smodel.behaviour.BehaviorManager;

public class AbstractTextGenParameter_Behavior {
  private static Class[] PARAMETERS_1234885318469 = {SNode.class};

  public static void init(SNode thisNode) {
  }

  public static String virtual_getGetterName_1234885318469(SNode thisNode) {
    String alias = SConceptPropertyOperations.getString(thisNode, "alias");
    StringBuilder builder = new StringBuilder("get");
    for (int i = 0; i < alias.length(); i++) {
      char ch = alias.charAt(i);
      if (i == 0) {
        builder.append(alias.toUpperCase().charAt(i));
      } else {
        builder.append(ch);
      }
    }
    return builder.toString();
  }

  public static boolean call_inLangConcept_1236168601263(SNode thisNode) {
    return SNodeOperations.isInstanceOf((SNodeOperations.getAncestor(thisNode, "jetbrains.mps.lang.textGen.structure.AbstractTextGenDeclaration", false, false)), "jetbrains.mps.lang.textGen.structure.LanguageTextGenDeclaration");
  }

  public static boolean virtual_needConceptFunction_1236687728308(SNode thisNode) {
    return false;
  }

  public static String call_getGetterName_1234885318469(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (String) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.lang.textGen.structure.AbstractTextGenParameter"), "virtual_getGetterName_1234885318469", PARAMETERS_1234885318469);
  }

  public static String callSuper_getGetterName_1234885318469(SNode thisNode, String callerConceptFqName) {
    return (String) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.lang.textGen.structure.AbstractTextGenParameter"), callerConceptFqName, "virtual_getGetterName_1234885318469", PARAMETERS_1234885318469);
  }
}
