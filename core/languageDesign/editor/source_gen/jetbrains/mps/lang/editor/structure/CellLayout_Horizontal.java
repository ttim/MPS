package jetbrains.mps.lang.editor.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class CellLayout_Horizontal extends jetbrains.mps.lang.editor.structure.CellLayout {
  public static final String concept = "jetbrains.mps.lang.editor.structure.CellLayout_Horizontal";

  public CellLayout_Horizontal(SNode node) {
    super(node);
  }

  public static CellLayout_Horizontal newInstance(SModel sm, boolean init) {
    return (CellLayout_Horizontal)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.editor.structure.CellLayout_Horizontal", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static CellLayout_Horizontal newInstance(SModel sm) {
    return CellLayout_Horizontal.newInstance(sm, false);
  }

}
