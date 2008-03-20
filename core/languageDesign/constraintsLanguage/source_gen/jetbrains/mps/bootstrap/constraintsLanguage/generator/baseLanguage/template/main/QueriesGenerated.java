package jetbrains.mps.bootstrap.constraintsLanguage.generator.baseLanguage.template.main;

/*Generated by MPS */

import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.generator.template.CreateRootRuleContext;
import jetbrains.mps.generator.template.BaseMappingRuleContext;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.generator.template.PropertyMacroContext;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.bootstrap.constraintsLanguage.constraints.ConceptMethodDeclaration_Behavior;
import jetbrains.mps.util.NameUtil;
import jetbrains.mps.bootstrap.constraintsLanguage.constraints.NodePropertyConstraint_Behavior;
import jetbrains.mps.bootstrap.constraintsLanguage.constraints.NodeReferentConstraint_Behavior;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.bootstrap.structureLanguage.structure.LinkDeclaration;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.bootstrap.constraintsLanguage.constraints.NodeDefaultSearchScope_Behavior;
import jetbrains.mps.smodel.behaviour.BehaviorConstants;
import jetbrains.mps.core.constraints.INamedConcept_Behavior;
import jetbrains.mps.bootstrap.constraintsLanguage.constraints.StaticConceptMethodDeclaration_Behavior;
import jetbrains.mps.generator.template.ReferenceMacroContext;
import jetbrains.mps.baseLanguage.ext.collections.internal.query.SequenceOperations;
import jetbrains.mps.bootstrap.structureLanguage.constraints.DataTypeDeclaration_Behavior;
import jetbrains.mps.generator.template.IfMacroContext;
import jetbrains.mps.generator.template.SourceSubstituteMacroNodeContext;
import jetbrains.mps.baseLanguage.constraints.Type_Behavior;
import java.util.List;
import jetbrains.mps.generator.template.SourceSubstituteMacroNodesContext;
import jetbrains.mps.bootstrap.smodelLanguage.generator.smodelAdapter.SModelOperations;
import jetbrains.mps.generator.template.TemplateFragmentContext;
import jetbrains.mps.bootstrap.constraintsLanguage.generator.baseLanguage.template.util.QueriesUtil;
import jetbrains.mps.generator.template.WeavingMappingRuleContext;

public class QueriesGenerated {

  public static boolean createRootRule_Condition_1194967181314(final IOperationContext operationContext, final CreateRootRuleContext _context) {
    return _context.getSourceModel().getLongName().endsWith(".constraints");
  }

