package jetbrains.mps.regexp.structure;

/*Generated by MPS */

import jetbrains.mps.regexp.structure.LookRegexp;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class NegativeLookAheadRegexp extends LookRegexp {

  public  NegativeLookAheadRegexp(SNode node) {
    super(node);
  }

  public static NegativeLookAheadRegexp newInstance(SModel sm, boolean init) {
    return (NegativeLookAheadRegexp)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.regexp.NegativeLookAheadRegexp", sm, GlobalScope.getInstance(), init).getAdapter();
  }
  public static NegativeLookAheadRegexp newInstance(SModel sm) {
    return NegativeLookAheadRegexp.newInstance(sm, false);
  }
}
