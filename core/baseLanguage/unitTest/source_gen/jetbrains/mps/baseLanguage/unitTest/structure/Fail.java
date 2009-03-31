package jetbrains.mps.baseLanguage.unitTest.structure;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.structure.Statement;
import jetbrains.mps.baseLanguage.unitTest.structure.MessageHolder;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.baseLanguage.unitTest.structure.Message;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class Fail extends Statement implements MessageHolder {
  public static final String concept = "jetbrains.mps.baseLanguage.unitTest.structure.Fail";
  public static final String SHORT_DESCRIPTION = "shortDescription";
  public static final String ALIAS = "alias";
  public static final String VIRTUAL_PACKAGE = "virtualPackage";
  public static final String MESSAGE = "message";

  public Fail(SNode node) {
    super(node);
  }

  public String getShortDescription() {
    return this.getProperty(Fail.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(Fail.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(Fail.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(Fail.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(Fail.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(Fail.VIRTUAL_PACKAGE, value);
  }

  public Message getMessage() {
    return (Message)this.getChild(Message.class, Fail.MESSAGE);
  }

  public void setMessage(Message node) {
    super.setChild(Fail.MESSAGE, node);
  }


  public static Fail newInstance(SModel sm, boolean init) {
    return (Fail)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.unitTest.structure.Fail", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static Fail newInstance(SModel sm) {
    return Fail.newInstance(sm, false);
  }

}
