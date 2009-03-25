package jetbrains.mps.lang.editor.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class CellModel_NonEmptyProperty extends jetbrains.mps.lang.editor.structure.CellModel_Property {
  public static final String concept = "jetbrains.mps.lang.editor.structure.CellModel_NonEmptyProperty";

  public CellModel_NonEmptyProperty(SNode node) {
    super(node);
  }

  public static CellModel_NonEmptyProperty newInstance(SModel sm, boolean init) {
    return (CellModel_NonEmptyProperty)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.editor.structure.CellModel_NonEmptyProperty", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static CellModel_NonEmptyProperty newInstance(SModel sm) {
    return CellModel_NonEmptyProperty.newInstance(sm, false);
  }

}
