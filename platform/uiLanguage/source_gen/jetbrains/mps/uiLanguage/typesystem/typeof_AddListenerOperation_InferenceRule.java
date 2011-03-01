package jetbrains.mps.uiLanguage.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.AbstractInferenceRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;
import jetbrains.mps.lang.typesystem.runtime.IsApplicableStatus;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.errors.BaseQuickFixProvider;
import jetbrains.mps.errors.messageTargets.MessageTarget;
import jetbrains.mps.errors.messageTargets.NodeMessageTarget;
import jetbrains.mps.errors.IErrorReporter;
import jetbrains.mps.typesystem.inference.EquationInfo;
import jetbrains.mps.smodel.SModelUtil_new;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.project.GlobalScope;

public class typeof_AddListenerOperation_InferenceRule extends AbstractInferenceRule_Runtime implements InferenceRule_Runtime {
  public typeof_AddListenerOperation_InferenceRule() {
  }

  public void applyRule(final SNode operation, final TypeCheckingContext typeCheckingContext, IsApplicableStatus status) {
    SNode eventNode = SLinkOperations.getTarget(SNodeOperations.cast(SLinkOperations.getTarget(SNodeOperations.cast(SLinkOperations.getTarget(operation, "leftExpression", true), "jetbrains.mps.baseLanguage.structure.DotExpression"), "operation", true), "jetbrains.mps.uiLanguage.structure.EventAccessOperation"), "member", false);
    SNode methodNode = SLinkOperations.getTarget(SNodeOperations.cast(SLinkOperations.getTarget(operation, "rightExpression", true), "jetbrains.mps.uiLanguage.structure.EventHandlerReference"), "handler", false);
    if (ListSequence.fromList(SLinkOperations.getTargets(methodNode, "parameter", true)).count() != 1) {
      {
        BaseQuickFixProvider intentionProvider = null;
        MessageTarget errorTarget = new NodeMessageTarget();
        IErrorReporter _reporter_2309309498 = typeCheckingContext.reportTypeError(methodNode, "handler must have 1 parameter", "r:00000000-0000-4000-0000-011c89590550(jetbrains.mps.uiLanguage.typesystem)", "1208111560705", intentionProvider, errorTarget);
      }
    }
    {
      SNode _nodeToCheck_1029348928467 = SNodeOperations.getAncestor(operation, "jetbrains.mps.baseLanguage.structure.Statement", false, false);
      BaseQuickFixProvider intentionProvider = null;
      EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, "parameter types do not match", "r:00000000-0000-4000-0000-011c89590550(jetbrains.mps.uiLanguage.typesystem)", "1208111560719", 0, intentionProvider);
      _info_12389875345.setInequationGroup("");
      typeCheckingContext.createLessThanInequationStrong((SNode) SLinkOperations.getTarget(SLinkOperations.getTarget(eventNode, "parameter", true), "type", true), (SNode) typeCheckingContext.typeOf(ListSequence.fromList(SLinkOperations.getTargets(methodNode, "parameter", true)).first(), "r:00000000-0000-4000-0000-011c89590550(jetbrains.mps.uiLanguage.typesystem)", "1208111560721", true), true, _info_12389875345);
    }
    {
      SNode _nodeToCheck_1029348928467 = SNodeOperations.getAncestor(operation, "jetbrains.mps.baseLanguage.structure.Statement", false, false);
      BaseQuickFixProvider intentionProvider = null;
      EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, "handler return type must be void", "r:00000000-0000-4000-0000-011c89590550(jetbrains.mps.uiLanguage.typesystem)", "1208112038267", 0, intentionProvider);
      typeCheckingContext.createEquation((SNode) SLinkOperations.getTarget(methodNode, "returnType", true), (SNode) new typeof_AddListenerOperation_InferenceRule.QuotationClass_of7xmz_a0a4a0().createNode(typeCheckingContext), _info_12389875345);
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.uiLanguage.structure.AddListenerOperation";
  }

  public IsApplicableStatus isApplicableAndPattern(SNode argument) {
    {
      boolean b = SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
      return new IsApplicableStatus(b, null);
    }
  }

  public boolean overrides() {
    return true;
  }

  public static class QuotationClass_of7xmz_a0a4a0 {
    public QuotationClass_of7xmz_a0a4a0() {
    }

    public SNode createNode(final TypeCheckingContext typeCheckingContext) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_1 = null;
      {
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.VoidType", null, GlobalScope.getInstance(), false);
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
        quotedNode_1 = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.VoidType", null, GlobalScope.getInstance(), false);
        SNode quotedNode1_2 = quotedNode_1;
        result = quotedNode1_2;
      }
      return result;
    }
  }
}
