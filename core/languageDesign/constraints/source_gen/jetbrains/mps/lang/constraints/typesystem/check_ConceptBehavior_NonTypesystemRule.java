package jetbrains.mps.lang.constraints.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.AbstractNonTypesystemRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.NonTypesystemRule_Runtime;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;
import java.util.List;
import jetbrains.mps.lang.structure.behavior.AbstractConceptDeclaration_Behavior;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.project.GlobalScope;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptPropertyOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.intentions.BaseIntentionProvider;
import jetbrains.mps.typesystem.inference.IErrorTarget;
import jetbrains.mps.typesystem.inference.NodeErrorTarget;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import jetbrains.mps.smodel.SModelUtil_new;

public class check_ConceptBehavior_NonTypesystemRule extends AbstractNonTypesystemRule_Runtime implements NonTypesystemRule_Runtime {

  public check_ConceptBehavior_NonTypesystemRule() {
  }

  public void applyRule(final SNode nodeToCheck, final TypeCheckingContext typeCheckingContext) {
    List<SNode> methodDeclarations = AbstractConceptDeclaration_Behavior.call_getNotImplementedConceptMethods_1213877394339(SLinkOperations.getTarget(nodeToCheck, "concept", false), GlobalScope.getInstance());
    if (SConceptPropertyOperations.getBoolean(SLinkOperations.getTarget(nodeToCheck, "concept", false), "abstract")) {
      return;
    }
    if (SNodeOperations.isInstanceOf(SLinkOperations.getTarget(nodeToCheck, "concept", false), "jetbrains.mps.lang.structure.structure.InterfaceConceptDeclaration")) {
      return;
    }
    if (!(ListSequence.fromList(methodDeclarations).isEmpty())) {
      boolean notImplementedMethods = false;
      for(SNode cm : methodDeclarations) {
        if (!(ListSequence.fromList(SLinkOperations.getTargets(nodeToCheck, "method", true)).contains(cm))) {
          notImplementedMethods = true;
        }
      }
      if (notImplementedMethods) {
        {
          BaseIntentionProvider intentionProvider = null;
          IErrorTarget errorTarget = new NodeErrorTarget();
          typeCheckingContext.reportTypeError(nodeToCheck, "Concept " + SPropertyOperations.getString(SLinkOperations.getTarget(nodeToCheck, "concept", false), "name") + " doesn't implement " + methodDeclarations, "r:00000000-0000-4000-0000-011c89590309(jetbrains.mps.lang.constraints.typesystem)", "1198950378289", intentionProvider, errorTarget);
        }
      }
    }
    for(SNode cmd : SLinkOperations.getTargets(nodeToCheck, "method", true)) {
      if (SConceptPropertyOperations.getBoolean(cmd, "abstract")) {
        {
          BaseIntentionProvider intentionProvider = null;
          IErrorTarget errorTarget = new NodeErrorTarget();
          typeCheckingContext.reportTypeError(cmd, "Abstract method in non abstract concept", "r:00000000-0000-4000-0000-011c89590309(jetbrains.mps.lang.constraints.typesystem)", "1198949983025", intentionProvider, errorTarget);
        }
      }
    }
  }

  public String getApplicableConceptFQName() {
    return "jetbrains.mps.lang.behavior.structure.ConceptBehavior";
  }

  public boolean isApplicable(SNode argument) {
    return SModelUtil_new.isAssignableConcept(argument.getConceptFqName(), this.getApplicableConceptFQName());
  }

  public boolean overrides() {
    return false;
  }

}
