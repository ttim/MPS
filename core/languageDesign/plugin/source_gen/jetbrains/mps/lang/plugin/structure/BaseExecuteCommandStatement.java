package jetbrains.mps.lang.plugin.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.plugin.structure.CommandClosureLiteral;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class BaseExecuteCommandStatement extends jetbrains.mps.baseLanguage.structure.Statement {
  public static final String concept = "jetbrains.mps.lang.plugin.structure.BaseExecuteCommandStatement";
  public static final String COMMAND_CLOSURE_LITERAL = "commandClosureLiteral";

  public BaseExecuteCommandStatement(SNode node) {
    super(node);
  }

  public jetbrains.mps.lang.plugin.structure.CommandClosureLiteral getCommandClosureLiteral() {
    return (jetbrains.mps.lang.plugin.structure.CommandClosureLiteral)this.getChild(CommandClosureLiteral.class, BaseExecuteCommandStatement.COMMAND_CLOSURE_LITERAL);
  }

  public void setCommandClosureLiteral(jetbrains.mps.lang.plugin.structure.CommandClosureLiteral node) {
    super.setChild(BaseExecuteCommandStatement.COMMAND_CLOSURE_LITERAL, node);
  }


  public static BaseExecuteCommandStatement newInstance(SModel sm, boolean init) {
    return (BaseExecuteCommandStatement)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.plugin.structure.BaseExecuteCommandStatement", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static BaseExecuteCommandStatement newInstance(SModel sm) {
    return BaseExecuteCommandStatement.newInstance(sm, false);
  }

}
