package jetbrains.mps.lang.dataFlow.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class InsertAfter extends InsertPosition {
  public static final String concept = "jetbrains.mps.lang.dataFlow.structure.InsertAfter";

  public InsertAfter(SNode node) {
    super(node);
  }

  public static InsertAfter newInstance(SModel sm, boolean init) {
    return (InsertAfter) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.dataFlow.structure.InsertAfter", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static InsertAfter newInstance(SModel sm) {
    return InsertAfter.newInstance(sm, false);
  }
}
