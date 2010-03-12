package jetbrains.mps.lang.plugin.generator.baseLanguage.template.runconfigs;

/*Generated by MPS */

import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.generator.template.BaseMappingRuleContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.baseLanguage.classifiers.behavior.ThisClassifierExpression_Behavior;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.generator.template.PropertyMacroContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.util.Macros;
import jetbrains.mps.project.IModule;
import jetbrains.mps.generator.template.TemplateQueryContext;
import jetbrains.mps.lang.plugin.behavior.RunConfigurationTypeDeclaration_Behavior;
import jetbrains.mps.lang.plugin.behavior.RunConfigurationDeclaration_Behavior;
import jetbrains.mps.lang.plugin.behavior.ActionDeclaration_Behavior;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptPropertyOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.plugin.behavior.RunConfigCreator_Behavior;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.generator.template.ReferenceMacroContext;
import jetbrains.mps.typesystem.inference.TypeChecker;
import jetbrains.mps.lang.typesystem.runtime.HUtil;
import jetbrains.mps.lang.plugin.behavior.BaseCreatorTarget_Behavior;
import jetbrains.mps.generator.template.IfMacroContext;
import jetbrains.mps.generator.template.SourceSubstituteMacroNodeContext;
import jetbrains.mps.lang.plugin.behavior.ActionParameter_Behavior;
import jetbrains.mps.generator.template.SourceSubstituteMacroNodesContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.smodel.SReference;
import jetbrains.mps.smodel.SModelReference;
import jetbrains.mps.smodel.SNodeId;

public class QueriesGenerated {
  public static boolean baseMappingRule_Condition_680902548763517194(final IOperationContext operationContext, final BaseMappingRuleContext _context) {
    return SNodeOperations.isInstanceOf(ThisClassifierExpression_Behavior.call_getClassifier_1213877512819(_context.getNode()), "jetbrains.mps.lang.plugin.structure.RunConfigurationDeclaration") && (SNodeOperations.getAncestor(_context.getNode(), "jetbrains.mps.lang.plugin.structure.GetConfigurationIconBlock", false, false) != null);
  }

  public static boolean baseMappingRule_Condition_3452826078638209704(final IOperationContext operationContext, final BaseMappingRuleContext _context) {
    return SNodeOperations.isInstanceOf(ThisClassifierExpression_Behavior.call_getClassifier_1213877512819(_context.getNode()), "jetbrains.mps.lang.plugin.structure.RunConfigurationDeclaration") && (SNodeOperations.getAncestor(_context.getNode(), "jetbrains.mps.lang.plugin.structure.ConfigurationEditorDeclaration", false, false) != null);
  }

  public static boolean baseMappingRule_Condition_680902548763517325(final IOperationContext operationContext, final BaseMappingRuleContext _context) {
    return SNodeOperations.isInstanceOf(ThisClassifierExpression_Behavior.call_getClassifier_1213877512819(_context.getNode()), "jetbrains.mps.lang.plugin.structure.RunConfigurationDeclaration") && (SNodeOperations.getAncestorWhereConceptInList(_context.getNode(), new String[]{"jetbrains.mps.lang.plugin.structure.GetConfigurationIconBlock","jetbrains.mps.lang.plugin.structure.ConfigurationEditorDeclaration"}, false, false) == null);
  }

  public static boolean baseMappingRule_Condition_8294332872984918711(final IOperationContext operationContext, final BaseMappingRuleContext _context) {
    return (SNodeOperations.getAncestor(_context.getNode(), "jetbrains.mps.lang.plugin.structure.RunConfigurationDeclaration", false, false) != null);
  }

  public static boolean baseMappingRule_Condition_7382861867148540167(final IOperationContext operationContext, final BaseMappingRuleContext _context) {
    return SNodeOperations.isInstanceOf(SLinkOperations.getTarget(_context.getNode(), "operation", true), "jetbrains.mps.lang.plugin.structure.PersistentPropertyReference") && (SNodeOperations.getAncestor(SLinkOperations.getTarget(SNodeOperations.cast(SLinkOperations.getTarget(_context.getNode(), "operation", true), "jetbrains.mps.lang.plugin.structure.PersistentPropertyReference"), "member", false), "jetbrains.mps.lang.plugin.structure.RunConfigurationDeclaration", false, false) != null);
  }

