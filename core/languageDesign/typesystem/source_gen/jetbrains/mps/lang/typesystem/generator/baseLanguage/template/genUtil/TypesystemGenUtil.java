package jetbrains.mps.lang.typesystem.generator.baseLanguage.template.genUtil;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import java.util.List;
import jetbrains.mps.typesystem.inference.TypeChecker;

public class TypesystemGenUtil {

  public TypesystemGenUtil() {
  }

  public static boolean isInCheckEquation(SNode node) {
    SNode current = node;
    SNode oldCurrent = null;
    while (current != null) {
      oldCurrent = current;
      current = SNodeOperations.getAncestor(current, "jetbrains.mps.baseLanguage.structure.AnonymousClass", false, false);
    }
    return "checkInequation".equals(SPropertyOperations.getString(SNodeOperations.getAncestor(oldCurrent, "jetbrains.mps.baseLanguage.structure.BaseMethodDeclaration", false, false), "name"));
  }

  public static boolean isInRuleWithContext(SNode node) {
    SNode root = SNodeOperations.getContainingRoot(node);
    if (SNodeOperations.isInstanceOf(root, "jetbrains.mps.lang.typesystem.structure.AbstractCheckingRule")) {
      return true;
    }
    SNode baseMethodDeclaration = SNodeOperations.getAncestor(node, "jetbrains.mps.baseLanguage.structure.BaseMethodDeclaration", false, false);
    if ((baseMethodDeclaration != null)) {
      for(SNode annotationInstance : SLinkOperations.getTargets(baseMethodDeclaration, "annotation", true)) {
        SNode annotation = SLinkOperations.getTarget(annotationInstance, "annotation", false);
        if (annotation == SLinkOperations.getTarget(new _Quotations.QuotationClass_1().createNode(), "classifier", false) || annotation == SLinkOperations.getTarget(new _Quotations.QuotationClass_0().createNode(), "classifier", false)) {
          return true;
        }
      }
    }
    return false;
  }

  public static boolean returnsNode(SNode subtypingRule) {
    List<SNode> returnStatements = SNodeOperations.getDescendants(subtypingRule, "jetbrains.mps.baseLanguage.structure.ReturnStatement", false, new String[]{"jetbrains.mps.baseLanguage.closures.structure.ClosureLiteral","jetbrains.mps.baseLanguage.structure.AnonymousClass","jetbrains.mps.baseLanguage.structure.BaseMethodDeclaration"});
    for(SNode retSt : returnStatements) {
      if (!(TypeChecker.getInstance().getSubtypingManager().isSubtype(TypeChecker.getInstance().getTypeOf(SLinkOperations.getTarget(retSt, "expression", true)), new _Quotations.QuotationClass_2().createNode()))) {
        return false;
      }
    }
    return true;
  }

}
