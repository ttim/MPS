package jetbrains.mps.traceInfo.testWeavingGenerated.data.structure;

/*Generated by MPS */

import jetbrains.mps.lang.core.structure.BaseConcept;
import jetbrains.mps.lang.core.structure.INamedConcept;
import jetbrains.mps.smodel.SNode;
import java.util.Iterator;
import jetbrains.mps.lang.core.structure.Attribute;
import java.util.List;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class ChildConceptWeave extends BaseConcept implements INamedConcept {
  public static final String concept = "jetbrains.mps.traceInfo.testWeavingGenerated.data.structure.ChildConceptWeave";
  public static final String NAME = "name";
  public static final String SHORT_DESCRIPTION = "shortDescription";
  public static final String ALIAS = "alias";
  public static final String VIRTUAL_PACKAGE = "virtualPackage";
  public static final String SMODEL_ATTRIBUTE = "smodelAttribute";

  public ChildConceptWeave(SNode node) {
    super(node);
  }

  public String getName() {
    return this.getProperty(ChildConceptWeave.NAME);
  }

  public void setName(String value) {
    this.setProperty(ChildConceptWeave.NAME, value);
  }

  public String getShortDescription() {
    return this.getProperty(ChildConceptWeave.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(ChildConceptWeave.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(ChildConceptWeave.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(ChildConceptWeave.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(ChildConceptWeave.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(ChildConceptWeave.VIRTUAL_PACKAGE, value);
  }

  public int getSmodelAttributesCount() {
    return this.getChildCount(ChildConceptWeave.SMODEL_ATTRIBUTE);
  }

  public Iterator<Attribute> smodelAttributes() {
    return this.children(Attribute.class, ChildConceptWeave.SMODEL_ATTRIBUTE);
  }

  public List<Attribute> getSmodelAttributes() {
    return this.getChildren(Attribute.class, ChildConceptWeave.SMODEL_ATTRIBUTE);
  }

  public void addSmodelAttribute(Attribute node) {
    this.addChild(ChildConceptWeave.SMODEL_ATTRIBUTE, node);
  }

  public void insertSmodelAttribute(Attribute prev, Attribute node) {
    this.insertChild(prev, ChildConceptWeave.SMODEL_ATTRIBUTE, node);
  }

  public static ChildConceptWeave newInstance(SModel sm, boolean init) {
    return (ChildConceptWeave) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.traceInfo.testWeavingGenerated.data.structure.ChildConceptWeave", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static ChildConceptWeave newInstance(SModel sm) {
    return ChildConceptWeave.newInstance(sm, false);
  }
}