  public static boolean baseMappingRule_Condition_1187043003325(final IOperationContext operationContext, final BaseMappingRuleContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "propertyGetter", true) != null;
  }

  public static boolean baseMappingRule_Condition_1187043119206(final IOperationContext operationContext, final BaseMappingRuleContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "propertySetter", true) != null;
  }

  public static boolean baseMappingRule_Condition_1187043231002(final IOperationContext operationContext, final BaseMappingRuleContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "referentSetHandler", true) != null;
  }

  public static boolean baseMappingRule_Condition_1187043358729(final IOperationContext operationContext, final BaseMappingRuleContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "searchScopeFactory", true) != null;
  }

  public static Object propertyMacro_GetPropertyValue_1177676953415(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(_context.getNode(), "name");
  }

  public static Object propertyMacro_GetPropertyValue_1177677003299(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return ConceptMethodDeclaration_Behavior.call_getGeneratedName_1177681178696(_context.getNode());
  }

  public static Object propertyMacro_GetPropertyValue_1181726948102(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return ConceptMethodDeclaration_Behavior.call_getCallerMethodName_1181725268250(_context.getNode());
  }

  public static Object propertyMacro_GetPropertyValue_1181727126085(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(_context.getNode(), "name");
  }

  public static Object propertyMacro_GetPropertyValue_1181727149831(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return ConceptMethodDeclaration_Behavior.call_getGeneratedName_1177681178696(_context.getNode());
  }

  public static Object propertyMacro_GetPropertyValue_1182162752919(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return ConceptMethodDeclaration_Behavior.call_getGeneratedName_1177681178696(_context.getNode());
  }

  public static Object propertyMacro_GetPropertyValue_1182162752942(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(_context.getNode(), "name");
  }

  public static Object propertyMacro_GetPropertyValue_1184608713100(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return NameUtil.nodeFQName(NodePropertyConstraint_Behavior.call_getApplicableConcept_1178176331859(_context.getNode()));
  }

  public static Object propertyMacro_GetPropertyValue_1184608867617(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return NameUtil.nodeFQName(NodePropertyConstraint_Behavior.call_getApplicableConcept_1178176331859(_context.getNode()));
  }

  public static Object propertyMacro_GetPropertyValue_1184608961609(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return NameUtil.nodeFQName(NodePropertyConstraint_Behavior.call_getApplicableConcept_1178176331859(_context.getNode()));
  }

  public static Object propertyMacro_GetPropertyValue_1184608998084(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return NameUtil.nodeFQName(NodePropertyConstraint_Behavior.call_getApplicableConcept_1178176331859(_context.getNode()));
  }

  public static Object propertyMacro_GetPropertyValue_1184609127099(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(SLinkOperations.getTarget(_context.getNode(), "applicableProperty", false), "name");
  }

  public static Object propertyMacro_GetPropertyValue_1184609151833(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(SLinkOperations.getTarget(_context.getNode(), "applicableProperty", false), "name");
  }

  public static Object propertyMacro_GetPropertyValue_1184609198140(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(SLinkOperations.getTarget(_context.getNode(), "applicableProperty", false), "name");
  }

  public static Object propertyMacro_GetPropertyValue_1184609224170(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(SLinkOperations.getTarget(_context.getNode(), "applicableProperty", false), "name");
  }

  public static Object propertyMacro_GetPropertyValue_1184609665202(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return NameUtil.nodeFQName(NodeReferentConstraint_Behavior.call_getApplicableConcept_1178190078587(_context.getNode()));
  }

  public static Object propertyMacro_GetPropertyValue_1184609700758(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return NameUtil.nodeFQName(NodeReferentConstraint_Behavior.call_getApplicableConcept_1178190078587(_context.getNode()));
  }

  public static Object propertyMacro_GetPropertyValue_1184609767181(final IOperationContext operationContext, final PropertyMacroContext _context) {
    SNode applicableLink = SLinkOperations.getTarget(_context.getNode(), "applicableLink", false);
    return SModelUtil_new.getGenuineLinkRole(((LinkDeclaration)SNodeOperations.getAdapter(applicableLink)));
  }

  public static Object propertyMacro_GetPropertyValue_1184609822047(final IOperationContext operationContext, final PropertyMacroContext _context) {
    SNode applicableLink = SLinkOperations.getTarget(_context.getNode(), "applicableLink", false);
    return SModelUtil_new.getGenuineLinkRole(((LinkDeclaration)SNodeOperations.getAdapter(applicableLink)));
  }

  public static Object propertyMacro_GetPropertyValue_1184609972214(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return NameUtil.nodeFQName(NodeReferentConstraint_Behavior.call_getApplicableConcept_1178190078587(_context.getNode()));
  }

  public static Object propertyMacro_GetPropertyValue_1184609981357(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return NameUtil.nodeFQName(NodeReferentConstraint_Behavior.call_getApplicableConcept_1178190078587(_context.getNode()));
  }

  public static Object propertyMacro_GetPropertyValue_1184610007581(final IOperationContext operationContext, final PropertyMacroContext _context) {
    SNode applicableLink = SLinkOperations.getTarget(_context.getNode(), "applicableLink", false);
    return SModelUtil_new.getGenuineLinkRole(((LinkDeclaration)SNodeOperations.getAdapter(applicableLink)));
  }

  public static Object propertyMacro_GetPropertyValue_1184610013893(final IOperationContext operationContext, final PropertyMacroContext _context) {
    SNode applicableLink = SLinkOperations.getTarget(_context.getNode(), "applicableLink", false);
    return SModelUtil_new.getGenuineLinkRole(((LinkDeclaration)SNodeOperations.getAdapter(applicableLink)));
  }

  public static Object propertyMacro_GetPropertyValue_1184610250485(final IOperationContext operationContext, final PropertyMacroContext _context) {
    String description = SPropertyOperations.getString(_context.getNode(), "searchScopeDescription");
    if(description != null) {
      return description;
    }
    return _context.getTemplateValue();
  }

  public static Object propertyMacro_GetPropertyValue_1184610547646(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return NameUtil.nodeFQName(NodeDefaultSearchScope_Behavior.call_getReferentConcept_1178193833041(_context.getNode()));
  }

  public static Object propertyMacro_GetPropertyValue_1184610580040(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return NameUtil.nodeFQName(NodeDefaultSearchScope_Behavior.call_getReferentConcept_1178193833041(_context.getNode()));
  }

  public static Object propertyMacro_GetPropertyValue_1184610822428(final IOperationContext operationContext, final PropertyMacroContext _context) {
    String description = SPropertyOperations.getString(_context.getNode(), "description");
    if(description != null) {
      return description;
    }
    return _context.getTemplateValue();
  }

  public static Object propertyMacro_GetPropertyValue_1193402330791(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return ConceptMethodDeclaration_Behavior.call_getSuperCallerMethodName_1193402369204(_context.getNode());
  }

  public static Object propertyMacro_GetPropertyValue_1193402330855(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return ConceptMethodDeclaration_Behavior.call_getGeneratedName_1177681178696(_context.getNode());
  }

  public static Object propertyMacro_GetPropertyValue_1193402330879(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(_context.getNode(), "name");
  }

  public static Object propertyMacro_GetPropertyValue_1193402330913(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return ConceptMethodDeclaration_Behavior.call_getGeneratedName_1177681178696(_context.getNode());
  }

  public static Object propertyMacro_GetPropertyValue_1193402330937(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(_context.getNode(), "name");
  }

  public static Object propertyMacro_GetPropertyValue_1194605448577(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return "PARAMETERS_" + _context.getNode().getId();
  }

  public static Object propertyMacro_GetPropertyValue_1201044913095(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return BehaviorConstants.GET_DEFAULT_CONCRETE_CONCEPT_FQ_NAME;
  }

  public static Object propertyMacro_GetPropertyValue_1201044963790(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return INamedConcept_Behavior.call_getFqName_1184686272576(SLinkOperations.getTarget(_context.getNode(), "defaultConcreteConcept", false));
  }

  public static Object propertyMacro_GetPropertyValue_1202992934826(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return BehaviorConstants.CAN_BE_A_CHILD_METHOD_NAME;
  }

  public static Object propertyMacro_GetPropertyValue_1203004860889(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return BehaviorConstants.CAN_BE_A_PARENT_METHOD_NAME;
  }

  public static Object propertyMacro_GetPropertyValue_1206018606831(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return StaticConceptMethodDeclaration_Behavior.call_getGeneratedName_1206019079060(_context.getNode());
  }

  public static Object propertyMacro_GetPropertyValue_1206018674516(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(_context.getNode(), "name");
  }

  public static Object referenceMacro_GetReferent_1194605811159(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return _context.getGenerator().findOutputNodeByInputNodeAndMappingName(_context.getNode(), "parameters");
  }

  public static Object referenceMacro_GetReferent_1194605886822(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return _context.getGenerator().findOutputNodeByInputNodeAndMappingName(_context.getNode(), "parameters");
  }

  public static Object referenceMacro_GetReferent_1194605928349(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return _context.getGenerator().findOutputNodeByInputNodeAndMappingName(_context.getNode(), "parameters");
  }

  public static Object referenceMacro_GetReferent_1194605982656(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return _context.getGenerator().findOutputNodeByInputNodeAndMappingName(_context.getNode(), "parameters");
  }

  public static Object referenceMacro_GetReferent_1194966901464(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    SNode snode = _context.getGenerator().findOutputNodeByInputNodeAndMappingName(_context.getNode(), "class_for_concept");
    return SequenceOperations.getFirst(SLinkOperations.getTargets(snode, "constructor", true));
  }

  public static Object referenceMacro_GetReferent_1194967347554(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    SNode snode = _context.getGenerator().findOutputNodeByInputNodeAndMappingName(_context.getNode(), "class_for_concept");
    return SequenceOperations.getFirst(SLinkOperations.getTargets(snode, "constructor", true));
  }

  public static Object referenceMacro_GetReferent_1194967351492(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    SNode snode = _context.getGenerator().findOutputNodeByInputNodeAndMappingName(_context.getNode(), "class_for_concept");
    return SequenceOperations.getFirst(SLinkOperations.getTargets(snode, "constructor", true));
  }

  public static Object referenceMacro_GetReferent_1198586190309(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    SNode propertyConstraint = SNodeOperations.getAncestor(_context.getNode(), "jetbrains.mps.bootstrap.constraintsLanguage.structure.NodePropertyConstraint", false, false);
    SNode property = SLinkOperations.getTarget(propertyConstraint, "applicableProperty", false);
    SNode dataType = SLinkOperations.getTarget(property, "dataType", false);
    if(dataType == null) {
      return null;
    }
    SNode bltype = DataTypeDeclaration_Behavior.call_toBaseLanguageType_1182472765133(dataType);
    if(SNodeOperations.isInstanceOf(bltype, "jetbrains.mps.baseLanguage.structure.IntegerType")) {
      return SLinkOperations.getTarget(new QuotationClass_().createNode(), "baseMethodDeclaration", false);
    }
    if(SNodeOperations.isInstanceOf(bltype, "jetbrains.mps.baseLanguage.structure.BooleanType")) {
      return SLinkOperations.getTarget(new QuotationClass_1().createNode(), "baseMethodDeclaration", false);
    }
    return SLinkOperations.getTarget(new QuotationClass_2().createNode(), "baseMethodDeclaration", false);
  }

  public static boolean ifMacro_Condition_1177759890771(final IOperationContext operationContext, final IfMacroContext _context) {
    return !(SPropertyOperations.getBoolean(_context.getNode(), "isAbstract"));
  }

  public static boolean ifMacro_Condition_1181726948109(final IOperationContext operationContext, final IfMacroContext _context) {
    return SPropertyOperations.getBoolean(_context.getNode(), "isVirtual");
  }

  public static boolean ifMacro_Condition_1182162768293(final IOperationContext operationContext, final IfMacroContext _context) {
    return !(SNodeOperations.isInstanceOf(SLinkOperations.getTarget(_context.getNode(), "returnType", true), "jetbrains.mps.baseLanguage.structure.VoidType"));
  }

  public static boolean ifMacro_Condition_1182162773432(final IOperationContext operationContext, final IfMacroContext _context) {
    return SNodeOperations.isInstanceOf(SLinkOperations.getTarget(_context.getNode(), "returnType", true), "jetbrains.mps.baseLanguage.structure.VoidType");
  }

  public static boolean ifMacro_Condition_1184610049652(final IOperationContext operationContext, final IfMacroContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "searchScopeCanCreate", true) != null;
  }

  public static boolean ifMacro_Condition_1184610109644(final IOperationContext operationContext, final IfMacroContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "searchScopeCanCreate", true) == null;
  }

  public static boolean ifMacro_Condition_1184610641051(final IOperationContext operationContext, final IfMacroContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "searchScopeCanCreate", true) != null;
  }

  public static boolean ifMacro_Condition_1184610697840(final IOperationContext operationContext, final IfMacroContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "searchScopeCanCreate", true) == null;
  }

  public static boolean ifMacro_Condition_1193402330798(final IOperationContext operationContext, final IfMacroContext _context) {
    return SPropertyOperations.getBoolean(_context.getNode(), "isVirtual");
  }

  public static boolean ifMacro_Condition_1193402330896(final IOperationContext operationContext, final IfMacroContext _context) {
    return !(SNodeOperations.isInstanceOf(SLinkOperations.getTarget(_context.getNode(), "returnType", true), "jetbrains.mps.baseLanguage.structure.VoidType"));
  }

  public static boolean ifMacro_Condition_1193402330944(final IOperationContext operationContext, final IfMacroContext _context) {
    return SNodeOperations.isInstanceOf(SLinkOperations.getTarget(_context.getNode(), "returnType", true), "jetbrains.mps.baseLanguage.structure.VoidType");
  }

  public static boolean ifMacro_Condition_1201044836362(final IOperationContext operationContext, final IfMacroContext _context) {
    return (SLinkOperations.getTarget(_context.getNode(), "defaultConcreteConcept", false) != null);
  }

  public static boolean ifMacro_Condition_1202990166610(final IOperationContext operationContext, final IfMacroContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "canBeAChild", true) != null;
  }

  public static boolean ifMacro_Condition_1203004849002(final IOperationContext operationContext, final IfMacroContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "canBeAParent", true) != null;
  }

  public static SNode sourceNodeQuery_1177676686820(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(SLinkOperations.getTarget(_context.getNode(), "constructor", true), "body", true);
  }

  public static SNode sourceNodeQuery_1177676837084(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return _context.getNode();
  }

  public static SNode sourceNodeQuery_1177676892345(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "returnType", true);
  }

  public static SNode sourceNodeQuery_1177676915590(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "body", true);
  }

  public static SNode sourceNodeQuery_1177762503932(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return _context.getNode();
  }

  public static SNode sourceNodeQuery_1181726948071(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return _context.getNode();
  }

  public static SNode sourceNodeQuery_1181726948078(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "returnType", true);
  }

  public static SNode sourceNodeQuery_1181727002179(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return Type_Behavior.call_getUnboxedType_1182580547590(SLinkOperations.getTarget(_context.getNode(), "returnType", true));
  }

  public static SNode sourceNodeQuery_1181727110484(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "type", true);
  }

  public static SNode sourceNodeQuery_1182162752928(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "type", true);
  }

  public static SNode sourceNodeQuery_1184609310103(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(SLinkOperations.getTarget(_context.getNode(), "propertyGetter", true), "body", true);
  }

  public static SNode sourceNodeQuery_1184609400762(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(SLinkOperations.getTarget(_context.getNode(), "propertySetter", true), "body", true);
  }

  public static SNode sourceNodeQuery_1184609613810(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(SLinkOperations.getTarget(_context.getNode(), "referentSetHandler", true), "body", true);
  }

  public static SNode sourceNodeQuery_1184610152426(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(SLinkOperations.getTarget(_context.getNode(), "searchScopeCanCreate", true), "body", true);
  }

  public static SNode sourceNodeQuery_1184610216074(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(SLinkOperations.getTarget(_context.getNode(), "searchScopeFactory", true), "body", true);
  }

  public static SNode sourceNodeQuery_1184610732199(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(SLinkOperations.getTarget(_context.getNode(), "searchScopeCanCreate", true), "body", true);
  }

  public static SNode sourceNodeQuery_1184610779284(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(SLinkOperations.getTarget(_context.getNode(), "searchScopeFactory", true), "body", true);
  }

  public static SNode sourceNodeQuery_1193402330769(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return _context.getNode();
  }

  public static SNode sourceNodeQuery_1193402330776(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "returnType", true);
  }

  public static SNode sourceNodeQuery_1193402330865(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "type", true);
  }

  public static SNode sourceNodeQuery_1193402330887(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return Type_Behavior.call_getUnboxedType_1182580547590(SLinkOperations.getTarget(_context.getNode(), "returnType", true));
  }

  public static SNode sourceNodeQuery_1193402330923(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "type", true);
  }

  public static SNode sourceNodeQuery_1194605404279(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return Type_Behavior.call_getClassExpression_1194035415601(SLinkOperations.getTarget(_context.getNode(), "type", true));
  }

  public static SNode sourceNodeQuery_1202990149752(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(SLinkOperations.getTarget(_context.getNode(), "canBeAChild", true), "body", true);
  }

  public static SNode sourceNodeQuery_1203004832816(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(SLinkOperations.getTarget(_context.getNode(), "canBeAParent", true), "body", true);
  }

  public static SNode sourceNodeQuery_1206018594838(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "body", true);
  }

  public static SNode sourceNodeQuery_1206018638934(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "returnType", true);
  }

  public static SNode sourceNodeQuery_1206018656405(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "type", true);
  }

  public static List sourceNodesQuery_1177676783297(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "parameter", true);
  }

  public static List sourceNodesQuery_1177676798785(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "method", true);
  }

  public static List sourceNodesQuery_1181726948063(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "parameter", true);
  }

  public static List sourceNodesQuery_1181726948095(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "method", true);
  }

  public static List sourceNodesQuery_1181727087114(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "parameter", true);
  }

  public static List sourceNodesQuery_1182162752935(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "parameter", true);
  }

  public static List sourceNodesQuery_1193402330761(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "parameter", true);
  }

  public static List sourceNodesQuery_1193402330784(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "method", true);
  }

  public static List sourceNodesQuery_1193402330872(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "parameter", true);
  }

  public static List sourceNodesQuery_1193402330930(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "parameter", true);
  }

  public static List sourceNodesQuery_1194605058164(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SequenceOperations.toList(SequenceOperations.where(SLinkOperations.getTargets(_context.getNode(), "method", true), new zPredicate(null, null)));
  }

  public static List sourceNodesQuery_1194605209301(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    SNode n = _context.getNode();
    return SLinkOperations.getTargets(n, "parameter", true);
  }

  public static List sourceNodesQuery_1194966878188(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SModelOperations.getNodes(_context.getSourceModel(), "jetbrains.mps.bootstrap.constraintsLanguage.structure.NodePropertyConstraint");
  }

  public static List sourceNodesQuery_1194966950464(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SModelOperations.getNodes(_context.getSourceModel(), "jetbrains.mps.bootstrap.constraintsLanguage.structure.NodeReferentConstraint");
  }

  public static List sourceNodesQuery_1194966965000(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SModelOperations.getNodes(_context.getSourceModel(), "jetbrains.mps.bootstrap.constraintsLanguage.structure.NodeDefaultSearchScope");
  }

  public static List sourceNodesQuery_1206018562524(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "staticMethod", true);
  }

  public static List sourceNodesQuery_1206018647334(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "parameter", true);
  }

  public static SNode templateFragment_ContextNodeQuery_1184605541559(final IOperationContext operationContext, final TemplateFragmentContext _context) {
    return QueriesUtil.get_registerSelf_body(_context.getMainContextNode());
  }

  public static SNode templateFragment_ContextNodeQuery_1184606850811(final IOperationContext operationContext, final TemplateFragmentContext _context) {
    return QueriesUtil.get_registerSelf_body(_context.getMainContextNode());
  }

  public static SNode templateFragment_ContextNodeQuery_1184606951866(final IOperationContext operationContext, final TemplateFragmentContext _context) {
    return QueriesUtil.get_unRegisterSelf_body(_context.getMainContextNode());
  }

  public static SNode templateFragment_ContextNodeQuery_1184607178268(final IOperationContext operationContext, final TemplateFragmentContext _context) {
    return QueriesUtil.get_unRegisterSelf_body(_context.getMainContextNode());
  }

  public static SNode templateFragment_ContextNodeQuery_1184607261276(final IOperationContext operationContext, final TemplateFragmentContext _context) {
    return QueriesUtil.get_registerSelf_body(_context.getMainContextNode());
  }

  public static SNode templateFragment_ContextNodeQuery_1184607289879(final IOperationContext operationContext, final TemplateFragmentContext _context) {
    return QueriesUtil.get_unRegisterSelf_body(_context.getMainContextNode());
  }

  public static SNode templateFragment_ContextNodeQuery_1184607373557(final IOperationContext operationContext, final TemplateFragmentContext _context) {
    return QueriesUtil.get_registerSelf_body(_context.getMainContextNode());
  }

  public static SNode templateFragment_ContextNodeQuery_1184607409488(final IOperationContext operationContext, final TemplateFragmentContext _context) {
    return QueriesUtil.get_unRegisterSelf_body(_context.getMainContextNode());
  }

  public static SNode weaving_MappingRule_ContextNodeQuery_1187042952593(final IOperationContext opereationContext, final WeavingMappingRuleContext _context) {
    return _context.getGenerator().findOutputNodeByInputNodeAndMappingName(_context.getNode(), "class_for_concept");
  }

  public static SNode weaving_MappingRule_ContextNodeQuery_1187043119199(final IOperationContext opereationContext, final WeavingMappingRuleContext _context) {
    return _context.getGenerator().findOutputNodeByInputNodeAndMappingName(_context.getNode(), "class_for_concept");
  }

  public static SNode weaving_MappingRule_ContextNodeQuery_1187043273468(final IOperationContext opereationContext, final WeavingMappingRuleContext _context) {
    return _context.getGenerator().findOutputNodeByInputNodeAndMappingName(_context.getNode(), "class_for_concept");
  }

  public static SNode weaving_MappingRule_ContextNodeQuery_1187043341571(final IOperationContext opereationContext, final WeavingMappingRuleContext _context) {
    return _context.getGenerator().findOutputNodeByInputNodeAndMappingName(_context.getNode(), "class_for_concept");
  }

}
