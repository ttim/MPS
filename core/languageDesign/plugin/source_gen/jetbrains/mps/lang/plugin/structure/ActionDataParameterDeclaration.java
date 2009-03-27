package jetbrains.mps.lang.plugin.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.baseLanguage.structure.StaticFieldDeclaration;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class ActionDataParameterDeclaration extends jetbrains.mps.lang.core.structure.BaseConcept implements jetbrains.mps.baseLanguage.classifiers.structure.IMember, jetbrains.mps.lang.plugin.structure.ActionParameter {
  public static final String concept = "jetbrains.mps.lang.plugin.structure.ActionDataParameterDeclaration";
  public static final String NAME = "name";
  public static final String SHORT_DESCRIPTION = "shortDescription";
  public static final String ALIAS = "alias";
  public static final String VIRTUAL_PACKAGE = "virtualPackage";
  public static final String IS_OPTIONAL = "isOptional";
  public static final String KEY = "key";

  public ActionDataParameterDeclaration(SNode node) {
    super(node);
  }

  public String getName() {
    return this.getProperty(ActionDataParameterDeclaration.NAME);
  }

  public void setName(String value) {
    this.setProperty(ActionDataParameterDeclaration.NAME, value);
  }

  public String getShortDescription() {
    return this.getProperty(ActionDataParameterDeclaration.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(ActionDataParameterDeclaration.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(ActionDataParameterDeclaration.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(ActionDataParameterDeclaration.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(ActionDataParameterDeclaration.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(ActionDataParameterDeclaration.VIRTUAL_PACKAGE, value);
  }

  public boolean getIsOptional() {
    return this.getBooleanProperty(ActionDataParameterDeclaration.IS_OPTIONAL);
  }

  public void setIsOptional(boolean value) {
    this.setBooleanProperty(ActionDataParameterDeclaration.IS_OPTIONAL, value);
  }

  public jetbrains.mps.baseLanguage.structure.StaticFieldDeclaration getKey() {
    return (jetbrains.mps.baseLanguage.structure.StaticFieldDeclaration)this.getReferent(StaticFieldDeclaration.class, ActionDataParameterDeclaration.KEY);
  }

  public void setKey(jetbrains.mps.baseLanguage.structure.StaticFieldDeclaration node) {
    super.setReferent(ActionDataParameterDeclaration.KEY, node);
  }


  public static ActionDataParameterDeclaration newInstance(SModel sm, boolean init) {
    return (ActionDataParameterDeclaration)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.plugin.structure.ActionDataParameterDeclaration", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static ActionDataParameterDeclaration newInstance(SModel sm) {
    return ActionDataParameterDeclaration.newInstance(sm, false);
  }

}
