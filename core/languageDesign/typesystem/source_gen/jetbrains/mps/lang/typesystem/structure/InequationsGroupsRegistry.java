package jetbrains.mps.lang.typesystem.structure;

/*Generated by MPS */

import jetbrains.mps.lang.core.structure.BaseConcept;
import jetbrains.mps.smodel.SNode;
import java.util.Iterator;
import java.util.List;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class InequationsGroupsRegistry extends BaseConcept {
  public static final String concept = "jetbrains.mps.lang.typesystem.structure.InequationsGroupsRegistry";
  public static final String GROUP = "group";

  public InequationsGroupsRegistry(SNode node) {
    super(node);
  }

  public int getGroupsCount() {
    return this.getChildCount(InequationsGroupsRegistry.GROUP);
  }

  public Iterator<InequationsGroup> groups() {
    return this.children(InequationsGroup.class, InequationsGroupsRegistry.GROUP);
  }

  public List<InequationsGroup> getGroups() {
    return this.getChildren(InequationsGroup.class, InequationsGroupsRegistry.GROUP);
  }

  public void addGroup(InequationsGroup node) {
    this.addChild(InequationsGroupsRegistry.GROUP, node);
  }

  public void insertGroup(InequationsGroup prev, InequationsGroup node) {
    this.insertChild(prev, InequationsGroupsRegistry.GROUP, node);
  }

  public static InequationsGroupsRegistry newInstance(SModel sm, boolean init) {
    return (InequationsGroupsRegistry)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.typesystem.structure.InequationsGroupsRegistry", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static InequationsGroupsRegistry newInstance(SModel sm) {
    return InequationsGroupsRegistry.newInstance(sm, false);
  }
}
