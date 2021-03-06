package jetbrains.mps.lang.smodel.structure;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.structure.Statement;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.baseLanguage.structure.Expression;
import java.util.Iterator;
import java.util.List;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class ConceptSwitchStatement extends Statement {
  public static final String concept = "jetbrains.mps.lang.smodel.structure.ConceptSwitchStatement";
  public static final String EXPRESSION = "expression";
  public static final String CASE = "case";

  public ConceptSwitchStatement(SNode node) {
    super(node);
  }

  public Expression getExpression() {
    return (Expression) this.getChild(Expression.class, ConceptSwitchStatement.EXPRESSION);
  }

  public void setExpression(Expression node) {
    super.setChild(ConceptSwitchStatement.EXPRESSION, node);
  }

  public int getCasesCount() {
    return this.getChildCount(ConceptSwitchStatement.CASE);
  }

  public Iterator<ConceptSwitchStatementCase> cases() {
    return this.children(ConceptSwitchStatementCase.class, ConceptSwitchStatement.CASE);
  }

  public List<ConceptSwitchStatementCase> getCases() {
    return this.getChildren(ConceptSwitchStatementCase.class, ConceptSwitchStatement.CASE);
  }

  public void addCase(ConceptSwitchStatementCase node) {
    this.addChild(ConceptSwitchStatement.CASE, node);
  }

  public void insertCase(ConceptSwitchStatementCase prev, ConceptSwitchStatementCase node) {
    this.insertChild(prev, ConceptSwitchStatement.CASE, node);
  }

  public static ConceptSwitchStatement newInstance(SModel sm, boolean init) {
    return (ConceptSwitchStatement) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.smodel.structure.ConceptSwitchStatement", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static ConceptSwitchStatement newInstance(SModel sm) {
    return ConceptSwitchStatement.newInstance(sm, false);
  }
}
