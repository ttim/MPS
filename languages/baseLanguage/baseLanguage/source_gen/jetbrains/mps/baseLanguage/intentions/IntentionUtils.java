package jetbrains.mps.baseLanguage.intentions;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;

public class IntentionUtils {
  private IntentionUtils() {
  }

  /*package*/ static SNode optimizeNode(SNode _node) {
    if ((_node == null)) {
      return null;
    }
    {
      SNode concept_b0a;
      {
        SNode node_b0a = _node;
        concept_b0a = SNodeOperations.getConceptDeclaration(node_b0a);
      }
      if (SConceptOperations.isSubConceptOf(concept_b0a, "jetbrains.mps.baseLanguage.structure.StatementList")) {
        {
          // todo: update concept switch 
          SNode node = SNodeOperations.cast(_node, "jetbrains.mps.baseLanguage.structure.StatementList");
          return ((int) ListSequence.fromList(SLinkOperations.getTargets(node, "statement", true)).count() == 1 ?
            optimizeNode(ListSequence.fromList(SLinkOperations.getTargets(node, "statement", true)).getElement(0)) :
            null
          );
        }
      }
      if (SConceptOperations.isSubConceptOf(concept_b0a, "jetbrains.mps.baseLanguage.structure.BlockStatement")) {
        return optimizeNode(SLinkOperations.getTarget(SNodeOperations.cast(_node, "jetbrains.mps.baseLanguage.structure.BlockStatement"), "statements", true));
      }
    }
    return _node;
  }

  /*package*/ static SNode getReturnedExpression(SNode _node) {
    SNode optimized = optimizeNode(_node);
    if ((optimized != null) && SNodeOperations.isInstanceOf(optimized, "jetbrains.mps.baseLanguage.structure.ReturnStatement")) {
      return SLinkOperations.getTarget(SNodeOperations.cast(optimized, "jetbrains.mps.baseLanguage.structure.ReturnStatement"), "expression", true);
    } else {
      return null;
    }
  }

  /*package*/ static SNode getExpressionFromNode(SNode _node) {
    SNode optimized = optimizeNode(_node);
    if ((optimized != null) && SNodeOperations.isInstanceOf(optimized, "jetbrains.mps.baseLanguage.structure.ExpressionStatement")) {
      return SLinkOperations.getTarget(SNodeOperations.cast(optimized, "jetbrains.mps.baseLanguage.structure.ExpressionStatement"), "expression", true);
    } else {
      return null;
    }
  }
}
