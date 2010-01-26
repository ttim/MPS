package jetbrains.mps.samples.agreementLanguage.generator.baseLanguage;

/*Generated by MPS */

import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.generator.template.CreateRootRuleContext;
import java.util.List;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SModelOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.generator.template.BaseMappingRuleContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.samples.agreementLanguage.generator.util.QueriesUtil;
import jetbrains.mps.generator.template.PropertyMacroContext;
import jetbrains.mps.util.NameUtil;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.generator.template.ReferenceMacroContext;
import jetbrains.mps.generator.template.SourceSubstituteMacroNodeContext;
import jetbrains.mps.generator.template.SourceSubstituteMacroNodesContext;
import jetbrains.mps.internal.collections.runtime.ITranslator2;
import java.util.Iterator;
import jetbrains.mps.baseLanguage.closures.runtime.YieldingIterator;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.typesystem.inference.TypeChecker;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.smodel.SReference;
import jetbrains.mps.smodel.SModelReference;
import jetbrains.mps.smodel.SNodeId;

public class QueriesGenerated {
  public static boolean createRootRule_Condition_1197658386740(final IOperationContext operationContext, final CreateRootRuleContext _context) {
    // apply rule if at least one Plan exists in input model 
    List<SNode> plans = SModelOperations.getRoots(_context.getInputModel(), "jetbrains.mps.samples.agreementLanguage.structure.Plan");
    return ListSequence.fromList(plans).isNotEmpty();
  }

  public static boolean baseMappingRule_Condition_1197664161642(final IOperationContext operationContext, final BaseMappingRuleContext _context) {
    return SPropertyOperations.hasValue(_context.getNode(), "unit", "KWH", "USD_KWH");
  }

  public static boolean baseMappingRule_Condition_1197664256798(final IOperationContext operationContext, final BaseMappingRuleContext _context) {
    return !(SPropertyOperations.hasValue(_context.getNode(), "unit", "KWH", "USD_KWH"));
  }

  public static boolean baseMappingRule_Condition_1197668424498(final IOperationContext operationContext, final BaseMappingRuleContext _context) {
    SNode eventVariable = SLinkOperations.getTarget(_context.getNode(), "eventVariable", false);
    return "fee".equals(SPropertyOperations.getString(eventVariable, "name"));
  }

  public static boolean baseMappingRule_Condition_1197668537118(final IOperationContext operationContext, final BaseMappingRuleContext _context) {
    SNode leftOperand = SLinkOperations.getTarget(_context.getNode(), "leftOperand", true);
    return QueriesUtil.isMoney(leftOperand);
  }

  public static boolean baseMappingRule_Condition_1197669676480(final IOperationContext operationContext, final BaseMappingRuleContext _context) {
    SNode leftOperand = SLinkOperations.getTarget(_context.getNode(), "leftOperand", true);
    return QueriesUtil.isMoney(leftOperand);
  }

  public static boolean baseMappingRule_Condition_1197670052131(final IOperationContext operationContext, final BaseMappingRuleContext _context) {
    SNode eventVariable = SLinkOperations.getTarget(_context.getNode(), "eventVariable", false);
    return "fee".equals(SPropertyOperations.getString(eventVariable, "name"));
  }

  public static boolean baseMappingRule_Condition_1197670162616(final IOperationContext operationContext, final BaseMappingRuleContext _context) {
    SNode leftOperand = SLinkOperations.getTarget(_context.getNode(), "leftOperand", true);
    return QueriesUtil.isMoney(leftOperand);
  }

  public static boolean baseMappingRule_Condition_1197670267710(final IOperationContext operationContext, final BaseMappingRuleContext _context) {
    return QueriesUtil.isMoney(_context.getNode());
  }

  public static boolean baseMappingRule_Condition_1197670348934(final IOperationContext operationContext, final BaseMappingRuleContext _context) {
    return !(QueriesUtil.isMoney(_context.getNode()));
  }

