package jetbrains.mps.lang.pattern.testLang.structure;

/*Generated by MPS */

import jetbrains.mps.lang.core.structure.BaseConcept;
import jetbrains.mps.lang.core.structure.INamedConcept;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.pattern.structure.PatternExpression;
import jetbrains.mps.baseLanguage.structure.BooleanConstant;
import java.util.Iterator;
import java.util.List;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class PatternTest extends BaseConcept implements INamedConcept {
  public static final String concept = "jetbrains.mps.lang.pattern.testLang.structure.PatternTest";
  public static final String NAME = "name";
  public static final String SHORT_DESCRIPTION = "shortDescription";
  public static final String ALIAS = "alias";
  public static final String VIRTUAL_PACKAGE = "virtualPackage";
  public static final String NODE_TO_MATCH = "nodeToMatch";
  public static final String PATTERN = "pattern";
  public static final String MATCHES = "matches";
  public static final String VALUES = "values";

  public PatternTest(SNode node) {
    super(node);
  }

  public String getName() {
    return this.getProperty(PatternTest.NAME);
  }

  public void setName(String value) {
    this.setProperty(PatternTest.NAME, value);
  }

  public String getShortDescription() {
    return this.getProperty(PatternTest.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(PatternTest.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(PatternTest.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(PatternTest.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(PatternTest.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(PatternTest.VIRTUAL_PACKAGE, value);
  }

  public BaseConcept getNodeToMatch() {
    return (BaseConcept) this.getChild(BaseConcept.class, PatternTest.NODE_TO_MATCH);
  }

  public void setNodeToMatch(BaseConcept node) {
    super.setChild(PatternTest.NODE_TO_MATCH, node);
  }

  public PatternExpression getPattern() {
    return (PatternExpression) this.getChild(PatternExpression.class, PatternTest.PATTERN);
  }

  public void setPattern(PatternExpression node) {
    super.setChild(PatternTest.PATTERN, node);
  }

  public BooleanConstant getMatches() {
    return (BooleanConstant) this.getChild(BooleanConstant.class, PatternTest.MATCHES);
  }

  public void setMatches(BooleanConstant node) {
    super.setChild(PatternTest.MATCHES, node);
  }

  public int getValuesesCount() {
    return this.getChildCount(PatternTest.VALUES);
  }

  public Iterator<ValueReference> valueses() {
    return this.children(ValueReference.class, PatternTest.VALUES);
  }

  public List<ValueReference> getValueses() {
    return this.getChildren(ValueReference.class, PatternTest.VALUES);
  }

  public void addValues(ValueReference node) {
    this.addChild(PatternTest.VALUES, node);
  }

  public void insertValues(ValueReference prev, ValueReference node) {
    this.insertChild(prev, PatternTest.VALUES, node);
  }

  public static PatternTest newInstance(SModel sm, boolean init) {
    return (PatternTest) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.pattern.testLang.structure.PatternTest", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static PatternTest newInstance(SModel sm) {
    return PatternTest.newInstance(sm, false);
  }
}
