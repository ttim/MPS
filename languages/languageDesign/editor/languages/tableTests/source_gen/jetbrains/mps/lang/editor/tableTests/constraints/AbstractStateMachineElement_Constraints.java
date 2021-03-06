package jetbrains.mps.lang.editor.tableTests.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.runtime.base.BaseConstraintsDescriptor;
import jetbrains.mps.smodel.SNodePointer;
import org.jetbrains.annotations.Nullable;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.runtime.CheckingNodeContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;

public class AbstractStateMachineElement_Constraints extends BaseConstraintsDescriptor {
  private static SNodePointer canBeChildBreakingPoint = new SNodePointer("r:5eda252d-8f97-48fa-a19c-1626b2b52512(jetbrains.mps.lang.editor.tableTests.constraints)", "7943979732673457902");

  public AbstractStateMachineElement_Constraints() {
    super("jetbrains.mps.lang.editor.tableTests.structure.AbstractStateMachineElement");
  }

  @Override
  public boolean hasOwnCanBeChildMethod() {
    return true;
  }

  @Override
  public boolean canBeChild(@Nullable SNode node, SNode parentNode, SNode link, SNode childConcept, final IOperationContext operationContext, @Nullable final CheckingNodeContext checkingNodeContext) {
    boolean result = static_canBeAChild(node, parentNode, link, childConcept, operationContext);

    if (!(result) && checkingNodeContext != null) {
      checkingNodeContext.setBreakingNode(canBeChildBreakingPoint);
    }

    return result;
  }

  public static boolean static_canBeAChild(SNode node, SNode parentNode, SNode link, SNode childConcept, final IOperationContext operationContext) {
    return SNodeOperations.isInstanceOf(parentNode, "jetbrains.mps.lang.editor.tableTests.structure.StateMachine");
  }
}
