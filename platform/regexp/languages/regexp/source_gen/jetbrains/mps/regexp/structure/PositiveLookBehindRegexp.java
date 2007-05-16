package jetbrains.mps.regexp.structure;

/*Generated by MPS */

import jetbrains.mps.regexp.structure.LookRegexp;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class PositiveLookBehindRegexp extends LookRegexp {

  public  PositiveLookBehindRegexp(SNode node) {
    super(node);
  }

  public static PositiveLookBehindRegexp newInstance(SModel sm, boolean init) {
    return (PositiveLookBehindRegexp)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.regexp.PositiveLookBehindRegexp", sm, GlobalScope.getInstance(), init).getAdapter();
  }
  public static PositiveLookBehindRegexp newInstance(SModel sm) {
    return PositiveLookBehindRegexp.newInstance(sm, false);
  }
}
