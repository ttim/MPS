package jetbrains.mps.lang.typesystem.structure;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.structure.Statement;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.baseLanguage.structure.Expression;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class PrintToTrace extends Statement {
  public static final String concept = "jetbrains.mps.lang.typesystem.structure.PrintToTrace";
  public static final String MESSAGE = "message";

  public PrintToTrace(SNode node) {
    super(node);
  }

  public Expression getMessage() {
    return (Expression) this.getChild(Expression.class, PrintToTrace.MESSAGE);
  }

  public void setMessage(Expression node) {
    super.setChild(PrintToTrace.MESSAGE, node);
  }

  public static PrintToTrace newInstance(SModel sm, boolean init) {
    return (PrintToTrace) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.typesystem.structure.PrintToTrace", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static PrintToTrace newInstance(SModel sm) {
    return PrintToTrace.newInstance(sm, false);
  }
}
