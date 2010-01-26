package jetbrains.mps.lang.behavior.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.AbstractInferenceRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.intentions.BaseIntentionProvider;
import jetbrains.mps.typesystem.inference.EquationInfo;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.smodel.SModelUtil_new;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.typesystem.inference.TypeChecker;
import jetbrains.mps.project.GlobalScope;

public class typeof_ThisNodeExpression_InferenceRule extends AbstractInferenceRule_Runtime implements InferenceRule_Runtime {
  public typeof_ThisNodeExpression_InferenceRule() {
  }

  public void applyRule(final SNode thisNode, final TypeCheckingContext typeCheckingContext) {
    SNode behaviour = SNodeOperations.getAncestor(thisNode, "jetbrains.mps.lang.behavior.structure.ConceptBehavior", true, false);
    {
      SNode _nodeToCheck_1029348928467 = thisNode;
      BaseIntentionProvider intentionProvider = null;
      EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:f7f8a091-d98d-402d-85c4-5f05cb2b8c61(jetbrains.mps.lang.behavior.typesystem)", "1225196556169", 0, intentionProvider);
      typeCheckingContext.createEquation((SNode) typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:f7f8a091-d98d-402d-85c4-5f05cb2b8c61(jetbrains.mps.lang.behavior.typesystem)", "1225196556171", true), (SNode) new typeof_ThisNodeExpression_InferenceRule.QuotationClass_1340_0().createNode(SLinkOperations.getTarget(behaviour, "concept", false), typeCheckingContext), _info_12389875345);
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.lang.behavior.structure.ThisNodeExpression";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return false;
  }

  public static class QuotationClass_1340_0 {
    public QuotationClass_1340_0() {
    }

    public SNode createNode(Object parameter_1340_0, final TypeCheckingContext typeCheckingContext) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1340_0 = null;
      {
        quotedNode_1340_0 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.smodel.structure.SNodeType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_1340_0 = quotedNode_1340_0;
        quotedNode1_1340_0.setReferent("concept", (SNode) parameter_1340_0);
        result = quotedNode1_1340_0;
      }
      return result;
    }

    public SNode createNode(Object parameter_1340_0) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1340_0 = null;
      {
        quotedNode_1340_0 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.smodel.structure.SNodeType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_1340_0 = quotedNode_1340_0;
        quotedNode1_1340_0.setReferent("concept", (SNode) parameter_1340_0);
        result = quotedNode1_1340_0;
      }
      return result;
    }
  }
}
