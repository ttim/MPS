package jetbrains.mps.lang.smodel.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.dependencies.CheckingMethod;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.behavior.SNodeOperation_Behavior;
import jetbrains.mps.typesystem.inference.TypeChecker;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptPropertyOperations;
import jetbrains.mps.lang.smodel.behavior.ILinkAccess_Behavior;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.structure.behavior.DataTypeDeclaration_Behavior;
import jetbrains.mps.errors.messageTargets.MessageTarget;
import jetbrains.mps.errors.messageTargets.NodeMessageTarget;
import jetbrains.mps.errors.IErrorReporter;
import jetbrains.mps.util.NameUtil;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.typesystem.dependencies.InferenceMethod;
import jetbrains.mps.typesystem.inference.EquationInfo;
import jetbrains.mps.lang.typesystem.runtime.HUtil;
import java.util.ArrayList;
import jetbrains.mps.typesystem.inference.SubtypingManager;
import java.util.Set;
import jetbrains.mps.internal.collections.runtime.SetSequence;
import java.util.HashSet;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.smodel.SReference;
import jetbrains.mps.smodel.SModelReference;
import jetbrains.mps.smodel.SNodeId;

public class RulesUtil {
  @CheckingMethod
  public static void checkAppliedCorrectly_generic(final TypeCheckingContext typeCheckingContext, final SNode op) {
    if (SConceptOperations.isExactly(SNodeOperations.getConceptDeclaration(op), "jetbrains.mps.lang.smodel.structure.SNodeOperation")) {
      // don't check - it is red anyway 
      return;
    }
    final SNode leftExpression = SNodeOperation_Behavior.call_getLeftExpression_1213877508894(op);
    SNode LeftType = TypeChecker.getInstance().getTypeOf(leftExpression);
    boolean isGood = false;
    if (SConceptPropertyOperations.getBoolean(op, "applicableToModel")) {
      if (TypeChecker.getInstance().getSubtypingManager().isSubtype(LeftType, new RulesUtil.QuotationClass_yxkngc_a1a0a0e0a().createNode(typeCheckingContext), false)) {
        isGood = true;
      }
    }
    if (SConceptPropertyOperations.getBoolean(op, "applicableToConcept")) {
      if (TypeChecker.getInstance().getSubtypingManager().isSubtype(LeftType, new RulesUtil.QuotationClass_yxkngc_a1a0a0f0a().createNode(typeCheckingContext))) {
        isGood = true;
      }
    }
    if (SConceptPropertyOperations.getBoolean(op, "applicableToNode")) {
      if (TypeChecker.getInstance().getSubtypingManager().isSubtype(LeftType, new RulesUtil.QuotationClass_yxkngc_a1a0a0g0a().createNode(typeCheckingContext), false)) {
        isGood = true;
      }
    }
    // =========== 
    if (SConceptPropertyOperations.getBoolean(op, "applicableToLink")) {
      SNode linkAccess = SNodeOperations.as(SNodeOperation_Behavior.call_getLeftExpressionOperation_1213877508946(op), "jetbrains.mps.lang.smodel.structure.ILinkAccess");
      if (linkAccess != null) {
        isGood = ILinkAccess_Behavior.call_isSingularCardinality_4024382256428848847(linkAccess);
        if (isGood) {
          // some of ops applicable to 'link' require left-expr to be a concept 
          if (SConceptPropertyOperations.getBoolean(op, "applicableToConcept") && !(SConceptPropertyOperations.getBoolean(op, "applicableToNode"))) {
            isGood = TypeChecker.getInstance().getSubtypingManager().isSubtype(LeftType, new RulesUtil.QuotationClass_yxkngc_a1a0a0a1a1a1a8a0().createNode(typeCheckingContext));
          }
        }
      }
    }
    if (SConceptPropertyOperations.getBoolean(op, "applicableToLinkList")) {
      SNode linkAccess = SNodeOperations.as(SNodeOperation_Behavior.call_getLeftExpressionOperation_1213877508946(op), "jetbrains.mps.lang.smodel.structure.ILinkAccess");
      if (linkAccess != null) {
        isGood = !(ILinkAccess_Behavior.call_isSingularCardinality_4024382256428848847(linkAccess));
      }
    }
    // =========== 
    SNode leftOperation = SNodeOperation_Behavior.call_getLeftExpressionOperation_1213877508946(op);
    if (SConceptPropertyOperations.getBoolean(op, "applicableToSimpleProperty")) {
      if (SConceptOperations.isExactly(SNodeOperations.getConceptDeclaration(leftOperation), "jetbrains.mps.lang.smodel.structure.SPropertyAccess")) {
        SNode propertyDecl = SLinkOperations.getTarget(SNodeOperations.cast(leftOperation, "jetbrains.mps.lang.smodel.structure.SPropertyAccess"), "property", false);
        if (DataTypeDeclaration_Behavior.call_isSimple_1220268671473(SLinkOperations.getTarget(propertyDecl, "dataType", false))) {
          isGood = true;
        }
      }
    }
    if (SConceptPropertyOperations.getBoolean(op, "applicableToEnumProperty")) {
      if (SConceptOperations.isExactly(SNodeOperations.getConceptDeclaration(leftOperation), "jetbrains.mps.lang.smodel.structure.SPropertyAccess")) {
        SNode propertyDecl = SLinkOperations.getTarget(SNodeOperations.cast(leftOperation, "jetbrains.mps.lang.smodel.structure.SPropertyAccess"), "property", false);
        if (DataTypeDeclaration_Behavior.call_isEnum_1220268692373(SLinkOperations.getTarget(propertyDecl, "dataType", false))) {
          isGood = true;
        }
      }
    }
    if (SConceptPropertyOperations.getBoolean(op, "applicableToConceptProperty")) {
      if (SConceptOperations.isExactly(SNodeOperations.getConceptDeclaration(leftOperation), "jetbrains.mps.lang.smodel.structure.SConceptPropertyAccess")) {
        isGood = true;
      }
    }
    if (!(isGood)) {
      MessageTarget errorTarget = new NodeMessageTarget();
      IErrorReporter _reporter_2309309498 = typeCheckingContext.reportTypeError(op, "operation is not applicable to " + LeftType, "r:00000000-0000-4000-0000-011c895902fe(jetbrains.mps.lang.smodel.typesystem)", "1186067417054", null, errorTarget);
    }
  }

