package jetbrains.mps.ui.modeling.structure;

/*Generated by MPS */

import jetbrains.mps.lang.core.structure.BaseConcept;
import jetbrains.mps.lang.core.structure.INamedConcept;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.baseLanguage.structure.Type;
import java.util.Iterator;
import jetbrains.mps.lang.core.structure.Attribute;
import java.util.List;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class UIProperty extends BaseConcept implements INamedConcept, HasTemplate {
  public static final String concept = "jetbrains.mps.ui.modeling.structure.UIProperty";
  public static final String NAME = "name";
  public static final String SHORT_DESCRIPTION = "shortDescription";
  public static final String ALIAS = "alias";
  public static final String VIRTUAL_PACKAGE = "virtualPackage";
  public static final String DATA_TYPE = "dataType";
  public static final String SMODEL_ATTRIBUTE = "smodelAttribute";

  public UIProperty(SNode node) {
    super(node);
  }

  public String getName() {
    return this.getProperty(UIProperty.NAME);
  }

  public void setName(String value) {
    this.setProperty(UIProperty.NAME, value);
  }

  public String getShortDescription() {
    return this.getProperty(UIProperty.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(UIProperty.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(UIProperty.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(UIProperty.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(UIProperty.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(UIProperty.VIRTUAL_PACKAGE, value);
  }

  public Type getDataType() {
    return (Type) this.getChild(Type.class, UIProperty.DATA_TYPE);
  }

  public void setDataType(Type node) {
    super.setChild(UIProperty.DATA_TYPE, node);
  }

  public int getSmodelAttributesCount() {
    return this.getChildCount(UIProperty.SMODEL_ATTRIBUTE);
  }

  public Iterator<Attribute> smodelAttributes() {
    return this.children(Attribute.class, UIProperty.SMODEL_ATTRIBUTE);
  }

  public List<Attribute> getSmodelAttributes() {
    return this.getChildren(Attribute.class, UIProperty.SMODEL_ATTRIBUTE);
  }

  public void addSmodelAttribute(Attribute node) {
    this.addChild(UIProperty.SMODEL_ATTRIBUTE, node);
  }

  public void insertSmodelAttribute(Attribute prev, Attribute node) {
    this.insertChild(prev, UIProperty.SMODEL_ATTRIBUTE, node);
  }

  public static UIProperty newInstance(SModel sm, boolean init) {
    return (UIProperty) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.ui.modeling.structure.UIProperty", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static UIProperty newInstance(SModel sm) {
    return UIProperty.newInstance(sm, false);
  }
}
