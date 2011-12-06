package jetbrains.mps.traceInfo.testWeavingGenerated.data.generator.template.generator.template.generator.template.main;

/*Generated by MPS */

import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.generator.template.PropertyMacroContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.generator.template.SourceSubstituteMacroNodesContext;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.generator.template.WeavingMappingRuleContext;
import jetbrains.mps.generator.runtime.TemplateModel;
import jetbrains.mps.generator.runtime.TemplateModule;

public class QueriesGenerated {
  public static Object propertyMacro_GetPropertyValue_6186432342008490331(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(_context.getNode(), "name");
  }

  public static Object propertyMacro_GetPropertyValue_6186432342008526320(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(_context.getNode(), "name");
  }

  public static Object propertyMacro_GetPropertyValue_6186432342008522555(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return _context.createUniqueName(SPropertyOperations.getString(SNodeOperations.getConceptDeclaration(_context.getNode()), "name"), null);
  }

  public static Object propertyMacro_GetPropertyValue_6186432342008533408(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(_context.getNode(), "name");
  }

  public static Object propertyMacro_GetPropertyValue_6186432342008533417(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return _context.createUniqueName(SPropertyOperations.getString(SNodeOperations.getConceptDeclaration(_context.getNode()), "name"), null);
  }

  public static Object propertyMacro_GetPropertyValue_6186432342008533449(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(_context.getNode(), "name");
  }

  public static Object propertyMacro_GetPropertyValue_6186432342008533458(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return _context.createUniqueName(SPropertyOperations.getString(SNodeOperations.getConceptDeclaration(_context.getNode()), "name"), null);
  }

  public static Object propertyMacro_GetPropertyValue_6186432342008533482(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(_context.getNode(), "name");
  }

  public static Object propertyMacro_GetPropertyValue_6186432342008533491(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return _context.createUniqueName(SPropertyOperations.getString(SNodeOperations.getConceptDeclaration(_context.getNode()), "name"), null);
  }

  public static Iterable sourceNodesQuery_6186432342008490342(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return Sequence.<SNode>singleton(_context.getNode());
  }

  public static Iterable sourceNodesQuery_6186432342008522532(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "weaveEach", true);
  }

  public static Iterable sourceNodesQuery_6186432342008533377(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return Sequence.<SNode>singleton(_context.getNode());
  }

  public static Iterable sourceNodesQuery_6186432342008533362(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "weaveEachMany", true);
  }

  public static SNode weaving_MappingRule_ContextNodeQuery_6186432342008490339(final IOperationContext opereationContext, final WeavingMappingRuleContext _context) {
    return _context.getOutputNodeByInputNodeAndMappingLabel(SNodeOperations.cast(SNodeOperations.getContainingRoot(_context.getNode()), "jetbrains.mps.traceInfo.testWeavingGenerated.data.structure.RootConcept"), "map_RootConcept");
  }

  public static SNode weaving_MappingRule_ContextNodeQuery_6186432342008522529(final IOperationContext opereationContext, final WeavingMappingRuleContext _context) {
    return _context.getOutputNodeByInputNodeAndMappingLabel(_context.getNode(), "map_RootConcept");
  }

  public static SNode weaving_MappingRule_ContextNodeQuery_6186432342008533384(final IOperationContext opereationContext, final WeavingMappingRuleContext _context) {
    return _context.getOutputNodeByInputNodeAndMappingLabel(SNodeOperations.cast(SNodeOperations.getContainingRoot(_context.getNode()), "jetbrains.mps.traceInfo.testWeavingGenerated.data.structure.RootConcept"), "map_RootConcept");
  }

  public static SNode weaving_MappingRule_ContextNodeQuery_6186432342008533368(final IOperationContext opereationContext, final WeavingMappingRuleContext _context) {
    return _context.getOutputNodeByInputNodeAndMappingLabel(_context.getNode(), "map_RootConcept");
  }

  public static TemplateModel getDescriptor(TemplateModule module) {
    return new TemplateModelImpl(module);
  }
}