  @CheckingMethod
  public static void checkAppliedTo_LinkAccess_aggregation(final TypeCheckingContext typeCheckingContext, final SNode op) {
    // expect access to an aggregation link with singular cardinality 
    final SNode leftExpressionOp = SNodeOperation_Behavior.call_getLeftExpressionOperation_1213877508946(op);
    boolean isGood = false;
    if (SNodeOperations.isInstanceOf(leftExpressionOp, "jetbrains.mps.lang.smodel.structure.ILinkAccess")) {
      if (ILinkAccess_Behavior.call_isAggregation_4024382256428848854(SNodeOperations.cast(leftExpressionOp, "jetbrains.mps.lang.smodel.structure.ILinkAccess"))) {
        isGood = true;
      }
    }
    // ---- 
    if (!(isGood)) {
      MessageTarget errorTarget = new NodeMessageTarget();
      IErrorReporter _reporter_2309309498 = typeCheckingContext.reportTypeError(op, "operation is only applicable to aggregation-link-access", "r:00000000-0000-4000-0000-011c895902fe(jetbrains.mps.lang.smodel.typesystem)", "1205272067893", null, errorTarget);
    }
  }

  @CheckingMethod
  public static void checkAppliedNotTo_LinkAccess_reference(final TypeCheckingContext typeCheckingContext, SNode op) {
    // expect access to an aggregation link with singular cardinality 
    // left expression could also be something else (like just 'node') but not access to a reference link 
    SNode leftExpressionOp = SNodeOperation_Behavior.call_getLeftExpressionOperation_1213877508946(op);
    boolean isGood = true;
    if (SNodeOperations.isInstanceOf(leftExpressionOp, "jetbrains.mps.lang.smodel.structure.ILinkAccess")) {
      if (!(ILinkAccess_Behavior.call_isAggregation_4024382256428848854(SNodeOperations.cast(leftExpressionOp, "jetbrains.mps.lang.smodel.structure.ILinkAccess")))) {
        isGood = false;
      }
    }
    // ---- 
    if (!(isGood)) {
      MessageTarget errorTarget = new NodeMessageTarget();
      IErrorReporter _reporter_2309309498 = typeCheckingContext.reportTypeError(op, "operation is not applicable to reference-link-access", "r:00000000-0000-4000-0000-011c895902fe(jetbrains.mps.lang.smodel.typesystem)", "1230333667606", null, errorTarget);
    }
  }

