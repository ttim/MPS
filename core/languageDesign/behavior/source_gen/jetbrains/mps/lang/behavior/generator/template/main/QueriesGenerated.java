package jetbrains.mps.lang.behavior.generator.template.main;

/*Generated by MPS */

import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.generator.template.PropertyMacroContext;
import jetbrains.mps.smodel.behaviour.BehaviorConstants;
import jetbrains.mps.lang.core.behavior.INamedConcept_Behavior;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.behavior.behavior.ConceptMethodDeclaration_Behavior;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.lang.behavior.behavior.StaticConceptMethodDeclaration_Behavior;
import jetbrains.mps.generator.template.ReferenceMacroContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.baseLanguage.behavior.Type_Behavior;
import jetbrains.mps.generator.template.IfMacroContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.generator.template.SourceSubstituteMacroNodeContext;
import jetbrains.mps.generator.template.SourceSubstituteMacroNodesContext;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.typesystem.inference.TypeChecker;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.smodel.SReference;
import jetbrains.mps.smodel.SModelReference;
import jetbrains.mps.smodel.SNodeId;

public class QueriesGenerated {
  public static Object propertyMacro_GetPropertyValue_1225195370259(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return "PARAMETERS_" + _context.getNode().getId();
  }

  public static Object propertyMacro_GetPropertyValue_1225195370295(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return BehaviorConstants.CAN_BE_A_CHILD_METHOD_NAME;
  }

  public static Object propertyMacro_GetPropertyValue_1225195370326(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return BehaviorConstants.CAN_BE_A_PARENT_METHOD_NAME;
  }

  public static Object propertyMacro_GetPropertyValue_1225195370337(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return INamedConcept_Behavior.call_getFqName_1213877404258(SLinkOperations.getTarget(_context.getNode(), "defaultConcreteConcept", false));
  }

  public static Object propertyMacro_GetPropertyValue_1225195370355(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return BehaviorConstants.GET_DEFAULT_CONCRETE_CONCEPT_FQ_NAME;
  }

  public static Object propertyMacro_GetPropertyValue_1225195370435(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return ConceptMethodDeclaration_Behavior.call_getGeneratedName_1225196404000(_context.getNode());
  }

  public static Object propertyMacro_GetPropertyValue_1225195370487(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return ConceptMethodDeclaration_Behavior.call_getCallerMethodName_1225196404032(_context.getNode());
  }

  public static Object propertyMacro_GetPropertyValue_1225195370537(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return ConceptMethodDeclaration_Behavior.call_getGeneratedName_1225196404000(_context.getNode());
  }

  public static Object propertyMacro_GetPropertyValue_1225195370569(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(_context.getNode(), "name");
  }

  public static Object propertyMacro_GetPropertyValue_1225195370604(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return ConceptMethodDeclaration_Behavior.call_getGeneratedName_1225196404000(_context.getNode());
  }

  public static Object propertyMacro_GetPropertyValue_1225195370636(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(_context.getNode(), "name");
  }

  public static Object propertyMacro_GetPropertyValue_1225195370690(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return ConceptMethodDeclaration_Behavior.call_getSuperCallerMethodName_1225196404049(_context.getNode());
  }

  public static Object propertyMacro_GetPropertyValue_1225195370741(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return ConceptMethodDeclaration_Behavior.call_getGeneratedName_1225196404000(_context.getNode());
  }

  public static Object propertyMacro_GetPropertyValue_1225195370773(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(_context.getNode(), "name");
  }

  public static Object propertyMacro_GetPropertyValue_1225195370809(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return ConceptMethodDeclaration_Behavior.call_getGeneratedName_1225196404000(_context.getNode());
  }

  public static Object propertyMacro_GetPropertyValue_1225195370841(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(_context.getNode(), "name");
  }

  public static Object propertyMacro_GetPropertyValue_1225195370906(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return StaticConceptMethodDeclaration_Behavior.call_getGeneratedName_1225196403920(_context.getNode());
  }

