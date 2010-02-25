package jetbrains.mps.lang.textGen.generator.template.main;

/*Generated by MPS */

import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.generator.template.BaseMappingRuleContext;
import jetbrains.mps.lang.textGen.behavior.SimpleTextGenOperation_Behavior;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.textGen.behavior.AbstractTextGenParameter_Behavior;
import jetbrains.mps.typesystem.inference.TypeChecker;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.textGen.behavior.WithIndentOperation_Behavior;
import jetbrains.mps.generator.template.PropertyMacroContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.kernel.model.SModelUtil;
import jetbrains.mps.generator.template.ReferenceMacroContext;
import jetbrains.mps.generator.template.IfMacroContext;
import org.apache.commons.lang.StringUtils;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.generator.template.SourceSubstituteMacroNodeContext;
import jetbrains.mps.generator.template.SourceSubstituteMacroNodesContext;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class QueriesGenerated {
  public static boolean baseMappingRule_Condition_1234790397321(final IOperationContext operationContext, final BaseMappingRuleContext _context) {
    return !(SimpleTextGenOperation_Behavior.call_inLangConcept_1236168713983(_context.getNode()));
  }

  public static boolean baseMappingRule_Condition_1234876313955(final IOperationContext operationContext, final BaseMappingRuleContext _context) {
    return !(SNodeOperations.isInstanceOf(_context.getNode(), "jetbrains.mps.lang.textGen.structure.NodeParameter")) && !(AbstractTextGenParameter_Behavior.call_inLangConcept_1236168601263(_context.getNode()));
  }

  public static boolean baseMappingRule_Condition_1234879670664(final IOperationContext operationContext, final BaseMappingRuleContext _context) {
    return SimpleTextGenOperation_Behavior.call_inLangConcept_1236168713983(_context.getNode());
  }

  public static boolean baseMappingRule_Condition_1234879955162(final IOperationContext operationContext, final BaseMappingRuleContext _context) {
    return AbstractTextGenParameter_Behavior.call_inLangConcept_1236168601263(_context.getNode());
  }

  public static boolean baseMappingRule_Condition_1235572192248(final IOperationContext operationContext, final BaseMappingRuleContext _context) {
    return !(AbstractTextGenParameter_Behavior.call_inLangConcept_1236168601263(_context.getNode()));
  }

  public static boolean baseMappingRule_Condition_1236184352354(final IOperationContext operationContext, final BaseMappingRuleContext _context) {
    return TypeChecker.getInstance().getSubtypingManager().isSubtype(TypeChecker.getInstance().getTypeOf(SLinkOperations.getTarget(_context.getNode(), "value", true)), new QueriesGenerated.QuotationClass_8087_l523emnfaae2().createNode());
  }

  public static boolean baseMappingRule_Condition_1236184488045(final IOperationContext operationContext, final BaseMappingRuleContext _context) {
    return !(TypeChecker.getInstance().getSubtypingManager().isSubtype(TypeChecker.getInstance().getTypeOf(SLinkOperations.getTarget(_context.getNode(), "value", true)), new QueriesGenerated.QuotationClass_8087_l523emnfaafk().createNode()));
  }

  public static boolean baseMappingRule_Condition_1236188801690(final IOperationContext operationContext, final BaseMappingRuleContext _context) {
    return WithIndentOperation_Behavior.call_inLangConcept_1236188788769(_context.getNode());
  }

  public static boolean baseMappingRule_Condition_1236188817234(final IOperationContext operationContext, final BaseMappingRuleContext _context) {
    return !(WithIndentOperation_Behavior.call_inLangConcept_1236188788769(_context.getNode()));
  }

  public static boolean baseMappingRule_Condition_1237469776079(final IOperationContext operationContext, final BaseMappingRuleContext _context) {
    return TypeChecker.getInstance().getSubtypingManager().isSubtype(TypeChecker.getInstance().getTypeOf(SLinkOperations.getTarget(_context.getNode(), "value", true)), new QueriesGenerated.QuotationClass_8087_l523emnfaah2().createNode());
  }

  public static boolean baseMappingRule_Condition_1237469776105(final IOperationContext operationContext, final BaseMappingRuleContext _context) {
    return !(TypeChecker.getInstance().getSubtypingManager().isSubtype(TypeChecker.getInstance().getTypeOf(SLinkOperations.getTarget(_context.getNode(), "value", true)), new QueriesGenerated.QuotationClass_8087_l523emnfaaik().createNode()));
  }

  public static boolean baseMappingRule_Condition_1237553681577(final IOperationContext operationContext, final BaseMappingRuleContext _context) {
    return SNodeOperations.isInstanceOf((SNodeOperations.getAncestor(_context.getNode(), "jetbrains.mps.lang.textGen.structure.AbstractTextGenDeclaration", false, false)), "jetbrains.mps.lang.textGen.structure.ConceptTextGenDeclaration");
  }

  public static boolean baseMappingRule_Condition_1237553683172(final IOperationContext operationContext, final BaseMappingRuleContext _context) {
    return !(SNodeOperations.isInstanceOf((SNodeOperations.getAncestor(_context.getNode(), "jetbrains.mps.lang.textGen.structure.AbstractTextGenDeclaration", false, false)), "jetbrains.mps.lang.textGen.structure.ConceptTextGenDeclaration"));
  }

  public static Object propertyMacro_GetPropertyValue_1233679994384(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(_context.getNode(), "name");
  }

  public static Object propertyMacro_GetPropertyValue_1233930145391(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(_context.getNode(), "name");
  }

  public static Object propertyMacro_GetPropertyValue_1234790549495(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(_context.getNode(), "name");
  }

  public static Object propertyMacro_GetPropertyValue_1234804322215(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(_context.getNode(), "name");
  }

  public static Object propertyMacro_GetPropertyValue_1237212089067(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SModelOperations.getModelName(SNodeOperations.getModel(SLinkOperations.getTarget(_context.getNode(), "baseTextGen", false))) + "." + SPropertyOperations.getString(SLinkOperations.getTarget(_context.getNode(), "baseTextGen", false), "name");
  }

  public static Object propertyMacro_GetPropertyValue_1237213071541(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(SLinkOperations.getTarget(_context.getNode(), "function", false), "name");
  }

  public static Object propertyMacro_GetPropertyValue_1237213101659(final IOperationContext operationContext, final PropertyMacroContext _context) {
    SNode tg = SNodeOperations.getAncestor(SLinkOperations.getTarget(_context.getNode(), "function", false), "jetbrains.mps.lang.textGen.structure.LanguageTextGenDeclaration", false, false);
    return SModelOperations.getModelName(SNodeOperations.getModel(tg)) + "." + SPropertyOperations.getString(tg, "name");
  }

  public static Object propertyMacro_GetPropertyValue_1237213172356(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(SLinkOperations.getTarget(_context.getNode(), "function", false), "name");
  }

  public static Object propertyMacro_GetPropertyValue_1237213172365(final IOperationContext operationContext, final PropertyMacroContext _context) {
    SNode tg = SNodeOperations.getAncestor(SLinkOperations.getTarget(_context.getNode(), "function", false), "jetbrains.mps.lang.textGen.structure.LanguageTextGenDeclaration", false, false);
    return SModelOperations.getModelName(SNodeOperations.getModel(tg)) + "." + SPropertyOperations.getString(tg, "name");
  }

  public static Object propertyMacro_GetPropertyValue_1237216130332(final IOperationContext operationContext, final PropertyMacroContext _context) {
    SNode tg = SNodeOperations.getAncestor(SLinkOperations.getTarget(_context.getNode(), "function", false), "jetbrains.mps.lang.textGen.structure.LanguageTextGenDeclaration", false, false);
    return SModelOperations.getModelName(SNodeOperations.getModel(tg)) + "." + SPropertyOperations.getString(tg, "name");
  }

  public static Object propertyMacro_GetPropertyValue_1237216146977(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(SLinkOperations.getTarget(_context.getNode(), "function", false), "name");
  }

  public static Object propertyMacro_GetPropertyValue_1237468586347(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(_context.getNode(), "value");
  }

  public static Object propertyMacro_GetPropertyValue_1237468867867(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SModelUtil.getGenuineLinkRole(SLinkOperations.getTarget(SNodeOperations.cast(SLinkOperations.getTarget(SNodeOperations.cast(SLinkOperations.getTarget(_context.getNode(), "value", true), "jetbrains.mps.baseLanguage.structure.DotExpression"), "operation", true), "jetbrains.mps.lang.smodel.structure.SLinkAccess"), "link", false));
  }

  public static Object propertyMacro_GetPropertyValue_1237469183268(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(_context.getNode(), "separator");
  }

  public static Object propertyMacro_GetPropertyValue_1237469183288(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(_context.getNode(), "separator");
  }

  public static Object propertyMacro_GetPropertyValue_1237469665264(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(_context.getNode(), "value");
  }

  public static Object propertyMacro_GetPropertyValue_3761071458242063884(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getBoolean(_context.getNode(), "uniqNameInFile");
  }

  public static Object propertyMacro_GetPropertyValue_4809320654438747921(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getBoolean(_context.getNode(), "uniqNameInFile");
  }

  public static Object propertyMacro_GetPropertyValue_6302490199502034190(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SModelUtil.getGenuineLinkRole(SLinkOperations.getTarget(SNodeOperations.cast(SLinkOperations.getTarget(SNodeOperations.cast(SLinkOperations.getTarget(_context.getNode(), "value", true), "jetbrains.mps.baseLanguage.structure.DotExpression"), "operation", true), "jetbrains.mps.lang.smodel.structure.SLinkAccess"), "link", false));
  }

  public static Object referenceMacro_GetReferent_1234197240096(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "conceptDeclaration", false);
  }

  public static Object referenceMacro_GetReferent_1234874573403(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return SimpleTextGenOperation_Behavior.call_getMethodName_1234789420862(_context.getNode());
  }

  public static Object referenceMacro_GetReferent_1234875781465(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return AbstractTextGenParameter_Behavior.call_getGetterName_1234885318469(_context.getNode());
  }

  public static Object referenceMacro_GetReferent_1234879337184(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return AbstractTextGenParameter_Behavior.call_getGetterName_1234885318469(_context.getNode());
  }

  public static Object referenceMacro_GetReferent_1234879458785(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return SimpleTextGenOperation_Behavior.call_getMethodName_1234789420862(_context.getNode());
  }

  public static Object referenceMacro_GetReferent_1237468698117(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return (!(SPropertyOperations.getBoolean(_context.getNode(), "withIndent")) ?
      "append" :
      "appendWithIndent"
    );
  }

  public static Object referenceMacro_GetReferent_1237468739820(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return (!(SPropertyOperations.getBoolean(_context.getNode(), "withIndent")) ?
      "append" :
      "appendWithIndent"
    );
  }

  public static Object referenceMacro_GetReferent_1237469474662(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return (!(SPropertyOperations.getBoolean(_context.getNode(), "withIndent")) ?
      "append" :
      "appendWithIndent"
    );
  }

  public static Object referenceMacro_GetReferent_1237469665271(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return (!(SPropertyOperations.getBoolean(_context.getNode(), "withIndent")) ?
      "append" :
      "appendWithIndent"
    );
  }

  public static Object referenceMacro_GetReferent_5481714986551320063(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "conceptDeclaration", false);
  }

  public static boolean ifMacro_Condition_1237214781943(final IOperationContext operationContext, final IfMacroContext _context) {
    return (SLinkOperations.getTarget(_context.getNode(), "baseTextGen", false) != null);
  }

  public static boolean ifMacro_Condition_1237468662201(final IOperationContext operationContext, final IfMacroContext _context) {
    return SPropertyOperations.getBoolean(_context.getNode(), "withIndent");
  }

  public static boolean ifMacro_Condition_1237469183232(final IOperationContext operationContext, final IfMacroContext _context) {
    return !(SimpleTextGenOperation_Behavior.call_inLangConcept_1236168713983(_context.getNode()));
  }

  public static boolean ifMacro_Condition_1237469183254(final IOperationContext operationContext, final IfMacroContext _context) {
    return SimpleTextGenOperation_Behavior.call_inLangConcept_1236168713983(_context.getNode());
  }

  public static boolean ifMacro_Condition_1237469183275(final IOperationContext operationContext, final IfMacroContext _context) {
    return !(SimpleTextGenOperation_Behavior.call_inLangConcept_1236168713983(_context.getNode()));
  }

  public static boolean ifMacro_Condition_1237469183295(final IOperationContext operationContext, final IfMacroContext _context) {
    return SimpleTextGenOperation_Behavior.call_inLangConcept_1236168713983(_context.getNode());
  }

  public static boolean ifMacro_Condition_1237469368381(final IOperationContext operationContext, final IfMacroContext _context) {
    return SPropertyOperations.getBoolean(_context.getNode(), "withIndent");
  }

  public static boolean ifMacro_Condition_1237469899006(final IOperationContext operationContext, final IfMacroContext _context) {
    return SNodeOperations.isInstanceOf((SNodeOperations.getAncestor(_context.getNode(), "jetbrains.mps.lang.textGen.structure.AbstractTextGenDeclaration", false, false)), "jetbrains.mps.lang.textGen.structure.ConceptTextGenDeclaration");
  }

  public static boolean ifMacro_Condition_1237469901071(final IOperationContext operationContext, final IfMacroContext _context) {
    return SNodeOperations.isInstanceOf((SNodeOperations.getAncestor(_context.getNode(), "jetbrains.mps.lang.textGen.structure.AbstractTextGenDeclaration", false, false)), "jetbrains.mps.lang.textGen.structure.LanguageTextGenDeclaration");
  }

  public static boolean ifMacro_Condition_1237470933865(final IOperationContext operationContext, final IfMacroContext _context) {
    return (SLinkOperations.getTarget(_context.getNode(), "text", true) != null);
  }

  public static boolean ifMacro_Condition_1237471225044(final IOperationContext operationContext, final IfMacroContext _context) {
    return (SLinkOperations.getTarget(_context.getNode(), "text", true) != null);
  }

  public static boolean ifMacro_Condition_1237984687060(final IOperationContext operationContext, final IfMacroContext _context) {
    return SPropertyOperations.getBoolean(_context.getNode(), "withSeparator") || StringUtils.isNotEmpty(SPropertyOperations.getString(_context.getNode(), "separator"));
  }

  public static boolean ifMacro_Condition_2341412953773710155(final IOperationContext operationContext, final IfMacroContext _context) {
    return SNodeOperations.isInstanceOf(SLinkOperations.getTarget(_context.getNode(), "conceptDeclaration", false), "jetbrains.mps.lang.structure.structure.ConceptDeclaration") && SPropertyOperations.getBoolean(SNodeOperations.cast(SLinkOperations.getTarget(_context.getNode(), "conceptDeclaration", false), "jetbrains.mps.lang.structure.structure.ConceptDeclaration"), "rootable") && ListSequence.fromList(SLinkOperations.getTargets(SLinkOperations.getTarget(SLinkOperations.getTarget(_context.getNode(), "extension", true), "body", true), "statement", true)).isNotEmpty();
  }

  public static SNode sourceNodeQuery_1234792857556(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "value", true);
  }

  public static SNode sourceNodeQuery_1234804310603(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "returnType", true);
  }

  public static SNode sourceNodeQuery_1234880828413(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "value", true);
  }

  public static SNode sourceNodeQuery_1236186566776(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "value", true);
  }

  public static SNode sourceNodeQuery_1236186605656(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "value", true);
  }

  public static SNode sourceNodeQuery_1237469183208(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "list", true);
  }

  public static SNode sourceNodeQuery_1237469183305(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "list", true);
  }

  public static SNode sourceNodeQuery_1237469183317(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "list", true);
  }

  public static SNode sourceNodeQuery_1237470929159(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "text", true);
  }

  public static SNode sourceNodeQuery_1237471221478(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "text", true);
  }

  public static SNode sourceNodeQuery_4340589516981966480(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "reference", true);
  }

  public static SNode sourceNodeQuery_4340589516982036844(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "reference", true);
  }

  public static SNode sourceNodeQuery_6302490199502034063(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(SNodeOperations.cast(SLinkOperations.getTarget(_context.getNode(), "value", true), "jetbrains.mps.baseLanguage.structure.DotExpression"), "operand", true);
  }

  public static SNode sourceNodeQuery_6302490199502034223(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(SNodeOperations.cast(SLinkOperations.getTarget(_context.getNode(), "value", true), "jetbrains.mps.baseLanguage.structure.DotExpression"), "operand", true);
  }

  public static Iterable sourceNodesQuery_1234790532953(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "operation", true);
  }

  public static Iterable sourceNodesQuery_1234790593537(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "parameter", true);
  }

  public static Iterable sourceNodesQuery_1234804342939(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "function", true);
  }

  public static Iterable sourceNodesQuery_1234804362278(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "parameter", true);
  }

  public static Iterable sourceNodesQuery_1236348444985(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(SLinkOperations.getTarget(_context.getNode(), "list", true), "statement", true);
  }

  public static Iterable sourceNodesQuery_1236348455212(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(SLinkOperations.getTarget(_context.getNode(), "list", true), "statement", true);
  }

  public static Iterable sourceNodesQuery_1237212767129(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "parameter", true);
  }

  public static Iterable sourceNodesQuery_1237213172348(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "parameter", true);
  }

  public static Iterable sourceNodesQuery_1237216160530(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "parameter", true);
  }

  public static Iterable sourceNodesQuery_1237470007570(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "part", true);
  }

  public static Iterable sourceNodesQuery_1237470011010(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "part", true);
  }

  public static Iterable sourceNodesQuery_1237473011962(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(SLinkOperations.getTarget(_context.getNode(), "body", true), "statement", true);
  }

  public static Iterable sourceNodesQuery_1237473044242(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(SLinkOperations.getTarget(_context.getNode(), "body", true), "statement", true);
  }

  public static Iterable sourceNodesQuery_1237473086491(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(SLinkOperations.getTarget(SLinkOperations.getTarget(_context.getNode(), "textGenBlock", true), "body", true), "statement", true);
  }

  public static Iterable sourceNodesQuery_7547703063484825651(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(SLinkOperations.getTarget(SLinkOperations.getTarget(_context.getNode(), "extension", true), "body", true), "statement", true);
  }

  public static class QuotationClass_8087_l523emnfaae2 {
    public QuotationClass_8087_l523emnfaae2() {
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_8087_l523emnfaac9 = null;
      {
        quotedNode_8087_l523emnfaac9 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.StringType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_8087_l523emnfaac9 = quotedNode_8087_l523emnfaac9;
        result = quotedNode1_8087_l523emnfaac9;
      }
      return result;
    }
  }

  public static class QuotationClass_8087_l523emnfaafk {
    public QuotationClass_8087_l523emnfaafk() {
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_8087_l523emnfaacq = null;
      {
        quotedNode_8087_l523emnfaacq = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.StringType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_8087_l523emnfaacq = quotedNode_8087_l523emnfaacq;
        result = quotedNode1_8087_l523emnfaacq;
      }
      return result;
    }
  }

  public static class QuotationClass_8087_l523emnfaah2 {
    public QuotationClass_8087_l523emnfaah2() {
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_8087_l523emnfaad7 = null;
      {
        quotedNode_8087_l523emnfaad7 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.StringType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_8087_l523emnfaad7 = quotedNode_8087_l523emnfaad7;
        result = quotedNode1_8087_l523emnfaad7;
      }
      return result;
    }
  }

  public static class QuotationClass_8087_l523emnfaaik {
    public QuotationClass_8087_l523emnfaaik() {
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_8087_l523emnfaado = null;
      {
        quotedNode_8087_l523emnfaado = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.StringType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_8087_l523emnfaado = quotedNode_8087_l523emnfaado;
        result = quotedNode1_8087_l523emnfaado;
      }
      return result;
    }
  }
}
