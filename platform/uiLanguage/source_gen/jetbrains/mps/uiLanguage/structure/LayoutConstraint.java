package jetbrains.mps.uiLanguage.structure;

/*Generated by MPS */

import jetbrains.mps.lang.core.structure.BaseConcept;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.baseLanguage.structure.Expression;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class LayoutConstraint extends BaseConcept implements IComponentPart {
  public static final String concept = "jetbrains.mps.uiLanguage.structure.LayoutConstraint";
  public static final String SHORT_DESCRIPTION = "shortDescription";
  public static final String ALIAS = "alias";
  public static final String VIRTUAL_PACKAGE = "virtualPackage";
  public static final String CONSTRAINT = "constraint";

  public LayoutConstraint(SNode node) {
    super(node);
  }

  public String getShortDescription() {
    return this.getProperty(LayoutConstraint.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(LayoutConstraint.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(LayoutConstraint.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(LayoutConstraint.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(LayoutConstraint.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(LayoutConstraint.VIRTUAL_PACKAGE, value);
  }

  public Expression getConstraint() {
    return (Expression) this.getChild(Expression.class, LayoutConstraint.CONSTRAINT);
  }

  public void setConstraint(Expression node) {
    super.setChild(LayoutConstraint.CONSTRAINT, node);
  }

  public static LayoutConstraint newInstance(SModel sm, boolean init) {
    return (LayoutConstraint) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.uiLanguage.structure.LayoutConstraint", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static LayoutConstraint newInstance(SModel sm) {
    return LayoutConstraint.newInstance(sm, false);
  }
}
