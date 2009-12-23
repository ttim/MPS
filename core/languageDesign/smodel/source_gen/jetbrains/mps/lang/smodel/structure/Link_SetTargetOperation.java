package jetbrains.mps.lang.smodel.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.baseLanguage.structure.Expression;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class Link_SetTargetOperation extends SNodeOperation {
  public static final String concept = "jetbrains.mps.lang.smodel.structure.Link_SetTargetOperation";
  public static final String LINK_TARGET = "linkTarget";

  public Link_SetTargetOperation(SNode node) {
    super(node);
  }

  public Expression getLinkTarget() {
    return (Expression) this.getChild(Expression.class, Link_SetTargetOperation.LINK_TARGET);
  }

  public void setLinkTarget(Expression node) {
    super.setChild(Link_SetTargetOperation.LINK_TARGET, node);
  }

  public static Link_SetTargetOperation newInstance(SModel sm, boolean init) {
    return (Link_SetTargetOperation) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.smodel.structure.Link_SetTargetOperation", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static Link_SetTargetOperation newInstance(SModel sm) {
    return Link_SetTargetOperation.newInstance(sm, false);
  }
}
