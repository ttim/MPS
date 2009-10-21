package jetbrains.mps.lang.plugin.structure;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.structure.Expression;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class ConsoleExpression extends Expression {
  public static final String concept = "jetbrains.mps.lang.plugin.structure.ConsoleExpression";

  public ConsoleExpression(SNode node) {
    super(node);
  }

  public static ConsoleExpression newInstance(SModel sm, boolean init) {
    return (ConsoleExpression)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.plugin.structure.ConsoleExpression", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static ConsoleExpression newInstance(SModel sm) {
    return ConsoleExpression.newInstance(sm, false);
  }
}
