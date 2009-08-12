package jetbrains.mps.baseLanguage.collections.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class LinkedListType extends ListType {
  public static final String concept = "jetbrains.mps.baseLanguage.collections.structure.LinkedListType";

  public LinkedListType(SNode node) {
    super(node);
  }

  public static LinkedListType newInstance(SModel sm, boolean init) {
    return (LinkedListType)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.collections.structure.LinkedListType", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static LinkedListType newInstance(SModel sm) {
    return LinkedListType.newInstance(sm, false);
  }

}
