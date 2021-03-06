package jetbrains.mps.make.script.structure;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.structure.Expression;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class PropertiesAccessorParameter extends Expression {
  public static final String concept = "jetbrains.mps.make.script.structure.PropertiesAccessorParameter";

  public PropertiesAccessorParameter(SNode node) {
    super(node);
  }

  public static PropertiesAccessorParameter newInstance(SModel sm, boolean init) {
    return (PropertiesAccessorParameter) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.make.script.structure.PropertiesAccessorParameter", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static PropertiesAccessorParameter newInstance(SModel sm) {
    return PropertiesAccessorParameter.newInstance(sm, false);
  }
}
