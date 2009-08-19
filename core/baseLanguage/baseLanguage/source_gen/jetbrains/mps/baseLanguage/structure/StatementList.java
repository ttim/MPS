package jetbrains.mps.baseLanguage.structure;

/*Generated by MPS */

import jetbrains.mps.lang.core.structure.BaseConcept;
import jetbrains.mps.lang.core.structure.IContainer;
import jetbrains.mps.smodel.SNode;
import java.util.Iterator;
import java.util.List;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class StatementList extends BaseConcept implements IContainer, ILocalVariableElementList {
  public static final String concept = "jetbrains.mps.baseLanguage.structure.StatementList";
  public static final String SHORT_DESCRIPTION = "shortDescription";
  public static final String ALIAS = "alias";
  public static final String VIRTUAL_PACKAGE = "virtualPackage";
  public static final String STATEMENT = "statement";

  public StatementList(SNode node) {
    super(node);
  }

  public String getShortDescription() {
    return this.getProperty(StatementList.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(StatementList.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(StatementList.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(StatementList.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(StatementList.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(StatementList.VIRTUAL_PACKAGE, value);
  }

  public int getStatementsCount() {
    return this.getChildCount(StatementList.STATEMENT);
  }

  public Iterator<Statement> statements() {
    return this.children(Statement.class, StatementList.STATEMENT);
  }

  public List<Statement> getStatements() {
    return this.getChildren(Statement.class, StatementList.STATEMENT);
  }

  public void addStatement(Statement node) {
    this.addChild(StatementList.STATEMENT, node);
  }

  public void insertStatement(Statement prev, Statement node) {
    this.insertChild(prev, StatementList.STATEMENT, node);
  }

  public static StatementList newInstance(SModel sm, boolean init) {
    return (StatementList)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.StatementList", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static StatementList newInstance(SModel sm) {
    return StatementList.newInstance(sm, false);
  }
}
