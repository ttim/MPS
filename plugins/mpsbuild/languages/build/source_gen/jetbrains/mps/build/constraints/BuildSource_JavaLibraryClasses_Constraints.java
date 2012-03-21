package jetbrains.mps.build.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.runtime.base.BaseConstraintsDescriptor;
import jetbrains.mps.smodel.SNodePointer;
import jetbrains.mps.smodel.SNode;
import org.jetbrains.annotations.Nullable;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.runtime.CheckingNodeContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SConceptOperations;

public class BuildSource_JavaLibraryClasses_Constraints extends BaseConstraintsDescriptor {
  private static SNodePointer canBeParentBreakingPoint = new SNodePointer("r:5076fdb3-19c3-4563-aa26-7ace7591e78d(jetbrains.mps.build.constraints)", "1258644073389093527");

  public BuildSource_JavaLibraryClasses_Constraints() {
    super("jetbrains.mps.build.structure.BuildSource_JavaLibraryClasses");
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
    return SConceptOperations.isExactly(childConcept, "jetbrains.mps.build.structure.BuildSource_JavaLibraryJar") || SConceptOperations.isExactly(childConcept, "jetbrains.mps.build.structure.BuildSource_JavaLibraryClassFiles");
  }
}
