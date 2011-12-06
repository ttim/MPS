package jetbrains.mps.traceInfo.testWeavingInterpreted.data.structure;

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

public class ChildConceptWeaveMany extends BaseConcept implements INamedConcept {
  public static final String concept = "jetbrains.mps.traceInfo.testWeavingInterpreted.data.structure.ChildConceptWeaveMany";
  public static final String NAME = "name";
  public static final String SHORT_DESCRIPTION = "shortDescription";
  public static final String ALIAS = "alias";
  public static final String VIRTUAL_PACKAGE = "virtualPackage";
  public static final String SMODEL_ATTRIBUTE = "smodelAttribute";

  public ChildConceptWeaveMany(SNode node) {
    super(node);
  }

  public String getName() {
    return this.getProperty(ChildConceptWeaveMany.NAME);
  }

  public void setName(String value) {
    this.setProperty(ChildConceptWeaveMany.NAME, value);
  }

  public String getShortDescription() {
    return this.getProperty(ChildConceptWeaveMany.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(ChildConceptWeaveMany.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(ChildConceptWeaveMany.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(ChildConceptWeaveMany.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(ChildConceptWeaveMany.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(ChildConceptWeaveMany.VIRTUAL_PACKAGE, value);
  }

  public int getSmodelAttributesCount() {
    return this.getChildCount(ChildConceptWeaveMany.SMODEL_ATTRIBUTE);
  }

  public Iterator<Attribute> smodelAttributes() {
    return this.children(Attribute.class, ChildConceptWeaveMany.SMODEL_ATTRIBUTE);
  }

  public List<Attribute> getSmodelAttributes() {
    return this.getChildren(Attribute.class, ChildConceptWeaveMany.SMODEL_ATTRIBUTE);
  }

  public void addSmodelAttribute(Attribute node) {
    this.addChild(ChildConceptWeaveMany.SMODEL_ATTRIBUTE, node);
  }

  public void insertSmodelAttribute(Attribute prev, Attribute node) {
    this.insertChild(prev, ChildConceptWeaveMany.SMODEL_ATTRIBUTE, node);
  }

  public static ChildConceptWeaveMany newInstance(SModel sm, boolean init) {
    return (ChildConceptWeaveMany) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.traceInfo.testWeavingInterpreted.data.structure.ChildConceptWeaveMany", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static ChildConceptWeaveMany newInstance(SModel sm) {
    return ChildConceptWeaveMany.newInstance(sm, false);
  }
}
