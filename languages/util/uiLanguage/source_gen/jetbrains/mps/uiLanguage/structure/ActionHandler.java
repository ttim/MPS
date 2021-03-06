package jetbrains.mps.uiLanguage.structure;

/*Generated by MPS */

import jetbrains.mps.lang.core.structure.BaseConcept;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.baseLanguage.structure.Expression;
import java.util.Iterator;
import jetbrains.mps.lang.core.structure.Attribute;
import java.util.List;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class ActionHandler extends BaseConcept implements IComponentPart {
  public static final String concept = "jetbrains.mps.uiLanguage.structure.ActionHandler";
  public static final String SHORT_DESCRIPTION = "shortDescription";
  public static final String ALIAS = "alias";
  public static final String VIRTUAL_PACKAGE = "virtualPackage";
  public static final String HANDLER = "handler";
  public static final String SMODEL_ATTRIBUTE = "smodelAttribute";

  public ActionHandler(SNode node) {
    super(node);
  }

  public String getShortDescription() {
    return this.getProperty(ActionHandler.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(ActionHandler.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(ActionHandler.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(ActionHandler.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(ActionHandler.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(ActionHandler.VIRTUAL_PACKAGE, value);
  }

  public Expression getHandler() {
    return (Expression) this.getChild(Expression.class, ActionHandler.HANDLER);
  }

  public void setHandler(Expression node) {
    super.setChild(ActionHandler.HANDLER, node);
  }

  public int getSmodelAttributesCount() {
    return this.getChildCount(ActionHandler.SMODEL_ATTRIBUTE);
  }

  public Iterator<Attribute> smodelAttributes() {
    return this.children(Attribute.class, ActionHandler.SMODEL_ATTRIBUTE);
  }

  public List<Attribute> getSmodelAttributes() {
    return this.getChildren(Attribute.class, ActionHandler.SMODEL_ATTRIBUTE);
  }

  public void addSmodelAttribute(Attribute node) {
    this.addChild(ActionHandler.SMODEL_ATTRIBUTE, node);
  }

  public void insertSmodelAttribute(Attribute prev, Attribute node) {
    this.insertChild(prev, ActionHandler.SMODEL_ATTRIBUTE, node);
  }

  public static ActionHandler newInstance(SModel sm, boolean init) {
    return (ActionHandler) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.uiLanguage.structure.ActionHandler", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static ActionHandler newInstance(SModel sm) {
    return ActionHandler.newInstance(sm, false);
  }
}
