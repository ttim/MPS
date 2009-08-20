package jetbrains.mps.nanoj.structure;

/*Generated by MPS */

import jetbrains.mps.lang.core.structure.BaseConcept;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class NanoExpression extends BaseConcept {
  public static final String concept = "jetbrains.mps.nanoj.structure.NanoExpression";

  public NanoExpression(SNode node) {
    super(node);
  }

  public static NanoExpression newInstance(SModel sm, boolean init) {
    return (NanoExpression)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.nanoj.structure.NanoExpression", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static NanoExpression newInstance(SModel sm) {
    return NanoExpression.newInstance(sm, false);
  }
}
