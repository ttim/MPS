package jetbrains.mps.bash.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class EqualityStrings extends BinaryConditionalExpression {
  public static final String concept = "jetbrains.mps.bash.structure.EqualityStrings";

  public EqualityStrings(SNode node) {
    super(node);
  }

  public static EqualityStrings newInstance(SModel sm, boolean init) {
    return (EqualityStrings) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.bash.structure.EqualityStrings", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static EqualityStrings newInstance(SModel sm) {
    return EqualityStrings.newInstance(sm, false);
  }
}
