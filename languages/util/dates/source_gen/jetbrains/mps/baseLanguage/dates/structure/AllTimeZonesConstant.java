package jetbrains.mps.baseLanguage.dates.structure;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.structure.Expression;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class AllTimeZonesConstant extends Expression {
  public static final String concept = "jetbrains.mps.baseLanguage.dates.structure.AllTimeZonesConstant";

  public AllTimeZonesConstant(SNode node) {
    super(node);
  }

  public static AllTimeZonesConstant newInstance(SModel sm, boolean init) {
    return (AllTimeZonesConstant) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.dates.structure.AllTimeZonesConstant", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static AllTimeZonesConstant newInstance(SModel sm) {
    return AllTimeZonesConstant.newInstance(sm, false);
  }
}
