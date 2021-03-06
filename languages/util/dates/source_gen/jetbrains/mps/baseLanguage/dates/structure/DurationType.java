package jetbrains.mps.baseLanguage.dates.structure;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.structure.Type;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class DurationType extends Type {
  public static final String concept = "jetbrains.mps.baseLanguage.dates.structure.DurationType";

  public DurationType(SNode node) {
    super(node);
  }

  public static DurationType newInstance(SModel sm, boolean init) {
    return (DurationType) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.dates.structure.DurationType", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static DurationType newInstance(SModel sm) {
    return DurationType.newInstance(sm, false);
  }
}
