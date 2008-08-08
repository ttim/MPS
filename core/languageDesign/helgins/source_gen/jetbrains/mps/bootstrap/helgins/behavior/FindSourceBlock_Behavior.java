package jetbrains.mps.bootstrap.helgins.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.baseLanguage.helgins.RulesFunctions_BaseLanguage;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.helgins.inference.TypeChecker;

public class FindSourceBlock_Behavior {

  public static void init(SNode thisNode) {
  }

  public static SNode virtual_getExpectedReturnType_1213877374441(SNode thisNode) {
    return new QuotationClass_0().createNode();
  }

  public static boolean call_isSet_1213877521577(SNode thisNode) {
    Iterable<SNode> returnStatements = RulesFunctions_BaseLanguage.collectReturnStatements(thisNode);
    SNode lastStatement = ListSequence.fromList(SLinkOperations.getTargets(SLinkOperations.getTarget(thisNode, "body", true), "statement", true)).last();
    Set<SNode> expressions = new HashSet<SNode>();
    for(SNode returnStatement : returnStatements) {
      expressions.add(SLinkOperations.getTarget(returnStatement, "expression", true));
    }
    if (SNodeOperations.isInstanceOf(lastStatement, "jetbrains.mps.baseLanguage.structure.ExpressionStatement")) {
      expressions.add(SLinkOperations.getTarget(lastStatement, "expression", true));
    }
    for(SNode expr : expressions) {
      SNode type = TypeChecker.getInstance().getTypeOf(expr);
      if (TypeChecker.getInstance().getSubtypingManager().isSubtype(type, new QuotationClass_1().createNode()) && !(SNodeOperations.isInstanceOf(type, "jetbrains.mps.baseLanguage.structure.NullType"))) {
        return true;
      }
    }
    return false;
  }

}
