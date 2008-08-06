package jetbrains.mps.baseLanguage.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import java.util.Iterator;
import java.util.List;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class TryCatchStatement extends Statement {
  public static final String concept = "jetbrains.mps.baseLanguage.structure.TryCatchStatement";
  public static String BODY = "body";
  public static String CATCH_CLAUSE = "catchClause";

  public TryCatchStatement(SNode node) {
    super(node);
  }

  public StatementList getBody() {
    return (StatementList)this.getChild(TryCatchStatement.BODY);
  }

  public void setBody(StatementList node) {
    super.setChild(TryCatchStatement.BODY, node);
  }

  public int getCatchClausesCount() {
    return this.getChildCount(TryCatchStatement.CATCH_CLAUSE);
  }

  public Iterator<CatchClause> catchClauses() {
    return this.children(TryCatchStatement.CATCH_CLAUSE);
  }

  public List<CatchClause> getCatchClauses() {
    return this.getChildren(TryCatchStatement.CATCH_CLAUSE);
  }

  public void addCatchClause(CatchClause node) {
    this.addChild(TryCatchStatement.CATCH_CLAUSE, node);
  }

  public void insertCatchClause(CatchClause prev, CatchClause node) {
    this.insertChild(prev, TryCatchStatement.CATCH_CLAUSE, node);
  }


  public static TryCatchStatement newInstance(SModel sm, boolean init) {
    return (TryCatchStatement)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.TryCatchStatement", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static TryCatchStatement newInstance(SModel sm) {
    return TryCatchStatement.newInstance(sm, false);
  }

}
