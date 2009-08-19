package jetbrains.mps.lang.typesystem.typesystem;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import java.util.List;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;

public class RulesUtil {
  public static final Object MAY_BE_VARIABLE = new Object();

  public static boolean withinInferenceItem(SNode node) {
    if ((SNodeOperations.getAncestor(node, "jetbrains.mps.lang.typesystem.structure.InferenceRule", false, false) != null)) {
      return true;
    }
    if ((SNodeOperations.getAncestor(node, "jetbrains.mps.lang.typesystem.structure.InequationReplacementRule", false, false) != null)) {
      return true;
    }
    List<SNode> annotations = SLinkOperations.getTargets(SNodeOperations.getAncestor(node, "jetbrains.mps.baseLanguage.structure.BaseMethodDeclaration", false, false), "annotation", true);
    for (SNode annotation : annotations) {
      if (SLinkOperations.getTarget(annotation, "annotation", false) == SLinkOperations.getTarget(new _Quotations.QuotationClass_15().createNode(), "classifier", false)) {
        return true;
      }
    }
    return false;
  }

  public static boolean withinCheckingItem(SNode node) {
    if ((SNodeOperations.getAncestor(node, "jetbrains.mps.lang.typesystem.structure.AbstractSubtypingRule", true, false) != null)) {
      return true;
    }
    if ((SNodeOperations.getAncestor(node, "jetbrains.mps.lang.typesystem.structure.AbstractCheckingRule", true, false) != null)) {
      return true;
    }
    List<SNode> annotations = SLinkOperations.getTargets(SNodeOperations.getAncestor(node, "jetbrains.mps.baseLanguage.structure.BaseMethodDeclaration", true, false), "annotation", true);
    for (SNode annotation : annotations) {
      if (SLinkOperations.getTarget(annotation, "annotation", false) == SLinkOperations.getTarget(new _Quotations.QuotationClass_54().createNode(), "classifier", false) || SLinkOperations.getTarget(annotation, "annotation", false) == SLinkOperations.getTarget(new _Quotations.QuotationClass_55().createNode(), "classifier", false)) {
        return true;
      }
    }
    return false;
  }
}
