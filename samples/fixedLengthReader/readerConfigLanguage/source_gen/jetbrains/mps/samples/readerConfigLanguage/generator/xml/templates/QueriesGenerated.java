package jetbrains.mps.samples.readerConfigLanguage.generator.xml.templates;

/*Generated by MPS */

import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.generator.template.PropertyMacroContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.generator.template.SourceSubstituteMacroNodesContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;

public class QueriesGenerated {
  public static Object propertyMacro_GetPropertyValue_8981739865593616941(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(_context.getNode(), "code");
  }

  public static Object propertyMacro_GetPropertyValue_8981739865593616976(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(_context.getNode(), "targetClass");
  }

  public static Object propertyMacro_GetPropertyValue_8981739865593616871(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(_context.getNode(), "name");
  }

  public static Object propertyMacro_GetPropertyValue_8981739865593616909(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return "" + SPropertyOperations.getInteger(_context.getNode(), "start");
  }

  public static Object propertyMacro_GetPropertyValue_8981739865593616926(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return "" + SPropertyOperations.getInteger(_context.getNode(), "end");
  }

  public static Object propertyMacro_GetPropertyValue_8981739865593585265(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(_context.getNode(), "name");
  }

  public static Iterable sourceNodesQuery_8981739865593616827(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "mapping", true);
  }

  public static Iterable sourceNodesQuery_8981739865593616836(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "field", true);
  }
}