  public static boolean baseMappingRule_Condition_1197670443101(final IOperationContext operationContext, final BaseMappingRuleContext _context) {
    return SPropertyOperations.hasValue(SLinkOperations.getTarget(_context.getNode(), "value", false), "type", "Quantity", "Quantity");
  }

  public static boolean baseMappingRule_Condition_1197670517981(final IOperationContext operationContext, final BaseMappingRuleContext _context) {
    SNode leftOperand = SLinkOperations.getTarget(_context.getNode(), "leftOperand", true);
    return QueriesUtil.isMoney(leftOperand);
  }

  public static boolean baseMappingRule_Condition_1197670562995(final IOperationContext operationContext, final BaseMappingRuleContext _context) {
    SNode leftOperand = SLinkOperations.getTarget(_context.getNode(), "leftOperand", true);
    return QueriesUtil.isQuantity(leftOperand);
  }

  public static boolean baseMappingRule_Condition_1197671638657(final IOperationContext operationContext, final BaseMappingRuleContext _context) {
    SNode eventVariable = SLinkOperations.getTarget(_context.getNode(), "eventVariable", false);
    return "usage".equals(SPropertyOperations.getString(eventVariable, "name"));
  }

  public static boolean baseMappingRule_Condition_1197672119886(final IOperationContext operationContext, final BaseMappingRuleContext _context) {
    SNode eventVariable = SLinkOperations.getTarget(_context.getNode(), "eventVariable", false);
    return "usage".equals(SPropertyOperations.getString(eventVariable, "name"));
  }

  public static Object propertyMacro_GetPropertyValue_1197662782219(final IOperationContext operationContext, final PropertyMacroContext _context) {
    String prefix = NameUtil.capitalize(_context.getInputModel().getShortName());
    return prefix + "RegistryBuilder";
  }

  public static Object propertyMacro_GetPropertyValue_1197663015302(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return NameUtil.decapitalize(SPropertyOperations.getString(_context.getNode(), "name"));
  }

  public static Object propertyMacro_GetPropertyValue_1197663161045(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return "setUp" + SPropertyOperations.getString(_context.getNode(), "name");
  }

  public static Object propertyMacro_GetPropertyValue_1197663246177(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(_context.getNode(), "name");
  }

  public static Object propertyMacro_GetPropertyValue_1197663461983(final IOperationContext operationContext, final PropertyMacroContext _context) {
    SNode value = SNodeOperations.cast(SNodeOperations.getParent(SNodeOperations.cast(_context.getNode(), "jetbrains.mps.samples.agreementLanguage.structure.QuantityTemporalProperty")), "jetbrains.mps.samples.agreementLanguage.structure.Value");
    return SPropertyOperations.getString(value, "name");
  }

  public static Object propertyMacro_GetPropertyValue_1197663681552(final IOperationContext operationContext, final PropertyMacroContext _context) {
    SNode event = SNodeOperations.getAncestor(_context.getNode(), "jetbrains.mps.samples.agreementLanguage.structure.Event", false, false);
    return SPropertyOperations.getBoolean_def(event, "taxable", "true");
  }

  public static Object propertyMacro_GetPropertyValue_1197664480423(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(SLinkOperations.getTarget(_context.getNode(), "amount", true), "value");
  }

  public static Object propertyMacro_GetPropertyValue_1197664628975(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(SLinkOperations.getTarget(_context.getNode(), "amount", true), "value");
  }

  public static Object propertyMacro_GetPropertyValue_1197666059703(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getInteger(_context.getNode(), "year");
  }

  public static Object propertyMacro_GetPropertyValue_1197666077682(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getInteger(_context.getNode(), "month");
  }

  public static Object propertyMacro_GetPropertyValue_1197666097252(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getInteger(_context.getNode(), "day");
  }

  public static Object propertyMacro_GetPropertyValue_1197670869156(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(SLinkOperations.getTarget(_context.getNode(), "amount", true), "value");
  }

  public static Object propertyMacro_GetPropertyValue_1197670925981(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(SLinkOperations.getTarget(_context.getNode(), "amount", true), "value");
  }

