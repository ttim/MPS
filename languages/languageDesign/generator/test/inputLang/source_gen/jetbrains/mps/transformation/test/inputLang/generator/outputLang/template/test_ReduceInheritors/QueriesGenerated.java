package jetbrains.mps.transformation.test.inputLang.generator.outputLang.template.test_ReduceInheritors;

/*Generated by MPS */

import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.generator.template.BaseMappingRuleContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.generator.template.PropertyMacroContext;
import jetbrains.mps.generator.template.SourceSubstituteMacroNodesContext;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations;
import jetbrains.mps.internal.collections.runtime.ITranslator2;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.generator.template.TemplateQueryContext;
import jetbrains.mps.generator.template.TemplateQueryContextWithMacro;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.generator.runtime.TemplateModel;
import jetbrains.mps.generator.runtime.TemplateModule;

public class QueriesGenerated {
  public static boolean baseMappingRule_Condition_1206461877475(final IOperationContext operationContext, final BaseMappingRuleContext _context) {
    return SPropertyOperations.hasValue(SNodeOperations.cast(SNodeOperations.getAncestor(_context.getNode(), null, false, true), "jetbrains.mps.transformation.test.inputLang.structure.InputRoot"), "useInTest", "reduceInheritors", "none");
  }

  public static boolean baseMappingRule_Condition_1206461190505(final IOperationContext operationContext, final BaseMappingRuleContext _context) {
    return SPropertyOperations.hasValue(SNodeOperations.cast(SNodeOperations.getAncestor(_context.getNode(), null, false, true), "jetbrains.mps.transformation.test.inputLang.structure.InputRoot"), "useInTest", "reduceInheritors", "none");
  }

  public static boolean baseMappingRule_Condition_1206461124351(final IOperationContext operationContext, final BaseMappingRuleContext _context) {
    return SPropertyOperations.hasValue(SNodeOperations.cast(SNodeOperations.getAncestor(_context.getNode(), null, false, true), "jetbrains.mps.transformation.test.inputLang.structure.InputRoot"), "useInTest", "reduceInheritors", "none");
  }

  public static boolean baseMappingRule_Condition_1206460092545(final IOperationContext operationContext, final BaseMappingRuleContext _context) {
    return SPropertyOperations.hasValue(_context.getNode(), "useInTest", "reduceInheritors", "none");
  }

  public static Object propertyMacro_GetPropertyValue_8014813979421777301(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return "arch:" + ((String) _context.getGenerationParameter("r:00000000-0000-4000-0000-011c895905f9.GlobalParameters.arch"));
  }

  public static Iterable sourceNodesQuery_8417539822878722925(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return ListSequence.fromList(SModelOperations.getRoots(_context.getOriginalInputModel(), "jetbrains.mps.transformation.test.inputLang.structure.InputRoot")).translate(new ITranslator2<SNode, SNode>() {
      public Iterable<SNode> translate(SNode it) {
        return SLinkOperations.getTargets(it, "inputChild", true);
      }
    });
  }

  public static Iterable sourceNodesQuery_1206460249786(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "inputChild", true);
  }

  public static boolean mappingConfiguration_Condition_2507865635201605483(final TemplateQueryContext _context) {
    return (((Integer) _context.getGenerationParameter("r:00000000-0000-4000-0000-011c895905f9.GlobalParameters.list")) == null ?
      true :
      ((Integer) _context.getGenerationParameter("r:00000000-0000-4000-0000-011c895905f9.GlobalParameters.list")) < 2
    );
  }

  public static SNode insertMacro_Query_7612440128092282150(final IOperationContext operationContext, final TemplateQueryContextWithMacro _context) {
    SNode inode = SConceptOperations.createNewNode("jetbrains.mps.transformation.test.outputLang.structure.OutputNode", null);
    SPropertyOperations.set(inode, "text", "Inserted node for input=" + SPropertyOperations.getString(_context.getNode(), "name"));
    return inode;
  }

  public static TemplateModel getDescriptor(TemplateModule module) {
    return new TemplateModelImpl(module);
  }
}
