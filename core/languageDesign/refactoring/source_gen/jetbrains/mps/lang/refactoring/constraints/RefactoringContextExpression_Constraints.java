package jetbrains.mps.lang.refactoring.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.structure.ConstraintsDataHolder;
import org.jetbrains.annotations.Nullable;
import jetbrains.mps.smodel.structure.CanBeASomethingMethod;
import jetbrains.mps.smodel.constraints.CanBeAChildContext;
import jetbrains.mps.smodel.SNodePointer;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.structure.CheckingNodeContext;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;

public class RefactoringContextExpression_Constraints extends ConstraintsDataHolder {
  public RefactoringContextExpression_Constraints() {
  }

  public String getConceptFqName() {
    return "jetbrains.mps.lang.refactoring.structure.RefactoringContextExpression";
  }

  @Override
  @Nullable
  public CanBeASomethingMethod<CanBeAChildContext> getCanBeAChildMethod() {
    return new CanBeASomethingMethod<CanBeAChildContext>() {
      private SNodePointer breakingNode = new SNodePointer("r:00000000-0000-4000-0000-011c89590313(jetbrains.mps.lang.refactoring.constraints)", "5934994956487117014");

      public boolean canBe(IOperationContext operationContext, CanBeAChildContext _context, @Nullable CheckingNodeContext checkingNodeContext) {
        boolean result = canBeAChild(operationContext, _context);
        if (!(result) && checkingNodeContext != null) {
          checkingNodeContext.breakingNodePointer = breakingNode;
        }
        return result;
      }
    };
  }

  public static boolean canBeAChild(final IOperationContext operationContext, final CanBeAChildContext _context) {
    return (SNodeOperations.getAncestor(_context.getParentNode(), "jetbrains.mps.lang.refactoring.structure.CustomParameterChooser", false, false) != null) && (SNodeOperations.getAncestor(_context.getParentNode(), "jetbrains.mps.lang.refactoring.structure.CommitClause", false, false) == null);
  }
}
