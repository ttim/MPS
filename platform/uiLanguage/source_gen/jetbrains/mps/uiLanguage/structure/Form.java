package jetbrains.mps.uiLanguage.structure;

/*Generated by MPS */

import jetbrains.mps.core.structure.BaseConcept;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

import java.util.Iterator;
import java.util.List;

public class Form extends BaseConcept implements IComponentPart, IComponentInstance {
  public static final String concept = "jetbrains.mps.uiLanguage.structure.Form";
  public static String SHORT_DESCRIPTION = "shortDescription";
  public static String ALIAS = "alias";
  public static String VIRTUAL_PACKAGE = "virtualPackage";
  public static String PART = "part";
  public static String CONTENT = "content";

  public Form(SNode node) {
    super(node);
  }

  public static Form newInstance(SModel sm, boolean init) {
    return (Form) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.uiLanguage.structure.Form", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static Form newInstance(SModel sm) {
    return Form.newInstance(sm, false);
  }


  public String getShortDescription() {
    return this.getProperty(Form.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(Form.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(Form.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(Form.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(Form.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(Form.VIRTUAL_PACKAGE, value);
  }

  public int getPartsCount() {
    return this.getChildCount(Form.PART);
  }

  public Iterator<FormPart> parts() {
    return this.children(Form.PART);
  }

  public List<FormPart> getParts() {
    return this.getChildren(Form.PART);
  }

  public void addPart(FormPart node) {
    this.addChild(Form.PART, node);
  }

  public void insertPart(FormPart prev, FormPart node) {
    this.insertChild(prev, Form.PART, node);
  }

  public int getContentsCount() {
    return this.getChildCount(Form.CONTENT);
  }

  public Iterator<IComponentPart> contents() {
    return this.children(Form.CONTENT);
  }

  public List<IComponentPart> getContents() {
    return this.getChildren(Form.CONTENT);
  }

  public void addContent(IComponentPart node) {
    this.addChild(Form.CONTENT, node);
  }

  public void insertContent(IComponentPart prev, IComponentPart node) {
    this.insertChild(prev, Form.CONTENT, node);
  }

}
