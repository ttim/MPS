package jetbrains.mps.baseLanguage.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import java.util.Iterator;
import java.util.List;
import jetbrains.mps.lang.core.structure.Attribute;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class TryCatchStatement extends Statement implements IContainsStatementList, ITryCatchStatement {
  public static final String concept = "jetbrains.mps.baseLanguage.structure.TryCatchStatement";
  public static final String SHORT_DESCRIPTION = "shortDescription";
  public static final String ALIAS = "alias";
  public static final String VIRTUAL_PACKAGE = "virtualPackage";
  public static final String BODY = "body";
  public static final String CATCH_CLAUSE = "catchClause";
  public static final String SMODEL_ATTRIBUTE = "smodelAttribute";

  public TryCatchStatement(SNode node) {
    super(node);
  }

  public String getShortDescription() {
    return this.getProperty(TryCatchStatement.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(TryCatchStatement.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(TryCatchStatement.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(TryCatchStatement.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(TryCatchStatement.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(TryCatchStatement.VIRTUAL_PACKAGE, value);
  }

  public StatementList getBody() {
    return (StatementList) this.getChild(StatementList.class, TryCatchStatement.BODY);
  }

  public void setBody(StatementList node) {
    super.setChild(TryCatchStatement.BODY, node);
  }

  public int getCatchClausesCount() {
    return this.getChildCount(TryCatchStatement.CATCH_CLAUSE);
  }

  public Iterator<CatchClause> catchClauses() {
    return this.children(CatchClause.class, TryCatchStatement.CATCH_CLAUSE);
  }

  public List<CatchClause> getCatchClauses() {
    return this.getChildren(CatchClause.class, TryCatchStatement.CATCH_CLAUSE);
  }

  public void addCatchClause(CatchClause node) {
    this.addChild(TryCatchStatement.CATCH_CLAUSE, node);
  }

  public void insertCatchClause(CatchClause prev, CatchClause node) {
    this.insertChild(prev, TryCatchStatement.CATCH_CLAUSE, node);
  }

  public int getSmodelAttributesCount() {
    return this.getChildCount(TryCatchStatement.SMODEL_ATTRIBUTE);
  }

  public Iterator<Attribute> smodelAttributes() {
    return this.children(Attribute.class, TryCatchStatement.SMODEL_ATTRIBUTE);
  }

  public List<Attribute> getSmodelAttributes() {
    return this.getChildren(Attribute.class, TryCatchStatement.SMODEL_ATTRIBUTE);
  }

  public void addSmodelAttribute(Attribute node) {
    this.addChild(TryCatchStatement.SMODEL_ATTRIBUTE, node);
  }

  public void insertSmodelAttribute(Attribute prev, Attribute node) {
    this.insertChild(prev, TryCatchStatement.SMODEL_ATTRIBUTE, node);
  }

  public static TryCatchStatement newInstance(SModel sm, boolean init) {
    return (TryCatchStatement) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.TryCatchStatement", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static TryCatchStatement newInstance(SModel sm) {
    return TryCatchStatement.newInstance(sm, false);
  }
}
