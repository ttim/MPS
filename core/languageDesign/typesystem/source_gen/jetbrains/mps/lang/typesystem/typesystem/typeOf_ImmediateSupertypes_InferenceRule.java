package jetbrains.mps.lang.typesystem.typesystem;

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

public class typeOf_ImmediateSupertypes_InferenceRule extends AbstractInferenceRule_Runtime implements InferenceRule_Runtime {
  public typeOf_ImmediateSupertypes_InferenceRule() {
  }

  public void applyRule(final SNode immediateSupertypesExpr, final TypeCheckingContext typeCheckingContext) {
    {
      SNode _nodeToCheck_1029348928467 = immediateSupertypesExpr;
      BaseIntentionProvider intentionProvider = null;
      EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c895902b1(jetbrains.mps.lang.typesystem.typesystem)", "1223981204989", 0, intentionProvider);
      typeCheckingContext.createEquation((SNode) typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:00000000-0000-4000-0000-011c895902b1(jetbrains.mps.lang.typesystem.typesystem)", "1223981204994", true), (SNode) new typeOf_ImmediateSupertypes_InferenceRule.QuotationClass_0601_l523emnfdlz2().createNode(typeCheckingContext), _info_12389875345);
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.lang.typesystem.structure.ImmediateSupertypesExpression";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return false;
  }

  public static class QuotationClass_0601_l523emnfdlz2 {
    public QuotationClass_0601_l523emnfdlz2() {
    }

    public SNode createNode(final TypeCheckingContext typeCheckingContext) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_0601_l523emnfdit3 = null;
      SNode quotedNode_0601_l523emnfdit4 = null;
      {
        quotedNode_0601_l523emnfdit3 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.ClassifierType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_0601_l523emnfdit3 = quotedNode_0601_l523emnfdit3;
        quotedNode1_0601_l523emnfdit3.addReference(SReference.create("classifier", quotedNode1_0601_l523emnfdit3, SModelReference.fromString("f:java_stub#java.util(java.util@java_stub)"), SNodeId.fromString("~Set")));
        {
          quotedNode_0601_l523emnfdit4 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.ClassifierType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
          SNode quotedNode1_0601_l523emnfdit4 = quotedNode_0601_l523emnfdit4;
          quotedNode1_0601_l523emnfdit4.addReference(SReference.create("classifier", quotedNode1_0601_l523emnfdit4, SModelReference.fromString("f:java_stub#jetbrains.mps.smodel(jetbrains.mps.smodel@java_stub)"), SNodeId.fromString("~SNode")));
          quotedNode_0601_l523emnfdit3.addChild("parameter", quotedNode1_0601_l523emnfdit4);
        }
        result = quotedNode1_0601_l523emnfdit3;
      }
      return result;
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_0601_l523emnfdit3 = null;
      SNode quotedNode_0601_l523emnfdit4 = null;
      {
        quotedNode_0601_l523emnfdit3 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.ClassifierType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_0601_l523emnfdit3 = quotedNode_0601_l523emnfdit3;
        quotedNode1_0601_l523emnfdit3.addReference(SReference.create("classifier", quotedNode1_0601_l523emnfdit3, SModelReference.fromString("f:java_stub#java.util(java.util@java_stub)"), SNodeId.fromString("~Set")));
        {
          quotedNode_0601_l523emnfdit4 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.ClassifierType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
          SNode quotedNode1_0601_l523emnfdit4 = quotedNode_0601_l523emnfdit4;
          quotedNode1_0601_l523emnfdit4.addReference(SReference.create("classifier", quotedNode1_0601_l523emnfdit4, SModelReference.fromString("f:java_stub#jetbrains.mps.smodel(jetbrains.mps.smodel@java_stub)"), SNodeId.fromString("~SNode")));
          quotedNode_0601_l523emnfdit3.addChild("parameter", quotedNode1_0601_l523emnfdit4);
        }
        result = quotedNode1_0601_l523emnfdit3;
      }
      return result;
    }
  }
}
