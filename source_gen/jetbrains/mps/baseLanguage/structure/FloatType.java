package jetbrains.mps.baseLanguage.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class FloatType extends PrimitiveType {
  public static final String concept = "jetbrains.mps.baseLanguage.structure.FloatType";

  public  FloatType(SNode node) {
    super(node);
  }

  public static FloatType newInstance(SModel sm, boolean init) {
    return (FloatType)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.FloatType", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static FloatType newInstance(SModel sm) {
    return FloatType.newInstance(sm, false);
  }

}
