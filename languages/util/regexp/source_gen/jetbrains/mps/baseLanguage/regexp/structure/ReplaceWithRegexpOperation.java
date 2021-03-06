package jetbrains.mps.baseLanguage.regexp.structure;

/*Generated by MPS */

import jetbrains.mps.lang.core.structure.BaseConcept;
import jetbrains.mps.baseLanguage.structure.IOperation;
import jetbrains.mps.smodel.SNode;
import java.util.Iterator;
import jetbrains.mps.lang.core.structure.Attribute;
import java.util.List;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class ReplaceWithRegexpOperation extends BaseConcept implements IOperation, RegexpUsingConstruction {
  public static final String concept = "jetbrains.mps.baseLanguage.regexp.structure.ReplaceWithRegexpOperation";
  public static final String SHORT_DESCRIPTION = "shortDescription";
  public static final String ALIAS = "alias";
  public static final String VIRTUAL_PACKAGE = "virtualPackage";
  public static final String REPLACE_BLOCK = "replaceBlock";
  public static final String REGEXP = "regexp";
  public static final String SMODEL_ATTRIBUTE = "smodelAttribute";

  public ReplaceWithRegexpOperation(SNode node) {
    super(node);
  }

  public String getShortDescription() {
    return this.getProperty(ReplaceWithRegexpOperation.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(ReplaceWithRegexpOperation.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(ReplaceWithRegexpOperation.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(ReplaceWithRegexpOperation.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(ReplaceWithRegexpOperation.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(ReplaceWithRegexpOperation.VIRTUAL_PACKAGE, value);
  }

  public ReplaceBlock getReplaceBlock() {
    return (ReplaceBlock) this.getChild(ReplaceBlock.class, ReplaceWithRegexpOperation.REPLACE_BLOCK);
  }

  public void setReplaceBlock(ReplaceBlock node) {
    super.setChild(ReplaceWithRegexpOperation.REPLACE_BLOCK, node);
  }

  public RegexpExpression getRegexp() {
    return (RegexpExpression) this.getChild(RegexpExpression.class, ReplaceWithRegexpOperation.REGEXP);
  }

  public void setRegexp(RegexpExpression node) {
    super.setChild(ReplaceWithRegexpOperation.REGEXP, node);
  }

  public int getSmodelAttributesCount() {
    return this.getChildCount(ReplaceWithRegexpOperation.SMODEL_ATTRIBUTE);
  }

  public Iterator<Attribute> smodelAttributes() {
    return this.children(Attribute.class, ReplaceWithRegexpOperation.SMODEL_ATTRIBUTE);
  }

  public List<Attribute> getSmodelAttributes() {
    return this.getChildren(Attribute.class, ReplaceWithRegexpOperation.SMODEL_ATTRIBUTE);
  }

  public void addSmodelAttribute(Attribute node) {
    this.addChild(ReplaceWithRegexpOperation.SMODEL_ATTRIBUTE, node);
  }

  public void insertSmodelAttribute(Attribute prev, Attribute node) {
    this.insertChild(prev, ReplaceWithRegexpOperation.SMODEL_ATTRIBUTE, node);
  }

  public static ReplaceWithRegexpOperation newInstance(SModel sm, boolean init) {
    return (ReplaceWithRegexpOperation) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.regexp.structure.ReplaceWithRegexpOperation", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static ReplaceWithRegexpOperation newInstance(SModel sm) {
    return ReplaceWithRegexpOperation.newInstance(sm, false);
  }
}
