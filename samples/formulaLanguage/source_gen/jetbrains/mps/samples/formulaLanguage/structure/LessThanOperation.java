package jetbrains.mps.samples.formulaLanguage.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class LessThanOperation extends Operation {
  public static final String concept = "jetbrains.mps.samples.formulaLanguage.structure.LessThanOperation";

  public LessThanOperation(SNode node) {
    super(node);
  }

  public static LessThanOperation newInstance(SModel sm, boolean init) {
    return (LessThanOperation) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.samples.formulaLanguage.structure.LessThanOperation", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static LessThanOperation newInstance(SModel sm) {
    return LessThanOperation.newInstance(sm, false);
  }
}
