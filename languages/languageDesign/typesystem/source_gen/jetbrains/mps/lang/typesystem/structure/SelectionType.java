package jetbrains.mps.lang.typesystem.structure;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.structure.Type;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class SelectionType extends Type {
  public static final String concept = "jetbrains.mps.lang.typesystem.structure.SelectionType";

  public SelectionType(SNode node) {
    super(node);
  }

  public static SelectionType newInstance(SModel sm, boolean init) {
    return (SelectionType) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.typesystem.structure.SelectionType", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static SelectionType newInstance(SModel sm) {
    return SelectionType.newInstance(sm, false);
  }
}