  public static Object propertyMacro_GetPropertyValue_1225195370914(final IOperationContext operationContext, final PropertyMacroContext _context) {
    return SPropertyOperations.getString(_context.getNode(), "name");
  }

  public static Object referenceMacro_GetReferent_1225195370510(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    if (SNodeOperations.isInstanceOf(SLinkOperations.getTarget(_context.getNode(), "returnType", true), "jetbrains.mps.baseLanguage.structure.PrimitiveType")) {
      return SLinkOperations.getTarget(SNodeOperations.cast(Type_Behavior.call_getUnboxedType_1213877337320(SLinkOperations.getTarget(_context.getNode(), "returnType", true)), "jetbrains.mps.baseLanguage.structure.ClassifierType"), "classifier", false);
    }
    return SLinkOperations.getTarget(new QueriesGenerated.QuotationClass_8087_0().createNode(), "classifier", false);
  }

  public static Object referenceMacro_GetReferent_1225195370545(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return _context.getOutputNodeByInputNodeAndMappingLabel(_context.getNode(), "parameters");
  }

  public static Object referenceMacro_GetReferent_1225195370612(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return _context.getOutputNodeByInputNodeAndMappingLabel(_context.getNode(), "parameters");
  }

  public static Object referenceMacro_GetReferent_1225195370713(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    if (SNodeOperations.isInstanceOf(SLinkOperations.getTarget(_context.getNode(), "returnType", true), "jetbrains.mps.baseLanguage.structure.PrimitiveType")) {
      return SLinkOperations.getTarget(SNodeOperations.cast(Type_Behavior.call_getUnboxedType_1213877337320(SLinkOperations.getTarget(_context.getNode(), "returnType", true)), "jetbrains.mps.baseLanguage.structure.ClassifierType"), "classifier", false);
    }
    return SLinkOperations.getTarget(new QueriesGenerated.QuotationClass_8087_1().createNode(), "classifier", false);
  }

  public static Object referenceMacro_GetReferent_1225195370749(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return _context.getOutputNodeByInputNodeAndMappingLabel(_context.getNode(), "parameters");
  }

  public static Object referenceMacro_GetReferent_1225195370817(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return _context.getOutputNodeByInputNodeAndMappingLabel(_context.getNode(), "parameters");
  }

  public static Object referenceMacro_GetReferent_1241075527936(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return ConceptMethodDeclaration_Behavior.call_getContainingConcept_1241074789565(_context.getNode());
  }

  public static Object referenceMacro_GetReferent_1241075556924(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return ConceptMethodDeclaration_Behavior.call_getContainingConcept_1241074789565(_context.getNode());
  }

  public static Object referenceMacro_GetReferent_1241075574811(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return ConceptMethodDeclaration_Behavior.call_getContainingConcept_1241074789565(_context.getNode());
  }

  public static Object referenceMacro_GetReferent_1241075591554(final IOperationContext operationContext, final ReferenceMacroContext _context) {
    return ConceptMethodDeclaration_Behavior.call_getContainingConcept_1241074789565(_context.getNode());
  }

