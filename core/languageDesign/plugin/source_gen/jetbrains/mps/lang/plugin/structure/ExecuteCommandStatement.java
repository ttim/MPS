package jetbrains.mps.lang.plugin.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class ExecuteCommandStatement extends jetbrains.mps.lang.plugin.structure.BaseExecuteCommandStatementSync {
  public static final String concept = "jetbrains.mps.lang.plugin.structure.ExecuteCommandStatement";

  public ExecuteCommandStatement(SNode node) {
    super(node);
  }

  public static ExecuteCommandStatement newInstance(SModel sm, boolean init) {
    return (ExecuteCommandStatement)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.plugin.structure.ExecuteCommandStatement", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static ExecuteCommandStatement newInstance(SModel sm) {
    return ExecuteCommandStatement.newInstance(sm, false);
  }

}
