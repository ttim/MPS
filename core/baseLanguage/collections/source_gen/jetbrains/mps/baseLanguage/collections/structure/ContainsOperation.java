package jetbrains.mps.baseLanguage.collections.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class ContainsOperation extends SingleArgumentSequenceOperation {
  public static final String concept = "jetbrains.mps.baseLanguage.collections.structure.ContainsOperation";

  public ContainsOperation(SNode node) {
    super(node);
  }

  public static ContainsOperation newInstance(SModel sm, boolean init) {
    return (ContainsOperation)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.collections.structure.ContainsOperation", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static ContainsOperation newInstance(SModel sm) {
    return ContainsOperation.newInstance(sm, false);
  }
}
