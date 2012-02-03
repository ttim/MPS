package jetbrains.mps.make.script.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.runtime.base.BaseConstraintsDescriptor;
import jetbrains.mps.smodel.SNodePointer;
import org.jetbrains.annotations.Nullable;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.runtime.CheckingNodeContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;

public class ResultStatement_Constraints extends BaseConstraintsDescriptor {
  private static SNodePointer canBeChildBreakingPoint = new SNodePointer("r:56325792-0540-48ec-8d52-897a8821cc64(jetbrains.mps.make.script.constraints)", "1977954644795408666");

  public ResultStatement_Constraints() {
    super("jetbrains.mps.make.script.structure.ResultStatement");
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
    SNode anc = SNodeOperations.getAncestorWhereConceptInList(parentNode, new String[]{"jetbrains.mps.make.script.structure.JobDefinition", "jetbrains.mps.make.script.structure.ConfigDefinition", "jetbrains.mps.baseLanguage.structure.IStatementListContainer"}, false, false);
    return SNodeOperations.isInstanceOf(anc, "jetbrains.mps.make.script.structure.JobDefinition") || SNodeOperations.isInstanceOf(anc, "jetbrains.mps.make.script.structure.ConfigDefinition");
  }
}
