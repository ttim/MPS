package jetbrains.mps.baseLanguage.regexp.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.runtime.base.BaseConstraintsDescriptor;
import jetbrains.mps.smodel.SNodePointer;
import org.jetbrains.annotations.Nullable;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.runtime.CheckingNodeContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.typesystem.inference.TypeChecker;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.typesystem.runtime.HUtil;

public class MatchRegexpOperation_Constraints extends BaseConstraintsDescriptor {
  private static SNodePointer canBeChildBreakingPoint = new SNodePointer("r:00000000-0000-4000-0000-011c89590515(jetbrains.mps.baseLanguage.regexp.constraints)", "1231768942676");

  public MatchRegexpOperation_Constraints() {
    super("jetbrains.mps.baseLanguage.regexp.structure.MatchRegexpOperation");
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
    boolean can = false;
    if (SNodeOperations.isInstanceOf(parentNode, "jetbrains.mps.baseLanguage.structure.DotExpression")) {
      SNode type = TypeChecker.getInstance().getTypeOf(SLinkOperations.getTarget(SNodeOperations.cast(parentNode, "jetbrains.mps.baseLanguage.structure.DotExpression"), "operand", true));
      can = TypeChecker.getInstance().getRuntimeSupport().coerce_(type, HUtil.createMatchingPatternByConceptFQName("jetbrains.mps.baseLanguage.structure.StringType"), true) != null;
    }
    return can;
  }
}
