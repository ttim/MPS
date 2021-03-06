package jetbrains.mps.lang.editor.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class CellKeyMap_IsApplicableFunction extends CellKeyMap_AbstractFunction {
  public static final String concept = "jetbrains.mps.lang.editor.structure.CellKeyMap_IsApplicableFunction";

  public CellKeyMap_IsApplicableFunction(SNode node) {
    super(node);
  }

  public static CellKeyMap_IsApplicableFunction newInstance(SModel sm, boolean init) {
    return (CellKeyMap_IsApplicableFunction) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.editor.structure.CellKeyMap_IsApplicableFunction", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static CellKeyMap_IsApplicableFunction newInstance(SModel sm) {
    return CellKeyMap_IsApplicableFunction.newInstance(sm, false);
  }
}
