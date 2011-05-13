package jetbrains.mps.analyzers.structure;

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

public class AnalyzerRunnerAnalyzeOperation extends BaseConcept implements IOperation {
  public static final String concept = "jetbrains.mps.analyzers.structure.AnalyzerRunnerAnalyzeOperation";
  public static final String SHORT_DESCRIPTION = "shortDescription";
  public static final String ALIAS = "alias";
  public static final String VIRTUAL_PACKAGE = "virtualPackage";
  public static final String SMODEL_ATTRIBUTE = "smodelAttribute";

  public AnalyzerRunnerAnalyzeOperation(SNode node) {
    super(node);
  }

  public String getShortDescription() {
    return this.getProperty(AnalyzerRunnerAnalyzeOperation.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(AnalyzerRunnerAnalyzeOperation.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(AnalyzerRunnerAnalyzeOperation.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(AnalyzerRunnerAnalyzeOperation.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(AnalyzerRunnerAnalyzeOperation.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(AnalyzerRunnerAnalyzeOperation.VIRTUAL_PACKAGE, value);
  }

  public int getSmodelAttributesCount() {
    return this.getChildCount(AnalyzerRunnerAnalyzeOperation.SMODEL_ATTRIBUTE);
  }

  public Iterator<Attribute> smodelAttributes() {
    return this.children(Attribute.class, AnalyzerRunnerAnalyzeOperation.SMODEL_ATTRIBUTE);
  }

  public List<Attribute> getSmodelAttributes() {
    return this.getChildren(Attribute.class, AnalyzerRunnerAnalyzeOperation.SMODEL_ATTRIBUTE);
  }

  public void addSmodelAttribute(Attribute node) {
    this.addChild(AnalyzerRunnerAnalyzeOperation.SMODEL_ATTRIBUTE, node);
  }

  public void insertSmodelAttribute(Attribute prev, Attribute node) {
    this.insertChild(prev, AnalyzerRunnerAnalyzeOperation.SMODEL_ATTRIBUTE, node);
  }

  public static AnalyzerRunnerAnalyzeOperation newInstance(SModel sm, boolean init) {
    return (AnalyzerRunnerAnalyzeOperation) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.analyzers.structure.AnalyzerRunnerAnalyzeOperation", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static AnalyzerRunnerAnalyzeOperation newInstance(SModel sm) {
    return AnalyzerRunnerAnalyzeOperation.newInstance(sm, false);
  }
}
