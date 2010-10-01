package jetbrains.mps.baseLanguage.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.AbstractNonTypesystemRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.NonTypesystemRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;
import jetbrains.mps.lang.typesystem.runtime.IsApplicableStatus;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.baseLanguage.behavior.StatementList_Behavior;
import jetbrains.mps.intentions.BaseIntentionProvider;
import jetbrains.mps.typesystem.inference.IErrorTarget;
import jetbrains.mps.typesystem.inference.NodeErrorTarget;
import jetbrains.mps.nodeEditor.IErrorReporter;
import jetbrains.mps.lang.core.behavior.BaseConcept_Behavior;
import jetbrains.mps.smodel.SModelUtil_new;

public class check_ConstructorInvocationStatementIsFirstStatement_NonTypesystemRule extends AbstractNonTypesystemRule_Runtime implements NonTypesystemRule_Runtime {
  public check_ConstructorInvocationStatementIsFirstStatement_NonTypesystemRule() {
  }

  public void applyRule(final SNode constructorInvocation, final TypeCheckingContext typeCheckingContext, IsApplicableStatus status) {
    SNode constructor = SNodeOperations.getAncestor(constructorInvocation, "jetbrains.mps.baseLanguage.structure.ConstructorDeclaration", false, false);
    if (constructor != null) {
      SNode statementList = SLinkOperations.getTarget(constructor, "body", true);
      SNode firstStatement = StatementList_Behavior.call_getFirstStatement_5420652334935371934(statementList);
      if (firstStatement != constructorInvocation) {
        {
          BaseIntentionProvider intentionProvider = null;
          IErrorTarget errorTarget = new NodeErrorTarget();
          IErrorReporter _reporter_2309309498 = typeCheckingContext.reportTypeError(constructorInvocation, "Call to '" + BaseConcept_Behavior.call_getPresentation_1213877396640(constructorInvocation) + "' must be first statement in constructor body", "r:00000000-0000-4000-0000-011c895902c5(jetbrains.mps.baseLanguage.typesystem)", "3133930811460325358", intentionProvider, errorTarget);
        }
      }
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.baseLanguage.structure.ConstructorInvocationStatement";
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
