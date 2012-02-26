package jetbrains.mps.baseLanguage.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;

public class EnumClass_Behavior {
  public static void init(SNode thisNode) {
  }

  public static SNode call_findConstantByName_1213877267258(SNode thisNode, String name) {
    for (SNode constant : SLinkOperations.getTargets(thisNode, "enumConstant", true)) {
      if (name.equalsIgnoreCase(SPropertyOperations.getString(constant, "name"))) {
        return constant;
      }
    }
    return null;
  }

  public static List<SNode> virtual_getExtendedClassifiers_2201875424516179426(SNode thisNode) {
    List<SNode> extended = Classifier_Behavior.callSuper_getExtendedClassifiers_2201875424516179426(thisNode, "jetbrains.mps.baseLanguage.structure.EnumClass");
    if (!(ListSequence.fromList(extended).contains(SNodeOperations.getNode("f:java_stub#6354ebe7-c22a-4a0f-ac54-50b52ab9b065#java.lang(JDK/java.lang@java_stub)", "~Enum")))) {
      // todo: WTF??? 
      ListSequence.fromList(extended).addElement(SNodeOperations.getNode("f:java_stub#6354ebe7-c22a-4a0f-ac54-50b52ab9b065#java.lang(JDK/java.lang@java_stub)", "~Enum"));
    }
    return extended;
  }

  public static List<SNode> virtual_getMembers_1213877531970(SNode thisNode) {
    List<SNode> members = IMemberContainer_Behavior.callSuper_getMembers_1213877531970(thisNode, "jetbrains.mps.baseLanguage.structure.EnumClass");
    ListSequence.fromList(members).addSequence(ListSequence.fromList(SLinkOperations.getTargets(thisNode, "enumConstant", true)));
    return members;
  }

  public static boolean virtual_hasStaticMemebers_1214840444586(SNode thisNode) {
    // enums always have static operations: valueOf and values 
    return true;
  }

  public static List<SNode> virtual_getMembers_2201875424515824604(SNode thisNode, SNode kind) {
    if (SConceptOperations.isSubConceptOf(kind, "jetbrains.mps.baseLanguage.structure.EnumConstantDeclaration")) {
      return SLinkOperations.getTargets(thisNode, "enumConstant", true);
    } else {
      return Classifier_Behavior.callSuper_getMembers_2201875424515824604(thisNode, "jetbrains.mps.baseLanguage.structure.EnumClass", kind);
    }
  }
}