  @CheckingMethod
  public static boolean checkAssignableConcept(final TypeCheckingContext typeCheckingContext, SNode fromConcept, SNode toConcept, SNode nodeToReportError, String errorTextPrefix) {
    if (SConceptOperations.isSubConceptOf(fromConcept, NameUtil.nodeFQName(toConcept))) {
      return true;
    }
    {
      MessageTarget errorTarget = new NodeMessageTarget();
      IErrorReporter _reporter_2309309498 = typeCheckingContext.reportTypeError(nodeToReportError, "" + errorTextPrefix + "\nexpected: " + SPropertyOperations.getString(toConcept, "name") + "\nwas: " + SPropertyOperations.getString(fromConcept, "name"), "r:00000000-0000-4000-0000-011c895902fe(jetbrains.mps.lang.smodel.typesystem)", "1179506569646", null, errorTarget);
    }
    return false;
  }

  @CheckingMethod
  public static boolean checkOpParameters_generic(final TypeCheckingContext typeCheckingContext, SNode op) {
    boolean noProblem = true;
    List<SNode> applicableParmConcepts = SLinkOperations.getConceptLinkTargets(op, "applicableParameter");
    for (SNode parm : ListSequence.fromList(SLinkOperations.getTargets(op, "parameter", true))) {
      if (!(ListSequence.fromList(applicableParmConcepts).contains(SNodeOperations.getConceptDeclaration(parm)))) {
        {
          MessageTarget errorTarget = new NodeMessageTarget();
          IErrorReporter _reporter_2309309498 = typeCheckingContext.reportTypeError(parm, "not applicable here", "r:00000000-0000-4000-0000-011c895902fe(jetbrains.mps.lang.smodel.typesystem)", "1178302007667", null, errorTarget);
        }
        noProblem = false;
      }
    }
    return noProblem;
  }

  @InferenceMethod
  public static void equate_inputNodeConcept(final TypeCheckingContext typeCheckingContext, SNode op, SNode TypeToEquate) {
    RulesUtil.equate_inputNodeConcept_internal(typeCheckingContext, op, TypeToEquate);
  }

  @InferenceMethod
  private static void equate_inputNodeConcept_internal(final TypeCheckingContext typeCheckingContext, final SNode op, final SNode TypeToEquate) {
    final SNode leftExpression = SNodeOperation_Behavior.call_getLeftExpression_1213877508894(op);
    {
      final SNode LeftType = typeCheckingContext.typeOf(leftExpression, "r:00000000-0000-4000-0000-011c895902fe(jetbrains.mps.lang.smodel.typesystem)", "8844001996561701140", false);
      typeCheckingContext.whenConcrete(LeftType, new Runnable() {
        public void run() {
          {
            SNode _nodeToCheck_1029348928467 = null;
            EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c895902fe(jetbrains.mps.lang.smodel.typesystem)", "3056149436216256793", 0, null);
            typeCheckingContext.createGreaterThanInequality((SNode) new RulesUtil.QuotationClass_yxkngc_a0a0a1a6().createNode(TypeToEquate, TypeToEquate, typeCheckingContext), (SNode) typeCheckingContext.getExpandedNode(LeftType), false, true, _info_12389875345);
          }
        }
      }, "r:00000000-0000-4000-0000-011c895902fe(jetbrains.mps.lang.smodel.typesystem)", "8844001996561701137", true, false);
    }
  }

