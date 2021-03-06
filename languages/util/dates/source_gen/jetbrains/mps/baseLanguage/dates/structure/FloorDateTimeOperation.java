package jetbrains.mps.baseLanguage.dates.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class FloorDateTimeOperation extends RoundDateTimeOperation {
  public static final String concept = "jetbrains.mps.baseLanguage.dates.structure.FloorDateTimeOperation";

  public FloorDateTimeOperation(SNode node) {
    super(node);
  }

  public static FloorDateTimeOperation newInstance(SModel sm, boolean init) {
    return (FloorDateTimeOperation) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.dates.structure.FloorDateTimeOperation", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static FloorDateTimeOperation newInstance(SModel sm) {
    return FloorDateTimeOperation.newInstance(sm, false);
  }
}
