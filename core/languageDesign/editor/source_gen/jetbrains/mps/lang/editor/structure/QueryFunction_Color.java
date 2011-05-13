package jetbrains.mps.lang.editor.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import java.util.Iterator;
import jetbrains.mps.lang.core.structure.Attribute;
import java.util.List;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class QueryFunction_Color extends QueryFunction_StyleParameter implements IQueryFunction_Color {
  public static final String concept = "jetbrains.mps.lang.editor.structure.QueryFunction_Color";
  public static final String SHORT_DESCRIPTION = "shortDescription";
  public static final String ALIAS = "alias";
  public static final String VIRTUAL_PACKAGE = "virtualPackage";
  public static final String SMODEL_ATTRIBUTE = "smodelAttribute";

  public QueryFunction_Color(SNode node) {
    super(node);
  }

  public String getShortDescription() {
    return this.getProperty(QueryFunction_Color.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(QueryFunction_Color.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(QueryFunction_Color.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(QueryFunction_Color.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(QueryFunction_Color.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(QueryFunction_Color.VIRTUAL_PACKAGE, value);
  }

  public int getSmodelAttributesCount() {
    return this.getChildCount(QueryFunction_Color.SMODEL_ATTRIBUTE);
  }

  public Iterator<Attribute> smodelAttributes() {
    return this.children(Attribute.class, QueryFunction_Color.SMODEL_ATTRIBUTE);
  }

  public List<Attribute> getSmodelAttributes() {
    return this.getChildren(Attribute.class, QueryFunction_Color.SMODEL_ATTRIBUTE);
  }

  public void addSmodelAttribute(Attribute node) {
    this.addChild(QueryFunction_Color.SMODEL_ATTRIBUTE, node);
  }

  public void insertSmodelAttribute(Attribute prev, Attribute node) {
    this.insertChild(prev, QueryFunction_Color.SMODEL_ATTRIBUTE, node);
  }

  public static QueryFunction_Color newInstance(SModel sm, boolean init) {
    return (QueryFunction_Color) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.editor.structure.QueryFunction_Color", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static QueryFunction_Color newInstance(SModel sm) {
    return QueryFunction_Color.newInstance(sm, false);
  }
}
