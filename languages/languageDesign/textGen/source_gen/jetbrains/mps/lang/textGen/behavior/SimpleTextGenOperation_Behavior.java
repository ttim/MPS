package jetbrains.mps.lang.textGen.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptPropertyOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.runtime.BehaviorDescriptor;
import jetbrains.mps.smodel.language.ConceptRegistry;
import jetbrains.mps.smodel.behaviour.BehaviorManager;

public class SimpleTextGenOperation_Behavior {
  private static Class[] PARAMETERS_1234789420862 = {SNode.class};

  public static void init(SNode thisNode) {
  }

  public static String virtual_getMethodName_1234789420862(SNode thisNode) {
    String name = SConceptPropertyOperations.getString(thisNode, "alias");
    if (name == null || name.length() <= 1) {
      return name;
    }
    StringBuilder result = new StringBuilder();
    boolean space = false;
    for (int i = 0; i < name.length(); i += (space ?
      2 :
      1
    )) {
      space = Character.isWhitespace(name.charAt(i));
      if (!(space)) {
        result.append(name.charAt(i));
      } else if (i < name.length() - 1) {
        result.append(name.toUpperCase().charAt(i + 1));
      }
    }
    return result.toString();
  }

  public static boolean call_inLangConcept_1236168713983(SNode thisNode) {
    return SNodeOperations.isInstanceOf((SNodeOperations.getAncestor(thisNode, "jetbrains.mps.lang.textGen.structure.AbstractTextGenDeclaration", false, false)), "jetbrains.mps.lang.textGen.structure.LanguageTextGenDeclaration");
  }

  public static String call_getMethodName_1234789420862(SNode thisNode) {
    BehaviorDescriptor descriptor = ConceptRegistry.getInstance().getBehaviorDescriptorForInstanceNode(thisNode);
    return (String) descriptor.invoke(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.lang.textGen.structure.SimpleTextGenOperation"), "virtual_getMethodName_1234789420862", PARAMETERS_1234789420862);
  }

  public static String callSuper_getMethodName_1234789420862(SNode thisNode, String callerConceptFqName) {
    return (String) BehaviorManager.getInstance().invokeSuper(Object.class, SNodeOperations.cast(thisNode, "jetbrains.mps.lang.textGen.structure.SimpleTextGenOperation"), callerConceptFqName, "virtual_getMethodName_1234789420862", PARAMETERS_1234789420862);
  }
}
