package jetbrains.mps.baseLanguage.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.AbstractNonTypesystemRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.NonTypesystemRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;
import jetbrains.mps.lang.typesystem.runtime.IsApplicableStatus;
import jetbrains.mps.baseLanguage.util.OverridingMethodsFinder;
import jetbrains.mps.internal.collections.runtime.SetSequence;
import java.util.Set;
import jetbrains.mps.baseLanguage.tuples.runtime.Tuples;
import java.util.Iterator;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.baseLanguage.behavior.Classifier_Behavior;
import jetbrains.mps.typesystem.inference.TypeChecker;
import jetbrains.mps.errors.messageTargets.MessageTarget;
import jetbrains.mps.errors.messageTargets.NodeMessageTarget;
import jetbrains.mps.errors.IErrorReporter;
import jetbrains.mps.smodel.SModelUtil_new;

public class check_ClassifierOverridingMethods_NonTypesystemRule extends AbstractNonTypesystemRule_Runtime implements NonTypesystemRule_Runtime {
  public check_ClassifierOverridingMethods_NonTypesystemRule() {
  }

  public void applyRule(final SNode classifier, final TypeCheckingContext typeCheckingContext, IsApplicableStatus status) {
    OverridingMethodsFinder finder = new OverridingMethodsFinder(classifier);
    for (SNode overridingMethod : SetSequence.fromSet(finder.getOverridingMethods())) {
      Set<Tuples._2<SNode, SNode>> overridenMethods = finder.getOverridenMethods(overridingMethod);
      for (Iterator<Tuples._2<SNode, SNode>> it = SetSequence.fromSet(overridenMethods).iterator(); it.hasNext();) {
        SNode overridenMethod = it.next()._0();
        SNode returnType = SLinkOperations.getTarget(overridenMethod, "returnType", true);
        SNode ancestor = SNodeOperations.cast(SNodeOperations.getParent(overridenMethod), "jetbrains.mps.baseLanguage.structure.Classifier");
        SNode descendant = SNodeOperations.cast(SNodeOperations.getParent(overridingMethod), "jetbrains.mps.baseLanguage.structure.Classifier");
        SNode resolvedReturnType = Classifier_Behavior.call_getWithResolvedTypevars_3305065273710852527(descendant, returnType, ancestor, overridingMethod, overridenMethod);
        if (!(TypeChecker.getInstance().getSubtypingManager().isSubtype(SLinkOperations.getTarget(overridingMethod, "returnType", true), resolvedReturnType))) {
          {
            MessageTarget errorTarget = new NodeMessageTarget();
            IErrorReporter _reporter_2309309498 = typeCheckingContext.reportTypeError(SLinkOperations.getTarget(overridingMethod, "returnType", true), "method's return type is incompatible with overridden method ", "r:00000000-0000-4000-0000-011c895902c5(jetbrains.mps.baseLanguage.typesystem)", "2792291462223216211", null, errorTarget);
          }
          break;
        }
      }
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.baseLanguage.structure.Classifier";
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
