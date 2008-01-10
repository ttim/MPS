package jetbrains.mps.baseLanguage.generator.java.closures;

/*Generated by MPS */

import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.generator.template.BaseMappingRuleContext;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.baseLanguage.structure.VariableDeclaration;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.baseLanguage.generator.java.closures.util.QueriesUtil;
import java.util.List;

import jetbrains.mps.generator.template.*;

public class QueriesGenerated {

  public static boolean baseMappingRule_Condition_1170282608160(final IOperationContext operationContext, final BaseMappingRuleContext _parameterObject) {
    return ClosuresUtil.hasVariablesUsedInClosure(_parameterObject.getNode(), _parameterObject.getGenerator());
  }

  public static boolean baseMappingRule_Condition_1170282061477(final IOperationContext operationContext, final BaseMappingRuleContext _parameterObject) {
    if(!(SNodeOperations.isInstanceOf(_parameterObject.getNode(), "jetbrains.mps.baseLanguage.structure.Closure"))) {
      return ClosuresUtil.hasVariablesUsedInClosure(_parameterObject.getNode(), _parameterObject.getGenerator());
    }
    return false;
  }

  public static boolean baseMappingRule_Condition_1170198286262(final IOperationContext operationContext, final BaseMappingRuleContext _parameterObject) {
    SNode parent = SNodeOperations.getParent(_parameterObject.getNode(), null, false, false);
    if(ClosuresUtil.isClosureContextOwner(parent)) {
      return ClosuresUtil.hasVariablesUsedInClosure(parent, _parameterObject.getGenerator());
    }
    return false;
  }

  public static boolean baseMappingRule_Condition_1170198485461(final IOperationContext operationContext, final BaseMappingRuleContext _parameterObject) {
    return SNodeOperations.getAncestor(_parameterObject.getNode(), "jetbrains.mps.baseLanguage.structure.Closure", false, false) != null;
  }

  public static boolean baseMappingRule_Condition_1170198665539(final IOperationContext operationContext, final BaseMappingRuleContext _parameterObject) {
    SNode var = SLinkOperations.getTarget(_parameterObject.getNode(), "variableDeclaration", false);
    SNode contextOwner = ClosuresUtil.findEnclosingClosureContextOwner(var);
    if(contextOwner != null) {
      return ClosuresUtil.isVariableUsedInClosure(contextOwner, ((VariableDeclaration)SNodeOperations.getAdapter(var)), _parameterObject.getGenerator());
    }
    return false;
  }

  public static boolean baseMappingRule_Condition_1170198858690(final IOperationContext operationContext, final BaseMappingRuleContext _parameterObject) {
    SNode var = SLinkOperations.getTarget(_parameterObject.getNode(), "variableDeclaration", false);
    SNode contextOwner = ClosuresUtil.findEnclosingClosureContextOwner(var);
    if(contextOwner != null) {
      return ClosuresUtil.isVariableUsedInClosure(contextOwner, ((VariableDeclaration)SNodeOperations.getAdapter(var)), _parameterObject.getGenerator());
    }
    return false;
  }

  public static boolean baseMappingRule_Condition_1170199119856(final IOperationContext operationContext, final BaseMappingRuleContext _parameterObject) {
    SNode var = SLinkOperations.getTarget(_parameterObject.getNode(), "localVariableDeclaration", true);
    if(SLinkOperations.getTarget(var, "initializer", true) != null) {
      SNode contextOwner = ClosuresUtil.findEnclosingClosureContextOwner(var);
      if(contextOwner != null) {
        return ClosuresUtil.isVariableUsedInClosure(contextOwner, ((VariableDeclaration)SNodeOperations.getAdapter(var)), _parameterObject.getGenerator());
      }
    }
    return false;
  }

  public static Object propertyMacro_GetPropertyValue_1170347597854(final IOperationContext operationContext, final PropertyMacroContext _parameterObject) {
    return _QueriesUtil.getString_VariableDeclaration_nameInClosureContext(_parameterObject.getNode(), _parameterObject.getGenerator());
  }

  public static Object propertyMacro_GetPropertyValue_1170707207731(final IOperationContext operationContext, final PropertyMacroContext _parameterObject) {
    return _parameterObject.getGenerator().getGeneratorSessionContext().createUniqueName("zClosureContext");
  }

  public static Object propertyMacro_GetPropertyValue_1170707554571(final IOperationContext operationContext, final PropertyMacroContext _parameterObject) {
    return _parameterObject.getGenerator().getGeneratorSessionContext().createUniqueName("_zClosureContext");
  }

  public static Object propertyMacro_GetPropertyValue_1170874110540(final IOperationContext operationContext, final PropertyMacroContext _parameterObject) {
    return SPropertyOperations.getString(_parameterObject.getNode(), "name");
  }

  public static Object referenceMacro_GetReferent_1170294467354(final IOperationContext operationContext, final ReferenceMacroContext _parameterObject) {
    return _QueriesUtil.find_ContextOwner_ClosureContext_generatedClass(_parameterObject.getNode(), _parameterObject.getGenerator());
  }

  public static Object referenceMacro_GetReferent_1170295650824(final IOperationContext operationContext, final ReferenceMacroContext _parameterObject) {
    return SPropertyOperations.getString(_parameterObject.getNode(), "name");
  }

  public static Object referenceMacro_GetReferent_1170295049904(final IOperationContext operationContext, final ReferenceMacroContext _parameterObject) {
    return _QueriesUtil.find_ContextOwner_ClosureContext_generatedClass_constructor(_parameterObject.getNode(), _parameterObject.getGenerator());
  }

