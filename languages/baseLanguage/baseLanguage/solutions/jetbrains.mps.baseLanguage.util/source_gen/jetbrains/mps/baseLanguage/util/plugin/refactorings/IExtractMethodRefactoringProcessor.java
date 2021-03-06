package jetbrains.mps.baseLanguage.util.plugin.refactorings;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import java.util.List;

public interface IExtractMethodRefactoringProcessor {
  public SNode getContainerMethod();
  public SNode createNewMethod();
  public void addMethod(SNode method);
  public SNode createMethodCall(SNode method, List<SNode> params);
  public SNode getContainerReturnType();
}
