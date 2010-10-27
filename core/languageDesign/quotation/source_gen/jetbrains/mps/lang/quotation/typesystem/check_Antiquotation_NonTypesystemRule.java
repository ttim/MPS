package jetbrains.mps.lang.quotation.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.AbstractNonTypesystemRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.NonTypesystemRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;
import jetbrains.mps.lang.typesystem.runtime.IsApplicableStatus;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.errors.BaseQuickFixProvider;
import jetbrains.mps.typesystem.inference.IErrorTarget;
import jetbrains.mps.typesystem.inference.NodeErrorTarget;
import jetbrains.mps.nodeEditor.IErrorReporter;

public class check_Antiquotation_NonTypesystemRule extends AbstractNonTypesystemRule_Runtime implements NonTypesystemRule_Runtime {
  public check_Antiquotation_NonTypesystemRule() {
  }

  public void applyRule(final SNode antiquotation, final TypeCheckingContext typeCheckingContext, IsApplicableStatus status) {
    SNode annotatedNode = SNodeOperations.getParent(antiquotation);
    do {
      SNode matchedNode_6y0fd_b0 = SNodeOperations.getParent(annotatedNode);
      {
        boolean matches_6y0fd_a1a = false;
        {
          SNode matchingNode_6y0fd_a1a = SNodeOperations.getParent(annotatedNode);
          if (matchingNode_6y0fd_a1a != null) {
            matches_6y0fd_a1a = SModelUtil_new.isAssignableConcept(matchingNode_6y0fd_a1a.getConceptFqName(), "jetbrains.mps.lang.quotation.structure.Quotation");
          }
        }
        if (matches_6y0fd_a1a) {
          if (SLinkOperations.getTarget(matchedNode_6y0fd_b0, "quotedNode", true) == annotatedNode) {
            {
              BaseQuickFixProvider intentionProvider = null;
              IErrorTarget errorTarget = new NodeErrorTarget();
              IErrorReporter _reporter_2309309498 = typeCheckingContext.reportTypeError(antiquotation, "node antiquotation should not be used on a quoted node itself", "r:00000000-0000-4000-0000-011c8959034a(jetbrains.mps.lang.quotation.typesystem)", "1202840754879", intentionProvider, errorTarget);
            }
          }
          break;
        }
      }
    } while (false);
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.lang.quotation.structure.Antiquotation";
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
