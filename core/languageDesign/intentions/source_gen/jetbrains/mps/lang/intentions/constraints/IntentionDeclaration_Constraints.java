package jetbrains.mps.lang.intentions.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.structure.ConstraintsDataHolder;
import org.jetbrains.annotations.Nullable;
import jetbrains.mps.smodel.structure.CanBeASomethingMethod;
import jetbrains.mps.smodel.constraints.CanBeARootContext;
import jetbrains.mps.smodel.SNodePointer;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.structure.CheckingNodeContext;
import jetbrains.mps.smodel.LanguageAspect;
import jetbrains.mps.smodel.SModelStereotype;

public class IntentionDeclaration_Constraints extends ConstraintsDataHolder {
  public IntentionDeclaration_Constraints() {
  }

  public String getConceptFqName() {
    return "jetbrains.mps.lang.intentions.structure.IntentionDeclaration";
  }

  @Override
  @Nullable
  public CanBeASomethingMethod<CanBeARootContext> getCanBeARootMethod() {
    return new CanBeASomethingMethod<CanBeARootContext>() {
      private SNodePointer breakingNode = new SNodePointer("r:00000000-0000-4000-0000-011c8959034f(jetbrains.mps.lang.intentions.constraints)", "1227089959348");

      public boolean canBe(IOperationContext operationContext, CanBeARootContext _context, @Nullable CheckingNodeContext checkingNodeContext) {
        boolean result = canBeARoot(operationContext, _context);
        if (!(result) && checkingNodeContext != null) {
          checkingNodeContext.breakingNodePointer = breakingNode;
        }
        return result;
      }
    };
  }

  public static boolean canBeARoot(final IOperationContext operationContext, final CanBeARootContext _context) {
    return LanguageAspect.INTENTIONS.is(_context.getModel()) || SModelStereotype.isGeneratorModel(_context.getModel());
  }
}
