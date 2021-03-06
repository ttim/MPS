package jetbrains.mps.lang.smodel.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.baseLanguage.structure.Expression;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class LinkList_InsertChildFirstOperation extends SNodeOperation {
  public static final String concept = "jetbrains.mps.lang.smodel.structure.LinkList_InsertChildFirstOperation";
  public static final String CHILD_NODE = "childNode";

  public LinkList_InsertChildFirstOperation(SNode node) {
    super(node);
  }

  public Expression getChildNode() {
    return (Expression) this.getChild(Expression.class, LinkList_InsertChildFirstOperation.CHILD_NODE);
  }

  public void setChildNode(Expression node) {
    super.setChild(LinkList_InsertChildFirstOperation.CHILD_NODE, node);
  }

  public static LinkList_InsertChildFirstOperation newInstance(SModel sm, boolean init) {
    return (LinkList_InsertChildFirstOperation) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.smodel.structure.LinkList_InsertChildFirstOperation", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static LinkList_InsertChildFirstOperation newInstance(SModel sm) {
    return LinkList_InsertChildFirstOperation.newInstance(sm, false);
  }
}
