package jetbrains.mps.bootstrap.smodelLanguage.structure;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.structure.Type;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class SModelType extends Type {

  public  SModelType(SNode node) {
    super(node);
  }

  public static SModelType newInstance(SModel sm, boolean init) {
    return (SModelType)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.bootstrap.smodelLanguage.structure.SModelType", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static SModelType newInstance(SModel sm) {
    return SModelType.newInstance(sm, false);
  }

}
