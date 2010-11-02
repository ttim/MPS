package jetbrains.mps.baseLanguage.dataFlow;

/*Generated by MPS */

import jetbrains.mps.analyzers.runtime.framework.DataFlowConstructor;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.lang.core.behavior.INamedConcept_Behavior;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.dataFlow.framework.Program;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.dataFlow.framework.instructions.Instruction;

public class IfNullReturnAll extends DataFlowConstructor {
  public IfNullReturnAll() {
  }

  public boolean isApplicable(SNode node) {
    return SModelUtil_new.isAssignableConcept(INamedConcept_Behavior.call_getFqName_1213877404258(SNodeOperations.getConceptDeclaration(node)), getApplicableConceptFqName());
  }

  public String getApplicableConceptFqName() {
    return "jetbrains.mps.baseLanguage.structure.IfStatement";
  }

  public void performActions(Program o, SNode node) {
    SNode ifTrue = SLinkOperations.getTarget(node, "ifTrue", true);
    if (ListSequence.fromList(SLinkOperations.getTargets(ifTrue, "statement", true)).count() == 1 && SNodeOperations.isInstanceOf(ListSequence.fromList(SLinkOperations.getTargets(ifTrue, "statement", true)).first(), "jetbrains.mps.baseLanguage.structure.ReturnStatement")) {
      for (SNode expression : NullableUtil.getOrConditions(node)) {
        if (SNodeOperations.isInstanceOf(expression, "jetbrains.mps.baseLanguage.structure.EqualsExpression")) {
          SNode notNullNode = NullableUtil.getEqualsNull(SNodeOperations.cast(expression, "jetbrains.mps.baseLanguage.structure.EqualsExpression"));
          if (notNullNode != null) {
            {
              Object object = expression;
              if (((Program) o).contains(object)) {
                int position = ((Program) (o)).getEnd(object);
                Instruction instruction = new notNullInstruction(notNullNode);
                instruction.setSource(node);
                ((Program) (o)).insert(instruction, position, true);
              }
            }
          }
        }
      }
    }
  }
}
