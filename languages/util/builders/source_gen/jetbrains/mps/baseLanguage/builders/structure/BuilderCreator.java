package jetbrains.mps.baseLanguage.builders.structure;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.structure.AbstractCreator;
import jetbrains.mps.baseLanguage.structure.IControlFlowInterrupter;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.baseLanguage.structure.StatementList;
import java.util.Iterator;
import jetbrains.mps.lang.core.structure.Attribute;
import java.util.List;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class BuilderCreator extends AbstractCreator implements BuilderContainer, IControlFlowInterrupter {
  public static final String concept = "jetbrains.mps.baseLanguage.builders.structure.BuilderCreator";
  public static final String SHORT_DESCRIPTION = "shortDescription";
  public static final String ALIAS = "alias";
  public static final String VIRTUAL_PACKAGE = "virtualPackage";
  public static final String BUILDER = "builder";
  public static final String BODY = "body";
  public static final String SMODEL_ATTRIBUTE = "smodelAttribute";

  public BuilderCreator(SNode node) {
    super(node);
  }

  public String getShortDescription() {
    return this.getProperty(BuilderCreator.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(BuilderCreator.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(BuilderCreator.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(BuilderCreator.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(BuilderCreator.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(BuilderCreator.VIRTUAL_PACKAGE, value);
  }

  public Builder getBuilder() {
    return (Builder) this.getChild(Builder.class, BuilderCreator.BUILDER);
  }

  public void setBuilder(Builder node) {
    super.setChild(BuilderCreator.BUILDER, node);
  }

  public StatementList getBody() {
    return (StatementList) this.getChild(StatementList.class, BuilderCreator.BODY);
  }

  public void setBody(StatementList node) {
    super.setChild(BuilderCreator.BODY, node);
  }

  public int getSmodelAttributesCount() {
    return this.getChildCount(BuilderCreator.SMODEL_ATTRIBUTE);
  }

  public Iterator<Attribute> smodelAttributes() {
    return this.children(Attribute.class, BuilderCreator.SMODEL_ATTRIBUTE);
  }

  public List<Attribute> getSmodelAttributes() {
    return this.getChildren(Attribute.class, BuilderCreator.SMODEL_ATTRIBUTE);
  }

  public void addSmodelAttribute(Attribute node) {
    this.addChild(BuilderCreator.SMODEL_ATTRIBUTE, node);
  }

  public void insertSmodelAttribute(Attribute prev, Attribute node) {
    this.insertChild(prev, BuilderCreator.SMODEL_ATTRIBUTE, node);
  }

  public static BuilderCreator newInstance(SModel sm, boolean init) {
    return (BuilderCreator) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.builders.structure.BuilderCreator", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static BuilderCreator newInstance(SModel sm) {
    return BuilderCreator.newInstance(sm, false);
  }
}
