package jetbrains.mps.baseLanguage.closures.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.AbstractInferenceRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.InferenceRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;
import jetbrains.mps.lang.typesystem.runtime.IsApplicableStatus;
import jetbrains.mps.baseLanguage.closures.behavior.ControlMethodUtil;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.errors.BaseQuickFixProvider;
import jetbrains.mps.errors.messageTargets.MessageTarget;
import jetbrains.mps.errors.messageTargets.NodeMessageTarget;
import jetbrains.mps.errors.IErrorReporter;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.typesystem.inference.EquationInfo;
import java.util.Iterator;
import jetbrains.mps.smodel.SModelUtil_new;

public class typeof_ClosureControlStatement_InferenceRule extends AbstractInferenceRule_Runtime implements InferenceRule_Runtime {
  public typeof_ClosureControlStatement_InferenceRule() {
  }

  public void applyRule(final SNode ccs, final TypeCheckingContext typeCheckingContext, IsApplicableStatus status) {
    ControlMethodUtil.Info cmuInfo = ControlMethodUtil.analyze(SLinkOperations.getTarget(ccs, "controlMethod", false));
    if (!(cmuInfo != null)) {
      BaseQuickFixProvider intentionProvider = null;
      MessageTarget errorTarget = new NodeMessageTarget();
      IErrorReporter _reporter_2309309498 = typeCheckingContext.reportTypeError(ccs, "Not referring to a control method", "r:00000000-0000-4000-0000-011c89590337(jetbrains.mps.baseLanguage.closures.typesystem)", "1232453890820", intentionProvider, errorTarget);
    }
    if (cmuInfo != null) {
      List<SNode> ccts = cmuInfo.getControlClosureTypes();
      if (!(ListSequence.fromList(ccts).count() > 0)) {
        BaseQuickFixProvider intentionProvider = null;
        MessageTarget errorTarget = new NodeMessageTarget();
        IErrorReporter _reporter_2309309498 = typeCheckingContext.reportTypeError(ccs, "Control method should accept at least one unrestricted closure", "r:00000000-0000-4000-0000-011c89590337(jetbrains.mps.baseLanguage.closures.typesystem)", "1232454232193", intentionProvider, errorTarget);
      }
      if (!((SLinkOperations.getTarget(ccs, "controlClosure", true) != null))) {
        BaseQuickFixProvider intentionProvider = null;
        MessageTarget errorTarget = new NodeMessageTarget();
        IErrorReporter _reporter_2309309498 = typeCheckingContext.reportTypeError(ccs, "Must define a control closure", "r:00000000-0000-4000-0000-011c89590337(jetbrains.mps.baseLanguage.closures.typesystem)", "1232454314258", intentionProvider, errorTarget);
      }
      if (ListSequence.fromList(ccts).count() > 0) {
        {
          SNode _nodeToCheck_1029348928467 = SLinkOperations.getTarget(ccs, "controlClosure", true);
          BaseQuickFixProvider intentionProvider = null;
          EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c89590337(jetbrains.mps.baseLanguage.closures.typesystem)", "1236533962056", 0, intentionProvider);
          typeCheckingContext.createLessThanInequationStrong((SNode) typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:00000000-0000-4000-0000-011c89590337(jetbrains.mps.baseLanguage.closures.typesystem)", "1236533965287", true), (SNode) ListSequence.fromList(ccts).getElement(ListSequence.fromList(ccts).count() - 1), false, _info_12389875345);
        }
      }
      List<SNode> params = SLinkOperations.getTargets(ccs, "actualParameter", true);
      List<SNode> fpts = cmuInfo.getFunctionParamTypes();
      if (!(ListSequence.fromList(params).count() == ListSequence.fromList(fpts).count())) {
        BaseQuickFixProvider intentionProvider = null;
        MessageTarget errorTarget = new NodeMessageTarget();
        IErrorReporter _reporter_2309309498 = typeCheckingContext.reportTypeError(ccs, "Incorrect parameters number", "r:00000000-0000-4000-0000-011c89590337(jetbrains.mps.baseLanguage.closures.typesystem)", "1232455288552", intentionProvider, errorTarget);
      }
      {
        SNode pt;
        SNode param;
        Iterator<SNode> pt_iterator = ListSequence.fromList(fpts).iterator();
        Iterator<SNode> param_iterator = ListSequence.fromList(params).iterator();
        while (true) {
          if (!(pt_iterator.hasNext())) {
            break;
          }
          if (!(param_iterator.hasNext())) {
            break;
          }
          pt = pt_iterator.next();
          param = param_iterator.next();
          {
            SNode _nodeToCheck_1029348928467 = param;
            BaseQuickFixProvider intentionProvider = null;
            EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:00000000-0000-4000-0000-011c89590337(jetbrains.mps.baseLanguage.closures.typesystem)", "1236534225483", 0, intentionProvider);
            typeCheckingContext.createLessThanInequation((SNode) typeCheckingContext.typeOf(_nodeToCheck_1029348928467, "r:00000000-0000-4000-0000-011c89590337(jetbrains.mps.baseLanguage.closures.typesystem)", "1236534227246", true), (SNode) pt, false, _info_12389875345);
          }
        }
      }
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.baseLanguage.closures.structure.ClosureControlStatement";
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
}
