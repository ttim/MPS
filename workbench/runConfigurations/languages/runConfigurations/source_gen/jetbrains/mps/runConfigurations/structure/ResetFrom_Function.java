package jetbrains.mps.runConfigurations.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class ResetFrom_Function extends EditorOperationDeclaration {
  public static final String concept = "jetbrains.mps.runConfigurations.structure.ResetFrom_Function";

  public ResetFrom_Function(SNode node) {
    super(node);
  }

  public static ResetFrom_Function newInstance(SModel sm, boolean init) {
    return (ResetFrom_Function) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.runConfigurations.structure.ResetFrom_Function", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static ResetFrom_Function newInstance(SModel sm) {
    return ResetFrom_Function.newInstance(sm, false);
  }
}
