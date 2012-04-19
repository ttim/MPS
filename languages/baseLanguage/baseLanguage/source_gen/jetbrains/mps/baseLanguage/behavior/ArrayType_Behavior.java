package jetbrains.mps.baseLanguage.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.core.behavior.BaseConcept_Behavior;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.util.NameUtil;

public class ArrayType_Behavior {
  public static void init(SNode thisNode) {
  }

  public static String virtual_getPresentation_1213877396640(SNode thisNode) {
    if (SLinkOperations.getTarget(thisNode, "componentType", true) == null) {
      return "???[]";
    }
    return BaseConcept_Behavior.call_getPresentation_1213877396640(SLinkOperations.getTarget(thisNode, "componentType", true)) + "[]";
  }

  public static String virtual_getErasureSignature_1213877337313(SNode thisNode) {
    return Type_Behavior.call_getErasureSignature_1213877337313(SLinkOperations.getTarget(thisNode, "componentType", true)) + "[]";
  }

  public static SNode virtual_getErasure_702942408396803226(SNode thisNode) {
    SNode result = SNodeOperations.copyNode(thisNode);
    SLinkOperations.setTarget(result, "componentType", Type_Behavior.call_getErasure_702942408396803226(SLinkOperations.getTarget(result, "componentType", true)), true);
    return result;
  }

  public static SNode virtual_getJavaType_1213877337345(SNode thisNode) {
    SNode result = SNodeOperations.copyNode(thisNode);
    SLinkOperations.setTarget(result, "componentType", Type_Behavior.call_getJavaType_1213877337345(SLinkOperations.getTarget(result, "componentType", true)), true);
    return result;
  }

  public static SNode virtual_getClassExpression_1213877337357(SNode thisNode) {
    SNode expr = SConceptOperations.createNewNode("jetbrains.mps.baseLanguage.structure.ArrayClassExpression", null);
    SLinkOperations.setTarget(expr, "arrayType", SNodeOperations.cast(Type_Behavior.call_getErasure_702942408396803226(thisNode), "jetbrains.mps.baseLanguage.structure.ArrayType"), true);
    return expr;
  }

  public static List<String> virtual_getVariableSuffixes_1213877337304(SNode thisNode) {
    List<String> variableSuffixes = ListSequence.fromListAndArray(new ArrayList<String>(), "array");
    if ((SLinkOperations.getTarget(thisNode, "componentType", true) != null)) {
      if (Type_Behavior.call_hasPluralVariableSuffixes_1447667470349154499(SLinkOperations.getTarget(thisNode, "componentType", true))) {
        for (String suffix : ListSequence.fromList(Type_Behavior.call_getVariableSuffixes_1213877337304(SLinkOperations.getTarget(thisNode, "componentType", true)))) {
          if (!(ListSequence.fromList(variableSuffixes).contains(suffix))) {
            ListSequence.fromList(variableSuffixes).addElement(suffix);
          }
        }
      } else {
        for (String suffix : ListSequence.fromList(Type_Behavior.call_getVariableSuffixes_1213877337304(SLinkOperations.getTarget(thisNode, "componentType", true)))) {
          ListSequence.fromList(variableSuffixes).addElement(NameUtil.pluralize(suffix));
        }
      }
    }
    return variableSuffixes;
  }

  public static boolean virtual_hasPluralVariableSuffixes_1447667470349154499(SNode thisNode) {
    return true;
  }

  public static SNode virtual_getAbstractCreator_1213877337340(SNode thisNode) {
    SNode arrayCreator = SConceptOperations.createNewNode("jetbrains.mps.baseLanguage.structure.ArrayCreator", null);
    SNode type = SLinkOperations.getTarget(thisNode, "componentType", true);
    while (SNodeOperations.isInstanceOf(type, "jetbrains.mps.baseLanguage.structure.ArrayType")) {
      type = SLinkOperations.getTarget(SNodeOperations.cast(type, "jetbrains.mps.baseLanguage.structure.ArrayType"), "componentType", true);
      SLinkOperations.addNewChild(arrayCreator, "dimensionExpression", "jetbrains.mps.baseLanguage.structure.DimensionExpression");
    }
    SLinkOperations.setTarget(arrayCreator, "componentType", SNodeOperations.copyNode(type), true);
    return arrayCreator;
  }

  public static String virtual_jniSignature_8847328628797633411(SNode thisNode) {
    return "[" + Type_Behavior.call_jniSignature_8847328628797633411(SLinkOperations.getTarget(thisNode, "componentType", true));
  }

  public static boolean virtual_isReifiable_2817265908000464118(SNode thisNode) {
    return Type_Behavior.call_isReifiable_2817265908000464118(SLinkOperations.getTarget(thisNode, "componentType", true));
  }
}
