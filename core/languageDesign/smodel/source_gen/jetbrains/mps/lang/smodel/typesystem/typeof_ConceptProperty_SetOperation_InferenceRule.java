package jetbrains.mps.lang.smodel.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.AbstractInferenceRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.behavior.SNodeOperation_Behavior;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.intentions.BaseIntentionProvider;
import jetbrains.mps.typesystem.inference.IErrorTarget;
import jetbrains.mps.typesystem.inference.NodeErrorTarget;
import jetbrains.mps.smodel.SModelUtil_new;

public class typeof_ConceptProperty_SetOperation_InferenceRule extends AbstractInferenceRule_Runtime implements InferenceRule_Runtime {

  public typeof_ConceptProperty_SetOperation_InferenceRule() {
  }

  public void applyRule(final SNode op, final TypeCheckingContext typeCheckingContext) {
    SNode propertyAccessOp = SNodeOperations.cast(SNodeOperation_Behavior.call_getLeftExpressionOperation_1213877508946(op), "jetbrains.mps.lang.smodel.structure.SConceptPropertyAccess");
    SNode cpd = SLinkOperations.getTarget(propertyAccessOp, "conceptProperty", false);
    if (!((cpd != null))) {
      BaseIntentionProvider intentionProvider = null;
      IErrorTarget errorTarget = new NodeErrorTarget();
      typeCheckingContext.reportTypeError(op, "couldn't define accessed concept property declaration", "r:00000000-0000-4000-0000-011c895902fe(jetbrains.mps.lang.smodel.typesystem)", "2648652578096473339", intentionProvider, errorTarget);
    }
    SNode value = SLinkOperations.getTarget(op, "value", true);
    if ((value != null)) {
      if (SNodeOperations.isInstanceOf(cpd, "jetbrains.mps.lang.structure.structure.StringConceptPropertyDeclaration")) {
        {
          SNode _nodeToCheck_1029348928467 = value;
          BaseIntentionProvider intentionProvider = null;
          typeCheckingContext.createLessThanInequation((SNode)typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:00000000-0000-4000-0000-011c895902fe(jetbrains.mps.lang.smodel.typesystem)", "2648652578096473360", true), (SNode)new _Quotations.QuotationClass_123().createNode(typeCheckingContext), _nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c895902fe(jetbrains.mps.lang.smodel.typesystem)", "2648652578096473355", false, 0, intentionProvider);
        }
      } else
      if (SNodeOperations.isInstanceOf(cpd, "jetbrains.mps.lang.structure.structure.IntegerConceptPropertyDeclaration")) {
        {
          SNode _nodeToCheck_1029348928467 = value;
          BaseIntentionProvider intentionProvider = null;
          typeCheckingContext.createLessThanInequation((SNode)typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:00000000-0000-4000-0000-011c895902fe(jetbrains.mps.lang.smodel.typesystem)", "2648652578096473372", true), (SNode)new _Quotations.QuotationClass_124().createNode(typeCheckingContext), _nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c895902fe(jetbrains.mps.lang.smodel.typesystem)", "2648652578096473367", false, 0, intentionProvider);
        }
      } else
      if (SNodeOperations.isInstanceOf(cpd, "jetbrains.mps.lang.structure.structure.BooleanConceptPropertyDeclaration")) {
        {
          SNode _nodeToCheck_1029348928467 = value;
          BaseIntentionProvider intentionProvider = null;
          typeCheckingContext.createLessThanInequation((SNode)typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:00000000-0000-4000-0000-011c895902fe(jetbrains.mps.lang.smodel.typesystem)", "2648652578096473384", true), (SNode)new _Quotations.QuotationClass_125().createNode(typeCheckingContext), _nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c895902fe(jetbrains.mps.lang.smodel.typesystem)", "2648652578096473379", false, 0, intentionProvider);
        }
      }
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.lang.smodel.structure.ConceptProperty_SetOperation";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return true;
  }

}
