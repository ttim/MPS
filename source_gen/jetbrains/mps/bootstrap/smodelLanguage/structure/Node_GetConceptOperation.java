package jetbrains.mps.bootstrap.smodelLanguage.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class Node_GetConceptOperation extends SNodeOperation {

  public  Node_GetConceptOperation(SNode node) {
    super(node);
  }

  public static Node_GetConceptOperation newInstance(SModel sm, boolean init) {
    return (Node_GetConceptOperation)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.bootstrap.smodelLanguage.structure.Node_GetConceptOperation", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static Node_GetConceptOperation newInstance(SModel sm) {
    return Node_GetConceptOperation.newInstance(sm, false);
  }

}
