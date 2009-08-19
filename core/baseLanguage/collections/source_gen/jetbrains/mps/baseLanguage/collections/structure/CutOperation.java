package jetbrains.mps.baseLanguage.collections.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class CutOperation extends ChunkOperation {
  public static final String concept = "jetbrains.mps.baseLanguage.collections.structure.CutOperation";

  public CutOperation(SNode node) {
    super(node);
  }

  public static CutOperation newInstance(SModel sm, boolean init) {
    return (CutOperation)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.collections.structure.CutOperation", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static CutOperation newInstance(SModel sm) {
    return CutOperation.newInstance(sm, false);
  }
}
