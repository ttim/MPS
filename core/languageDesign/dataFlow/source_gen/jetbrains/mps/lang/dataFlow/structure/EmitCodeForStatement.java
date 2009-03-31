package jetbrains.mps.lang.dataFlow.structure;

/*Generated by MPS */

import jetbrains.mps.lang.dataFlow.structure.EmitStatement;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.baseLanguage.structure.Expression;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class EmitCodeForStatement extends EmitStatement {
  public static final String concept = "jetbrains.mps.lang.dataFlow.structure.EmitCodeForStatement";
  public static final String CODE_FOR = "codeFor";

  public EmitCodeForStatement(SNode node) {
    super(node);
  }

  public Expression getCodeFor() {
    return (Expression)this.getChild(Expression.class, EmitCodeForStatement.CODE_FOR);
  }

  public void setCodeFor(Expression node) {
    super.setChild(EmitCodeForStatement.CODE_FOR, node);
  }


  public static EmitCodeForStatement newInstance(SModel sm, boolean init) {
    return (EmitCodeForStatement)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.dataFlow.structure.EmitCodeForStatement", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static EmitCodeForStatement newInstance(SModel sm) {
    return EmitCodeForStatement.newInstance(sm, false);
  }

}