  public static SNode get_inputNodeConcept(final SNode op, final boolean conceptOfConceptIfInputConcept) {
    final SNode leftExpression = SNodeOperation_Behavior.call_getLeftExpression_1213877508894(op);
    SNode leftType = TypeChecker.getInstance().getTypeOf(leftExpression);
    SNode conceptDeclaration = null;
    if (SNodeOperations.isInstanceOf(SNodeOperation_Behavior.call_getLeftExpressionOperation_1213877508946(op), "jetbrains.mps.lang.smodel.structure.ILinkAccess")) {
      conceptDeclaration = ILinkAccess_Behavior.call_getTargetConcept_4024382256428848859(SNodeOperations.cast(SNodeOperation_Behavior.call_getLeftExpressionOperation_1213877508946(op), "jetbrains.mps.lang.smodel.structure.ILinkAccess"));
    } else
    if (SNodeOperations.isInstanceOf(leftType, "jetbrains.mps.lang.smodel.structure.SNodeType")) {
      conceptDeclaration = SLinkOperations.getTarget(SNodeOperations.cast(leftType, "jetbrains.mps.lang.smodel.structure.SNodeType"), "concept", false);
    } else
    if (SNodeOperations.isInstanceOf(leftType, "jetbrains.mps.lang.smodel.structure.SConceptType")) {
      if (conceptOfConceptIfInputConcept) {
        conceptDeclaration = SLinkOperations.getTarget(SNodeOperations.cast(leftType, "jetbrains.mps.lang.smodel.structure.SConceptType"), "conceptDeclaraton", false);
      } else {
        conceptDeclaration = SConceptOperations.findConceptDeclaration("jetbrains.mps.lang.structure.structure.AbstractConceptDeclaration");
      }
    } else if (SNodeOperations.isInstanceOf(conceptDeclaration, "jetbrains.mps.lang.typesystem.structure.RuntimeTypeVariable")) {
      conceptDeclaration = SConceptOperations.findConceptDeclaration("jetbrains.mps.lang.core.structure.BaseConcept");
    } else {
      SNode nodeType = TypeChecker.getInstance().getRuntimeSupport().coerce_(leftType, HUtil.createMatchingPatternByConceptFQName("jetbrains.mps.lang.smodel.structure.SNodeType"), false);
      if (nodeType != null) {
        conceptDeclaration = SLinkOperations.getTarget(nodeType, "concept", false);
      }
    }
    if (conceptDeclaration == null) {
      conceptDeclaration = SConceptOperations.findConceptDeclaration("jetbrains.mps.lang.core.structure.BaseConcept");
    }
    return conceptDeclaration;
  }

  @InferenceMethod
  public static void equate_inputNodeType(final TypeCheckingContext typeCheckingContext, SNode op, SNode TypeToEquate) {
    final SNode Concept_typevar_1206099042246 = typeCheckingContext.createNewRuntimeTypesVariable();
    equate_inputNodeConcept(typeCheckingContext, op, typeCheckingContext.getRepresentative(Concept_typevar_1206099042246));
    {
      SNode _nodeToCheck_1029348928467 = null;
      EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c895902fe(jetbrains.mps.lang.smodel.typesystem)", "1206099071408", 0, null);
      typeCheckingContext.createEquation((SNode) TypeToEquate, (SNode) new RulesUtil.QuotationClass_yxkngc_a0a2a8().createNode(typeCheckingContext.getRepresentative(Concept_typevar_1206099042246), typeCheckingContext), _info_12389875345);
    }
  }

