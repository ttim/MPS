package jetbrains.mps.bootstrap.helgins.structure;

/*Generated by MPS */

import jetbrains.mps.core.structure.BaseConcept;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;
import java.util.Iterator;
import java.util.List;

public class JoinType extends BaseConcept {
  public static String ARGUMENT = "argument";

  public  JoinType(SNode node) {
    super(node);
  }

  public static JoinType newInstance(SModel sm, boolean init) {
    return (JoinType)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.bootstrap.helgins.JoinType", sm, GlobalScope.getInstance(), init).getAdapter();
  }
  public static JoinType newInstance(SModel sm) {
    return JoinType.newInstance(sm, false);
  }

  public int getArgumentsCount() {
    return this.getChildCount(JoinType.ARGUMENT);
  }
  public Iterator<BaseConcept> arguments() {
    return this.children(JoinType.ARGUMENT);
  }
  public List<BaseConcept> getArguments() {
    return this.getChildren(JoinType.ARGUMENT);
  }
  public void addArgument(BaseConcept node) {
    this.addChild(JoinType.ARGUMENT, node);
  }
  public void insertArgument(BaseConcept prev, BaseConcept node) {
    this.insertChild(prev, JoinType.ARGUMENT, node);
  }
}
