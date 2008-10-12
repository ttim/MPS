package jetbrains.mps.baseLanguage.helgins;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.dependencies.InferenceMethod;
import jetbrains.mps.helgins.inference.TypeCheckingContext;
import jetbrains.mps.smodel.SNode;
import java.util.Set;
import jetbrains.mps.lang.dataFlow.DataFlow;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.intentions.BaseIntentionProvider;
import java.util.List;
import jetbrains.mps.baseLanguage.behavior.StatementList_Behavior;
import jetbrains.mps.baseLanguage.behavior.VariableReference_Behavior;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;

public class DataFlowUtil {

  public DataFlowUtil() {
  }

  @InferenceMethod()
  public static void checkDataFlow(final TypeCheckingContext typeCheckingContext, SNode statementList) {
    checkUnreachable(typeCheckingContext, statementList);
    checkUninitializedReads(typeCheckingContext, statementList);
    checkUnusedAssignments(typeCheckingContext, statementList);
    checkUnusedVariables(typeCheckingContext, statementList);
  }

  @InferenceMethod()
  public static void checkReturns(final TypeCheckingContext typeCheckingContext, SNode statementList) {
    Set<SNode> expectedReturns = DataFlow.getExpectedReturns(statementList);
    for(SNode n : expectedReturns) {
      if (n != null) {
        SNode nodeToSelect;
        SNode sl = SNodeOperations.getAncestor(n, "jetbrains.mps.baseLanguage.structure.StatementList", false, false);
        if ((sl != null) && ListSequence.fromList(SLinkOperations.getTargets(sl, "statement", true)).isNotEmpty()) {
          SNodeOperations.getAncestor(nodeToSelect = n, "jetbrains.mps.baseLanguage.structure.Statement", true, false);
        } else
        {
          nodeToSelect = SNodeOperations.getAncestor(n, "jetbrains.mps.baseLanguage.structure.StatementList", false, false);
        }
        if (nodeToSelect != null) {
          {
            BaseIntentionProvider intentionProvider = null;
            typeCheckingContext.reportTypeError(nodeToSelect, "Return expected", "r:00000000-0000-4000-0000-011c895902c5(jetbrains.mps.baseLanguage.helgins)", "1223640343628", intentionProvider);
          }
        } else
        {
          {
            BaseIntentionProvider intentionProvider = null;
            typeCheckingContext.reportTypeError(n, "Return expected", "r:00000000-0000-4000-0000-011c895902c5(jetbrains.mps.baseLanguage.helgins)", "1223640343636", intentionProvider);
          }
        }
      }
    }
  }

  @InferenceMethod()
  private static void checkUnreachable(final TypeCheckingContext typeCheckingContext, SNode statementList) {
    Set<SNode> unreachable = DataFlow.getUnreachableNodes(statementList);
    for(SNode n : unreachable) {
      {
        BaseIntentionProvider intentionProvider = null;
        typeCheckingContext.reportTypeError(n, "Unreachable node", "r:00000000-0000-4000-0000-011c895902c5(jetbrains.mps.baseLanguage.helgins)", "1223640538234", intentionProvider);
      }
    }
  }

  @InferenceMethod()
  private static void checkUninitializedReads(final TypeCheckingContext typeCheckingContext, SNode statementList) {
    Set<SNode> uninitializedReads = DataFlow.getUninitializedReads(statementList);
    List<SNode> referencedInClosures = StatementList_Behavior.call_getVariablesReferencedInClosures_1213877327584(statementList);
    for(SNode read : uninitializedReads) {
      if (SNodeOperations.isInstanceOf(read, "jetbrains.mps.baseLanguage.structure.LocalVariableReference")) {
        SNode ref = read;
        if (ListSequence.fromList(referencedInClosures).contains(SLinkOperations.getTarget(ref, "variableDeclaration", false)) || VariableReference_Behavior.call_isClosureReference_1213877348225(ref)) {
          continue;
        }
        {
          BaseIntentionProvider intentionProvider = null;
          typeCheckingContext.reportTypeError(read, "Variable used before it is initialized", "r:00000000-0000-4000-0000-011c895902c5(jetbrains.mps.baseLanguage.helgins)", "1223640624825", intentionProvider);
        }
      }
    }
  }

