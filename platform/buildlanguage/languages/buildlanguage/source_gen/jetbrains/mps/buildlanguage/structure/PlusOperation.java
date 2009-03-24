package jetbrains.mps.buildlanguage.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class PlusOperation extends jetbrains.mps.buildlanguage.structure.BinaryOperation {
  public static final String concept = "jetbrains.mps.buildlanguage.structure.PlusOperation";

  public PlusOperation(SNode node) {
    super(node);
  }

  public static PlusOperation newInstance(SModel sm, boolean init) {
    return (PlusOperation)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.buildlanguage.structure.PlusOperation", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static PlusOperation newInstance(SModel sm) {
    return PlusOperation.newInstance(sm, false);
  }

}
