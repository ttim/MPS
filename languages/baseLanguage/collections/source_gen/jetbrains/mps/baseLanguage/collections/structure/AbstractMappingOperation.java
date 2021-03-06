package jetbrains.mps.baseLanguage.collections.structure;

/*Generated by MPS */

import jetbrains.mps.lang.core.structure.BaseConcept;
import jetbrains.mps.baseLanguage.structure.IOperation;
import jetbrains.mps.smodel.SNode;
import java.util.Iterator;
import jetbrains.mps.lang.core.structure.Attribute;
import java.util.List;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class AbstractMappingOperation extends BaseConcept implements IOperation {
  public static final String concept = "jetbrains.mps.baseLanguage.collections.structure.AbstractMappingOperation";
  public static final String SHORT_DESCRIPTION = "shortDescription";
  public static final String ALIAS = "alias";
  public static final String VIRTUAL_PACKAGE = "virtualPackage";
  public static final String SMODEL_ATTRIBUTE = "smodelAttribute";

  public AbstractMappingOperation(SNode node) {
    super(node);
  }

  public String getShortDescription() {
    return this.getProperty(AbstractMappingOperation.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(AbstractMappingOperation.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(AbstractMappingOperation.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(AbstractMappingOperation.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(AbstractMappingOperation.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(AbstractMappingOperation.VIRTUAL_PACKAGE, value);
  }

  public int getSmodelAttributesCount() {
    return this.getChildCount(AbstractMappingOperation.SMODEL_ATTRIBUTE);
  }

  public Iterator<Attribute> smodelAttributes() {
    return this.children(Attribute.class, AbstractMappingOperation.SMODEL_ATTRIBUTE);
  }

  public List<Attribute> getSmodelAttributes() {
    return this.getChildren(Attribute.class, AbstractMappingOperation.SMODEL_ATTRIBUTE);
  }

  public void addSmodelAttribute(Attribute node) {
    this.addChild(AbstractMappingOperation.SMODEL_ATTRIBUTE, node);
  }

  public void insertSmodelAttribute(Attribute prev, Attribute node) {
    this.insertChild(prev, AbstractMappingOperation.SMODEL_ATTRIBUTE, node);
  }

  public static AbstractMappingOperation newInstance(SModel sm, boolean init) {
    return (AbstractMappingOperation) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.collections.structure.AbstractMappingOperation", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static AbstractMappingOperation newInstance(SModel sm) {
    return AbstractMappingOperation.newInstance(sm, false);
  }
}
