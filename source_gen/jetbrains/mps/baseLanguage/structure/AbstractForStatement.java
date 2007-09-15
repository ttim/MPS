package jetbrains.mps.baseLanguage.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class AbstractForStatement extends AbstractLoopStatement {
  public static final String concept = "jetbrains.mps.baseLanguage.structure.AbstractForStatement";
  public static String VARIABLE = "variable";

  public  AbstractForStatement(SNode node) {
    super(node);
  }

  public static AbstractForStatement newInstance(SModel sm, boolean init) {
    return (AbstractForStatement)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.baseLanguage.structure.AbstractForStatement", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static AbstractForStatement newInstance(SModel sm) {
    return AbstractForStatement.newInstance(sm, false);
  }


  public LocalVariableDeclaration getVariable() {
    return (LocalVariableDeclaration)this.getChild(AbstractForStatement.VARIABLE);
  }

  public void setVariable(LocalVariableDeclaration node) {
    super.setChild(AbstractForStatement.VARIABLE, node);
  }

}