  public static Object propertyMacro_GetPropertyValue_1197671024196(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(SLinkOperations.getTarget(_context.getNode(), "value", false), "name");
  }

  public static Object propertyMacro_GetPropertyValue_1197671925790(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(SLinkOperations.getTarget(_context.getNode(), "amount", true), "value");
  }

  public static Object propertyMacro_GetPropertyValue_1197671968115(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(SLinkOperations.getTarget(_context.getNode(), "value", false), "name");
  }

  public static Object referenceMacro_GetReferent_1197659829378(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    SNode event = SNodeOperations.cast(SNodeOperations.getParent(SNodeOperations.cast(_context.getNode(), "jetbrains.mps.samples.agreementLanguage.structure.PostingRuleTemporalProperty")), "jetbrains.mps.samples.agreementLanguage.structure.Event");
    SNode eventType = SLinkOperations.getTarget(event, "type", false);
    if ("SERVICE CALL".equals(SPropertyOperations.getString(eventType, "name"))) {
      return SLinkOperations.getTarget(new QueriesGenerated.QuotationClass_8087_0().createNode(), "variableDeclaration", false);
    }
    if ("USAGE".equals(SPropertyOperations.getString(eventType, "name"))) {
      return SLinkOperations.getTarget(new QueriesGenerated.QuotationClass_8087_1().createNode(), "variableDeclaration", false);
    }
    if ("TAX".equals(SPropertyOperations.getString(eventType, "name"))) {
      return SLinkOperations.getTarget(new QueriesGenerated.QuotationClass_8087_2().createNode(), "variableDeclaration", false);
    }
    return null;
  }

  public static Object referenceMacro_GetReferent_1197661270681(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    SNode postingRule = SLinkOperations.getTarget(SNodeOperations.cast(_context.getNode(), "jetbrains.mps.samples.agreementLanguage.structure.PostingRuleTemporalProperty"), "value", true);
    SNode accountType = SLinkOperations.getTarget(postingRule, "account", false);
    if ("base-usage".equals(SPropertyOperations.getString(accountType, "name"))) {
      return SLinkOperations.getTarget(new QueriesGenerated.QuotationClass_8087_3().createNode(), "enumConstantDeclaration", false);
    }
    if ("service".equals(SPropertyOperations.getString(accountType, "name"))) {
      return SLinkOperations.getTarget(new QueriesGenerated.QuotationClass_8087_4().createNode(), "enumConstantDeclaration", false);
    }
    if ("tax".equals(SPropertyOperations.getString(accountType, "name"))) {
      return SLinkOperations.getTarget(new QueriesGenerated.QuotationClass_8087_5().createNode(), "enumConstantDeclaration", false);
    }
    // error 
    return null;
  }

