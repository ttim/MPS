package jetbrains.mps.transformation.test.inputLang.generator.outputLang.template.test_reduceExpressionToStatement;

/*Generated by MPS */

import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.generator.template.BaseMappingRuleContext;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.generator.template.SourceSubstituteMacroNodeContext;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;

public class QueriesGenerated {

  public static boolean baseMappingRule_Condition_1209150502311(final IOperationContext operationContext, final BaseMappingRuleContext _context) {
    return SPropertyOperations.hasValue(_context.getNode(), "useInTest", "reduceExpressionToStatement", "none");
  }

  public static boolean baseMappingRule_Condition_1209150617830(final IOperationContext operationContext, final BaseMappingRuleContext _context) {
    return SPropertyOperations.hasValue(SNodeOperations.getContainingRoot(_context.getNode()), "useInTest", "reduceExpressionToStatement", "none");
  }

  public static SNode sourceNodeQuery_1209150187921(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "statementList", true);
  }

}
