package jetbrains.mps.baseLanguage.collections.structure;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.structure.Type;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class ListType extends Type {
  public static final String concept = "jetbrains.mps.baseLanguage.collections.structure.ListType";
  public static final String ELEMENT_TYPE = "elementType";

  public ListType(SNode node) {
    super(node);
  }

  public Type getElementType() {
    return (Type)this.getChild(Type.class, ListType.ELEMENT_TYPE);
  }

  public void setElementType(Type node) {
    super.setChild(ListType.ELEMENT_TYPE, node);
  }

  public static ListType newInstance(SModel sm, boolean init) {
    return (ListType)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.collections.structure.ListType", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static ListType newInstance(SModel sm) {
    return ListType.newInstance(sm, false);
  }
}
