package jetbrains.mps.lang.plugin.structure;

/*Generated by MPS */

import jetbrains.mps.lang.plugin.structure.BaseExecuteCommandStatement;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class ExecuteCommandInEDTStatement extends BaseExecuteCommandStatement {
  public static final String concept = "jetbrains.mps.lang.plugin.structure.ExecuteCommandInEDTStatement";

  public ExecuteCommandInEDTStatement(SNode node) {
    super(node);
  }

  public static ExecuteCommandInEDTStatement newInstance(SModel sm, boolean init) {
    return (ExecuteCommandInEDTStatement)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.plugin.structure.ExecuteCommandInEDTStatement", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static ExecuteCommandInEDTStatement newInstance(SModel sm) {
    return ExecuteCommandInEDTStatement.newInstance(sm, false);
  }

}
