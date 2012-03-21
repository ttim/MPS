package jetbrains.mps.lang.scopes.structure;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.structure.Expression;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.structure.structure.LinkDeclaration;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class ComeFromExpression extends Expression {
  public static final String concept = "jetbrains.mps.lang.scopes.structure.ComeFromExpression";
  public static final String LINK = "link";

  public ComeFromExpression(SNode node) {
    super(node);
  }

  public LinkDeclaration getLink() {
    return (LinkDeclaration) this.getReferent(LinkDeclaration.class, ComeFromExpression.LINK);
  }

  public void setLink(LinkDeclaration node) {
    super.setReferent(ComeFromExpression.LINK, node);
  }

  public static ComeFromExpression newInstance(SModel sm, boolean init) {
    return (ComeFromExpression) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.scopes.structure.ComeFromExpression", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static ComeFromExpression newInstance(SModel sm) {
    return ComeFromExpression.newInstance(sm, false);
  }
}
