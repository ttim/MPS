package jetbrains.mps.lang.smodel.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class Node_GetAncestorOperation extends SNodeOperation {
  public static final String concept = "jetbrains.mps.lang.smodel.structure.Node_GetAncestorOperation";

  public Node_GetAncestorOperation(SNode node) {
    super(node);
  }

  public static Node_GetAncestorOperation newInstance(SModel sm, boolean init) {
    return (Node_GetAncestorOperation)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.smodel.structure.Node_GetAncestorOperation", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static Node_GetAncestorOperation newInstance(SModel sm) {
    return Node_GetAncestorOperation.newInstance(sm, false);
  }

}
