package org.jetbrains.mps.samples.ParallelFor.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.AbstractNonTypesystemRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.NonTypesystemRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;
import jetbrains.mps.lang.typesystem.runtime.IsApplicableStatus;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.AttributeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.IAttributeDescriptor;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.errors.messageTargets.MessageTarget;
import jetbrains.mps.errors.messageTargets.NodeMessageTarget;
import jetbrains.mps.errors.IErrorReporter;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.smodel.SModelUtil_new;

public class CallsToNonThreadSafeMethod_NonTypesystemRule extends AbstractNonTypesystemRule_Runtime implements NonTypesystemRule_Runtime {
  public CallsToNonThreadSafeMethod_NonTypesystemRule() {
  }

  public void applyRule(final SNode baseMethodCall, final TypeCheckingContext typeCheckingContext, IsApplicableStatus status) {
    SNode parentLoop = SNodeOperations.getAncestor(baseMethodCall, "org.jetbrains.mps.samples.ParallelFor.structure.ParallelFor", false, false);
    if (parentLoop != null) {
      if (SNodeOperations.isInstanceOf(baseMethodCall, "jetbrains.mps.baseLanguage.structure.StaticMethodCall")) {
        if (AttributeOperations.getAttribute(SNodeOperations.cast(baseMethodCall, "jetbrains.mps.baseLanguage.structure.StaticMethodCall"), new IAttributeDescriptor.NodeAttribute(SConceptOperations.findConceptDeclaration("org.jetbrains.mps.samples.ParallelFor.structure.ThreadSafe"))) != null) {
          return;
        }
        final SNode classConcept = SLinkOperations.getTarget(SNodeOperations.cast(baseMethodCall, "jetbrains.mps.baseLanguage.structure.StaticMethodCall"), "classConcept", false);
        if (AttributeOperations.getAttribute(classConcept, new IAttributeDescriptor.NodeAttribute(SConceptOperations.findConceptDeclaration("org.jetbrains.mps.samples.ParallelFor.structure.ThreadSafe"))) != null) {
          return;
        }
        if (AttributeOperations.getAttribute(classConcept, new IAttributeDescriptor.NodeAttribute(SConceptOperations.findConceptDeclaration("org.jetbrains.mps.samples.ParallelFor.structure.NonThreadSafeClass"))) != null) {
          {
            MessageTarget errorTarget = new NodeMessageTarget();
            IErrorReporter _reporter_2309309498 = typeCheckingContext.reportTypeError(baseMethodCall, "Calling a method on a non-thread-safe class", "r:4c36f4b4-7816-4067-aa6e-a49c547265ed(org.jetbrains.mps.samples.ParallelFor.typesystem)", "5384012304952426855", null, errorTarget);
          }
        } else {
          if (!(ListSequence.fromList(CheckingRuleHelper.allowedClasses()).any(new IWhereFilter<SNode>() {
            public boolean accept(SNode it) {
              return SLinkOperations.getTarget(it, "classifier", false) == classConcept;
            }
          }))) {
            {
              MessageTarget errorTarget = new NodeMessageTarget();
              IErrorReporter _reporter_2309309498 = typeCheckingContext.reportWarning(baseMethodCall, "Calling a method on a potentially non-thread-safe class", "r:4c36f4b4-7816-4067-aa6e-a49c547265ed(org.jetbrains.mps.samples.ParallelFor.typesystem)", "5384012304952426862", null, errorTarget);
            }
          }
        }
      } else if (SNodeOperations.isInstanceOf(baseMethodCall, "jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall")) {
        if (AttributeOperations.getAttribute(SNodeOperations.cast(baseMethodCall, "jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall"), new IAttributeDescriptor.NodeAttribute(SConceptOperations.findConceptDeclaration("org.jetbrains.mps.samples.ParallelFor.structure.ThreadSafe"))) != null) {
          return;
        }
        SNode instanceMethodDeclaration = SLinkOperations.getTarget(SNodeOperations.cast(baseMethodCall, "jetbrains.mps.baseLanguage.structure.LocalInstanceMethodCall"), "baseMethodDeclaration", false);
        SNode declaringClass = SNodeOperations.getAncestor(instanceMethodDeclaration, "jetbrains.mps.baseLanguage.structure.ClassConcept", false, false);
        if (declaringClass != null && AttributeOperations.getAttribute(declaringClass, new IAttributeDescriptor.NodeAttribute(SConceptOperations.findConceptDeclaration("org.jetbrains.mps.samples.ParallelFor.structure.ThreadSafe"))) != null && SPropertyOperations.getBoolean(declaringClass, "isFinal")) {
          return;
        }
        if (declaringClass != null && AttributeOperations.getAttribute(declaringClass, new IAttributeDescriptor.NodeAttribute(SConceptOperations.findConceptDeclaration("org.jetbrains.mps.samples.ParallelFor.structure.NonThreadSafeClass"))) != null) {
          {
            MessageTarget errorTarget = new NodeMessageTarget();
            IErrorReporter _reporter_2309309498 = typeCheckingContext.reportTypeError(baseMethodCall, "Calling a method on a non-thread-safe shared object", "r:4c36f4b4-7816-4067-aa6e-a49c547265ed(org.jetbrains.mps.samples.ParallelFor.typesystem)", "5384012304952487123", null, errorTarget);
          }
        }
        {
          MessageTarget errorTarget = new NodeMessageTarget();
          IErrorReporter _reporter_2309309498 = typeCheckingContext.reportWarning(baseMethodCall, "Calling a method on a potentially non-thread-safe shared object", "r:4c36f4b4-7816-4067-aa6e-a49c547265ed(org.jetbrains.mps.samples.ParallelFor.typesystem)", "5384012304952427127", null, errorTarget);
        }
        return;
      } else if (SNodeOperations.isInstanceOf(baseMethodCall, "jetbrains.mps.baseLanguage.structure.LocalStaticMethodCall")) {
        if (AttributeOperations.getAttribute(SNodeOperations.cast(baseMethodCall, "jetbrains.mps.baseLanguage.structure.LocalStaticMethodCall"), new IAttributeDescriptor.NodeAttribute(SConceptOperations.findConceptDeclaration("org.jetbrains.mps.samples.ParallelFor.structure.ThreadSafe"))) != null) {
          return;
        }
        SNode staticMethodDeclaration = SLinkOperations.getTarget(SNodeOperations.cast(baseMethodCall, "jetbrains.mps.baseLanguage.structure.LocalStaticMethodCall"), "baseMethodDeclaration", false);
        SNode declaringClass = SNodeOperations.getAncestor(staticMethodDeclaration, "jetbrains.mps.baseLanguage.structure.ClassConcept", false, false);
        if (declaringClass != null && AttributeOperations.getAttribute(declaringClass, new IAttributeDescriptor.NodeAttribute(SConceptOperations.findConceptDeclaration("org.jetbrains.mps.samples.ParallelFor.structure.ThreadSafe"))) != null) {
          return;
        }
        if (declaringClass != null && AttributeOperations.getAttribute(declaringClass, new IAttributeDescriptor.NodeAttribute(SConceptOperations.findConceptDeclaration("org.jetbrains.mps.samples.ParallelFor.structure.NonThreadSafeClass"))) != null) {
          {
            MessageTarget errorTarget = new NodeMessageTarget();
            IErrorReporter _reporter_2309309498 = typeCheckingContext.reportTypeError(baseMethodCall, "Calling a method on a non-thread-safe class", "r:4c36f4b4-7816-4067-aa6e-a49c547265ed(org.jetbrains.mps.samples.ParallelFor.typesystem)", "5384012304952487099", null, errorTarget);
          }
        }
        {
          MessageTarget errorTarget = new NodeMessageTarget();
          IErrorReporter _reporter_2309309498 = typeCheckingContext.reportWarning(baseMethodCall, "Calling a method on a potentially non-thread-safe class", "r:4c36f4b4-7816-4067-aa6e-a49c547265ed(org.jetbrains.mps.samples.ParallelFor.typesystem)", "5384012304952427264", null, errorTarget);
        }
      }

    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.baseLanguage.structure.BaseMethodCall";
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
