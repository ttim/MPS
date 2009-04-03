package jetbrains.mps.lang.typesystem.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.typesystem.behavior._Quotations;
import jetbrains.mps.baseLanguage.typesystem.RulesFunctions_BaseLanguage;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import java.util.Set;
import jetbrains.mps.internal.collections.runtime.SetSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.typesystem.inference.TypeChecker;

public class FindSourceBlock_Behavior {

  public static void init(SNode thisNode) {
  }

  public static SNode virtual_getExpectedReturnType_1213877374441(SNode thisNode) {
    return new _Quotations.QuotationClass_0().createNode();
  }

  public static boolean call_isSet_1213877521577(SNode thisNode) {
    Iterable<SNode> returnStatements = RulesFunctions_BaseLanguage.collectReturnStatements(thisNode);
    SNode lastStatement = ListSequence.fromList(SLinkOperations.getTargets(SLinkOperations.getTarget(thisNode, "body", true), "statement", true)).last();
    Set<SNode> expressions = SetSequence.<SNode>fromArray();
    for(SNode returnStatement : returnStatements) {
      SetSequence.fromSet(expressions).addElement(SLinkOperations.getTarget(returnStatement, "expression", true));
    }
    if (SNodeOperations.isInstanceOf(lastStatement, "jetbrains.mps.baseLanguage.structure.ExpressionStatement")) {
      SetSequence.fromSet(expressions).addElement(SLinkOperations.getTarget(SNodeOperations.cast(lastStatement, "jetbrains.mps.baseLanguage.structure.ExpressionStatement"), "expression", true));
    }
    for(SNode expr : expressions) {
      SNode type = TypeChecker.getInstance().getTypeOf(expr);
      if (TypeChecker.getInstance().getSubtypingManager().isSubtype(type, new _Quotations.QuotationClass_1().createNode()) && !(SNodeOperations.isInstanceOf(type, "jetbrains.mps.baseLanguage.structure.NullType"))) {
        return true;
      }
    }
    return false;
  }

}
