package jetbrains.mps.debugger.decisionTable.generator.template.main;

/*Generated by MPS */

import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.generator.template.PropertyMacroContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.generator.template.ReferenceMacroContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.generator.template.SourceSubstituteMacroNodeContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.generator.template.SourceSubstituteMacroNodesContext;
import jetbrains.mps.generator.template.TemplateQueryContext;

public class QueriesGenerated {
  public static Object propertyMacro_GetPropertyValue_6487201325881289206(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return "check_" + SNodeOperations.getContainingLinkRole(_context.getNode()) + "_" + SNodeOperations.getIndexInParent(_context.getNode());
  }

  public static Object referenceMacro_GetReferent_6487201325881286712(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return _context.getOutputNodeByInputNodeAndMappingLabel(_context.getNode(), "caseToMethod");
  }

  public static Object referenceMacro_GetReferent_6487201325881288166(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return _context.getOutputNodeByInputNodeAndMappingLabel(_context.getNode(), "caseToMethod");
  }

  public static SNode sourceNodeQuery_6487201325881288334(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTargets(SNodeOperations.cast(SNodeOperations.getParent(_context.getNode()), "jetbrains.mps.debugger.decisionTable.structure.DecisionTable"), "content", true).get(SNodeOperations.getIndexInParent(_context.getNode()) * ListSequence.fromList(SLinkOperations.getTargets(SNodeOperations.cast(SNodeOperations.getParent(_context.getNode()), "jetbrains.mps.debugger.decisionTable.structure.DecisionTable"), "caseX", true)).count() + ((Integer) _context.getVariable("var:indexX")));
  }

  public static SNode sourceNodeQuery_6487201325881289290(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "expression", true);
  }

  public static SNode sourceNodeQuery_6487201325881290061(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "x", true);
  }

  public static SNode sourceNodeQuery_6487201325881290085(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "y", true);
  }

  public static Iterable sourceNodesQuery_6487201325881286636(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "caseX", true);
  }

  public static Iterable sourceNodesQuery_6487201325881286672(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "caseY", true);
  }

  public static Iterable sourceNodesQuery_6487201325881288703(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(SNodeOperations.cast(SNodeOperations.getParent(_context.getNode()), "jetbrains.mps.debugger.decisionTable.structure.DecisionTable"), "caseY", true);
  }

  public static Iterable sourceNodesQuery_6487201325881286685(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "caseX", true);
  }

  public static Object insertMacro_varValue_6487201325881288718(final IOperationContext operationContext, final TemplateQueryContext _context) {
    return SNodeOperations.getIndexInParent(_context.getNode());
  }
}