  public static SNode sourceNodeQuery_1197664761362(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "value", true);
  }

  public static SNode sourceNodeQuery_1197665787457(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "date", true);
  }

  public static SNode sourceNodeQuery_1197665895323(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "date", true);
  }

  public static SNode sourceNodeQuery_1197668254451(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(SLinkOperations.getTarget(_context.getNode(), "value", true), "expression", true);
  }

  public static SNode sourceNodeQuery_1197670008699(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "leftOperand", true);
  }

  public static SNode sourceNodeQuery_1197671353557(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "leftOperand", true);
  }

  public static SNode sourceNodeQuery_1197671390861(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "rightOperand", true);
  }

  public static SNode sourceNodeQuery_1197671443307(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "leftOperand", true);
  }

  public static SNode sourceNodeQuery_1197671463393(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "rightOperand", true);
  }

  public static SNode sourceNodeQuery_1197672723074(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "logicalTest", true);
  }

  public static SNode sourceNodeQuery_1197672752770(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "valueIfTrue", true);
  }

  public static SNode sourceNodeQuery_1197672770684(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "valueIfFalse", true);
  }

  public static SNode sourceNodeQuery_1197673441717(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "rightOperand", true);
  }

  public static Iterable sourceNodesQuery_1197659458874(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SModelOperations.getRoots(_context.getInputModel(), "jetbrains.mps.samples.agreementLanguage.structure.Plan");
  }

  public static Iterable sourceNodesQuery_1197659602870(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    List<SNode> events = SLinkOperations.getTargets(_context.getNode(), "event", true);
    return ListSequence.fromList(events).translate(new ITranslator2<SNode, SNode>() {
      public Iterable<SNode> translate(final SNode event) {
        return new Iterable<SNode>() {
          public Iterator<SNode> iterator() {
            return new YieldingIterator<SNode>() {
              private int __CP__ = 0;
              private SNode _2_postingRule;
              private Iterator<SNode> _2_postingRule_it;

              protected boolean moveToNext() {
__loop__:
                do {
__switch__:
                  switch (this.__CP__) {
                    case -1:
                      assert false : "Internal error";
                      return false;
                    case 2:
                      this._2_postingRule_it = ListSequence.fromList(SLinkOperations.getTargets(event, "postingRule", true)).iterator();
                    case 3:
                      if (!(this._2_postingRule_it.hasNext())) {
                        this.__CP__ = 1;
                        break;
                      }
                      this._2_postingRule = this._2_postingRule_it.next();
                      this.__CP__ = 4;
                      break;
                    case 5:
                      this.__CP__ = 3;
                      this.yield(_2_postingRule);
                      return true;
                    case 0:
                      this.__CP__ = 2;
                      break;
                    case 4:
                      this.__CP__ = 5;
                      break;
                    default:
                      break __loop__;
                  }
                } while(true);
                return false;
              }
            };
          }
        };
      }
    }).toListSequence();
  }

  public static Iterable sourceNodesQuery_1197662961260(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SModelOperations.getRoots(_context.getInputModel(), "jetbrains.mps.samples.agreementLanguage.structure.Plan");
  }

  public static Iterable sourceNodesQuery_1197663210559(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "value", true);
  }

  public static Iterable sourceNodesQuery_1197663295186(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    List<SNode> values = SLinkOperations.getTargets(_context.getNode(), "value", true);
    return ListSequence.fromList(values).translate(new ITranslator2<SNode, SNode>() {
      public Iterable<SNode> translate(final SNode value) {
        return new Iterable<SNode>() {
          public Iterator<SNode> iterator() {
            return new YieldingIterator<SNode>() {
              private int __CP__ = 0;
              private SNode _2_quantity;
              private Iterator<SNode> _2_quantity_it;

              protected boolean moveToNext() {
__loop__:
                do {
__switch__:
                  switch (this.__CP__) {
                    case -1:
                      assert false : "Internal error";
                      return false;
                    case 2:
                      this._2_quantity_it = ListSequence.fromList(SLinkOperations.getTargets(value, "quantity", true)).iterator();
                    case 3:
                      if (!(this._2_quantity_it.hasNext())) {
                        this.__CP__ = 1;
                        break;
                      }
                      this._2_quantity = this._2_quantity_it.next();
                      this.__CP__ = 4;
                      break;
                    case 5:
                      this.__CP__ = 3;
                      this.yield(_2_quantity);
                      return true;
                    case 0:
                      this.__CP__ = 2;
                      break;
                    case 4:
                      this.__CP__ = 5;
                      break;
                    default:
                      break __loop__;
                  }
                } while(true);
                return false;
              }
            };
          }
        };
      }
    }).toListSequence();
  }

  public static class QuotationClass_8087_0 {
    public QuotationClass_8087_0() {
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_8087_0 = null;
      {
        quotedNode_8087_0 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.StaticFieldReference", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_8087_0 = quotedNode_8087_0;
        quotedNode1_8087_0.addReference(SReference.create("classifier", quotedNode1_8087_0, SModelReference.fromString("f:java_stub#postingrules(postingrules@java_stub)"), SNodeId.fromString("~EventType")));
        quotedNode1_8087_0.addReference(SReference.create("variableDeclaration", quotedNode1_8087_0, SModelReference.fromString("f:java_stub#postingrules(postingrules@java_stub)"), SNodeId.fromString("~EventType.SERVICE_CALL")));
        result = quotedNode1_8087_0;
      }
      return result;
    }
  }

  public static class QuotationClass_8087_1 {
    public QuotationClass_8087_1() {
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_8087_1 = null;
      {
        quotedNode_8087_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.StaticFieldReference", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_8087_1 = quotedNode_8087_1;
        quotedNode1_8087_1.addReference(SReference.create("classifier", quotedNode1_8087_1, SModelReference.fromString("f:java_stub#postingrules(postingrules@java_stub)"), SNodeId.fromString("~EventType")));
        quotedNode1_8087_1.addReference(SReference.create("variableDeclaration", quotedNode1_8087_1, SModelReference.fromString("f:java_stub#postingrules(postingrules@java_stub)"), SNodeId.fromString("~EventType.USAGE")));
        result = quotedNode1_8087_1;
      }
      return result;
    }
  }

  public static class QuotationClass_8087_2 {
    public QuotationClass_8087_2() {
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_8087_2 = null;
      {
        quotedNode_8087_2 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.StaticFieldReference", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_8087_2 = quotedNode_8087_2;
        quotedNode1_8087_2.addReference(SReference.create("classifier", quotedNode1_8087_2, SModelReference.fromString("f:java_stub#postingrules(postingrules@java_stub)"), SNodeId.fromString("~EventType")));
        quotedNode1_8087_2.addReference(SReference.create("variableDeclaration", quotedNode1_8087_2, SModelReference.fromString("f:java_stub#postingrules(postingrules@java_stub)"), SNodeId.fromString("~EventType.TAX")));
        result = quotedNode1_8087_2;
      }
      return result;
    }
  }

  public static class QuotationClass_8087_3 {
    public QuotationClass_8087_3() {
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_8087_3 = null;
      {
        quotedNode_8087_3 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.EnumConstantReference", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_8087_3 = quotedNode_8087_3;
        quotedNode1_8087_3.addReference(SReference.create("enumClass", quotedNode1_8087_3, SModelReference.fromString("f:java_stub#postingrules(postingrules@java_stub)"), SNodeId.fromString("~AccountType")));
        quotedNode1_8087_3.addReference(SReference.create("enumConstantDeclaration", quotedNode1_8087_3, SModelReference.fromString("f:java_stub#postingrules(postingrules@java_stub)"), SNodeId.fromString("~AccountType.BASE_USAGE")));
        result = quotedNode1_8087_3;
      }
      return result;
    }
  }

  public static class QuotationClass_8087_4 {
    public QuotationClass_8087_4() {
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_8087_4 = null;
      {
        quotedNode_8087_4 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.EnumConstantReference", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_8087_4 = quotedNode_8087_4;
        quotedNode1_8087_4.addReference(SReference.create("enumClass", quotedNode1_8087_4, SModelReference.fromString("f:java_stub#postingrules(postingrules@java_stub)"), SNodeId.fromString("~AccountType")));
        quotedNode1_8087_4.addReference(SReference.create("enumConstantDeclaration", quotedNode1_8087_4, SModelReference.fromString("f:java_stub#postingrules(postingrules@java_stub)"), SNodeId.fromString("~AccountType.SERVICE")));
        result = quotedNode1_8087_4;
      }
      return result;
    }
  }

  public static class QuotationClass_8087_5 {
    public QuotationClass_8087_5() {
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_8087_5 = null;
      {
        quotedNode_8087_5 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.EnumConstantReference", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_8087_5 = quotedNode_8087_5;
        quotedNode1_8087_5.addReference(SReference.create("enumClass", quotedNode1_8087_5, SModelReference.fromString("f:java_stub#postingrules(postingrules@java_stub)"), SNodeId.fromString("~AccountType")));
        quotedNode1_8087_5.addReference(SReference.create("enumConstantDeclaration", quotedNode1_8087_5, SModelReference.fromString("f:java_stub#postingrules(postingrules@java_stub)"), SNodeId.fromString("~AccountType.TAX")));
        result = quotedNode1_8087_5;
      }
      return result;
    }
  }
}
