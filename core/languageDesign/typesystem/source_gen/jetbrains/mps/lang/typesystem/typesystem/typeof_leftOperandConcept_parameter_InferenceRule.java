package jetbrains.mps.lang.typesystem.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.AbstractInferenceRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.intentions.BaseIntentionProvider;
import jetbrains.mps.typesystem.inference.EquationInfo;
import jetbrains.mps.smodel.SModelUtil_new;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.typesystem.inference.TypeChecker;
import jetbrains.mps.project.GlobalScope;

public class typeof_leftOperandConcept_parameter_InferenceRule extends AbstractInferenceRule_Runtime implements InferenceRule_Runtime {
  public typeof_leftOperandConcept_parameter_InferenceRule() {
  }

  public void applyRule(final SNode concept_parameter, final TypeCheckingContext typeCheckingContext) {
    SNode typeRule = SNodeOperations.getAncestor(concept_parameter, "jetbrains.mps.lang.typesystem.structure.OverloadedOperatorTypeRule", false, false);
    if ((typeRule != null)) {
      final SNode C_typevar_1097880957047046534 = typeCheckingContext.createNewRuntimeTypesVariable();
      {
        SNode _nodeToCheck_1029348928467 = SLinkOperations.getTarget(typeRule, "leftOperandType", true);
        BaseIntentionProvider intentionProvider = null;
        EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c895902b1(jetbrains.mps.lang.typesystem.typesystem)", "1097880957047046510", 0, intentionProvider);
        _info_12389875345.setInequationGroup("default");
        typeCheckingContext.createLessThanInequation((SNode) typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:00000000-0000-4000-0000-011c895902b1(jetbrains.mps.lang.typesystem.typesystem)", "1097880957047046524", true), (SNode) new typeof_leftOperandConcept_parameter_InferenceRule.QuotationClass_6764_l523emnfdnha().createNode(typeCheckingContext.getEquationManager().getRepresentator(C_typevar_1097880957047046534), typeCheckingContext), false, _info_12389875345);
      }
      {
        SNode _nodeToCheck_1029348928467 = concept_parameter;
        BaseIntentionProvider intentionProvider = null;
        EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c895902b1(jetbrains.mps.lang.typesystem.typesystem)", "1236083427968", 0, intentionProvider);
        typeCheckingContext.createEquation((SNode) typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:00000000-0000-4000-0000-011c895902b1(jetbrains.mps.lang.typesystem.typesystem)", "1236083427979", true), (SNode) new typeof_leftOperandConcept_parameter_InferenceRule.QuotationClass_6764_l523emnfdnj9().createNode(typeCheckingContext.getEquationManager().getRepresentator(C_typevar_1097880957047046534), typeCheckingContext), _info_12389875345);
      }
    } else {
      {
        SNode _nodeToCheck_1029348928467 = concept_parameter;
        BaseIntentionProvider intentionProvider = null;
        EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c895902b1(jetbrains.mps.lang.typesystem.typesystem)", "3841122719873946001", 0, intentionProvider);
        typeCheckingContext.createEquation((SNode) typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:00000000-0000-4000-0000-011c895902b1(jetbrains.mps.lang.typesystem.typesystem)", "3841122719873945999", true), (SNode) new typeof_leftOperandConcept_parameter_InferenceRule.QuotationClass_6764_l523emnfdnl1().createNode(typeCheckingContext), _info_12389875345);
      }
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.lang.typesystem.structure.LeftOperandType_parameter";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return true;
  }

  public static class QuotationClass_6764_l523emnfdnha {
    public QuotationClass_6764_l523emnfdnha() {
    }

    public SNode createNode(Object parameter_6764_l523emnfdl1j, final TypeCheckingContext typeCheckingContext) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_6764_l523emnfdl0m = null;
      {
        quotedNode_6764_l523emnfdl0m = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.smodel.structure.SNodeType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_6764_l523emnfdl0m = quotedNode_6764_l523emnfdl0m;
        quotedNode1_6764_l523emnfdl0m.setReferent("concept", (SNode) parameter_6764_l523emnfdl1j);
        result = quotedNode1_6764_l523emnfdl0m;
      }
      return result;
    }

    public SNode createNode(Object parameter_6764_l523emnfdl1j) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_6764_l523emnfdl0m = null;
      {
        quotedNode_6764_l523emnfdl0m = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.smodel.structure.SNodeType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_6764_l523emnfdl0m = quotedNode_6764_l523emnfdl0m;
        quotedNode1_6764_l523emnfdl0m.setReferent("concept", (SNode) parameter_6764_l523emnfdl1j);
        result = quotedNode1_6764_l523emnfdl0m;
      }
      return result;
    }
  }

  public static class QuotationClass_6764_l523emnfdnj9 {
    public QuotationClass_6764_l523emnfdnj9() {
    }

    public SNode createNode(Object parameter_6764_l523emnfdl1t, final TypeCheckingContext typeCheckingContext) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_6764_l523emnfdl0r = null;
      {
        quotedNode_6764_l523emnfdl0r = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.smodel.structure.SNodeType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_6764_l523emnfdl0r = quotedNode_6764_l523emnfdl0r;
        quotedNode1_6764_l523emnfdl0r.setReferent("concept", (SNode) parameter_6764_l523emnfdl1t);
        result = quotedNode1_6764_l523emnfdl0r;
      }
      return result;
    }

    public SNode createNode(Object parameter_6764_l523emnfdl1t) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_6764_l523emnfdl0r = null;
      {
        quotedNode_6764_l523emnfdl0r = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.smodel.structure.SNodeType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_6764_l523emnfdl0r = quotedNode_6764_l523emnfdl0r;
        quotedNode1_6764_l523emnfdl0r.setReferent("concept", (SNode) parameter_6764_l523emnfdl1t);
        result = quotedNode1_6764_l523emnfdl0r;
      }
      return result;
    }
  }

  public static class QuotationClass_6764_l523emnfdnl1 {
    public QuotationClass_6764_l523emnfdnl1() {
    }

    public SNode createNode(final TypeCheckingContext typeCheckingContext) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_6764_l523emnfdl11 = null;
      {
        quotedNode_6764_l523emnfdl11 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.smodel.structure.SNodeType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_6764_l523emnfdl11 = quotedNode_6764_l523emnfdl11;
        result = quotedNode1_6764_l523emnfdl11;
      }
      return result;
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_6764_l523emnfdl11 = null;
      {
        quotedNode_6764_l523emnfdl11 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.smodel.structure.SNodeType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_6764_l523emnfdl11 = quotedNode_6764_l523emnfdl11;
        result = quotedNode1_6764_l523emnfdl11;
      }
      return result;
    }
  }
}