  public static boolean baseMappingRule_Condition_8294332872984117169(final IOperationContext operationContext, final BaseMappingRuleContext _context) {
    return SNodeOperations.isInstanceOf(SLinkOperations.getTarget(_context.getNode(), "operation", true), "jetbrains.mps.lang.plugin.structure.PersistentPropertyReference") && (SNodeOperations.getAncestor(SLinkOperations.getTarget(SNodeOperations.cast(SLinkOperations.getTarget(_context.getNode(), "operation", true), "jetbrains.mps.lang.plugin.structure.PersistentPropertyReference"), "member", false), "jetbrains.mps.lang.plugin.structure.RunConfigurationDeclaration", false, false) != null);
  }

  public static boolean baseMappingRule_Condition_2928927484561935393(final IOperationContext operationContext, final BaseMappingRuleContext _context) {
    return SNodeOperations.isInstanceOf(SLinkOperations.getTarget(_context.getNode(), "operation", true), "jetbrains.mps.lang.plugin.structure.RunConfigParameterReferenceOperation");
  }

  public static Object propertyMacro_GetPropertyValue_7840798570674908490(final IOperationContext operationContext, final PropertyMacroContext _context) {
    if (SPropertyOperations.getString(_context.getNode(), "iconPath").startsWith(Macros.MPS_HOME)) {
      _context.showWarningMessage(_context.getNode(), "Icon path is stored relative to project home. This may not work in builds (packaged).");
    }
    return SPropertyOperations.getString(_context.getNode(), "iconPath").replaceAll("\\\\", "\\\\\\\\");
  }

  public static Object propertyMacro_GetPropertyValue_7840798570674908516(final IOperationContext operationContext, final PropertyMacroContext _context) {
    IModule module = ((TemplateQueryContext) _context).getGenerator().getGeneratorSessionContext().getInvocationContext().getModule();
    return (module == null ?
      null :
      module.getModuleFqName()
    );
  }

  public static Object propertyMacro_GetPropertyValue_7840798570674901990(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(_context.getNode(), "description");
  }

  public static Object propertyMacro_GetPropertyValue_7840798570674830541(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(_context.getNode(), "caption");
  }

  public static Object propertyMacro_GetPropertyValue_7840798570674908563(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(_context.getNode(), "name");
  }

  public static Object propertyMacro_GetPropertyValue_7840798570674946761(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return RunConfigurationTypeDeclaration_Behavior.call_getGeneratedName_7840798570674947566(_context.getNode());
  }

  public static Object propertyMacro_GetPropertyValue_7840798570674951685(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return RunConfigurationDeclaration_Behavior.call_getGeneratedFactoryName_7840798570674951628(_context.getNode());
  }

  public static Object propertyMacro_GetPropertyValue_7840798570674954473(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return RunConfigurationDeclaration_Behavior.call_getGeneratedName_7840798570674951656(_context.getNode());
  }

  public static Object propertyMacro_GetPropertyValue_5561767741219971803(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(_context.getNode(), "name");
  }

  public static Object propertyMacro_GetPropertyValue_7840798570675189135(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return ActionDeclaration_Behavior.call_getGeneratedClassFQName_1213877371952(SLinkOperations.getTarget(_context.getNode(), "action", false));
  }

  public static Object propertyMacro_GetPropertyValue_7840798570675189145(final IOperationContext operationContext, final PropertyMacroContext _context) {
    SModel actionModel = SNodeOperations.getModel(SLinkOperations.getTarget(_context.getNode(), "action", false));
    SModel referenceModel = SNodeOperations.getModel(_context.getNode());
    SModel originalModel = (actionModel == referenceModel ?
      _context.getOriginalInputModel() :
      actionModel
    );
    return originalModel.getModelDescriptor().getModule().getModuleFqName();
  }

  public static Object propertyMacro_GetPropertyValue_6135182812223258861(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SConceptPropertyOperations.getString(ListSequence.fromList(SLinkOperations.getConceptLinkTargets(RunConfigCreator_Behavior.call_getFunction_5528847031674340387(((SNode) SNodeOperations.getContainingRoot(_context.getNode()))), "applicableConceptFunctionParameter")).first(), "alias");
  }

