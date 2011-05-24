package jetbrains.mps.baseLanguage.javadoc.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.structure.ConstraintsDataHolder;
import org.jetbrains.annotations.Nullable;
import jetbrains.mps.smodel.structure.CanBeASomethingMethod;
import jetbrains.mps.smodel.constraints.CanBeAChildContext;
import jetbrains.mps.smodel.SNodePointer;
import jetbrains.mps.smodel.IOperationContext;
import jetbrains.mps.smodel.structure.CheckingNodeContext;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;

public class ReturnBlockDocTag_Constraints extends ConstraintsDataHolder {
  public ReturnBlockDocTag_Constraints() {
  }

  public String getConceptFqName() {
    return "jetbrains.mps.baseLanguage.javadoc.structure.ReturnBlockDocTag";
  }

  @Override
  @Nullable
  public CanBeASomethingMethod<CanBeAChildContext> getCanBeAChildMethod() {
    return new CanBeASomethingMethod<CanBeAChildContext>() {
      private SNodePointer breakingNode = new SNodePointer("r:28bcf003-0004-46b6-9fe7-2093e7fb1368(jetbrains.mps.baseLanguage.javadoc.constraints)", "8970989240998521777");

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
    SNode returnType = SLinkOperations.getTarget(SNodeOperations.getAncestor(_context.getParentNode(), "jetbrains.mps.baseLanguage.structure.BaseMethodDeclaration", false, false), "returnType", true);
    return !((returnType != null) && SNodeOperations.isInstanceOf(returnType, "jetbrains.mps.baseLanguage.structure.VoidType"));
  }
}
