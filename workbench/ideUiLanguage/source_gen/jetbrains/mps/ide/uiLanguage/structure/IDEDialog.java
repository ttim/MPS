package jetbrains.mps.ide.uiLanguage.structure;

/*Generated by MPS */

import jetbrains.mps.core.structure.BaseConcept;
import jetbrains.mps.uiLanguage.structure.IComponentInstance;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;
import java.util.Iterator;
import java.util.List;
import jetbrains.mps.uiLanguage.structure.IComponentPart;

public class IDEDialog extends BaseConcept implements IComponentInstance {
  public static final String concept = "jetbrains.mps.ide.uiLanguage.structure.IDEDialog";
  public static String CONTENT_PANE = "contentPane";
  public static String BUTTON = "button";
  public static String CONTENT = "content";
  public static String SHORT_DESCRIPTION = "shortDescription";
  public static String ALIAS = "alias";
  public static String VIRTUAL_PACKAGE = "virtualPackage";

  public  IDEDialog(SNode node) {
    super(node);
  }

  public static IDEDialog newInstance(SModel sm, boolean init) {
    return (IDEDialog)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.ide.uiLanguage.structure.IDEDialog", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static IDEDialog newInstance(SModel sm) {
    return IDEDialog.newInstance(sm, false);
  }


  public IComponentInstance getContentPane() {
    return (IComponentInstance)this.getChild(IDEDialog.CONTENT_PANE);
  }

  public void setContentPane(IComponentInstance node) {
    super.setChild(IDEDialog.CONTENT_PANE, node);
  }

  public int getButtonsCount() {
    return this.getChildCount(IDEDialog.BUTTON);
  }

  public Iterator<IDEDialogButton> buttons() {
    return this.children(IDEDialog.BUTTON);
  }

  public List<IDEDialogButton> getButtons() {
    return this.getChildren(IDEDialog.BUTTON);
  }

  public void addButton(IDEDialogButton node) {
    this.addChild(IDEDialog.BUTTON, node);
  }

  public void insertButton(IDEDialogButton prev, IDEDialogButton node) {
    this.insertChild(prev, IDEDialog.BUTTON, node);
  }

  public int getContentsCount() {
    return this.getChildCount(IDEDialog.CONTENT);
  }

  public Iterator<IComponentPart> contents() {
    return this.children(IDEDialog.CONTENT);
  }

  public List<IComponentPart> getContents() {
    return this.getChildren(IDEDialog.CONTENT);
  }

  public void addContent(IComponentPart node) {
    this.addChild(IDEDialog.CONTENT, node);
  }

  public void insertContent(IComponentPart prev, IComponentPart node) {
    this.insertChild(prev, IDEDialog.CONTENT, node);
  }

  public String getShortDescription() {
    return this.getProperty(IDEDialog.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(IDEDialog.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(IDEDialog.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(IDEDialog.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(IDEDialog.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(IDEDialog.VIRTUAL_PACKAGE, value);
  }

}
