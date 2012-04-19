package jetbrains.mps.baseLanguage.structure;

/*Generated by MPS */

import jetbrains.mps.lang.core.structure.IContainer;
import jetbrains.mps.lang.core.structure.ScopeProvider;
import jetbrains.mps.smodel.SNode;
import java.util.Iterator;
import jetbrains.mps.lang.core.structure.Attribute;
import java.util.List;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class AbstractLoopStatement extends Statement implements IContainer, IContainsStatementList, ScopeProvider {
  public static final String concept = "jetbrains.mps.baseLanguage.structure.AbstractLoopStatement";
  public static final String LABEL = "label";
  public static final String SHORT_DESCRIPTION = "shortDescription";
  public static final String ALIAS = "alias";
  public static final String VIRTUAL_PACKAGE = "virtualPackage";
  public static final String BODY = "body";
  public static final String LOOP_LABEL = "loopLabel";
  public static final String SMODEL_ATTRIBUTE = "smodelAttribute";

  public AbstractLoopStatement(SNode node) {
    super(node);
  }

  public String getLabel() {
    return this.getProperty(AbstractLoopStatement.LABEL);
  }

  public void setLabel(String value) {
    this.setProperty(AbstractLoopStatement.LABEL, value);
  }

  public String getShortDescription() {
    return this.getProperty(AbstractLoopStatement.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(AbstractLoopStatement.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(AbstractLoopStatement.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(AbstractLoopStatement.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(AbstractLoopStatement.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(AbstractLoopStatement.VIRTUAL_PACKAGE, value);
  }

  public StatementList getBody() {
    return (StatementList) this.getChild(StatementList.class, AbstractLoopStatement.BODY);
  }

  public void setBody(StatementList node) {
    super.setChild(AbstractLoopStatement.BODY, node);
  }

  public LoopLabel getLoopLabel() {
    return (LoopLabel) this.getChild(LoopLabel.class, AbstractLoopStatement.LOOP_LABEL);
  }

  public void setLoopLabel(LoopLabel node) {
    super.setChild(AbstractLoopStatement.LOOP_LABEL, node);
  }

  public int getSmodelAttributesCount() {
    return this.getChildCount(AbstractLoopStatement.SMODEL_ATTRIBUTE);
  }

  public Iterator<Attribute> smodelAttributes() {
    return this.children(Attribute.class, AbstractLoopStatement.SMODEL_ATTRIBUTE);
  }

  public List<Attribute> getSmodelAttributes() {
    return this.getChildren(Attribute.class, AbstractLoopStatement.SMODEL_ATTRIBUTE);
  }

  public void addSmodelAttribute(Attribute node) {
    this.addChild(AbstractLoopStatement.SMODEL_ATTRIBUTE, node);
  }

  public void insertSmodelAttribute(Attribute prev, Attribute node) {
    this.insertChild(prev, AbstractLoopStatement.SMODEL_ATTRIBUTE, node);
  }

  public static AbstractLoopStatement newInstance(SModel sm, boolean init) {
    return (AbstractLoopStatement) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.AbstractLoopStatement", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static AbstractLoopStatement newInstance(SModel sm) {
    return AbstractLoopStatement.newInstance(sm, false);
  }
}
