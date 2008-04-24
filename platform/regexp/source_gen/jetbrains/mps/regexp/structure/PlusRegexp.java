package jetbrains.mps.regexp.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class PlusRegexp extends UnaryRegexp {
  public static final String concept = "jetbrains.mps.regexp.structure.PlusRegexp";

  public PlusRegexp(SNode node) {
    super(node);
  }

  public static PlusRegexp newInstance(SModel sm, boolean init) {
    return (PlusRegexp)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.regexp.structure.PlusRegexp", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static PlusRegexp newInstance(SModel sm) {
    return PlusRegexp.newInstance(sm, false);
  }

}
