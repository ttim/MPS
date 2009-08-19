package jetbrains.mps.baseLanguage.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class UpperBoundType extends Type {
  public static final String concept = "jetbrains.mps.baseLanguage.structure.UpperBoundType";
  public static final String BOUND = "bound";

  public UpperBoundType(SNode node) {
    super(node);
  }

  public Type getBound() {
    return (Type)this.getChild(Type.class, UpperBoundType.BOUND);
  }

  public void setBound(Type node) {
    super.setChild(UpperBoundType.BOUND, node);
  }

  public static UpperBoundType newInstance(SModel sm, boolean init) {
    return (UpperBoundType)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.UpperBoundType", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static UpperBoundType newInstance(SModel sm) {
    return UpperBoundType.newInstance(sm, false);
  }
}