  public static boolean ifMacro_Condition_1225195370286(final IOperationContext operationContext, final IfMacroContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "canBeAChild", true) != null;
  }

  public static boolean ifMacro_Condition_1225195370317(final IOperationContext operationContext, final IfMacroContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "canBeAParent", true) != null;
  }

  public static boolean ifMacro_Condition_1225195370346(final IOperationContext operationContext, final IfMacroContext _context) {
    return (SLinkOperations.getTarget(_context.getNode(), "defaultConcreteConcept", false) != null);
  }

  public static boolean ifMacro_Condition_1225195370442(final IOperationContext operationContext, final IfMacroContext _context) {
    return !(SPropertyOperations.getBoolean(SNodeOperations.cast(_context.getNode(), "jetbrains.mps.lang.behavior.structure.ConceptMethodDeclaration"), "isAbstract"));
  }

  public static boolean ifMacro_Condition_1225195370494(final IOperationContext operationContext, final IfMacroContext _context) {
    return SPropertyOperations.getBoolean(SNodeOperations.cast(_context.getNode(), "jetbrains.mps.lang.behavior.structure.ConceptMethodDeclaration"), "isVirtual");
  }

  public static boolean ifMacro_Condition_1225195370586(final IOperationContext operationContext, final IfMacroContext _context) {
    return !(SNodeOperations.isInstanceOf(SLinkOperations.getTarget(_context.getNode(), "returnType", true), "jetbrains.mps.baseLanguage.structure.VoidType"));
  }

  public static boolean ifMacro_Condition_1225195370643(final IOperationContext operationContext, final IfMacroContext _context) {
    return SNodeOperations.isInstanceOf(SLinkOperations.getTarget(_context.getNode(), "returnType", true), "jetbrains.mps.baseLanguage.structure.VoidType");
  }

  public static boolean ifMacro_Condition_1225195370697(final IOperationContext operationContext, final IfMacroContext _context) {
    return SPropertyOperations.getBoolean(SNodeOperations.cast(_context.getNode(), "jetbrains.mps.lang.behavior.structure.ConceptMethodDeclaration"), "isVirtual");
  }

  public static boolean ifMacro_Condition_1225195370790(final IOperationContext operationContext, final IfMacroContext _context) {
    return !(SNodeOperations.isInstanceOf(SLinkOperations.getTarget(_context.getNode(), "returnType", true), "jetbrains.mps.baseLanguage.structure.VoidType"));
  }

  public static boolean ifMacro_Condition_1225195370848(final IOperationContext operationContext, final IfMacroContext _context) {
    return SNodeOperations.isInstanceOf(SLinkOperations.getTarget(_context.getNode(), "returnType", true), "jetbrains.mps.baseLanguage.structure.VoidType");
  }

  public static SNode sourceNodeQuery_1225195370232(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return Type_Behavior.call_getClassExpression_1213877337357(SLinkOperations.getTarget(_context.getNode(), "type", true));
  }

  public static SNode sourceNodeQuery_1225195370273(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(SLinkOperations.getTarget(_context.getNode(), "canBeAChild", true), "body", true);
  }

  public static SNode sourceNodeQuery_1225195370304(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(SLinkOperations.getTarget(_context.getNode(), "canBeAParent", true), "body", true);
  }

  public static SNode sourceNodeQuery_1225195370365(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(SLinkOperations.getTarget(_context.getNode(), "constructor", true), "body", true);
  }

  public static SNode sourceNodeQuery_1225195370388(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SNodeOperations.cast(_context.getNode(), "jetbrains.mps.baseLanguage.structure.ParameterDeclaration");
  }

  public static SNode sourceNodeQuery_1225195370395(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(SNodeOperations.cast(_context.getNode(), "jetbrains.mps.lang.behavior.structure.ConceptMethodDeclaration"), "returnType", true);
  }

  public static SNode sourceNodeQuery_1225195370420(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(SNodeOperations.cast(_context.getNode(), "jetbrains.mps.lang.behavior.structure.ConceptMethodDeclaration"), "body", true);
  }

  public static SNode sourceNodeQuery_1225195370465(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SNodeOperations.cast(_context.getNode(), "jetbrains.mps.baseLanguage.structure.ParameterDeclaration");
  }

  public static SNode sourceNodeQuery_1225195370472(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(SNodeOperations.cast(_context.getNode(), "jetbrains.mps.lang.behavior.structure.ConceptMethodDeclaration"), "returnType", true);
  }

  public static SNode sourceNodeQuery_1225195370555(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "type", true);
  }

  public static SNode sourceNodeQuery_1225195370577(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return Type_Behavior.call_getUnboxedType_1213877337320(SLinkOperations.getTarget(_context.getNode(), "returnType", true));
  }

  public static SNode sourceNodeQuery_1225195370622(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "type", true);
  }

  public static SNode sourceNodeQuery_1225195370668(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SNodeOperations.cast(_context.getNode(), "jetbrains.mps.baseLanguage.structure.ParameterDeclaration");
  }

  public static SNode sourceNodeQuery_1225195370675(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(SNodeOperations.cast(_context.getNode(), "jetbrains.mps.lang.behavior.structure.ConceptMethodDeclaration"), "returnType", true);
  }

  public static SNode sourceNodeQuery_1225195370759(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "type", true);
  }

  public static SNode sourceNodeQuery_1225195370781(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return Type_Behavior.call_getUnboxedType_1213877337320(SLinkOperations.getTarget(_context.getNode(), "returnType", true));
  }

  public static SNode sourceNodeQuery_1225195370827(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "type", true);
  }

  public static SNode sourceNodeQuery_1225195370860(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "returnType", true);
  }

  public static SNode sourceNodeQuery_1225195370869(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return SLinkOperations.getTarget(_context.getNode(), "body", true);
  }

  public static SNode sourceNodeQuery_1225195370946(final IOperationContext operationContext, final SourceSubstituteMacroNodeContext _context) {
    return _context.getNode();
  }

  public static Iterable sourceNodesQuery_1225195370221(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    SNode n = _context.getNode();
    return SLinkOperations.getTargets(n, "parameter", true);
  }

  public static Iterable sourceNodesQuery_1225195370241(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return ListSequence.fromList(SLinkOperations.getTargets(_context.getNode(), "method", true)).where(new IWhereFilter<SNode>() {
      public boolean accept(SNode it) {
        return SPropertyOperations.getBoolean(it, "isVirtual");
      }
    }).toListSequence();
  }

  public static Iterable sourceNodesQuery_1225195370380(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(SNodeOperations.cast(_context.getNode(), "jetbrains.mps.lang.behavior.structure.ConceptMethodDeclaration"), "parameter", true);
  }

  public static Iterable sourceNodesQuery_1225195370428(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "method", true);
  }

  public static Iterable sourceNodesQuery_1225195370457(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(SNodeOperations.cast(_context.getNode(), "jetbrains.mps.lang.behavior.structure.ConceptMethodDeclaration"), "parameter", true);
  }

  public static Iterable sourceNodesQuery_1225195370480(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "method", true);
  }

  public static Iterable sourceNodesQuery_1225195370562(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "parameter", true);
  }

  public static Iterable sourceNodesQuery_1225195370629(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "parameter", true);
  }

  public static Iterable sourceNodesQuery_1225195370660(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(SNodeOperations.cast(_context.getNode(), "jetbrains.mps.lang.behavior.structure.ConceptMethodDeclaration"), "parameter", true);
  }

  public static Iterable sourceNodesQuery_1225195370683(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "method", true);
  }

  public static Iterable sourceNodesQuery_1225195370766(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "parameter", true);
  }

  public static Iterable sourceNodesQuery_1225195370834(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "parameter", true);
  }

  public static Iterable sourceNodesQuery_1225195370876(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "staticMethod", true);
  }

  public static Iterable sourceNodesQuery_1232967387673(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "parameter", true);
  }

  public static Iterable sourceNodesQuery_3317934321613707903(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "annotation", true);
  }

  public static Iterable sourceNodesQuery_3317934321613716219(final IOperationContext operationContext, final SourceSubstituteMacroNodesContext _context) {
    return SLinkOperations.getTargets(_context.getNode(), "annotation", true);
  }

  public static class QuotationClass_8087_0 {
    public QuotationClass_8087_0() {
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_0 = null;
      {
        quotedNode_0 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.ClassifierType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_0 = quotedNode_0;
        quotedNode1_0.addReference(SReference.create("classifier", quotedNode1_0, SModelReference.fromString("f:java_stub#java.lang(java.lang@java_stub)"), SNodeId.fromString("~Object")));
        result = quotedNode1_0;
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
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.ClassifierType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_1 = quotedNode_1;
        quotedNode1_1.addReference(SReference.create("classifier", quotedNode1_1, SModelReference.fromString("f:java_stub#java.lang(java.lang@java_stub)"), SNodeId.fromString("~Object")));
        result = quotedNode1_1;
      }
      return result;
    }
  }
}
