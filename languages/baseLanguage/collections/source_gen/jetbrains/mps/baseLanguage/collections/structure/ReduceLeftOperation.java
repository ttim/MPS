package jetbrains.mps.baseLanguage.collections.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.baseLanguage.structure.Expression;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class ReduceLeftOperation extends InternalSequenceOperation {
  public static final String concept = "jetbrains.mps.baseLanguage.collections.structure.ReduceLeftOperation";

  public ReduceLeftOperation(SNode node) {
    super(node);
  }

  public Expression getComb() {
    return this.ensureAdapter(Expression.class, "closure", this.getClosure());
  }

  public void setComb(Expression node) {
    this.setClosure(node);
  }

  public static ReduceLeftOperation newInstance(SModel sm, boolean init) {
    return (ReduceLeftOperation) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.collections.structure.ReduceLeftOperation", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static ReduceLeftOperation newInstance(SModel sm) {
    return ReduceLeftOperation.newInstance(sm, false);
  }
}