  @InferenceMethod()
  private static void checkUnusedAssignments(final TypeCheckingContext typeCheckingContext, SNode statementList) {
    Set<SNode> unusedAssignments = DataFlow.getUnusedAssignments(statementList);
    List<SNode> referencedInClosure = StatementList_Behavior.call_getVariablesReferencedInClosures_1213877327584(statementList);
    for(SNode write : unusedAssignments) {
      if (SNodeOperations.isInstanceOf(write, "jetbrains.mps.baseLanguage.structure.BaseAssignmentExpression")) {
        SNode assignment = write;
        if (SNodeOperations.isInstanceOf(SLinkOperations.getTarget(assignment, "lValue", true), "jetbrains.mps.baseLanguage.structure.LocalVariableReference") || SNodeOperations.isInstanceOf(SLinkOperations.getTarget(assignment, "lValue", true), "jetbrains.mps.baseLanguage.structure.ParameterReference")) {
          SNode ref = SLinkOperations.getTarget(assignment, "lValue", true);
          if (ListSequence.fromList(referencedInClosure).contains(SLinkOperations.getTarget(ref, "variableDeclaration", false)) || VariableReference_Behavior.call_isClosureReference_1213877348225(ref)) {
            continue;
          }
          {
            BaseIntentionProvider intentionProvider = null;
            intentionProvider = new BaseIntentionProvider("r:00000000-0000-4000-0000-011c895902c1(jetbrains.mps.baseLanguage.constraints).RemoveUnusedAssignment_QuickFix");
            typeCheckingContext.reportWarning(assignment, "Unused assignment", "r:00000000-0000-4000-0000-011c895902c5(jetbrains.mps.baseLanguage.helgins)", "1223642282236", intentionProvider);
          }
        }
      }
      if (SNodeOperations.isInstanceOf(write, "jetbrains.mps.baseLanguage.structure.LocalVariableDeclaration")) {
        if (ListSequence.fromList(referencedInClosure).contains(write)) {
          continue;
        }
        {
          BaseIntentionProvider intentionProvider = null;
          intentionProvider = new BaseIntentionProvider("r:00000000-0000-4000-0000-011c895902c1(jetbrains.mps.baseLanguage.constraints).RemoveUnusedAssignment_QuickFix");
          typeCheckingContext.reportWarning(write, "Unused assignment", "r:00000000-0000-4000-0000-011c895902c5(jetbrains.mps.baseLanguage.helgins)", "1223642282266", intentionProvider);
        }
      }
      if (SNodeOperations.isInstanceOf(write, "jetbrains.mps.baseLanguage.structure.ParameterDeclaration")) {
        SNode method = ((SNode)SNodeOperations.getParent(write));
        if (SPropertyOperations.getBoolean(method, "isFinal") || SNodeOperations.isInstanceOf(method, "jetbrains.mps.baseLanguage.structure.Visible") && SNodeOperations.isInstanceOf(SLinkOperations.getTarget(((SNode)method), "visibility", true), "jetbrains.mps.baseLanguage.structure.PrivateVisibility")) {
          {
            BaseIntentionProvider intentionProvider = null;
            typeCheckingContext.reportWarning(write, "Unused parameter", "r:00000000-0000-4000-0000-011c895902c5(jetbrains.mps.baseLanguage.helgins)", "1223642282287", intentionProvider);
          }
        }
      }
    }
  }

  @InferenceMethod()
  public static void checkUnusedVariables(final TypeCheckingContext typeCheckingContext, SNode statementList) {
    Set<SNode> unusedVariables = DataFlow.getUnusedVariables(statementList);
    for(SNode var : unusedVariables) {
      if (!(SNodeOperations.isInstanceOf(SNodeOperations.getParent(var), "jetbrains.mps.baseLanguage.structure.CatchClause"))) {
        {
          BaseIntentionProvider intentionProvider = null;
          typeCheckingContext.reportWarning(var, "Unused variable", "r:00000000-0000-4000-0000-011c895902c5(jetbrains.mps.baseLanguage.helgins)", "1223642399966", intentionProvider);
        }
      }
    }
  }

}
