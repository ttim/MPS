package jetbrains.mps.baseLanguage.checkedDots.generator.template.main;

/*Generated by MPS */

import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.generator.template.PropertyMacroContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.generator.template.SourceSubstituteMacroNodeContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.typesystem.inference.TypeChecker;

public class QueriesGenerated {
  public static Object propertyMacro_GetPropertyValue_4549711462050029098(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return "check_" + _context.getNode().getId();
  }

  public static SNode sourceNodeQuery_4549711462050028768(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "operation", true);
  }

  public static SNode sourceNodeQuery_7907427828436736378(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return TypeChecker.getInstance().getTypeOf(SLinkOperations.getTarget(_context.getNode(), "operand", true));
  }

  public static SNode sourceNodeQuery_7907427828436735258(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "operand", true);
  }
}