  public static Object referenceMacro_GetReferent_1170288297219(final IOperationContext operationContext, final ReferenceMacroContext _parameterObject) {
    return _QueriesUtil.find_EnclosingContextOwner_ClosureContext_generatedClass(_parameterObject.getNode(), _parameterObject.getGenerator());
  }

  public static Object referenceMacro_GetReferent_1170287949033(final IOperationContext operationContext, final ReferenceMacroContext _parameterObject) {
    return _QueriesUtil.find_EnclosingContextOwner_ClosureContext_generatedClass(_parameterObject.getNode(), _parameterObject.getGenerator());
  }

  public static Object referenceMacro_GetReferent_1170350646244(final IOperationContext operationContext, final ReferenceMacroContext _parameterObject) {
    return _QueriesUtil.resolve_VariableReference_Variable_ClosureContext_generatedField(_parameterObject.getNode(), _parameterObject.getGenerator());
  }

  public static Object referenceMacro_GetReferent_1170348563863(final IOperationContext operationContext, final ReferenceMacroContext _parameterObject) {
    return _QueriesUtil.resolve_VariableDeclStmt_Variable_ClosureContext_generatedField(_parameterObject.getNode(), _parameterObject.getGenerator());
  }

  public static Object referenceMacro_GetReferent_1170288676089(final IOperationContext operationContext, final ReferenceMacroContext _parameterObject) {
    return _QueriesUtil.find_Closure_generatedClosureAdapter_constructor(_parameterObject.getNode(), _parameterObject.getGenerator());
  }

  public static Object referenceMacro_GetReferent_1170293907670(final IOperationContext operationContext, final ReferenceMacroContext _parameterObject) {
    return SPropertyOperations.getString(SLinkOperations.getTarget(_parameterObject.getNode(), "closureParameter", false), "name");
  }

  public static SNode sourceNodeQuery_1170347410888(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _parameterObject) {
    return SLinkOperations.getTarget(_parameterObject.getNode(), "type", true);
  }

  public static SNode sourceNodeQuery_1170294125679(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _parameterObject) {
    return SNodeOperations.getParent(_parameterObject.getNode(), null, false, false);
  }

  public static SNode sourceNodeQuery_1185917871131(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _parameterObject) {
    return QueriesUtil.createClassType_forClosure_enclosingClass(_parameterObject.getNode(), _parameterObject.getGenerator());
  }

  public static SNode sourceNodeQuery_1185918144604(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _parameterObject) {
    return QueriesUtil.createClassType_forClosure_enclosingClass(_parameterObject.getNode(), _parameterObject.getGenerator());
  }

  public static SNode sourceNodeQuery_1170348623270(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _parameterObject) {
    return SLinkOperations.getTarget(SLinkOperations.getTarget(_parameterObject.getNode(), "localVariableDeclaration", true), "initializer", true);
  }

  public static SNode sourceNodeQuery_1196118817337(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _parameterObject) {
    return QueriesUtil.create_enclosingClassObject(_parameterObject.getNode());
  }

  public static List sourceNodesQuery_1170347787985(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _parameterObject) {
    List list = _QueriesUtil.getList_ContextOwner_ifMethod_ParmsUsedInClosure(_parameterObject.getNode(), _parameterObject.getGenerator());
    return (List<SNode>)list;
  }

  public static List sourceNodesQuery_1170347696338(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _parameterObject) {
    List list = _QueriesUtil.getList_ContextOwner_ifMethod_ParmsUsedInClosure(_parameterObject.getNode(), _parameterObject.getGenerator());
    return (List<SNode>)list;
  }

  public static List sourceNodesQuery_1170347169279(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _parameterObject) {
    List list = _QueriesUtil.getList_ContextOwner_VariablesUsedInClosure(_parameterObject.getNode(), _parameterObject.getGenerator());
    return (List<SNode>)list;
  }

  public static List sourceNodesQuery_1170295259476(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _parameterObject) {
    List<SNode> list = _QueriesUtil.getList_ContextOwner_ifMethod_ParmsUsedInClosure(_parameterObject.getNode(), _parameterObject.getGenerator());
    return (List<SNode>)list;
  }

  public static List sourceNodesQuery_1170294170225(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _parameterObject) {
    return SLinkOperations.getTargets(_parameterObject.getNode(), "statement", true);
  }

  public static List sourceNodesQuery_1170874089896(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _parameterObject) {
    return QueriesUtil.getTypeVars_from_Closure_enclosingClass(_parameterObject.getNode(), operationContext.getScope());
  }

  public static SNode mapSrcMacro_mapper_1170898169592(final IOperationContext operationContext, final MapSrcMacroContext _parameterObject) {
    return _QueriesUtil.create_closureContextObject(_parameterObject.getNode(), _parameterObject.getGenerator());
  }

  public static SNode mapSrcMacro_mapper_1170899386077(final IOperationContext operationContext, final MapSrcMacroContext _parameterObject) {
    return _QueriesUtil.create_closureContextObject(_parameterObject.getNode(), _parameterObject.getGenerator());
  }

  public static SNode mapSrcMacro_mapper_1196117121002(final IOperationContext operationContext, final MapSrcMacroContext _parameterObject) {
    return _QueriesUtil.create_closureContextObject(_parameterObject.getNode(), _parameterObject.getGenerator());
  }

  public static SNode weaving_MappingRule_ContextNodeQuery_1186782271334(final IOperationContext opereationContext, final WeavingMappingRuleContext _parameterObject) {
    return _parameterObject.getGenerator().findOutputNodeByInputNodeAndMappingName(_parameterObject.getNode(), ClosuresMappingId.CLOSURE__ADAPTER_CLASS);
  }

}
