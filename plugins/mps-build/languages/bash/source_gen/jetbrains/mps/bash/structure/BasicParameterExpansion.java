package jetbrains.mps.bash.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import java.util.Iterator;
import jetbrains.mps.lang.core.structure.Attribute;
import java.util.List;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class BasicParameterExpansion extends ArithmeticExpression implements IGeneralizedWordUnit, IConcreteWordUnit {
  public static final String concept = "jetbrains.mps.bash.structure.BasicParameterExpansion";
  public static final String SHORT_DESCRIPTION = "shortDescription";
  public static final String ALIAS = "alias";
  public static final String VIRTUAL_PACKAGE = "virtualPackage";
  public static final String VARIABLE = "variable";
  public static final String SMODEL_ATTRIBUTE = "smodelAttribute";

  public BasicParameterExpansion(SNode node) {
    super(node);
  }

  public String getShortDescription() {
    return this.getProperty(BasicParameterExpansion.SHORT_DESCRIPTION);
  }

  public void setShortDescription(String value) {
    this.setProperty(BasicParameterExpansion.SHORT_DESCRIPTION, value);
  }

  public String getAlias() {
    return this.getProperty(BasicParameterExpansion.ALIAS);
  }

  public void setAlias(String value) {
    this.setProperty(BasicParameterExpansion.ALIAS, value);
  }

  public String getVirtualPackage() {
    return this.getProperty(BasicParameterExpansion.VIRTUAL_PACKAGE);
  }

  public void setVirtualPackage(String value) {
    this.setProperty(BasicParameterExpansion.VIRTUAL_PACKAGE, value);
  }

  public VariableNameDeclaration getVariable() {
    return (VariableNameDeclaration) this.getReferent(VariableNameDeclaration.class, BasicParameterExpansion.VARIABLE);
  }

  public void setVariable(VariableNameDeclaration node) {
    super.setReferent(BasicParameterExpansion.VARIABLE, node);
  }

  public int getSmodelAttributesCount() {
    return this.getChildCount(BasicParameterExpansion.SMODEL_ATTRIBUTE);
  }

  public Iterator<Attribute> smodelAttributes() {
    return this.children(Attribute.class, BasicParameterExpansion.SMODEL_ATTRIBUTE);
  }

  public List<Attribute> getSmodelAttributes() {
    return this.getChildren(Attribute.class, BasicParameterExpansion.SMODEL_ATTRIBUTE);
  }

  public void addSmodelAttribute(Attribute node) {
    this.addChild(BasicParameterExpansion.SMODEL_ATTRIBUTE, node);
  }

  public void insertSmodelAttribute(Attribute prev, Attribute node) {
    this.insertChild(prev, BasicParameterExpansion.SMODEL_ATTRIBUTE, node);
  }

  public static BasicParameterExpansion newInstance(SModel sm, boolean init) {
    return (BasicParameterExpansion) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.bash.structure.BasicParameterExpansion", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static BasicParameterExpansion newInstance(SModel sm) {
    return BasicParameterExpansion.newInstance(sm, false);
  }
}
