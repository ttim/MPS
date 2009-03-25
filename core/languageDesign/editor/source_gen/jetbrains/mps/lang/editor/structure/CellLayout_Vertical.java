package jetbrains.mps.lang.editor.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class CellLayout_Vertical extends jetbrains.mps.lang.editor.structure.CellLayout {
  public static final String concept = "jetbrains.mps.lang.editor.structure.CellLayout_Vertical";

  public CellLayout_Vertical(SNode node) {
    super(node);
  }

  public static CellLayout_Vertical newInstance(SModel sm, boolean init) {
    return (CellLayout_Vertical)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.editor.structure.CellLayout_Vertical", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static CellLayout_Vertical newInstance(SModel sm) {
    return CellLayout_Vertical.newInstance(sm, false);
  }

}
