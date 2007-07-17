package jetbrains.mps.transformation.TLBase.generator.baseLanguage.template.main;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.generator.template.ITemplateGenerator;
import jetbrains.mps.smodel.IScope;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.transformation.TLBase.generator.baseLanguage.template.TemplateFunctionMethodName;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SConceptPropertyOperations;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.baseLanguage.ext.collections.internal.ICursor;
import jetbrains.mps.baseLanguage.ext.collections.internal.CursorFactory;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.transformation.TLBase.helgins.Util_TLBase_types;
import jetbrains.mps.transformation.TLBase.generator.baseLanguage.template.util.QueriesUtil;

public class QueriesGenerated {

  public static Object propertyMacro_GetPropertyValue_1167762379110(SNode node, String templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return TemplateFunctionMethodName.createRootRule_Condition(node);
  }
  public static Object propertyMacro_GetPropertyValue_1167765482559(SNode node, String templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return TemplateFunctionMethodName.baseMappingRule_Condition(node);
  }
  public static Object propertyMacro_GetPropertyValue_1167764877550(SNode node, String templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return TemplateFunctionMethodName.propertyMacro_GetPropertyValue(node);
  }
  public static Object propertyMacro_GetPropertyValue_1167770891051(SNode node, String templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return TemplateFunctionMethodName.referenceMacro_GetReferent(node);
  }
  public static Object propertyMacro_GetPropertyValue_1167946761277(SNode node, String templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return TemplateFunctionMethodName.ifMacro_Condition(node);
  }
  public static Object propertyMacro_GetPropertyValue_1167952935373(SNode node, String templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return TemplateFunctionMethodName.sourceSubstituteMacro_SourceNodesQuery(node);
  }
  public static Object propertyMacro_GetPropertyValue_1168025033018(SNode node, String templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return TemplateFunctionMethodName.sourceSubstituteMacro_SourceNodeQuery(node);
  }
  public static Object propertyMacro_GetPropertyValue_1170727064429(SNode node, String templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return TemplateFunctionMethodName.mapSrcMacro_MapperFunction(node);
  }
  public static Object propertyMacro_GetPropertyValue_1184374857703(SNode node, String templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return TemplateFunctionMethodName.templateFragment_ContextNodeQuery(node);
  }
  public static Object propertyMacro_GetPropertyValue_1184617630764(SNode node, String templateValue, SNode templateNode, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return TemplateFunctionMethodName.weaving_MappingRule_ContextNodeQuery(node);
  }
  public static SNode referenceMacro_GetReferent_1167774837569(SNode node, SNode templateNode, SNode outputNode, SModel sourceModel, ITemplateGenerator generator) {
    String alias = SConceptPropertyOperations.getString(node, "alias");
    if(alias == null) {
      generator.showErrorMessage(node, templateNode, "concept function parm has no <alias> - can't map it to method parameter");
      return null;
    }
    SNode method = SNodeOperations.getAncestor(outputNode, "jetbrains.mps.baseLanguage.structure.BaseMethodDeclaration", false, false);
    {
      ICursor<SNode> _zCursor = CursorFactory.createCursor(SLinkOperations.getTargets(method, "parameter", true));
      try {
        while(_zCursor.moveToNext()) {
          SNode parm = _zCursor.getCurrent();
          if(alias.equals(SPropertyOperations.getString(parm, "name"))) {
            return parm;
          }
        }
      } finally {
        _zCursor.release();
      }
    }
    generator.showErrorMessage(node, templateNode, "couldn't find method parameter for concept function parm '" + alias + "'");
    return null;
  }
  public static SNode referenceMacro_GetReferent_1167771845166(SNode node, SNode templateNode, SNode outputNode, SModel sourceModel, ITemplateGenerator generator) {
    return SLinkOperations.getTarget(SNodeOperations.getAncestor(node, "jetbrains.mps.transformation.TLBase.structure.BaseMappingRule", false, false), "applicableConcept", false);
  }
  public static SNode sourceNodeQuery_1168025917226(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SLinkOperations.getTarget(node, "body", true);
  }
  public static SNode sourceNodeQuery_1168025905128(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SLinkOperations.getTarget(node, "body", true);
  }
  public static SNode sourceNodeQuery_1168025932423(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SLinkOperations.getTarget(node, "body", true);
  }
  public static SNode sourceNodeQuery_1168025938897(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SLinkOperations.getTarget(node, "body", true);
  }
  public static SNode sourceNodeQuery_1168025925887(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SLinkOperations.getTarget(node, "body", true);
  }
  public static SNode sourceNodeQuery_1168025947268(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SLinkOperations.getTarget(node, "body", true);
  }
  public static SNode sourceNodeQuery_1168025330833(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SLinkOperations.getTarget(node, "body", true);
  }
  public static SNode sourceNodeQuery_1170727064418(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SLinkOperations.getTarget(node, "body", true);
  }
  public static SNode sourceNodeQuery_1184374857693(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SLinkOperations.getTarget(node, "body", true);
  }
  public static SNode sourceNodeQuery_1184617630754(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SLinkOperations.getTarget(node, "body", true);
  }
  public static SNode mapSrcMacro_mapper_1178910515264(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SNodeOperations.copyNode(Util_TLBase_types.get_templateFunction_inputNodeType(node));
  }
  public static SNode mapSrcMacro_mapper_1178914145434(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SNodeOperations.copyNode(Util_TLBase_types.get_templateFunction_inputNodeType(node));
  }
  public static SNode mapSrcMacro_mapper_1178914006342(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SNodeOperations.copyNode(Util_TLBase_types.get_templateFunction_inputNodeType(node));
  }
  public static SNode mapSrcMacro_mapper_1178913463923(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SNodeOperations.copyNode(Util_TLBase_types.get_templateFunction_inputNodeType(node));
  }
  public static SNode mapSrcMacro_mapper_1178913788227(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SNodeOperations.copyNode(Util_TLBase_types.get_templateFunction_inputNodeType(node));
  }
  public static SNode mapSrcMacro_mapper_1178913590671(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SNodeOperations.copyNode(Util_TLBase_types.get_templateFunction_inputNodeType(node));
  }
  public static SNode mapSrcMacro_mapper_1184374857711(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SNodeOperations.copyNode(Util_TLBase_types.get_templateFunction_inputNodeType(node));
  }
  public static SNode mapSrcMacro_mapper_1184617630772(SNode node, SModel sourceModel, ITemplateGenerator generator, IScope scope, IOperationContext operationContext) {
    return SNodeOperations.copyNode(Util_TLBase_types.get_templateFunction_inputNodeType(node));
  }
  public static SNode weaving_MappingRule_ContextNodeQuery_1184619599466(SNode node, ITemplateGenerator generator) {
    return QueriesUtil.getQueriesGeneratedClass(generator);
  }
  public static SNode weaving_MappingRule_ContextNodeQuery_1184619796790(SNode node, ITemplateGenerator generator) {
    return QueriesUtil.getQueriesGeneratedClass(generator);
  }
  public static SNode weaving_MappingRule_ContextNodeQuery_1184619844945(SNode node, ITemplateGenerator generator) {
    return QueriesUtil.getQueriesGeneratedClass(generator);
  }
  public static SNode weaving_MappingRule_ContextNodeQuery_1184619847603(SNode node, ITemplateGenerator generator) {
    return QueriesUtil.getQueriesGeneratedClass(generator);
  }
  public static SNode weaving_MappingRule_ContextNodeQuery_1184619852561(SNode node, ITemplateGenerator generator) {
    return QueriesUtil.getQueriesGeneratedClass(generator);
  }
  public static SNode weaving_MappingRule_ContextNodeQuery_1184619865210(SNode node, ITemplateGenerator generator) {
    return QueriesUtil.getQueriesGeneratedClass(generator);
  }
  public static SNode weaving_MappingRule_ContextNodeQuery_1184619868267(SNode node, ITemplateGenerator generator) {
    return QueriesUtil.getQueriesGeneratedClass(generator);
  }
  public static SNode weaving_MappingRule_ContextNodeQuery_1184619877062(SNode node, ITemplateGenerator generator) {
    return QueriesUtil.getQueriesGeneratedClass(generator);
  }
  public static SNode weaving_MappingRule_ContextNodeQuery_1184619879860(SNode node, ITemplateGenerator generator) {
    return QueriesUtil.getQueriesGeneratedClass(generator);
  }
  public static SNode weaving_MappingRule_ContextNodeQuery_1184619882833(SNode node, ITemplateGenerator generator) {
    return QueriesUtil.getQueriesGeneratedClass(generator);
  }
}
