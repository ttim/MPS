package jetbrains.mps.baseLanguage.collections.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class ClearSetOperation extends AbstractSetOperation {
  public static final String concept = "jetbrains.mps.baseLanguage.collections.structure.ClearSetOperation";

  public ClearSetOperation(SNode node) {
    super(node);
  }

  public static ClearSetOperation newInstance(SModel sm, boolean init) {
    return (ClearSetOperation)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.collections.structure.ClearSetOperation", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static ClearSetOperation newInstance(SModel sm) {
    return ClearSetOperation.newInstance(sm, false);
  }
}
