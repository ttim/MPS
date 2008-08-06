package jetbrains.mps.baseLanguage.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class CharConstant extends Expression {
  public static final String concept = "jetbrains.mps.baseLanguage.structure.CharConstant";
  public static String CHAR_CONSTANT = "charConstant";

  public CharConstant(SNode node) {
    super(node);
  }

  public String getCharConstant() {
    return this.getProperty(CharConstant.CHAR_CONSTANT);
  }

  public void setCharConstant(String value) {
    this.setProperty(CharConstant.CHAR_CONSTANT, value);
  }


  public static CharConstant newInstance(SModel sm, boolean init) {
    return (CharConstant)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.CharConstant", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static CharConstant newInstance(SModel sm) {
    return CharConstant.newInstance(sm, false);
  }

}
