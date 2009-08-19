package jetbrains.mps.lang.plugin.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class ExecuteLightweightCommandStatement extends BaseExecuteCommandStatementSync {
  public static final String concept = "jetbrains.mps.lang.plugin.structure.ExecuteLightweightCommandStatement";

  public ExecuteLightweightCommandStatement(SNode node) {
    super(node);
  }

  public static ExecuteLightweightCommandStatement newInstance(SModel sm, boolean init) {
    return (ExecuteLightweightCommandStatement)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.plugin.structure.ExecuteLightweightCommandStatement", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static ExecuteLightweightCommandStatement newInstance(SModel sm) {
    return ExecuteLightweightCommandStatement.newInstance(sm, false);
  }
}