  public static Object propertyMacro_GetPropertyValue_6017961579228925652(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(_context.getNode(), "name");
  }

  public static Object propertyMacro_GetPropertyValue_446387597135526855(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(_context.getNode(), "name");
  }

  public static Object referenceMacro_GetReferent_7840798570674946672(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return _context.getOutputNodeByInputNodeAndMappingLabelAndOutputNode(_context.getNode(), _context.getOutputNode(), "map_FactoryConstructor");
  }

  public static Object referenceMacro_GetReferent_7840798570674952471(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return _context.getOutputNodeByInputNodeAndMappingLabelAndOutputNode(_context.getNode(), _context.getOutputNode(), "map_ConfigConstructor");
  }

  public static Object referenceMacro_GetReferent_4351631783611294090(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    SNode type = TypeChecker.getInstance().getRuntimeSupport().coerce_(SLinkOperations.getTarget(_context.getNode(), "type", true), HUtil.createMatchingPatternByConceptFQName("jetbrains.mps.baseLanguage.structure.ClassifierType"), true);
    return SLinkOperations.getTarget(type, "classifier", false);
  }

  public static Object referenceMacro_GetReferent_4351631783611294071(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return SPropertyOperations.getString(_context.getNode(), "name");
  }

  public static Object referenceMacro_GetReferent_4351631783611294035(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return SPropertyOperations.getString(_context.getNode(), "name");
  }

  public static Object referenceMacro_GetReferent_2751171488135057072(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return SPropertyOperations.getString(_context.getNode(), "name");
  }

