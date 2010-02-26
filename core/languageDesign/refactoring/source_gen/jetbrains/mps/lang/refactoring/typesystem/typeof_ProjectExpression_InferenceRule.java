package jetbrains.mps.lang.refactoring.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.AbstractInferenceRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;
import jetbrains.mps.intentions.BaseIntentionProvider;
import jetbrains.mps.typesystem.inference.EquationInfo;
import jetbrains.mps.smodel.SModelUtil_new;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.typesystem.inference.TypeChecker;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.smodel.SReference;
import jetbrains.mps.smodel.SModelReference;
import jetbrains.mps.smodel.SNodeId;

public class typeof_ProjectExpression_InferenceRule extends AbstractInferenceRule_Runtime implements InferenceRule_Runtime {
  public typeof_ProjectExpression_InferenceRule() {
  }

  public void applyRule(final SNode nodeToCheck, final TypeCheckingContext typeCheckingContext) {
    {
      SNode _nodeToCheck_1029348928467 = nodeToCheck;
      BaseIntentionProvider intentionProvider = null;
      EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c89590316(jetbrains.mps.lang.refactoring.typesystem)", "1215084525369", 0, intentionProvider);
      typeCheckingContext.createEquation((SNode) typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:00000000-0000-4000-0000-011c89590316(jetbrains.mps.lang.refactoring.typesystem)", "1215084519803", true), (SNode) new typeof_ProjectExpression_InferenceRule.QuotationClass_osiggc_a0a0a0().createNode(typeCheckingContext), _info_12389875345);
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.lang.refactoring.structure.ProjectExpression";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return false;
  }

  public static class QuotationClass_osiggc_a0a0a0 {
    public QuotationClass_osiggc_a0a0a0() {
    }

    public SNode createNode(final TypeCheckingContext typeCheckingContext) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_osiggc_a0a0a0 = null;
      {
        quotedNode_osiggc_a0a0a0 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.ClassifierType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_osiggc_a0a0a0 = quotedNode_osiggc_a0a0a0;
        quotedNode1_osiggc_a0a0a0.addReference(SReference.create("classifier", quotedNode1_osiggc_a0a0a0, SModelReference.fromString("f:java_stub#jetbrains.mps.project(jetbrains.mps.project@java_stub)"), SNodeId.fromString("~MPSProject")));
        result = quotedNode1_osiggc_a0a0a0;
      }
      return result;
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_osiggc_a0a0a0 = null;
      {
        quotedNode_osiggc_a0a0a0 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.ClassifierType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_osiggc_a0a0a0 = quotedNode_osiggc_a0a0a0;
        quotedNode1_osiggc_a0a0a0.addReference(SReference.create("classifier", quotedNode1_osiggc_a0a0a0, SModelReference.fromString("f:java_stub#jetbrains.mps.project(jetbrains.mps.project@java_stub)"), SNodeId.fromString("~MPSProject")));
        result = quotedNode1_osiggc_a0a0a0;
      }
      return result;
    }
  }
}