  @InferenceMethod
  public static void equate_conceptFromOpParm(final TypeCheckingContext typeCheckingContext, final SNode op, final SNode TypeToEquate) {
    SNode opParm = SNodeOperations.cast(SNodeOperation_Behavior.call_getParameter_1213877508972(op, SConceptOperations.findConceptDeclaration("jetbrains.mps.lang.smodel.structure.OperationParm_Concept")), "jetbrains.mps.lang.smodel.structure.OperationParm_Concept");
    SNode opParmList = SNodeOperations.cast(SNodeOperation_Behavior.call_getParameter_1213877508972(op, SConceptOperations.findConceptDeclaration("jetbrains.mps.lang.smodel.structure.OperationParm_ConceptList")), "jetbrains.mps.lang.smodel.structure.OperationParm_ConceptList");
    if (opParm == null) {
      if (opParmList == null) {
        {
          SNode _nodeToCheck_1029348928467 = null;
          EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c895902fe(jetbrains.mps.lang.smodel.typesystem)", "1207352395113", 0, null);
          typeCheckingContext.createEquation((SNode) TypeToEquate, (SNode) SConceptOperations.findConceptDeclaration("jetbrains.mps.lang.core.structure.BaseConcept"), _info_12389875345);
        }
      } else {
        List<SNode> concepts = new ArrayList<SNode>();
        for (SNode conceptReference : SLinkOperations.getTargets(opParmList, "concept", true)) {
          ListSequence.fromList(concepts).addElement(SLinkOperations.getTarget(conceptReference, "concept", false));
        }
        {
          SNode _nodeToCheck_1029348928467 = null;
          EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c895902fe(jetbrains.mps.lang.smodel.typesystem)", "1222429361005", 0, null);
          typeCheckingContext.createEquation((SNode) TypeToEquate, (SNode) leastCommonSuperconcept(concepts), _info_12389875345);
        }
      }
    } else
    if (SNodeOperations.isInstanceOf(SLinkOperations.getTarget(opParm, "conceptArgument", true), "jetbrains.mps.lang.smodel.structure.RefConcept_Reference")) {
      {
        SNode _nodeToCheck_1029348928467 = null;
        EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c895902fe(jetbrains.mps.lang.smodel.typesystem)", "1219348168406", 0, null);
        typeCheckingContext.createEquation((SNode) TypeToEquate, (SNode) SLinkOperations.getTarget(SNodeOperations.cast(SLinkOperations.getTarget(opParm, "conceptArgument", true), "jetbrains.mps.lang.smodel.structure.RefConcept_Reference"), "conceptDeclaration", false), _info_12389875345);
      }
    } else
    if (SNodeOperations.isInstanceOf(SLinkOperations.getTarget(opParm, "conceptArgument", true), "jetbrains.mps.lang.smodel.structure.PoundExpression")) {
      final SNode Concept_typevar_1226669497837 = typeCheckingContext.createNewRuntimeTypesVariable();
      {
        SNode _nodeToCheck_1029348928467 = SLinkOperations.getTarget(opParm, "conceptArgument", true);
        EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c895902fe(jetbrains.mps.lang.smodel.typesystem)", "1226669167291", 0, null);
        typeCheckingContext.createLessThanInequality((SNode) typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:00000000-0000-4000-0000-011c895902fe(jetbrains.mps.lang.smodel.typesystem)", "1226669149487", false), (SNode) new RulesUtil.QuotationClass_yxkngc_a0a1a0a2a9().createNode(typeCheckingContext.getRepresentative(Concept_typevar_1226669497837), typeCheckingContext), false, true, _info_12389875345);
      }
      {
        SNode _nodeToCheck_1029348928467 = null;
        EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c895902fe(jetbrains.mps.lang.smodel.typesystem)", "1226669541468", 0, null);
        typeCheckingContext.createEquation((SNode) TypeToEquate, (SNode) typeCheckingContext.getRepresentative(Concept_typevar_1226669497837), _info_12389875345);
      }
    }
  }

  public static SNode leastCommonSuperconcept(List<SNode> concepts) {
    SubtypingManager subtypingManager = TypeChecker.getInstance().getSubtypingManager();
    Set<SNode> set = SetSequence.fromSet(new HashSet<SNode>());
    for (SNode concept : concepts) {
      SetSequence.fromSet(set).addElement(new RulesUtil.QuotationClass_yxkngc_a0a0a0c0k().createNode(concept));
    }
    Set<SNode> leastCommonSupertypes = subtypingManager.leastCommonSupertypes(set, true);
    if (leastCommonSupertypes.isEmpty()) {
      return SLinkOperations.getTarget(new RulesUtil.QuotationClass_yxkngc_a0a0a4a01().createNode(), "concept", false);
    }
    return SLinkOperations.getTarget(SNodeOperations.cast(leastCommonSupertypes.iterator().next(), "jetbrains.mps.lang.smodel.structure.SNodeType"), "concept", false);
  }

  public static class QuotationClass_yxkngc_a1a0a0e0a {
    public QuotationClass_yxkngc_a1a0a0e0a() {
    }

    public SNode createNode(final TypeCheckingContext typeCheckingContext) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.smodel.structure.SModelType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        result = quotedNode1_2;
      }
      return result;
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.smodel.structure.SModelType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        result = quotedNode1_2;
      }
      return result;
    }
  }

  public static class QuotationClass_yxkngc_a1a0a0f0a {
    public QuotationClass_yxkngc_a1a0a0f0a() {
    }

    public SNode createNode(final TypeCheckingContext typeCheckingContext) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.smodel.structure.SConceptType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        result = quotedNode1_2;
      }
      return result;
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.smodel.structure.SConceptType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        result = quotedNode1_2;
      }
      return result;
    }
  }

  public static class QuotationClass_yxkngc_a1a0a0g0a {
    public QuotationClass_yxkngc_a1a0a0g0a() {
    }

    public SNode createNode(final TypeCheckingContext typeCheckingContext) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.smodel.structure.SNodeType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        result = quotedNode1_2;
      }
      return result;
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.smodel.structure.SNodeType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        result = quotedNode1_2;
      }
      return result;
    }
  }

  public static class QuotationClass_yxkngc_a1a0a0a1a1a1a8a0 {
    public QuotationClass_yxkngc_a1a0a0a1a1a1a8a0() {
    }

    public SNode createNode(final TypeCheckingContext typeCheckingContext) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.smodel.structure.SConceptType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        result = quotedNode1_2;
      }
      return result;
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.smodel.structure.SConceptType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        result = quotedNode1_2;
      }
      return result;
    }
  }

  public static class QuotationClass_yxkngc_a0a0a1a6 {
    public QuotationClass_yxkngc_a0a0a1a6() {
    }

    public SNode createNode(Object parameter_7, Object parameter_8, final TypeCheckingContext typeCheckingContext) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      SNode quotedNode_2 = null;
      SNode quotedNode_3 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.typesystem.structure.JoinType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_4 = quotedNode_1;
        {
          quotedNode_2 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.smodel.structure.SNodeType", null, GlobalScope.getInstance(), false);
          SNode quotedNode1_5 = quotedNode_2;
          quotedNode1_5.setReferent("concept", (SNode) parameter_7);
          quotedNode_1.addChild("argument", quotedNode1_5);
        }
        {
          quotedNode_3 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.smodel.structure.SNodeListType", null, GlobalScope.getInstance(), false);
          SNode quotedNode1_6 = quotedNode_3;
          quotedNode1_6.setReferent("elementConcept", (SNode) parameter_8);
          quotedNode_1.addChild("argument", quotedNode1_6);
        }
        result = quotedNode1_4;
      }
      return result;
    }

    public SNode createNode(Object parameter_7, Object parameter_8) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      SNode quotedNode_2 = null;
      SNode quotedNode_3 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.typesystem.structure.JoinType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_4 = quotedNode_1;
        {
          quotedNode_2 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.smodel.structure.SNodeType", null, GlobalScope.getInstance(), false);
          SNode quotedNode1_5 = quotedNode_2;
          quotedNode1_5.setReferent("concept", (SNode) parameter_7);
          quotedNode_1.addChild("argument", quotedNode1_5);
        }
        {
          quotedNode_3 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.smodel.structure.SNodeListType", null, GlobalScope.getInstance(), false);
          SNode quotedNode1_6 = quotedNode_3;
          quotedNode1_6.setReferent("elementConcept", (SNode) parameter_8);
          quotedNode_1.addChild("argument", quotedNode1_6);
        }
        result = quotedNode1_4;
      }
      return result;
    }
  }

  public static class QuotationClass_yxkngc_a0a2a8 {
    public QuotationClass_yxkngc_a0a2a8() {
    }

    public SNode createNode(Object parameter_3, final TypeCheckingContext typeCheckingContext) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.smodel.structure.SNodeType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        quotedNode1_2.setReferent("concept", (SNode) parameter_3);
        result = quotedNode1_2;
      }
      return result;
    }

    public SNode createNode(Object parameter_3) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.smodel.structure.SNodeType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        quotedNode1_2.setReferent("concept", (SNode) parameter_3);
        result = quotedNode1_2;
      }
      return result;
    }
  }

  public static class QuotationClass_yxkngc_a0a1a0a2a9 {
    public QuotationClass_yxkngc_a0a1a0a2a9() {
    }

    public SNode createNode(Object parameter_3, final TypeCheckingContext typeCheckingContext) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.smodel.structure.SConceptType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        quotedNode1_2.setReferent("conceptDeclaraton", (SNode) parameter_3);
        result = quotedNode1_2;
      }
      return result;
    }

    public SNode createNode(Object parameter_3) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.smodel.structure.SConceptType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        quotedNode1_2.setReferent("conceptDeclaraton", (SNode) parameter_3);
        result = quotedNode1_2;
      }
      return result;
    }
  }

  public static class QuotationClass_yxkngc_a0a0a0c0k {
    public QuotationClass_yxkngc_a0a0a0c0k() {
    }

    public SNode createNode(Object parameter_3) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.smodel.structure.SNodeType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        quotedNode1_2.setReferent("concept", (SNode) parameter_3);
        result = quotedNode1_2;
      }
      return result;
    }
  }

  public static class QuotationClass_yxkngc_a0a0a4a01 {
    public QuotationClass_yxkngc_a0a0a4a01() {
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.smodel.structure.SNodeType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        quotedNode1_2.addReference(SReference.create("concept", quotedNode1_2, SModelReference.fromString("r:00000000-0000-4000-0000-011c89590288(jetbrains.mps.lang.core.structure)"), SNodeId.fromString("1133920641626")));
        result = quotedNode1_2;
      }
      return result;
    }
  }
}
