package jetbrains.mps.lang.plugin.structure;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.structure.ConceptFunction;
import jetbrains.mps.smodel.SNode;
import java.util.Iterator;
import jetbrains.mps.lang.core.structure.Attribute;
import java.util.List;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class DoUpdateGroupBlock extends ConceptFunction implements GroupContents {
  public static final String concept = "jetbrains.mps.lang.plugin.structure.DoUpdateGroupBlock";
  public static final String SHORT_DESCRIPTION = "shortDescription";
  public static final String ALIAS = "alias";
  public static final String VIRTUAL_PACKAGE = "virtualPackage";
  public static final String SMODEL_ATTRIBUTE = "smodelAttribute";

  public DoUpdateGroupBlock(SNode node) {
    super(node);
  }

  public String getShortDescription() {
    return this.getProperty(DoUpdateGroupBlock.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(DoUpdateGroupBlock.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(DoUpdateGroupBlock.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(DoUpdateGroupBlock.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(DoUpdateGroupBlock.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(DoUpdateGroupBlock.VIRTUAL_PACKAGE, value);
  }

  public int getSmodelAttributesCount() {
    return this.getChildCount(DoUpdateGroupBlock.SMODEL_ATTRIBUTE);
  }

  public Iterator<Attribute> smodelAttributes() {
    return this.children(Attribute.class, DoUpdateGroupBlock.SMODEL_ATTRIBUTE);
  }

  public List<Attribute> getSmodelAttributes() {
    return this.getChildren(Attribute.class, DoUpdateGroupBlock.SMODEL_ATTRIBUTE);
  }

  public void addSmodelAttribute(Attribute node) {
    this.addChild(DoUpdateGroupBlock.SMODEL_ATTRIBUTE, node);
  }

  public void insertSmodelAttribute(Attribute prev, Attribute node) {
    this.insertChild(prev, DoUpdateGroupBlock.SMODEL_ATTRIBUTE, node);
  }

  public static DoUpdateGroupBlock newInstance(SModel sm, boolean init) {
    return (DoUpdateGroupBlock) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.plugin.structure.DoUpdateGroupBlock", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static DoUpdateGroupBlock newInstance(SModel sm) {
    return DoUpdateGroupBlock.newInstance(sm, false);
  }
}
