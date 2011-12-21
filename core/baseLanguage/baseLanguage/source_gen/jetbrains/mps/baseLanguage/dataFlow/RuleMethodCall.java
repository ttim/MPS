package jetbrains.mps.baseLanguage.dataFlow;

/*Generated by MPS */

import jetbrains.mps.analyzers.runtime.framework.DataFlowConstructor;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.lang.core.behavior.INamedConcept_Behavior;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.dataFlow.framework.Program;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.dataFlow.framework.instructions.Instruction;

public class RuleMethodCall extends DataFlowConstructor {
  public RuleMethodCall() {
  }

  public boolean isApplicable(SNode node) {
    return SModelUtil_new.isAssignableConcept(INamedConcept_Behavior.call_getFqName_1213877404258(SNodeOperations.getConceptDeclaration(node)), getApplicableConceptFqName());
  }

  public String getApplicableConceptFqName() {
    return "jetbrains.mps.baseLanguage.structure.IMethodCall";
  }

  public void performActions(Program o, SNode node) {
    SNode m = node;
    SNode targetNode = node;
    while (SNodeOperations.isInstanceOf(SNodeOperations.getParent(targetNode), "jetbrains.mps.baseLanguage.structure.DotExpression") && SLinkOperations.getTarget(SNodeOperations.cast(SNodeOperations.getParent(targetNode), "jetbrains.mps.baseLanguage.structure.DotExpression"), "operation", true) == targetNode) {
      targetNode = SNodeOperations.getParent(targetNode);
    }
    if (SLinkOperations.getTargets(SLinkOperations.getTarget(m, "baseMethodDeclaration", false), "annotation", true) != null) {
      for (SNode annotation : SLinkOperations.getTargets(SLinkOperations.getTarget(m, "baseMethodDeclaration", false), "annotation", true)) {
        if (SLinkOperations.getTarget(annotation, "annotation", false) == SNodeOperations.getNode("f:java_stub#6ed54515-acc8-4d1e-a16c-9fd6cfe951ea#org.jetbrains.annotations(MPS.Core/org.jetbrains.annotations@java_stub)", "~Nullable")) {
          {
            Object object = node;
            if (((Program) o).contains(object)) {
              boolean before = false;
              int position = ((Program) (o)).getEnd(object);
              Instruction instruction = new nullableInstruction(targetNode);
              instruction.setSource(node);
              ((Program) (o)).insert(instruction, position, true, before);
            }
          }
        }
        if (SLinkOperations.getTarget(annotation, "annotation", false) == SNodeOperations.getNode("f:java_stub#6ed54515-acc8-4d1e-a16c-9fd6cfe951ea#org.jetbrains.annotations(MPS.Core/org.jetbrains.annotations@java_stub)", "~NotNull")) {
          {
            Object object = node;
            if (((Program) o).contains(object)) {
              boolean before = false;
              int position = ((Program) (o)).getEnd(object);
              Instruction instruction = new notNullInstruction(targetNode);
              instruction.setSource(node);
              ((Program) (o)).insert(instruction, position, true, before);
            }
          }
        }
      }
    }
  }
}
