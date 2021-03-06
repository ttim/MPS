package jetbrains.mps.lang.generator.structure;

/*Generated by MPS */

import jetbrains.mps.lang.core.structure.BaseConcept;
import jetbrains.mps.lang.core.structure.INamedConcept;
import jetbrains.mps.lang.structure.structure.IConceptAspect;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.structure.structure.AbstractConceptDeclaration;
import java.util.Iterator;
import java.util.List;
import jetbrains.mps.lang.core.structure.Attribute;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class TemplateDeclaration extends BaseConcept implements INamedConcept, IConceptAspect {
  public static final String concept = "jetbrains.mps.lang.generator.structure.TemplateDeclaration";
  public static final String NAME = "name";
  public static final String SHORT_DESCRIPTION = "shortDescription";
  public static final String ALIAS = "alias";
  public static final String VIRTUAL_PACKAGE = "virtualPackage";
  public static final String APPLICABLE_CONCEPT = "applicableConcept";
  public static final String CONTENT_NODE = "contentNode";
  public static final String PARAMETER = "parameter";
  public static final String SMODEL_ATTRIBUTE = "smodelAttribute";

  public TemplateDeclaration(SNode node) {
    super(node);
  }

  public String getName() {
    return this.getProperty(TemplateDeclaration.NAME);
  }

  public void setName(String value) {
    this.setProperty(TemplateDeclaration.NAME, value);
  }

  public String getShortDescription() {
    return this.getProperty(TemplateDeclaration.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(TemplateDeclaration.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(TemplateDeclaration.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(TemplateDeclaration.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(TemplateDeclaration.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(TemplateDeclaration.VIRTUAL_PACKAGE, value);
  }

  public AbstractConceptDeclaration getApplicableConcept() {
    return (AbstractConceptDeclaration) this.getReferent(AbstractConceptDeclaration.class, TemplateDeclaration.APPLICABLE_CONCEPT);
  }

  public void setApplicableConcept(AbstractConceptDeclaration node) {
    super.setReferent(TemplateDeclaration.APPLICABLE_CONCEPT, node);
  }

  public BaseConcept getContentNode() {
    return (BaseConcept) this.getChild(BaseConcept.class, TemplateDeclaration.CONTENT_NODE);
  }

  public void setContentNode(BaseConcept node) {
    super.setChild(TemplateDeclaration.CONTENT_NODE, node);
  }

  public int getParametersCount() {
    return this.getChildCount(TemplateDeclaration.PARAMETER);
  }

  public Iterator<TemplateParameterDeclaration> parameters() {
    return this.children(TemplateParameterDeclaration.class, TemplateDeclaration.PARAMETER);
  }

  public List<TemplateParameterDeclaration> getParameters() {
    return this.getChildren(TemplateParameterDeclaration.class, TemplateDeclaration.PARAMETER);
  }

  public void addParameter(TemplateParameterDeclaration node) {
    this.addChild(TemplateDeclaration.PARAMETER, node);
  }

  public void insertParameter(TemplateParameterDeclaration prev, TemplateParameterDeclaration node) {
    this.insertChild(prev, TemplateDeclaration.PARAMETER, node);
  }

  public int getSmodelAttributesCount() {
    return this.getChildCount(TemplateDeclaration.SMODEL_ATTRIBUTE);
  }

  public Iterator<Attribute> smodelAttributes() {
    return this.children(Attribute.class, TemplateDeclaration.SMODEL_ATTRIBUTE);
  }

  public List<Attribute> getSmodelAttributes() {
    return this.getChildren(Attribute.class, TemplateDeclaration.SMODEL_ATTRIBUTE);
  }

  public void addSmodelAttribute(Attribute node) {
    this.addChild(TemplateDeclaration.SMODEL_ATTRIBUTE, node);
  }

  public void insertSmodelAttribute(Attribute prev, Attribute node) {
    this.insertChild(prev, TemplateDeclaration.SMODEL_ATTRIBUTE, node);
  }

  public static TemplateDeclaration newInstance(SModel sm, boolean init) {
    return (TemplateDeclaration) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.generator.structure.TemplateDeclaration", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static TemplateDeclaration newInstance(SModel sm) {
    return TemplateDeclaration.newInstance(sm, false);
  }
}
