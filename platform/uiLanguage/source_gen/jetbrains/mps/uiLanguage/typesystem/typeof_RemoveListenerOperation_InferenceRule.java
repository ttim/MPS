package jetbrains.mps.uiLanguage.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.AbstractInferenceRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.intentions.BaseIntentionProvider;
import jetbrains.mps.typesystem.inference.IErrorTarget;
import jetbrains.mps.typesystem.inference.NodeErrorTarget;
import jetbrains.mps.typesystem.inference.EquationInfo;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.smodel.SModelUtil_new;

public class typeof_RemoveListenerOperation_InferenceRule extends AbstractInferenceRule_Runtime implements InferenceRule_Runtime {
  public typeof_RemoveListenerOperation_InferenceRule() {
  }

  public void applyRule(final SNode operation, final TypeCheckingContext typeCheckingContext) {
    SNode eventNode = SLinkOperations.getTarget(SNodeOperations.cast(SLinkOperations.getTarget(SNodeOperations.cast(SLinkOperations.getTarget(operation, "leftExpression", true), "jetbrains.mps.baseLanguage.structure.DotExpression"), "operation", true), "jetbrains.mps.uiLanguage.structure.EventAccessOperation"), "member", false);
    SNode methodNode = SLinkOperations.getTarget(SNodeOperations.cast(SLinkOperations.getTarget(operation, "rightExpression", true), "jetbrains.mps.uiLanguage.structure.EventHandlerReference"), "handler", false);
    if (SLinkOperations.getCount(methodNode, "parameter") != 1) {
      {
        BaseIntentionProvider intentionProvider = null;
        IErrorTarget errorTarget = new NodeErrorTarget();
        typeCheckingContext.reportTypeError(methodNode, "handler must have 1 parameter", "r:00000000-0000-4000-0000-011c89590550(jetbrains.mps.uiLanguage.typesystem)", "1208689441014", intentionProvider, errorTarget);
      }
    }
    {
      SNode _nodeToCheck_1029348928467 = SNodeOperations.getAncestor(operation, "jetbrains.mps.baseLanguage.structure.Statement", false, false);
      BaseIntentionProvider intentionProvider = null;
      EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, "parameter types do not match", "r:00000000-0000-4000-0000-011c89590550(jetbrains.mps.uiLanguage.typesystem)", "1208689441024", 0, intentionProvider);
      _info_12389875345.setInequationGroup("default");
      typeCheckingContext.createLessThanInequationStrong((SNode)SLinkOperations.getTarget(SLinkOperations.getTarget(eventNode, "parameter", true), "type", true), (SNode)typeCheckingContext.typeOf(ListSequence.fromList(SLinkOperations.getTargets(methodNode, "parameter", true)).first(), "r:00000000-0000-4000-0000-011c89590550(jetbrains.mps.uiLanguage.typesystem)", "1208689441026", true), true, _info_12389875345);
    }
    {
      SNode _nodeToCheck_1029348928467 = SNodeOperations.getAncestor(operation, "jetbrains.mps.baseLanguage.structure.Statement", false, false);
      BaseIntentionProvider intentionProvider = null;
      EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, "handler return type must be void", "r:00000000-0000-4000-0000-011c89590550(jetbrains.mps.uiLanguage.typesystem)", "1208689441044", 0, intentionProvider);
      typeCheckingContext.createEquation((SNode)SLinkOperations.getTarget(methodNode, "returnType", true), (SNode)new _Quotations.QuotationClass_6().createNode(typeCheckingContext), _info_12389875345);
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.uiLanguage.structure.RemoveListenerOperation";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return false;
  }
}
