package jetbrains.mps.lang.typesystem.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.AbstractNonTypesystemRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.NonTypesystemRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.intentions.BaseIntentionProvider;
import jetbrains.mps.typesystem.inference.IErrorTarget;
import jetbrains.mps.typesystem.inference.NodeErrorTarget;
import jetbrains.mps.nodeEditor.IErrorReporter;
import jetbrains.mps.smodel.SModelUtil_new;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.typesystem.inference.TypeChecker;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.smodel.SReference;
import jetbrains.mps.smodel.SModelReference;
import jetbrains.mps.smodel.SNodeId;

public class check_MethodDeclaration_NonTypesystemRule extends AbstractNonTypesystemRule_Runtime implements NonTypesystemRule_Runtime {
  public check_MethodDeclaration_NonTypesystemRule() {
  }

  public void applyRule(final SNode baseMethodDeclaration, final TypeCheckingContext typeCheckingContext) {
    for (SNode annotationInstance : SLinkOperations.getTargets(baseMethodDeclaration, "annotation", true)) {
      if (SLinkOperations.getTarget(annotationInstance, "annotation", false) == SLinkOperations.getTarget(new check_MethodDeclaration_NonTypesystemRule.QuotationClass_46fcoa_a0a0a0a0a().createNode(typeCheckingContext), "classifier", false)) {
        if (!(SNodeOperations.isInstanceOf(SLinkOperations.getTarget(baseMethodDeclaration, "returnType", true), "jetbrains.mps.baseLanguage.structure.VoidType"))) {
          BaseIntentionProvider intentionProvider = null;
          IErrorTarget errorTarget = new NodeErrorTarget();
          IErrorReporter _reporter_2309309498 = typeCheckingContext.reportTypeError(SLinkOperations.getTarget(baseMethodDeclaration, "returnType", true), "inference method should not return a value", "r:00000000-0000-4000-0000-011c895902b1(jetbrains.mps.lang.typesystem.typesystem)", "1206297717786", intentionProvider, errorTarget);
        }
        return;
      }
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.baseLanguage.structure.BaseMethodDeclaration";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return false;
  }

  public static class QuotationClass_46fcoa_a0a0a0a0a {
    public QuotationClass_46fcoa_a0a0a0a0a() {
    }

    public SNode createNode(final TypeCheckingContext typeCheckingContext) {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_46fcoa_a0a0a0a0a = null;
      {
        quotedNode_46fcoa_a0a0a0a0a = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.ClassifierType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_46fcoa_a0a0a0a0a = quotedNode_46fcoa_a0a0a0a0a;
        quotedNode1_46fcoa_a0a0a0a0a.addReference(SReference.create("classifier", quotedNode1_46fcoa_a0a0a0a0a, SModelReference.fromString("r:00000000-0000-4000-0000-011c895902b5(jetbrains.mps.lang.typesystem.dependencies)"), SNodeId.fromString("1196177069451")));
        result = quotedNode1_46fcoa_a0a0a0a0a;
      }
      return result;
    }

    public SNode createNode() {
      SNode result = null;
      Set<SNode> _parameterValues_129834374 = new HashSet<SNode>();
      SNode quotedNode_46fcoa_a0a0a0a0a = null;
      {
        quotedNode_46fcoa_a0a0a0a0a = SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.ClassifierType", TypeChecker.getInstance().getRuntimeTypesModel(), GlobalScope.getInstance(), false);
        SNode quotedNode1_46fcoa_a0a0a0a0a = quotedNode_46fcoa_a0a0a0a0a;
        quotedNode1_46fcoa_a0a0a0a0a.addReference(SReference.create("classifier", quotedNode1_46fcoa_a0a0a0a0a, SModelReference.fromString("r:00000000-0000-4000-0000-011c895902b5(jetbrains.mps.lang.typesystem.dependencies)"), SNodeId.fromString("1196177069451")));
        result = quotedNode1_46fcoa_a0a0a0a0a;
      }
      return result;
    }
  }
}
