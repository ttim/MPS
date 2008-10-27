package jetbrains.mps.lang.smodel.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class LinkList_GetCountOperation extends SNodeOperation {
  public static final String concept = "jetbrains.mps.lang.smodel.structure.LinkList_GetCountOperation";

  public LinkList_GetCountOperation(SNode node) {
    super(node);
  }

  public static LinkList_GetCountOperation newInstance(SModel sm, boolean init) {
    return (LinkList_GetCountOperation)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.smodel.structure.LinkList_GetCountOperation", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static LinkList_GetCountOperation newInstance(SModel sm) {
    return LinkList_GetCountOperation.newInstance(sm, false);
  }

}
