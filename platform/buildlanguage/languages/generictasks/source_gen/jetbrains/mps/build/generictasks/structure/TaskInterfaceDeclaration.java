package jetbrains.mps.build.generictasks.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import java.util.Iterator;
import java.util.List;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class TaskInterfaceDeclaration extends BuiltInTaskDeclaration {
  public static final String concept = "jetbrains.mps.build.generictasks.structure.TaskInterfaceDeclaration";
  public static final String PARENTS = "parents";

  public TaskInterfaceDeclaration(SNode node) {
    super(node);
  }

  public int getParentsesCount() {
    return this.getChildCount(TaskInterfaceDeclaration.PARENTS);
  }

  public Iterator<TaskReference> parentses() {
    return this.children(TaskReference.class, TaskInterfaceDeclaration.PARENTS);
  }

  public List<TaskReference> getParentses() {
    return this.getChildren(TaskReference.class, TaskInterfaceDeclaration.PARENTS);
  }

  public void addParents(TaskReference node) {
    this.addChild(TaskInterfaceDeclaration.PARENTS, node);
  }

  public void insertParents(TaskReference prev, TaskReference node) {
    this.insertChild(prev, TaskInterfaceDeclaration.PARENTS, node);
  }

  public static TaskInterfaceDeclaration newInstance(SModel sm, boolean init) {
    return (TaskInterfaceDeclaration)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.build.generictasks.structure.TaskInterfaceDeclaration", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static TaskInterfaceDeclaration newInstance(SModel sm) {
    return TaskInterfaceDeclaration.newInstance(sm, false);
  }
}
