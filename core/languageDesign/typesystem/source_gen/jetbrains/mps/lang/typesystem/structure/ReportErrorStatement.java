package jetbrains.mps.lang.typesystem.structure;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.structure.Statement;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.baseLanguage.structure.Expression;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class ReportErrorStatement extends Statement implements MessageStatement {
  public static final String concept = "jetbrains.mps.lang.typesystem.structure.ReportErrorStatement";
  public static final String SHORT_DESCRIPTION = "shortDescription";
  public static final String ALIAS = "alias";
  public static final String VIRTUAL_PACKAGE = "virtualPackage";
  public static final String ERROR_STRING = "errorString";
  public static final String NODE_TO_REPORT = "nodeToReport";
  public static final String HELGINS_INTENTION = "helginsIntention";
  public static final String MESSAGE_TARGET = "messageTarget";
  public static final String FOREIGN_ERROR_SOURCE = "foreignErrorSource";

  public ReportErrorStatement(SNode node) {
    super(node);
  }

  public String getShortDescription() {
    return this.getProperty(ReportErrorStatement.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(ReportErrorStatement.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(ReportErrorStatement.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(ReportErrorStatement.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(ReportErrorStatement.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(ReportErrorStatement.VIRTUAL_PACKAGE, value);
  }

  public Expression getErrorString() {
    return (Expression)this.getChild(Expression.class, ReportErrorStatement.ERROR_STRING);
  }

  public void setErrorString(Expression node) {
    super.setChild(ReportErrorStatement.ERROR_STRING, node);
  }

  public Expression getNodeToReport() {
    return (Expression)this.getChild(Expression.class, ReportErrorStatement.NODE_TO_REPORT);
  }

  public void setNodeToReport(Expression node) {
    super.setChild(ReportErrorStatement.NODE_TO_REPORT, node);
  }

  public TypesystemIntention getHelginsIntention() {
    return (TypesystemIntention)this.getChild(TypesystemIntention.class, ReportErrorStatement.HELGINS_INTENTION);
  }

  public void setHelginsIntention(TypesystemIntention node) {
    super.setChild(ReportErrorStatement.HELGINS_INTENTION, node);
  }

  public MessageTarget getMessageTarget() {
    return (MessageTarget)this.getChild(MessageTarget.class, ReportErrorStatement.MESSAGE_TARGET);
  }

  public void setMessageTarget(MessageTarget node) {
    super.setChild(ReportErrorStatement.MESSAGE_TARGET, node);
  }

  public Expression getForeignErrorSource() {
    return (Expression)this.getChild(Expression.class, ReportErrorStatement.FOREIGN_ERROR_SOURCE);
  }

  public void setForeignErrorSource(Expression node) {
    super.setChild(ReportErrorStatement.FOREIGN_ERROR_SOURCE, node);
  }

  public static ReportErrorStatement newInstance(SModel sm, boolean init) {
    return (ReportErrorStatement)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.typesystem.structure.ReportErrorStatement", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static ReportErrorStatement newInstance(SModel sm) {
    return ReportErrorStatement.newInstance(sm, false);
  }
}
