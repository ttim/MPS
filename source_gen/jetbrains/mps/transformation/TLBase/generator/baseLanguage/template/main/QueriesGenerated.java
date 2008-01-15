package jetbrains.mps.transformation.TLBase.generator.baseLanguage.template.main;

/*Generated by MPS */

import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.generator.template.PropertyMacroContext;
import jetbrains.mps.transformation.TLBase.generator.baseLanguage.template.TemplateFunctionMethodName;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.generator.template.SourceSubstituteMacroNodeContext;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.generator.template.WeavingMappingRuleContext;
import jetbrains.mps.transformation.TLBase.generator.baseLanguage.template.util.QueriesUtil;
import jetbrains.mps.generator.template.MappingScriptContext;
import java.util.List;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SModelOperations;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.helgins.inference.TypeChecker;

public class QueriesGenerated {

  public static Object propertyMacro_GetPropertyValue_1167762379110(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return TemplateFunctionMethodName.createRootRule_Condition(_context.getNode());
  }

  public static Object propertyMacro_GetPropertyValue_1167765482559(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return TemplateFunctionMethodName.baseMappingRule_Condition(_context.getNode());
  }

  public static Object propertyMacro_GetPropertyValue_1167764877550(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return TemplateFunctionMethodName.propertyMacro_GetPropertyValue(_context.getNode());
  }

  public static Object propertyMacro_GetPropertyValue_1167770891051(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return TemplateFunctionMethodName.referenceMacro_GetReferent(_context.getNode());
  }

  public static Object propertyMacro_GetPropertyValue_1167946761277(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return TemplateFunctionMethodName.ifMacro_Condition(_context.getNode());
  }

  public static Object propertyMacro_GetPropertyValue_1167952935373(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return TemplateFunctionMethodName.sourceSubstituteMacro_SourceNodesQuery(_context.getNode());
  }

  public static Object propertyMacro_GetPropertyValue_1168025033018(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return TemplateFunctionMethodName.sourceSubstituteMacro_SourceNodeQuery(_context.getNode());
  }

  public static Object propertyMacro_GetPropertyValue_1170727064429(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return TemplateFunctionMethodName.mapSrcMacro_MapperFunction(_context.getNode());
  }

  public static Object propertyMacro_GetPropertyValue_1184374857703(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return TemplateFunctionMethodName.templateFragment_ContextNodeQuery(_context.getNode());
  }

  public static Object propertyMacro_GetPropertyValue_1184617630764(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return TemplateFunctionMethodName.weaving_MappingRule_ContextNodeQuery(_context.getNode());
  }

  public static Object propertyMacro_GetPropertyValue_1195504684817(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return TemplateFunctionMethodName.mappingScript_CodeBlock(_context.getNode());
  }

  public static SNode sourceNodeQuery_1168025917226(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "body", true);
  }

  public static SNode sourceNodeQuery_1168025905128(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "body", true);
  }

  public static SNode sourceNodeQuery_1168025932423(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "body", true);
  }

  public static SNode sourceNodeQuery_1168025938897(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "body", true);
  }

  public static SNode sourceNodeQuery_1168025925887(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "body", true);
  }

  public static SNode sourceNodeQuery_1168025947268(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "body", true);
  }

  public static SNode sourceNodeQuery_1168025330833(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "body", true);
  }

  public static SNode sourceNodeQuery_1170727064418(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "body", true);
  }

  public static SNode sourceNodeQuery_1184374857693(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "body", true);
  }

  public static SNode sourceNodeQuery_1184617630754(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "body", true);
  }

  public static SNode sourceNodeQuery_1195504684807(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "body", true);
  }

  public static SNode weaving_MappingRule_ContextNodeQuery_1184619599466(final IOperationContext opereationContext, final WeavingMappingRuleContext _context) {
    return QueriesUtil.getQueriesGeneratedClass(_context.getGenerator());
  }

  public static SNode weaving_MappingRule_ContextNodeQuery_1184619796790(final IOperationContext opereationContext, final WeavingMappingRuleContext _context) {
    return QueriesUtil.getQueriesGeneratedClass(_context.getGenerator());
  }

  public static SNode weaving_MappingRule_ContextNodeQuery_1184619844945(final IOperationContext opereationContext, final WeavingMappingRuleContext _context) {
    return QueriesUtil.getQueriesGeneratedClass(_context.getGenerator());
  }

  public static SNode weaving_MappingRule_ContextNodeQuery_1184619847603(final IOperationContext opereationContext, final WeavingMappingRuleContext _context) {
    return QueriesUtil.getQueriesGeneratedClass(_context.getGenerator());
  }

  public static SNode weaving_MappingRule_ContextNodeQuery_1184619852561(final IOperationContext opereationContext, final WeavingMappingRuleContext _context) {
    return QueriesUtil.getQueriesGeneratedClass(_context.getGenerator());
  }

  public static SNode weaving_MappingRule_ContextNodeQuery_1184619868267(final IOperationContext opereationContext, final WeavingMappingRuleContext _context) {
    return QueriesUtil.getQueriesGeneratedClass(_context.getGenerator());
  }

  public static SNode weaving_MappingRule_ContextNodeQuery_1184619865210(final IOperationContext opereationContext, final WeavingMappingRuleContext _context) {
    return QueriesUtil.getQueriesGeneratedClass(_context.getGenerator());
  }

  public static SNode weaving_MappingRule_ContextNodeQuery_1184619877062(final IOperationContext opereationContext, final WeavingMappingRuleContext _context) {
    return QueriesUtil.getQueriesGeneratedClass(_context.getGenerator());
  }

  public static SNode weaving_MappingRule_ContextNodeQuery_1184619879860(final IOperationContext opereationContext, final WeavingMappingRuleContext _context) {
    return QueriesUtil.getQueriesGeneratedClass(_context.getGenerator());
  }

  public static SNode weaving_MappingRule_ContextNodeQuery_1184619882833(final IOperationContext opereationContext, final WeavingMappingRuleContext _context) {
    return QueriesUtil.getQueriesGeneratedClass(_context.getGenerator());
  }

  public static SNode weaving_MappingRule_ContextNodeQuery_1195503404236(final IOperationContext opereationContext, final WeavingMappingRuleContext _context) {
    return QueriesUtil.getQueriesGeneratedClass(_context.getGenerator());
  }

  public static void mappingScript_CodeBlock_1199965771120(final IOperationContext operationContext, final MappingScriptContext _context) {
    List<SNode> nodes = SModelOperations.getNodes(_context.getModel(), "jetbrains.mps.transformation.TLBase.structure.TemplateFunctionParameter_sourceNode");
    int counter = 0;
    int size = nodes.size();
    for(SNode node : nodes) {
      SNode replacement = SConceptOperations.createNewNode("jetbrains.mps.baseLanguageInternal.structure.TypeHintExpression", null);
      SLinkOperations.setTarget(replacement, "typeHint", SNodeOperations.copyNode(TypeChecker.getInstance().getTypeOf(node)), true);
      SNodeOperations.replaceWithAnother(node, replacement);
      SLinkOperations.setTarget(replacement, "expression", node, true);
      counter++;
      if (counter > size) {
        System.err.println("oy vey!");
      }
    }
  }

}
