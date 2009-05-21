package jetbrains.mps.baseLanguage.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class LongLiteral extends Expression {
  public static final String concept = "jetbrains.mps.baseLanguage.structure.LongLiteral";
  public static final String VALUE = "value";

  public LongLiteral(SNode node) {
    super(node);
  }

  public String getValue() {
    return this.getProperty(LongLiteral.VALUE);
  }

  public void setValue(String value) {
    this.setProperty(LongLiteral.VALUE, value);
  }


  public static LongLiteral newInstance(SModel sm, boolean init) {
    return (LongLiteral)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.LongLiteral", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static LongLiteral newInstance(SModel sm) {
    return LongLiteral.newInstance(sm, false);
  }

}
