package jetbrains.mps.lang.smodel.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.AbstractInferenceRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.intentions.BaseIntentionProvider;
import jetbrains.mps.typesystem.inference.EquationInfo;
import jetbrains.mps.lang.smodel.behavior.SNodeOperation_Behavior;
import jetbrains.mps.smodel.SModelUtil_new;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.typesystem.inference.TypeChecker;
import jetbrains.mps.project.GlobalScope;

public class typeOf_Concept_NewInstance_InferenceRule extends AbstractInferenceRule_Runtime implements InferenceRule_Runtime {
  public typeOf_Concept_NewInstance_InferenceRule() {
  }

  public void applyRule(final SNode node, final TypeCheckingContext typeCheckingContext) {
    if (SLinkOperations.getTarget(node, "prototypeNode", true) != null) {
      {
        SNode _nodeToCheck_1029348928467 = SLinkOperations.getTarget(node, "prototypeNode", true);
        BaseIntentionProvider intentionProvider = null;
        EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c895902fe(jetbrains.mps.lang.smodel.typesystem)", "1181950211367", 0, intentionProvider);
        _info_12389875345.setInequationGroup("default");
        typeCheckingContext.createLessThanInequation((SNode) typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:00000000-0000-4000-0000-011c895902fe(jetbrains.mps.lang.smodel.typesystem)", "1186061176339", true), (SNode) new typeOf_Concept_NewInstance_InferenceRule.QuotationClass_6ngi1v_a0a0a0a0().createNode(typeCheckingContext), false, _info_12389875345);
      }
    }
    SNode leftExpression = SNodeOperation_Behavior.call_getLeftExpression_1213877508894(node);
    final SNode C_typevar_1225543919244 = typeCheckingContext.createNewRuntimeTypesVariable();
    {
      SNode _nodeToCheck_1029348928467 = leftExpression;
      BaseIntentionProvider intentionProvider = null;
      EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c895902fe(jetbrains.mps.lang.smodel.typesystem)", "1225543902992", 0, intentionProvider);
      _info_12389875345.setInequationGroup("default");
      typeCheckingContext.createLessThanInequation((SNode) typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:00000000-0000-4000-0000-011c895902fe(jetbrains.mps.lang.smodel.typesystem)", "1225543892444", false), (SNode) new typeOf_Concept_NewInstance_InferenceRule.QuotationClass_6ngi1v_a0a3a0().createNode(typeCheckingContext.getEquationManager().getRepresentator(C_typevar_1225543919244), typeCheckingContext), false, _info_12389875345);
    }
    {
      SNode _nodeToCheck_1029348928467 = node;
      BaseIntentionProvider intentionProvider = null;
      EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c895902fe(jetbrains.mps.lang.smodel.typesystem)", "1225543947064", 0, intentionProvider);
      typeCheckingContext.createEquation((SNode) typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:00000000-0000-4000-0000-011c895902fe(jetbrains.mps.lang.smodel.typesystem)", "1225543947066", true), (SNode) new typeOf_Concept_NewInstance_InferenceRule.QuotationClass_6ngi1v_a0a4a0().createNode(typeCheckingContext.getEquationManager().getRepresentator(C_typevar_1225543919244), typeCheckingContext), _info_12389875345);
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.lang.smodel.structure.Concept_NewInstance";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return false;
  }

  public static class QuotationClass_6ngi1v_a0a0a0a0 {
    public QuotationClass_6ngi1v_a0a0a0a0() {
    }

    public SNode createNode(final TypeCheckingContext typeCheckingContext) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_6ngi1v_a0a0a0a0 = null;
      {
        quotedNode_6ngi1v_a0a0a0a0 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.smodel.structure.SNodeType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_6ngi1v_a0a0a0a0 = quotedNode_6ngi1v_a0a0a0a0;
        result = quotedNode1_6ngi1v_a0a0a0a0;
      }
      return result;
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_6ngi1v_a0a0a0a0 = null;
      {
        quotedNode_6ngi1v_a0a0a0a0 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.smodel.structure.SNodeType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_6ngi1v_a0a0a0a0 = quotedNode_6ngi1v_a0a0a0a0;
        result = quotedNode1_6ngi1v_a0a0a0a0;
      }
      return result;
    }
  }

  public static class QuotationClass_6ngi1v_a0a3a0 {
    public QuotationClass_6ngi1v_a0a3a0() {
    }

    public SNode createNode(Object parameter_6ngi1v_a0a0a3a0, final TypeCheckingContext typeCheckingContext) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_6ngi1v_a0a3a0 = null;
      {
        quotedNode_6ngi1v_a0a3a0 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.smodel.structure.SConceptType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_6ngi1v_a0a3a0 = quotedNode_6ngi1v_a0a3a0;
        quotedNode1_6ngi1v_a0a3a0.setReferent("conceptDeclaraton", (SNode) parameter_6ngi1v_a0a0a3a0);
        result = quotedNode1_6ngi1v_a0a3a0;
      }
      return result;
    }

    public SNode createNode(Object parameter_6ngi1v_a0a0a3a0) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_6ngi1v_a0a3a0 = null;
      {
        quotedNode_6ngi1v_a0a3a0 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.smodel.structure.SConceptType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_6ngi1v_a0a3a0 = quotedNode_6ngi1v_a0a3a0;
        quotedNode1_6ngi1v_a0a3a0.setReferent("conceptDeclaraton", (SNode) parameter_6ngi1v_a0a0a3a0);
        result = quotedNode1_6ngi1v_a0a3a0;
      }
      return result;
    }
  }

  public static class QuotationClass_6ngi1v_a0a4a0 {
    public QuotationClass_6ngi1v_a0a4a0() {
    }

    public SNode createNode(Object parameter_6ngi1v_a0a0a4a0, final TypeCheckingContext typeCheckingContext) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_6ngi1v_a0a4a0 = null;
      {
        quotedNode_6ngi1v_a0a4a0 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.smodel.structure.SNodeType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_6ngi1v_a0a4a0 = quotedNode_6ngi1v_a0a4a0;
        quotedNode1_6ngi1v_a0a4a0.setReferent("concept", (SNode) parameter_6ngi1v_a0a0a4a0);
        result = quotedNode1_6ngi1v_a0a4a0;
      }
      return result;
    }

    public SNode createNode(Object parameter_6ngi1v_a0a0a4a0) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_6ngi1v_a0a4a0 = null;
      {
        quotedNode_6ngi1v_a0a4a0 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.smodel.structure.SNodeType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_6ngi1v_a0a4a0 = quotedNode_6ngi1v_a0a4a0;
        quotedNode1_6ngi1v_a0a4a0.setReferent("concept", (SNode) parameter_6ngi1v_a0a0a4a0);
        result = quotedNode1_6ngi1v_a0a4a0;
      }
      return result;
    }
  }
}
