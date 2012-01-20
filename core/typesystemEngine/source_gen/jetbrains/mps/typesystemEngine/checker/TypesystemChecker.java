package jetbrains.mps.typesystemEngine.checker;

/*Generated by MPS */

import jetbrains.mps.checkers.INodeChecker;
import jetbrains.mps.smodel.SNodePointer;
import jetbrains.mps.typesystem.inference.ITypeContextOwner;
import java.util.Set;
import jetbrains.mps.errors.IErrorReporter;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.IOperationContext;
import java.util.HashSet;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;
import jetbrains.mps.typesystem.inference.TypeContextManager;
import jetbrains.mps.util.Pair;
import java.util.List;

public class TypesystemChecker implements INodeChecker, ITypeContextOwner {
  public TypesystemChecker() {
  }

  public String getCategory() {
    return "type system";
  }

  public Set<IErrorReporter> getErrors(SNode node, IOperationContext context) {
    Set<IErrorReporter> result = new HashSet<IErrorReporter>();
    SNodePointer nodePointer = new SNodePointer(node);
    TypeCheckingContext typeCheckingContext = TypeContextManager.getInstance().getOrCreateContext(nodePointer, this, true);
    Set<Pair<SNode, List<IErrorReporter>>> nodeWithErrors = typeCheckingContext.checkRootAndGetErrors(true);
    for (Pair<SNode, List<IErrorReporter>> pair : nodeWithErrors) {
      result.addAll(pair.o2);
    }
    TypeContextManager.getInstance().removeOwnerForRootNodeContext(nodePointer, this);
    return result;
  }
}
