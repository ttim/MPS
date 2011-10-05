package jetbrains.mps.baseLanguage.util.plugin.refactorings;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;

public class MethodOptimizer {
  public MethodOptimizer() {
  }

  public static void optimize(SNode body) {
    SNode lastStatement = ListSequence.fromList(SLinkOperations.getTargets(body, "statement", true)).last();
    if (SNodeOperations.isInstanceOf(lastStatement, "jetbrains.mps.baseLanguage.structure.ReturnStatement")) {
      SNode lastReturn = SNodeOperations.cast(lastStatement, "jetbrains.mps.baseLanguage.structure.ReturnStatement");
      if (SNodeOperations.isInstanceOf(SLinkOperations.getTarget(lastReturn, "expression", true), "jetbrains.mps.baseLanguage.structure.LocalVariableReference")) {
        optimizeAssignmentFollowedByReturn(body, lastReturn, SNodeOperations.cast(SLinkOperations.getTarget(lastReturn, "expression", true), "jetbrains.mps.baseLanguage.structure.LocalVariableReference"));
      }
      if (SNodeOperations.isInstanceOf(SLinkOperations.getTarget(lastReturn, "expression", true), "jetbrains.mps.baseLanguage.structure.LocalVariableReference")) {
        optimizeVariableFollowedByReturn(body, lastReturn, SNodeOperations.cast(SLinkOperations.getTarget(lastReturn, "expression", true), "jetbrains.mps.baseLanguage.structure.LocalVariableReference"));
      }
    }
    // <node> 
  }

  public static void removeUnusedDeclarations(SNode body) {
    List<SNode> references = SNodeOperations.getDescendants(body, "jetbrains.mps.baseLanguage.structure.LocalVariableReference", false, new String[]{});
    for (SNode declaration : ListSequence.fromList(SNodeOperations.getDescendants(body, "jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration", false, new String[]{}))) {
      removeUnusedDeclaration(references, declaration);
    }
  }

  public static void removeUnusedDeclaration(List<SNode> references, final SNode declaration) {
    if (ListSequence.fromList(references).where(new IWhereFilter<SNode>() {
      public boolean accept(SNode it) {
        return SLinkOperations.getTarget(it, "variableDeclaration", false) == declaration;
      }
    }).isEmpty() && SNodeOperations.isInstanceOf(SNodeOperations.getParent(declaration), "jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement")) {
      SNodeOperations.deleteNode(SNodeOperations.getParent(declaration));
    }
  }

  public static void optimizeAssignmentFollowedByReturn(SNode body, SNode lastReturn, SNode variableReference) {
    List<SNode> statements = SLinkOperations.getTargets(body, "statement", true);
    int size = ListSequence.fromList(statements).count();
    if (size < 2) {
      return;
    }
    // what if statement is not on line of size -2? 
    SNode beforeLastStatement = ListSequence.fromList(statements).getElement(size - 2);
    if (SNodeOperations.isInstanceOf(beforeLastStatement, "jetbrains.mps.baseLanguage.structure.ExpressionStatement")) {
      SNode expressionStatement = SNodeOperations.cast(beforeLastStatement, "jetbrains.mps.baseLanguage.structure.ExpressionStatement");
      if (SNodeOperations.isInstanceOf(SLinkOperations.getTarget(expressionStatement, "expression", true), "jetbrains.mps.baseLanguage.structure.AssignmentExpression")) {
        SNode assignment = SNodeOperations.cast(SLinkOperations.getTarget(expressionStatement, "expression", true), "jetbrains.mps.baseLanguage.structure.AssignmentExpression");
        if (SNodeOperations.isInstanceOf(SLinkOperations.getTarget(assignment, "lValue", true), "jetbrains.mps.baseLanguage.structure.LocalVariableReference")) {
          SNode reference2 = SNodeOperations.cast(SLinkOperations.getTarget(assignment, "lValue", true), "jetbrains.mps.baseLanguage.structure.LocalVariableReference");
          if (SLinkOperations.getTarget(variableReference, "variableDeclaration", false) == SLinkOperations.getTarget(reference2, "variableDeclaration", false)) {
            SLinkOperations.setTarget(lastReturn, "expression", SLinkOperations.getTarget(assignment, "rValue", true), true);
            SNodeOperations.deleteNode(beforeLastStatement);

            if (SNodeOperations.isInstanceOf(SLinkOperations.getTarget(variableReference, "variableDeclaration", false), "jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration")) {
              removeUnusedDeclaration(SNodeOperations.getDescendants(body, "jetbrains.mps.baseLanguage.structure.LocalVariableReference", false, new String[]{}), SNodeOperations.cast(SLinkOperations.getTarget(variableReference, "variableDeclaration", false), "jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration"));

            }

          }
        }
      }
    }
  }

  public static void optimizeVariableFollowedByReturn(SNode body, SNode lastReturn, SNode variableReference) {
    List<SNode> statements = SLinkOperations.getTargets(body, "statement", true);
    int size = ListSequence.fromList(statements).count();
    if (size < 2) {
      return;
    }
    SNode berforeLastStatement = ListSequence.fromList(statements).getElement(size - 2);
    if (SNodeOperations.isInstanceOf(berforeLastStatement, "jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement")) {
      SNode declarationStatement = SNodeOperations.cast(berforeLastStatement, "jetbrains.mps.baseLanguage.structure.LocalVariableDeclarationStatement");
      if (SLinkOperations.getTarget(declarationStatement, "localVariableDeclaration", true) == SLinkOperations.getTarget(variableReference, "variableDeclaration", false)) {
        SLinkOperations.setTarget(lastReturn, "expression", SLinkOperations.getTarget(SLinkOperations.getTarget(declarationStatement, "localVariableDeclaration", true), "initializer", true), true);
        SNodeOperations.deleteNode(berforeLastStatement);
      }
    }
  }
}
