package jetbrains.mps.make.script.structure;

/*Generated by MPS */

import jetbrains.mps.lang.core.structure.BaseConcept;
import jetbrains.mps.baseLanguage.structure.IOperation;
import jetbrains.mps.smodel.SNode;
import java.util.Iterator;
import jetbrains.mps.baseLanguage.structure.Expression;
import java.util.List;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class RelayQueryOperation extends BaseConcept implements IOperation {
  public static final String concept = "jetbrains.mps.make.script.structure.RelayQueryOperation";
  public static final String SHORT_DESCRIPTION = "shortDescription";
  public static final String ALIAS = "alias";
  public static final String VIRTUAL_PACKAGE = "virtualPackage";
  public static final String QUERY = "query";
  public static final String PARAMETER = "parameter";

  public RelayQueryOperation(SNode node) {
    super(node);
  }

  public String getShortDescription() {
    return this.getProperty(RelayQueryOperation.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(RelayQueryOperation.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(RelayQueryOperation.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(RelayQueryOperation.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(RelayQueryOperation.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(RelayQueryOperation.VIRTUAL_PACKAGE, value);
  }

  public QueryDefinition getQuery() {
    return (QueryDefinition) this.getReferent(QueryDefinition.class, RelayQueryOperation.QUERY);
  }

  public void setQuery(QueryDefinition node) {
    super.setReferent(RelayQueryOperation.QUERY, node);
  }

  public int getParametersCount() {
    return this.getChildCount(RelayQueryOperation.PARAMETER);
  }

  public Iterator<Expression> parameters() {
    return this.children(Expression.class, RelayQueryOperation.PARAMETER);
  }

  public List<Expression> getParameters() {
    return this.getChildren(Expression.class, RelayQueryOperation.PARAMETER);
  }

  public void addParameter(Expression node) {
    this.addChild(RelayQueryOperation.PARAMETER, node);
  }

  public void insertParameter(Expression prev, Expression node) {
    this.insertChild(prev, RelayQueryOperation.PARAMETER, node);
  }

  public static RelayQueryOperation newInstance(SModel sm, boolean init) {
    return (RelayQueryOperation) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.make.script.structure.RelayQueryOperation", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static RelayQueryOperation newInstance(SModel sm) {
    return RelayQueryOperation.newInstance(sm, false);
  }
}
