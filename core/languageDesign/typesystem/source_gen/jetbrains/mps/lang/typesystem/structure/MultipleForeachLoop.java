package jetbrains.mps.lang.typesystem.structure;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.structure.AbstractLoopStatement;
import jetbrains.mps.smodel.SNode;
import java.util.Iterator;
import java.util.List;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class MultipleForeachLoop extends AbstractLoopStatement {
  public static final String concept = "jetbrains.mps.lang.typesystem.structure.MultipleForeachLoop";
  public static final String LOOP_VARIABLE = "loopVariable";

  public MultipleForeachLoop(SNode node) {
    super(node);
  }

  public int getLoopVariablesCount() {
    return this.getChildCount(MultipleForeachLoop.LOOP_VARIABLE);
  }

  public Iterator<MultipleForeachLoopVariable> loopVariables() {
    return this.children(MultipleForeachLoopVariable.class, MultipleForeachLoop.LOOP_VARIABLE);
  }

  public List<MultipleForeachLoopVariable> getLoopVariables() {
    return this.getChildren(MultipleForeachLoopVariable.class, MultipleForeachLoop.LOOP_VARIABLE);
  }

  public void addLoopVariable(MultipleForeachLoopVariable node) {
    this.addChild(MultipleForeachLoop.LOOP_VARIABLE, node);
  }

  public void insertLoopVariable(MultipleForeachLoopVariable prev, MultipleForeachLoopVariable node) {
    this.insertChild(prev, MultipleForeachLoop.LOOP_VARIABLE, node);
  }

  public static MultipleForeachLoop newInstance(SModel sm, boolean init) {
    return (MultipleForeachLoop) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.typesystem.structure.MultipleForeachLoop", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static MultipleForeachLoop newInstance(SModel sm) {
    return MultipleForeachLoop.newInstance(sm, false);
  }
}
