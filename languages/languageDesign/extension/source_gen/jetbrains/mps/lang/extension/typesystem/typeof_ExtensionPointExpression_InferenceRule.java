package jetbrains.mps.lang.extension.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.AbstractInferenceRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;
import jetbrains.mps.lang.typesystem.runtime.IsApplicableStatus;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.typesystem.inference.EquationInfo;
import jetbrains.mps.smodel.SModelUtil_new;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.project.GlobalScope;

public class typeof_ExtensionPointExpression_InferenceRule extends AbstractInferenceRule_Runtime implements InferenceRule_Runtime {
  public typeof_ExtensionPointExpression_InferenceRule() {
  }

  public void applyRule(final SNode epe, final TypeCheckingContext typeCheckingContext, IsApplicableStatus status) {
    SNode objectType = SLinkOperations.getTarget(SLinkOperations.getTarget(epe, "extensionPoint", false), "objectType", true);
    {
      SNode _nodeToCheck_1029348928467 = epe;
      EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:4b1ddbe6-5067-4a27-8697-eb786b50451b(jetbrains.mps.lang.extension.typesystem)", "6626851894249791047", 0, null);
      typeCheckingContext.createEquation((SNode) typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:4b1ddbe6-5067-4a27-8697-eb786b50451b(jetbrains.mps.lang.extension.typesystem)", "6626851894249791042", true), (SNode) new typeof_ExtensionPointExpression_InferenceRule.QuotationClass_x0hnp2_a0a1a0().createNode(SLinkOperations.getTarget(epe, "extensionPoint", false), typeCheckingContext), _info_12389875345);
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.lang.extension.structure.ExtensionPointExpression";
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

  public static class QuotationClass_x0hnp2_a0a1a0 {
    public QuotationClass_x0hnp2_a0a1a0() {
    }

    public SNode createNode(Object parameter_3, final TypeCheckingContext typeCheckingContext) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.extension.structure.ExtensionPointType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        quotedNode1_2.setReferent("extensionPoint", (SNode) parameter_3);
        result = quotedNode1_2;
      }
      return result;
    }

    public SNode createNode(Object parameter_3) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.extension.structure.ExtensionPointType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        quotedNode1_2.setReferent("extensionPoint", (SNode) parameter_3);
        result = quotedNode1_2;
      }
      return result;
    }
  }
}
