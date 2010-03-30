package jetbrains.mps.baseLanguage.constructors.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import java.util.Iterator;
import java.util.List;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class CustomArgumentClause extends ArgumentClause {
  public static final String concept = "jetbrains.mps.baseLanguage.constructors.structure.CustomArgumentClause";
  public static final String PARAMETER = "parameter";

  public CustomArgumentClause(SNode node) {
    super(node);
  }

  public int getParametersCount() {
    return this.getChildCount(CustomArgumentClause.PARAMETER);
  }

  public Iterator<CustomConstructorParameter> parameters() {
    return this.children(CustomConstructorParameter.class, CustomArgumentClause.PARAMETER);
  }

  public List<CustomConstructorParameter> getParameters() {
    return this.getChildren(CustomConstructorParameter.class, CustomArgumentClause.PARAMETER);
  }

  public void addParameter(CustomConstructorParameter node) {
    this.addChild(CustomArgumentClause.PARAMETER, node);
  }

  public void insertParameter(CustomConstructorParameter prev, CustomConstructorParameter node) {
    this.insertChild(prev, CustomArgumentClause.PARAMETER, node);
  }

  public static CustomArgumentClause newInstance(SModel sm, boolean init) {
    return (CustomArgumentClause) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.constructors.structure.CustomArgumentClause", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static CustomArgumentClause newInstance(SModel sm) {
    return CustomArgumentClause.newInstance(sm, false);
  }
}