  public static Object referenceMacro_GetReferent_5561767741219971792(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "key", false);
  }

  public static Object referenceMacro_GetReferent_8591610611835627262(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    if ((SLinkOperations.getTarget(_context.getNode(), "stateTypeParameter", false) != null)) {
      return SLinkOperations.getTarget(_context.getNode(), "stateTypeParameter", false);
    } else {
      return SLinkOperations.getTarget(new QueriesGenerated.QuotationClass_x583g4_a0a0a0a0cb().createNode(), "classifier", false);
    }
  }

  public static Object referenceMacro_GetReferent_8294332872984122924(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return _context.getOutputNodeByInputNodeAndMappingLabelAndOutputNode(SLinkOperations.getTarget(SNodeOperations.cast(SLinkOperations.getTarget(_context.getNode(), "operation", true), "jetbrains.mps.lang.plugin.structure.PersistentPropertyReference"), "member", false), _context.getOutputNode(), "map_PersistentProperty");
  }

  public static Object referenceMacro_GetReferent_8294332872984607864(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return _context.getOutputNodeByInputNodeAndMappingLabelAndOutputNode(SNodeOperations.cast(ThisClassifierExpression_Behavior.call_getClassifier_1213877512819(_context.getNode()), "jetbrains.mps.lang.plugin.structure.RunConfigurationDeclaration"), _context.getOutputNode(), "map_ConfigClass");
  }

  public static Object referenceMacro_GetReferent_6707043251018967862(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return _context.getOutputNodeByInputNodeAndMappingLabelAndOutputNode(SNodeOperations.getAncestor(_context.getNode(), "jetbrains.mps.lang.plugin.structure.RunConfigurationDeclaration", false, false), _context.getOutputNode(), "map_SettingsEditor");
  }

  public static Object referenceMacro_GetReferent_7382861867148540640(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return _context.getOutputNodeByInputNodeAndMappingLabelAndOutputNode(SLinkOperations.getTarget(SNodeOperations.cast(SLinkOperations.getTarget(_context.getNode(), "operation", true), "jetbrains.mps.lang.plugin.structure.PersistentPropertyReference"), "member", false), _context.getOutputNode(), "map_PersistentProperty");
  }

  public static Object referenceMacro_GetReferent_7974234327424529467(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return _context.getOutputNodeByInputNodeAndMappingLabelAndOutputNode(SLinkOperations.getTarget(_context.getNode(), "runConfig", false), _context.getOutputNode(), "map_ConfigClass");
  }

  public static Object referenceMacro_GetReferent_122179271028795198(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return _context.getOutputNodeByInputNodeAndMappingLabelAndOutputNode(SLinkOperations.getTarget(_context.getNode(), "rcType", false), _context.getOutputNode(), "map_ConfigTypeClass");
  }

  public static Object referenceMacro_GetReferent_5528847031674334455(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return RunConfigCreator_Behavior.call_getCreatorTypeParameter_5528847031674330314(_context.getNode());
  }

  public static Object referenceMacro_GetReferent_5528847031674340374(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return RunConfigCreator_Behavior.call_getCreatorTypeParameter_5528847031674330314(_context.getNode());
  }

  public static Object referenceMacro_GetReferent_5528847031674340381(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return RunConfigCreator_Behavior.call_getCreatorTypeParameter_5528847031674330314(_context.getNode());
  }

  public static Object referenceMacro_GetReferent_7603318568954580210(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return RunConfigCreator_Behavior.call_getCreatorTypeParameter_5528847031674330314(_context.getNode());
  }

  public static Object referenceMacro_GetReferent_122179271028796582(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return _context.getOutputNodeByInputNodeAndMappingLabelAndOutputNode(SLinkOperations.getTarget(SLinkOperations.getTarget(_context.getNode(), "runConfig", false), "configType", false), _context.getOutputNode(), "map_ConfigTypeClass");
  }

  public static Object referenceMacro_GetReferent_122179271028796598(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return _context.getOutputNodeByInputNodeAndMappingLabelAndOutputNode(SLinkOperations.getTarget(SLinkOperations.getTarget(_context.getNode(), "runConfig", false), "configType", false), _context.getOutputNode(), "map_ConfigTypeClass");
  }

  public static Object referenceMacro_GetReferent_5447563960349298714(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    SNode oldCreatorClass = _context.getOutputNodeByInputNodeAndMappingLabelAndOutputNode(SNodeOperations.getAncestor(_context.getNode(), "jetbrains.mps.lang.plugin.structure.RunConfigCreator", false, false), _context.getOutputNode(), "map_OldConfigCreatorClass");
    if ((oldCreatorClass != null)) {
      return oldCreatorClass;
    }
    return _context.getOutputNodeByInputNodeAndMappingLabelAndOutputNode(SNodeOperations.getAncestor(_context.getNode(), "jetbrains.mps.lang.plugin.structure.UniversalRunConfigCreator", false, false), _context.getOutputNode(), "map_ConfigCreatorClass");
  }

  public static Object referenceMacro_GetReferent_9068086904326285594(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return _context.getOutputNodeByInputNodeAndMappingLabelAndOutputNode(SLinkOperations.getTarget(_context.getNode(), "property", false), _context.getOutputNode(), "map_PersistentProperty");
  }

  public static Object referenceMacro_GetReferent_5447563960349298683(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    SNode oldCreatorClass = _context.getOutputNodeByInputNodeAndMappingLabelAndOutputNode(SNodeOperations.getAncestor(_context.getNode(), "jetbrains.mps.lang.plugin.structure.RunConfigCreator", false, false), _context.getOutputNode(), "map_OldConfigCreatorClass");
    if ((oldCreatorClass != null)) {
      return oldCreatorClass;
    }
    return _context.getOutputNodeByInputNodeAndMappingLabelAndOutputNode(SNodeOperations.getAncestor(_context.getNode(), "jetbrains.mps.lang.plugin.structure.UniversalRunConfigCreator", false, false), _context.getOutputNode(), "map_ConfigCreatorClass");
  }

  public static Object referenceMacro_GetReferent_9068086904326281899(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    SNode oldCreatorClass = _context.getOutputNodeByInputNodeAndMappingLabelAndOutputNode(SNodeOperations.getAncestor(_context.getNode(), "jetbrains.mps.lang.plugin.structure.RunConfigCreator", false, false), _context.getOutputNode(), "map_OldConfigCreatorClass");
    if ((oldCreatorClass != null)) {
      return oldCreatorClass;
    }
    return _context.getOutputNodeByInputNodeAndMappingLabelAndOutputNode(SNodeOperations.getAncestor(_context.getNode(), "jetbrains.mps.lang.plugin.structure.UniversalRunConfigCreator", false, false), _context.getOutputNode(), "map_ConfigCreatorClass");
  }

  public static Object referenceMacro_GetReferent_446387597135526744(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return _context.getOutputNodeByInputNodeAndMappingLabelAndOutputNode(SLinkOperations.getTarget(_context.getNode(), "rcType", false), _context.getOutputNode(), "map_ConfigTypeClass");
  }

  public static Object referenceMacro_GetReferent_446387597135526757(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    SNode typeNode = TypeChecker.getInstance().getTypeOf(SLinkOperations.getTarget(_context.getNode(), "target", true));
    return SLinkOperations.getTarget(TypeChecker.getInstance().getRuntimeSupport().coerce_(typeNode, HUtil.createMatchingPatternByConceptFQName("jetbrains.mps.baseLanguage.structure.ClassifierType"), true), "classifier", false);
  }

  public static Object referenceMacro_GetReferent_446387597135526769(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    SNode typeNode = TypeChecker.getInstance().getTypeOf(SLinkOperations.getTarget(_context.getNode(), "target", true));
    return SLinkOperations.getTarget(TypeChecker.getInstance().getRuntimeSupport().coerce_(typeNode, HUtil.createMatchingPatternByConceptFQName("jetbrains.mps.baseLanguage.structure.ClassifierType"), true), "classifier", false);
  }

  public static Object referenceMacro_GetReferent_7559322914920376255(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return BaseCreatorTarget_Behavior.call_getParameter_7559322914920378168(SLinkOperations.getTarget(_context.getNode(), "target", true));
  }

  public static Object referenceMacro_GetReferent_7559322914920376252(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    SNode typeNode = TypeChecker.getInstance().getTypeOf(SLinkOperations.getTarget(_context.getNode(), "target", true));
    return SLinkOperations.getTarget(TypeChecker.getInstance().getRuntimeSupport().coerce_(typeNode, HUtil.createMatchingPatternByConceptFQName("jetbrains.mps.baseLanguage.structure.ClassifierType"), true), "classifier", false);
  }

  public static Object referenceMacro_GetReferent_471524871959771467(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return (SLinkOperations.getTarget(_context.getNode(), "concept", false) == null ?
      SLinkOperations.getTarget(new QueriesGenerated.QuotationClass_x583g4_a0a0a0yb().createNode(), "concept", false) :
      SLinkOperations.getTarget(_context.getNode(), "concept", false)
    );
  }

  public static Object referenceMacro_GetReferent_3994570451548110947(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return (SLinkOperations.getTarget(_context.getNode(), "concept", false) == null ?
      SLinkOperations.getTarget(new QueriesGenerated.QuotationClass_x583g4_a0a0a0zb().createNode(), "concept", false) :
      SLinkOperations.getTarget(_context.getNode(), "concept", false)
    );
  }

  public static Object referenceMacro_GetReferent_6614054495165257580(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return SLinkOperations.getTarget(_context.getOutputNodeByInputNodeAndMappingLabelAndOutputNode(SLinkOperations.getTarget(SNodeOperations.cast(SLinkOperations.getTarget(_context.getNode(), "operation", true), "jetbrains.mps.lang.plugin.structure.RunConfigParameterReferenceOperation"), "member", false), _context.getOutputNode(), "map_RunConfigurationExecutionParameter"), "localVariableDeclaration", true);
  }

  public static boolean ifMacro_Condition_7840798570674908544(final IOperationContext operationContext, final IfMacroContext _context) {
    return SPropertyOperations.getString(_context.getNode(), "iconPath") != null;
  }

  public static boolean ifMacro_Condition_8294332872984122874(final IOperationContext operationContext, final IfMacroContext _context) {
    return (SLinkOperations.getTarget(_context.getNode(), "iconBlock", true) != null);
  }

  public static boolean ifMacro_Condition_6707043251019108517(final IOperationContext operationContext, final IfMacroContext _context) {
    return (SLinkOperations.getTarget(SLinkOperations.getTarget(_context.getNode(), "editor", true), "resetBlock", true) != null);
  }

  public static boolean ifMacro_Condition_6707043251019108547(final IOperationContext operationContext, final IfMacroContext _context) {
    return (SLinkOperations.getTarget(SLinkOperations.getTarget(_context.getNode(), "editor", true), "applyBlock", true) != null);
  }

  public static boolean ifMacro_Condition_6707043251019108600(final IOperationContext operationContext, final IfMacroContext _context) {
    return (SLinkOperations.getTarget(SLinkOperations.getTarget(_context.getNode(), "editor", true), "disposeBlock", true) != null);
  }

  public static boolean ifMacro_Condition_8901044928163425520(final IOperationContext operationContext, final IfMacroContext _context) {
    if (SNodeOperations.isInstanceOf(SLinkOperations.getTarget(_context.getNode(), "type", true), "jetbrains.mps.baseLanguage.structure.PrimitiveType")) {
      return false;
    }
    SNode type = TypeChecker.getInstance().getRuntimeSupport().coerce_(SLinkOperations.getTarget(_context.getNode(), "type", true), HUtil.createMatchingPatternByConceptFQName("jetbrains.mps.baseLanguage.structure.ClassifierType"), true);
    if (type == null) {
      return false;
    }
    if (SNodeOperations.isInstanceOf(SLinkOperations.getTarget(type, "classifier", false), "jetbrains.mps.baseLanguage.structure.EnumClass")) {
      return false;
    }
    if (SLinkOperations.getTarget(type, "classifier", false) == SLinkOperations.getTarget(new QueriesGenerated.QuotationClass_x583g4_a0a0e0gc().createNode(), "classifier", false)) {
      return false;
    }
    return true;
  }

  public static boolean ifMacro_Condition_8821770403474041673(final IOperationContext operationContext, final IfMacroContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "checkBlock", true) != null;
  }

  public static boolean ifMacro_Condition_5235140547387554339(final IOperationContext operationContext, final IfMacroContext _context) {
    return (SLinkOperations.getTarget(_context.getNode(), "suggestedName", true) != null);
  }

  public static boolean ifMacro_Condition_4418372807722341507(final IOperationContext operationContext, final IfMacroContext _context) {
    return (SLinkOperations.getTarget(_context.getNode(), "configName", true) != null);
  }

  public static boolean ifMacro_Condition_5694992420817274711(final IOperationContext operationContext, final IfMacroContext _context) {
    return (BaseCreatorTarget_Behavior.call_getParameter_7559322914920378168(SLinkOperations.getTarget(_context.getNode(), "target", true)) != null);
  }

  public static SNode sourceNodeQuery_8294332872984074416(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "iconBlock", true);
  }

  public static SNode sourceNodeQuery_6707043251019108530(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(SLinkOperations.getTarget(SLinkOperations.getTarget(_context.getNode(), "editor", true), "resetBlock", true), "body", true);
  }

  public static SNode sourceNodeQuery_6707043251019108560(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(SLinkOperations.getTarget(SLinkOperations.getTarget(_context.getNode(), "editor", true), "applyBlock", true), "body", true);
  }

  public static SNode sourceNodeQuery_6707043251019108583(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(SLinkOperations.getTarget(_context.getNode(), "editor", true), "editor", true);
  }

  public static SNode sourceNodeQuery_6707043251019108613(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(SLinkOperations.getTarget(SLinkOperations.getTarget(_context.getNode(), "editor", true), "disposeBlock", true), "body", true);
  }

  public static SNode sourceNodeQuery_1105312746397538781(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SNodeOperations.copyNode(TypeChecker.getInstance().getTypeOf(SLinkOperations.getTarget(SLinkOperations.getTarget(_context.getNode(), "editor", true), "editor", true)));
  }

  public static SNode sourceNodeQuery_8821770403474041647(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(SLinkOperations.getTarget(_context.getNode(), "checkBlock", true), "body", true);
  }

  public static SNode sourceNodeQuery_5561767741219971783(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return ActionParameter_Behavior.call_getType_1171743928471337193(_context.getNode());
  }

  public static SNode sourceNodeQuery_7840798570675188757(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(SLinkOperations.getTarget(_context.getNode(), "executeBlock", true), "body", true);
  }

  public static SNode sourceNodeQuery_7840798570675189708(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "consoleComponent", true);
  }

  public static SNode sourceNodeQuery_90909550749889565(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "disposeBlock", true);
  }

  public static SNode sourceNodeQuery_7840798570675189676(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "processHandler", true);
  }

  public static SNode sourceNodeQuery_8821770403474041737(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "error", true);
  }

  public static SNode sourceNodeQuery_8294332872985085200(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "operand", true);
  }

  public static SNode sourceNodeQuery_7382861867148540655(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "operand", true);
  }

  public static SNode sourceNodeQuery_6586153900349333382(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "actions", true);
  }

  public static SNode sourceNodeQuery_5447563960349298753(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(RunConfigCreator_Behavior.call_getFunction_5528847031674340387(_context.getNode()), "body", true);
  }

  public static SNode sourceNodeQuery_5235140547387557608(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "suggestedName", true);
  }

  public static SNode sourceNodeQuery_4418372807722341496(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "configName", true);
  }

  public static SNode sourceNodeQuery_9068086904326285561(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "propertyValue", true);
  }

  public static SNode sourceNodeQuery_5015922156501763993(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "contextItem", true);
  }

  public static SNode sourceNodeQuery_9061443648117888919(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "process", true);
  }

  public static SNode sourceNodeQuery_6483235410534828656(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "command", true);
  }

  public static SNode sourceNodeQuery_446387597135526817(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(SLinkOperations.getTarget(_context.getNode(), "createBlock", true), "body", true);
  }

  public static SNode sourceNodeQuery_446387597135550859(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "target", true);
  }

  public static SNode sourceNodeQuery_4593326532895577392(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "argument", true);
  }

  public static Iterable sourceNodesQuery_7840798570674946693(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return ListSequence.fromList(SModelOperations.getRoots(SNodeOperations.getModel(_context.getNode()), "jetbrains.mps.lang.plugin.structure.RunConfigurationDeclaration")).where(new IWhereFilter<SNode>() {
      public boolean accept(SNode it) {
        return SLinkOperations.getTarget(it, "configType", false) == _context.getNode();
      }
    });
  }

  public static Iterable sourceNodesQuery_7382861867148541769(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "property", true);
  }

  public static Iterable sourceNodesQuery_8901044928163425516(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "property", true);
  }

  public static Iterable sourceNodesQuery_5561767741219971812(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "executionParameter", true);
  }

  public static Iterable sourceNodesQuery_7840798570675189183(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "actualParameter", true);
  }

  public static Iterable sourceNodesQuery_7840798570675189192(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "action", true);
  }

  public static Iterable sourceNodesQuery_9068086904326285565(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "property", true);
  }

  public static class QuotationClass_x583g4_a0a0a0a0cb {
    public QuotationClass_x583g4_a0a0a0a0cb() {
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.ClassifierType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        quotedNode1_2.addReference(SReference.create("classifier", quotedNode1_2, SModelReference.fromString("f:java_stub#com.intellij.execution.configurations(com.intellij.execution.configurations@java_stub)"), SNodeId.fromString("~RunProfileState")));
        result = quotedNode1_2;
      }
      return result;
    }
  }

  public static class QuotationClass_x583g4_a0a0a0yb {
    public QuotationClass_x583g4_a0a0a0yb() {
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.smodel.structure.ConceptReference", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        quotedNode1_2.addReference(SReference.create("concept", quotedNode1_2, SModelReference.fromString("r:00000000-0000-4000-0000-011c89590288(jetbrains.mps.lang.core.structure)"), SNodeId.fromString("1133920641626")));
        result = quotedNode1_2;
      }
      return result;
    }
  }

  public static class QuotationClass_x583g4_a0a0a0zb {
    public QuotationClass_x583g4_a0a0a0zb() {
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.smodel.structure.ConceptReference", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        quotedNode1_2.addReference(SReference.create("concept", quotedNode1_2, SModelReference.fromString("r:00000000-0000-4000-0000-011c89590288(jetbrains.mps.lang.core.structure)"), SNodeId.fromString("1133920641626")));
        result = quotedNode1_2;
      }
      return result;
    }
  }

  public static class QuotationClass_x583g4_a0a0e0gc {
    public QuotationClass_x583g4_a0a0e0gc() {
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.ClassifierType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        quotedNode1_2.addReference(SReference.create("classifier", quotedNode1_2, SModelReference.fromString("f:java_stub#java.lang(java.lang@java_stub)"), SNodeId.fromString("~String")));
        result = quotedNode1_2;
      }
      return result;
    }
  }
}
