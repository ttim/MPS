package jetbrains.mps.baseLanguage.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import java.util.Iterator;
import java.util.List;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class SwitchStatement extends Statement {
  public static final String concept = "jetbrains.mps.baseLanguage.structure.SwitchStatement";
  public static String LABEL = "label";
  public static String EXPRESSION = "expression";
  public static String DEFAULT_BLOCK = "defaultBlock";
  public static String CASE = "case";

  public SwitchStatement(SNode node) {
    super(node);
  }

  public String getLabel() {
    return this.getProperty(SwitchStatement.LABEL);
  }

  public void setLabel(String value) {
    this.setProperty(SwitchStatement.LABEL, value);
  }

  public Expression getExpression() {
    return (Expression)this.getChild(SwitchStatement.EXPRESSION);
  }

  public void setExpression(Expression node) {
    super.setChild(SwitchStatement.EXPRESSION, node);
  }

  public StatementList getDefaultBlock() {
    return (StatementList)this.getChild(SwitchStatement.DEFAULT_BLOCK);
  }

  public void setDefaultBlock(StatementList node) {
    super.setChild(SwitchStatement.DEFAULT_BLOCK, node);
  }

  public int getCasesCount() {
    return this.getChildCount(SwitchStatement.CASE);
  }

  public Iterator<SwitchCase> cases() {
    return this.children(SwitchStatement.CASE);
  }

  public List<SwitchCase> getCases() {
    return this.getChildren(SwitchStatement.CASE);
  }

  public void addCase(SwitchCase node) {
    this.addChild(SwitchStatement.CASE, node);
  }

  public void insertCase(SwitchCase prev, SwitchCase node) {
    this.insertChild(prev, SwitchStatement.CASE, node);
  }


  public static SwitchStatement newInstance(SModel sm, boolean init) {
    return (SwitchStatement)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.SwitchStatement", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static SwitchStatement newInstance(SModel sm) {
    return SwitchStatement.newInstance(sm, false);
  }

}
