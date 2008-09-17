package jetbrains.mps.bootstrap.dataFlow.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.baseLanguage.structure.Expression;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class BaseEmitVariableStatement extends EmitStatement {
  public static final String concept = "jetbrains.mps.bootstrap.dataFlow.structure.BaseEmitVariableStatement";
  public static String VARIABLE = "variable";

  public BaseEmitVariableStatement(SNode node) {
    super(node);
  }

  public Expression getVariable() {
    return (Expression)this.getChild(BaseEmitVariableStatement.VARIABLE);
  }

  public void setVariable(Expression node) {
    super.setChild(BaseEmitVariableStatement.VARIABLE, node);
  }


  public static BaseEmitVariableStatement newInstance(SModel sm, boolean init) {
    return (BaseEmitVariableStatement)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.bootstrap.dataFlow.structure.BaseEmitVariableStatement", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static BaseEmitVariableStatement newInstance(SModel sm) {
    return BaseEmitVariableStatement.newInstance(sm, false);
  }

}
