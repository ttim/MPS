package jetbrains.mps.gwt.client.generator.template.main;

/*Generated by MPS */

import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.generator.template.PropertyMacroContext;
import jetbrains.mps.gwt.client.behavior.Element_Behavior;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.gwt.client.behavior.Attr_Behavior;
import jetbrains.mps.lang.core.behavior.INamedConcept_Behavior;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.generator.template.SourceSubstituteMacroNodeContext;
import jetbrains.mps.generator.template.SourceSubstituteMacroNodesContext;

public class QueriesGenerated {
  public static Object propertyMacro_GetPropertyValue_2968360207536878967(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return Element_Behavior.call_getXmlElement_3852159904898386595(_context.getNode());
  }

  public static Object propertyMacro_GetPropertyValue_2968360207536878977(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return ((SLinkOperations.getTarget(_context.getNode(), "path", true) != null) ?
      SPropertyOperations.getString(SLinkOperations.getTarget(_context.getNode(), "path", true), "value") :
      ""
    );
  }

  public static Object propertyMacro_GetPropertyValue_2968360207536879017(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return Attr_Behavior.call_getXmlAttr_3852159904898525999(_context.getNode());
  }

  public static Object propertyMacro_GetPropertyValue_2968360207536881405(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return Element_Behavior.call_getXmlElement_3852159904898386595(_context.getNode());
  }

  public static Object propertyMacro_GetPropertyValue_2968360207536881415(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(SLinkOperations.getTarget(_context.getNode(), "pattern", true), "value");
  }

  public static Object propertyMacro_GetPropertyValue_2968360207536881430(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return INamedConcept_Behavior.call_getFqName_1213877404258(SLinkOperations.getTarget(_context.getNode(), "entryPoint", false));
  }

  public static Object propertyMacro_GetPropertyValue_2968360207536881446(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return INamedConcept_Behavior.call_getFqName_1213877404258(SLinkOperations.getTarget(_context.getNode(), "module", false));
  }

  public static Object propertyMacro_GetPropertyValue_3852159904898263055(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(_context.getNode(), "name");
  }

  public static Object propertyMacro_GetPropertyValue_3852159904898549806(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return (SPropertyOperations.getBoolean(_context.getNode(), "value") ?
      "true" :
      "false"
    );
  }

  public static Object propertyMacro_GetPropertyValue_3852159904898556330(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return (SPropertyOperations.getBoolean(_context.getNode(), "value") ?
      "yes" :
      "no"
    );
  }

  public static Object propertyMacro_GetPropertyValue_3852159904898556344(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(SLinkOperations.getTarget(_context.getNode(), "pattern", true), "value");
  }

  public static Object propertyMacro_GetPropertyValue_3852159904898556361(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(SLinkOperations.getTarget(_context.getNode(), "pattern", true), "value");
  }

  public static Object propertyMacro_GetPropertyValue_3852159904898824978(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(_context.getNode(), "value");
  }

  public static SNode sourceNodeQuery_3852159904898824953(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "renameTo", true);
  }

  public static Iterable sourceNodesQuery_2968360207536878995(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "attr", true);
  }

  public static Iterable sourceNodesQuery_2968360207536985234(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "element", true);
  }

  public static Iterable sourceNodesQuery_2968360207537115113(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "pattern", true);
  }
}
