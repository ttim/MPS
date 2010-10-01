package jetbrains.mps.baseLanguage.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.AbstractNonTypesystemRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.NonTypesystemRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;
import jetbrains.mps.lang.typesystem.runtime.IsApplicableStatus;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.baseLanguage.behavior.Classifier_Behavior;
import jetbrains.mps.intentions.BaseIntentionProvider;
import jetbrains.mps.typesystem.inference.IErrorTarget;
import jetbrains.mps.typesystem.inference.NodeErrorTarget;
import jetbrains.mps.nodeEditor.IErrorReporter;
import jetbrains.mps.smodel.SModelUtil_new;

public class check_InnerClassesCantHaveStaticInitializer_NonTypesystemRule extends AbstractNonTypesystemRule_Runtime implements NonTypesystemRule_Runtime {
  public check_InnerClassesCantHaveStaticInitializer_NonTypesystemRule() {
  }

  public void applyRule(final SNode staticInitializer, final TypeCheckingContext typeCheckingContext, IsApplicableStatus status) {
    if (SNodeOperations.getConceptDeclaration(SNodeOperations.getParent(staticInitializer)) == SConceptOperations.findConceptDeclaration("jetbrains.mps.baseLanguage.structure.ClassConcept")) {
      SNode classConcept = (SNode) SNodeOperations.getParent(staticInitializer);
      if (Classifier_Behavior.call_isInner_521412098689998677(classConcept) && !(Classifier_Behavior.call_isStatic_521412098689998668(classConcept))) {
        {
          BaseIntentionProvider intentionProvider = null;
          intentionProvider = new BaseIntentionProvider("jetbrains.mps.baseLanguage.typesystem.MakeStaticInitializerNotStatic_QuickFix", false);
          intentionProvider.putArgument("staticInitializer", staticInitializer);
          intentionProvider.putArgument("containingClass", classConcept);
          IErrorTarget errorTarget = new NodeErrorTarget();
          IErrorReporter _reporter_2309309498 = typeCheckingContext.reportTypeError(staticInitializer, "Inner classes cannot have static initializer", "r:00000000-0000-4000-0000-011c895902c5(jetbrains.mps.baseLanguage.typesystem)", "498633765599292849", intentionProvider, errorTarget);
        }
      }
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.baseLanguage.structure.StaticInitializer";
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
