package jetbrains.mps.baseLanguage.structure;

/*Generated by MPS */

import jetbrains.mps.lang.core.structure.ScopeProvider;
import jetbrains.mps.smodel.SNode;
import java.util.Iterator;
import jetbrains.mps.lang.core.structure.Attribute;
import java.util.List;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class ImplicitAnnotationInstanceValue extends AnnotationInstanceValue implements ScopeProvider {
  public static final String concept = "jetbrains.mps.baseLanguage.structure.ImplicitAnnotationInstanceValue";
  public static final String SHORT_DESCRIPTION = "shortDescription";
  public static final String ALIAS = "alias";
  public static final String VIRTUAL_PACKAGE = "virtualPackage";
  public static final String SMODEL_ATTRIBUTE = "smodelAttribute";

  public ImplicitAnnotationInstanceValue(SNode node) {
    super(node);
  }

  public String getShortDescription() {
    return this.getProperty(ImplicitAnnotationInstanceValue.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(ImplicitAnnotationInstanceValue.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(ImplicitAnnotationInstanceValue.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(ImplicitAnnotationInstanceValue.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(ImplicitAnnotationInstanceValue.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(ImplicitAnnotationInstanceValue.VIRTUAL_PACKAGE, value);
  }

  public int getSmodelAttributesCount() {
    return this.getChildCount(ImplicitAnnotationInstanceValue.SMODEL_ATTRIBUTE);
  }

  public Iterator<Attribute> smodelAttributes() {
    return this.children(Attribute.class, ImplicitAnnotationInstanceValue.SMODEL_ATTRIBUTE);
  }

  public List<Attribute> getSmodelAttributes() {
    return this.getChildren(Attribute.class, ImplicitAnnotationInstanceValue.SMODEL_ATTRIBUTE);
  }

  public void addSmodelAttribute(Attribute node) {
    this.addChild(ImplicitAnnotationInstanceValue.SMODEL_ATTRIBUTE, node);
  }

  public void insertSmodelAttribute(Attribute prev, Attribute node) {
    this.insertChild(prev, ImplicitAnnotationInstanceValue.SMODEL_ATTRIBUTE, node);
  }

  public static ImplicitAnnotationInstanceValue newInstance(SModel sm, boolean init) {
    return (ImplicitAnnotationInstanceValue) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.ImplicitAnnotationInstanceValue", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static ImplicitAnnotationInstanceValue newInstance(SModel sm) {
    return ImplicitAnnotationInstanceValue.newInstance(sm, false);
  }
}
