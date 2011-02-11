package jetbrains.mps.lang.test.runtime;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;
import jetbrains.mps.typesystem.inference.TypeContextManager;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import junit.framework.Assert;
import jetbrains.mps.newTypesystem.TypesUtil;
import jetbrains.mps.newTypesystem.TypeCheckingContextNew;
import jetbrains.mps.newTypesystem.state.State;
import jetbrains.mps.newTypesystem.operation.AbstractOperation;
import java.util.List;
import java.util.Collections;
import jetbrains.mps.newTypesystem.test.StateMatcher;

public class TypeSystemChecker {
  public TypeSystemChecker() {
  }

  public static void checkGenerationMode(SNode node) {
    TypeCheckingContext typeCheckingContext = TypeContextManager.getInstance().createTypeCheckingContext(node.getContainingRoot());
    typeCheckingContext.checkRoot(true);
    TypeCheckingContext typeCheckingContext2 = TypeContextManager.getInstance().createTypeCheckingContext(node.getContainingRoot());
    for (SNode child : SNodeOperations.getDescendants(node, "jetbrains.mps.lang.core.structure.BaseConcept", false, new String[]{})) {
      SNode type1 = typeCheckingContext.getTypeDontCheck(child);
      SNode type2 = typeCheckingContext2.getTypeInGenerationMode(child);
      Assert.assertTrue(TypesUtil.match(type1, type2));
    }
  }

  public static void checkRollBacks(SNode node) {
    TypeCheckingContext typeCheckingContext = TypeContextManager.getInstance().createTypeCheckingContext(node.getContainingRoot());
    typeCheckingContext.checkIfNotChecked(node, true);
    if (typeCheckingContext instanceof TypeCheckingContextNew) {
      State state = ((TypeCheckingContextNew) typeCheckingContext).getState();
      State state2 = new State(state.getTypeCheckingContext());
      AbstractOperation rootOperation = state.getOperation();
      List<AbstractOperation> operations = state.getOperationsAsList();
      int num = operations.size() / 3;
      AbstractOperation operation = operations.get(num);
      Collections.reverse(operations);
      state2.executeOperationsBeforeAnchor(rootOperation, operation);
      for (AbstractOperation toRevert : operations) {
        if (toRevert.equals(operation)) {
          break;
        }
        toRevert.undo(state);
      }
      Assert.assertTrue(StateMatcher.match(state, state2));
    }
  }
}
