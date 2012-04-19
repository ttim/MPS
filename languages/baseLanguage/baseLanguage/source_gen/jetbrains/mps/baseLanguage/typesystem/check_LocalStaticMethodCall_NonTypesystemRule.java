package jetbrains.mps.baseLanguage.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.AbstractNonTypesystemRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.NonTypesystemRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;
import jetbrains.mps.lang.typesystem.runtime.IsApplicableStatus;
import java.util.List;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import java.util.Set;
import jetbrains.mps.internal.collections.runtime.SetSequence;
import java.util.HashSet;
import jetbrains.mps.baseLanguage.search.ClassifierAndSuperClassifiersScope;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.smodel.SModelUtil_new;

public class check_LocalStaticMethodCall_NonTypesystemRule extends AbstractNonTypesystemRule_Runtime implements NonTypesystemRule_Runtime {
  public check_LocalStaticMethodCall_NonTypesystemRule() {
  }

  public void applyRule(final SNode call, final TypeCheckingContext typeCheckingContext, IsApplicableStatus status) {
    List<SNode> containers = SNodeOperations.getAncestors(call, "jetbrains.mps.baseLanguage.structure.ClassConcept", false);
    Set<SNode> containersAndParentClasses = SetSequence.fromSet(new HashSet<SNode>());
    for (SNode classConcept : containers) {
      List<SNode> classifiers = new ClassifierAndSuperClassifiersScope(classConcept).getClassifiers();
      for (SNode classifier : classifiers) {
        SetSequence.fromSet(containersAndParentClasses).addElement(classifier);
      }
    }
    if (!(SetSequence.fromSet(containersAndParentClasses).contains(SNodeOperations.getParent(SLinkOperations.getTarget(call, "baseMethodDeclaration", false))))) {
      // todo: should be disabled? 
      // <node> 
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.baseLanguage.structure.LocalStaticMethodCall";
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
