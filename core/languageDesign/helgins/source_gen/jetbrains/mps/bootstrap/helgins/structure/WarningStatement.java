package jetbrains.mps.bootstrap.helgins.structure;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.structure.Statement;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.baseLanguage.structure.Expression;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class WarningStatement extends Statement {
  public static final String concept = "jetbrains.mps.bootstrap.helgins.structure.WarningStatement";
  public static String WARNING_TEXT = "warningText";
  public static String NODE_TO_REPORT = "nodeToReport";
  public static String HELGINS_INTENTION = "helginsIntention";

  public WarningStatement(SNode node) {
    super(node);
  }

  public Expression getWarningText() {
    return (Expression)this.getChild(WarningStatement.WARNING_TEXT);
  }

  public void setWarningText(Expression node) {
    super.setChild(WarningStatement.WARNING_TEXT, node);
  }

  public Expression getNodeToReport() {
    return (Expression)this.getChild(WarningStatement.NODE_TO_REPORT);
  }

  public void setNodeToReport(Expression node) {
    super.setChild(WarningStatement.NODE_TO_REPORT, node);
  }

  public HelginsIntention getHelginsIntention() {
    return (HelginsIntention)this.getChild(WarningStatement.HELGINS_INTENTION);
  }

  public void setHelginsIntention(HelginsIntention node) {
    super.setChild(WarningStatement.HELGINS_INTENTION, node);
  }


  public static WarningStatement newInstance(SModel sm, boolean init) {
    return (WarningStatement)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.bootstrap.helgins.structure.WarningStatement", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static WarningStatement newInstance(SModel sm) {
    return WarningStatement.newInstance(sm, false);
  }

}
