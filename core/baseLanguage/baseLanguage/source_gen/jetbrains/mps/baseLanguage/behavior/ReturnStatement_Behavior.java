package jetbrains.mps.baseLanguage.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import java.util.List;
import jetbrains.mps.baseLanguage.collections.internal.query.ListOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.baseLanguage.behavior.ConceptFunction_Behavior;
import jetbrains.mps.baseLanguage.behavior.IStatementListContainer_Behavior;

public class ReturnStatement_Behavior {

  public static void init(SNode thisNode) {
  }

  public static List<SNode> call_getFinallyBlocks_1213877501572(SNode thisNode) {
    List<SNode> result = ListOperations.<SNode>createList();
    SNode current = thisNode;
    while (true) {
      if (SNodeOperations.isInstanceOf(current, "jetbrains.mps.baseLanguage.structure.TryStatement")) {
        SNode tryStatement = SNodeOperations.cast(current, "jetbrains.mps.baseLanguage.structure.TryStatement");
        if ((SLinkOperations.getTarget(tryStatement, "finallyBody", true) != null) && SLinkOperations.getTarget(tryStatement, "finallyBody", true) != SNodeOperations.getParent(thisNode)) {
          ListSequence.fromList(result).addElement(SLinkOperations.getTarget(tryStatement, "finallyBody", true));
        }
      }
      current = SNodeOperations.getParent(current);
      if (!(SNodeOperations.isInstanceOf(current, "jetbrains.mps.baseLanguage.structure.Statement")) && !(SNodeOperations.isInstanceOf(current, "jetbrains.mps.baseLanguage.structure.StatementList"))) {
        break;
      }
    }
    return result;
  }

  public static SNode virtual_deriveType_1213877435747(SNode thisNode, SNode expression) {
    SNode type = null;
    if (SNodeOperations.getParent(expression) == thisNode && SNodeOperations.hasRole(expression, "jetbrains.mps.baseLanguage.structure.ReturnStatement", "expression")) {
      SNode ancestor = SNodeOperations.getAncestor(thisNode, null, false, false);
      if (SNodeOperations.isInstanceOf(ancestor, "jetbrains.mps.baseLanguage.structure.BaseMethodDeclaration")) {
        type = SNodeOperations.copyNode(SLinkOperations.getTarget(SNodeOperations.cast(ancestor, "jetbrains.mps.baseLanguage.structure.BaseMethodDeclaration"), "returnType", true));
      } else
      {
        SNode expectedReturnType = ConceptFunction_Behavior.call_getExpectedReturnType_1213877374441(SNodeOperations.cast(ancestor, "jetbrains.mps.baseLanguage.structure.ConceptFunction"));
        if (SNodeOperations.isInstanceOf(expectedReturnType, "jetbrains.mps.baseLanguage.structure.Type")) {
          type = SNodeOperations.cast(SNodeOperations.copyNode(expectedReturnType), "jetbrains.mps.baseLanguage.structure.Type");
        }
      }
    }
    return type;
  }

  public static SNode call_getReturnJumpTarget_1229351767970(SNode thisNode) {
    SNode container = SNodeOperations.getAncestor(thisNode, "jetbrains.mps.baseLanguage.structure.IStatementListContainer", false, false);
    if (IStatementListContainer_Behavior.call_isExecuteSynchronous_1230212745736(container)) {
      return SLinkOperations.getTarget(SNodeOperations.cast(container, "jetbrains.mps.baseLanguage.closures.structure.ClosureLiteral"), "body", true);
    }
    return null;
  }

  public static boolean virtual_isGuardClauseStatement_1237547327995(SNode thisNode) {
    if (SNodeOperations.isInstanceOf(SLinkOperations.getTarget(thisNode, "expression", true), "jetbrains.mps.baseLanguage.structure.DotExpression")) {
      return false;
    }
    return true;
  }

}
