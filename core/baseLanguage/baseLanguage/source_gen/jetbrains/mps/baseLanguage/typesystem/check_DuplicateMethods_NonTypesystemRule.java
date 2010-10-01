package jetbrains.mps.baseLanguage.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.AbstractNonTypesystemRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.NonTypesystemRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;
import jetbrains.mps.lang.typesystem.runtime.IsApplicableStatus;
import java.util.List;
import jetbrains.mps.baseLanguage.behavior.Classifier_Behavior;
import jetbrains.mps.baseLanguage.search.ClassifierAndSuperClassifiersScope;
import jetbrains.mps.baseLanguage.structure.Classifier;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.baseLanguage.search.IClassifiersSearchScope;
import jetbrains.mps.baseLanguage.structure.BaseMethodDeclaration;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.smodel.SModelUtil_new;

public class check_DuplicateMethods_NonTypesystemRule extends AbstractNonTypesystemRule_Runtime implements NonTypesystemRule_Runtime {
  public check_DuplicateMethods_NonTypesystemRule() {
  }

  public void applyRule(final SNode classifier, final TypeCheckingContext typeCheckingContext, IsApplicableStatus status) {
    List<SNode> ownMethods = Classifier_Behavior.call_getOwnMethods_1906502351318572840(classifier);
    ClassifierAndSuperClassifiersScope scope = new ClassifierAndSuperClassifiersScope(((Classifier) SNodeOperations.getAdapter(classifier)), IClassifiersSearchScope.INSTANCE_METHOD | IClassifiersSearchScope.STATIC_METHOD);
    for (SNode ownMethod : ownMethods) {
      List<BaseMethodDeclaration> namesakes = scope.getMethodsByName(SPropertyOperations.getString(ownMethod, "name"));
      if (namesakes.size() < 2) {
        continue;
      }
      RulesFunctions_BaseLanguage.checkDuplicates(typeCheckingContext, ownMethod, classifier, namesakes);
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
