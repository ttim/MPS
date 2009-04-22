package jetbrains.mps.baseLanguage.structure;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.structure.Expression;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class FloatingPointConstant extends Expression {
  public static final String concept = "jetbrains.mps.baseLanguage.structure.FloatingPointConstant";
  public static final String VALUE = "value";

  public FloatingPointConstant(SNode node) {
    super(node);
  }

  public String getValue() {
    return this.getProperty(FloatingPointConstant.VALUE);
  }

  public void setValue(String value) {
    this.setProperty(FloatingPointConstant.VALUE, value);
  }


  public static FloatingPointConstant newInstance(SModel sm, boolean init) {
    return (FloatingPointConstant)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.FloatingPointConstant", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static FloatingPointConstant newInstance(SModel sm) {
    return FloatingPointConstant.newInstance(sm, false);
  }

}
