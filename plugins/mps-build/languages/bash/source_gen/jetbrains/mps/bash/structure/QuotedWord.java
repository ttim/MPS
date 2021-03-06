package jetbrains.mps.bash.structure;

/*Generated by MPS */

import jetbrains.mps.lang.core.structure.BaseConcept;
import jetbrains.mps.smodel.SNode;
import java.util.Iterator;
import jetbrains.mps.lang.core.structure.Attribute;
import java.util.List;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class QuotedWord extends BaseConcept implements IGeneralizedWordUnit, IConcreteWordUnit {
  public static final String concept = "jetbrains.mps.bash.structure.QuotedWord";
  public static final String CPR_Quotetype = "quotetype";
  public static final String SHORT_DESCRIPTION = "shortDescription";
  public static final String ALIAS = "alias";
  public static final String VIRTUAL_PACKAGE = "virtualPackage";
  public static final String WORD = "word";
  public static final String SMODEL_ATTRIBUTE = "smodelAttribute";

  public QuotedWord(SNode node) {
    super(node);
  }

  public String getShortDescription() {
    return this.getProperty(QuotedWord.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(QuotedWord.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(QuotedWord.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(QuotedWord.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(QuotedWord.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(QuotedWord.VIRTUAL_PACKAGE, value);
  }

  public GeneralizedWord getWord() {
    return (GeneralizedWord) this.getChild(GeneralizedWord.class, QuotedWord.WORD);
  }

  public void setWord(GeneralizedWord node) {
    super.setChild(QuotedWord.WORD, node);
  }

  public int getSmodelAttributesCount() {
    return this.getChildCount(QuotedWord.SMODEL_ATTRIBUTE);
  }

  public Iterator<Attribute> smodelAttributes() {
    return this.children(Attribute.class, QuotedWord.SMODEL_ATTRIBUTE);
  }

  public List<Attribute> getSmodelAttributes() {
    return this.getChildren(Attribute.class, QuotedWord.SMODEL_ATTRIBUTE);
  }

  public void addSmodelAttribute(Attribute node) {
    this.addChild(QuotedWord.SMODEL_ATTRIBUTE, node);
  }

  public void insertSmodelAttribute(Attribute prev, Attribute node) {
    this.insertChild(prev, QuotedWord.SMODEL_ATTRIBUTE, node);
  }

  public static QuotedWord newInstance(SModel sm, boolean init) {
    return (QuotedWord) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.bash.structure.QuotedWord", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static QuotedWord newInstance(SModel sm) {
    return QuotedWord.newInstance(sm, false);
  }
}
