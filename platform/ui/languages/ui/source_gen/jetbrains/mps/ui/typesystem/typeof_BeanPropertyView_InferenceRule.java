package jetbrains.mps.ui.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.AbstractInferenceRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;
import jetbrains.mps.lang.typesystem.runtime.IsApplicableStatus;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.errors.BaseQuickFixProvider;
import jetbrains.mps.typesystem.inference.EquationInfo;
import jetbrains.mps.ui.behavior.View_Behavior;
import jetbrains.mps.smodel.SModelUtil_new;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.project.GlobalScope;

public class typeof_BeanPropertyView_InferenceRule extends AbstractInferenceRule_Runtime implements InferenceRule_Runtime {
  public typeof_BeanPropertyView_InferenceRule() {
  }

  public void applyRule(final SNode bv, final TypeCheckingContext typeCheckingContext, IsApplicableStatus status) {
    {
      SNode _nodeToCheck_1029348928467 = SLinkOperations.getTarget(bv, "bean", true);
      BaseQuickFixProvider intentionProvider = null;
      EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:f2d87002-eac7-4f98-addf-b2caa99c13a5(jetbrains.mps.ui.typesystem)", "8381258131358797402", 0, intentionProvider);
      _info_12389875345.setInequationGroup("");
      typeCheckingContext.createLessThanInequation((SNode) typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:f2d87002-eac7-4f98-addf-b2caa99c13a5(jetbrains.mps.ui.typesystem)", "8381258131358797394", true), (SNode) new typeof_BeanPropertyView_InferenceRule.QuotationClass_296jbb_a0a0a0().createNode(typeCheckingContext), false, _info_12389875345);
    }
    {
      SNode _nodeToCheck_1029348928467 = View_Behavior.call_getProperty_9014158157446906285(bv);
      BaseQuickFixProvider intentionProvider = null;
      EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:f2d87002-eac7-4f98-addf-b2caa99c13a5(jetbrains.mps.ui.typesystem)", "9014158157446908488", 0, intentionProvider);
      _info_12389875345.setInequationGroup("");
      typeCheckingContext.createLessThanInequation((SNode) SLinkOperations.getTarget(SLinkOperations.getTarget(bv, "getter", false), "returnType", true), (SNode) typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:f2d87002-eac7-4f98-addf-b2caa99c13a5(jetbrains.mps.ui.typesystem)", "9014158157446925826", true), false, _info_12389875345);
    }
    {
      SNode _nodeToCheck_1029348928467 = View_Behavior.call_getProperty_9014158157446906285(bv);
      BaseQuickFixProvider intentionProvider = null;
      EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:f2d87002-eac7-4f98-addf-b2caa99c13a5(jetbrains.mps.ui.typesystem)", "9014158157446942678", 0, intentionProvider);
      _info_12389875345.setInequationGroup("");
      typeCheckingContext.createLessThanInequation((SNode) typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:f2d87002-eac7-4f98-addf-b2caa99c13a5(jetbrains.mps.ui.typesystem)", "9014158157446942670", true), (SNode) SLinkOperations.getTarget(SLinkOperations.getTarget(bv, "getter", false), "returnType", true), false, _info_12389875345);
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.ui.structure.BeanPropertyView";
  }

  public IsApplicableStatus isApplicableAndPattern(SNode argument) {
    {
      boolean b = SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
      return new IsApplicableStatus(b, null);
    }
  }

  public boolean overrides() {
    return false;
  }

  public static class QuotationClass_296jbb_a0a0a0 {
    public QuotationClass_296jbb_a0a0a0() {
    }

    public SNode createNode(final TypeCheckingContext typeCheckingContext) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.WildCardType", null, GlobalScope.getInstance(), false);
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
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.WildCardType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        result = quotedNode1_2;
      }
      return result;
    }
  }
}
