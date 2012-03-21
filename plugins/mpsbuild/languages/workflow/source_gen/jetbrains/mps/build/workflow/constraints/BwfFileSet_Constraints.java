package jetbrains.mps.build.workflow.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.runtime.base.BaseConstraintsDescriptor;
import jetbrains.mps.smodel.SNodePointer;
import jetbrains.mps.smodel.SNode;
import org.jetbrains.annotations.Nullable;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.runtime.CheckingNodeContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;

public class BwfFileSet_Constraints extends BaseConstraintsDescriptor {
  private static SNodePointer canBeParentBreakingPoint = new SNodePointer("r:8c3c79a2-2377-4680-a62f-78d39fdded56(jetbrains.mps.build.workflow.constraints)", "7926701909975791099");

  public BwfFileSet_Constraints() {
    super("jetbrains.mps.build.workflow.structure.BwfFileSet");
  }

  @Override
  public boolean hasOwnCanBeParentMethod() {
    return true;
  }

  @Override
  public boolean canBeParent(SNode node, @Nullable SNode childNode, SNode childConcept, SNode link, IOperationContext operationContext, @Nullable CheckingNodeContext checkingNodeContext) {
    boolean result = static_canBeAParent(node, childNode, childConcept, link, operationContext);

    if (!(result) && checkingNodeContext != null) {
      checkingNodeContext.setBreakingNode(canBeParentBreakingPoint);
    }

    return result;
  }

  public static boolean static_canBeAParent(SNode node, SNode childNode, SNode childConcept, SNode link, final IOperationContext operationContext) {
    return SConceptOperations.isExactly(childConcept, "jetbrains.mps.core.xml.structure.XmlElement") || SConceptOperations.isExactly(childConcept, "jetbrains.mps.build.workflow.structure.BwfPathReference");
  }
}
