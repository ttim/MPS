package jetbrains.mps.regexp.structure;

/*Generated by MPS  */

import jetbrains.mps.core.structure.BaseConcept;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class NegativeSymbolClassRegexp extends BaseConcept {

  public  NegativeSymbolClassRegexp(SNode node) {
    super(node);
  }

  public static NegativeSymbolClassRegexp newInstance(SModel sm, boolean init) {
    return (NegativeSymbolClassRegexp)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.regexp.NegativeSymbolClassRegexp", sm, GlobalScope.getInstance(), init).getAdapter();
  }
  public static NegativeSymbolClassRegexp newInstance(SModel sm) {
    return NegativeSymbolClassRegexp.newInstance(sm, false);
  }
}
