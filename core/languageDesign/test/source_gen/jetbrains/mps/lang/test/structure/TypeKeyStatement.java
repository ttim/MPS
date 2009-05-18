package jetbrains.mps.lang.test.structure;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.structure.Statement;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class TypeKeyStatement extends Statement {
  public static final String concept = "jetbrains.mps.lang.test.structure.TypeKeyStatement";
  public static final String KEYS = "keys";

  public TypeKeyStatement(SNode node) {
    super(node);
  }

  public String getKeys() {
    return this.getProperty(TypeKeyStatement.KEYS);
  }

  public void setKeys(String value) {
    this.setProperty(TypeKeyStatement.KEYS, value);
  }


  public static TypeKeyStatement newInstance(SModel sm, boolean init) {
    return (TypeKeyStatement)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.test.structure.TypeKeyStatement", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static TypeKeyStatement newInstance(SModel sm) {
    return TypeKeyStatement.newInstance(sm, false);
  }

}
