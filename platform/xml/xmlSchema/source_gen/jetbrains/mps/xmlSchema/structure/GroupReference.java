package jetbrains.mps.xmlSchema.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class GroupReference extends TypeExpression {
  public static final String concept = "jetbrains.mps.xmlSchema.structure.GroupReference";
  public static final String GROUP_DECLARATION = "groupDeclaration";

  public GroupReference(SNode node) {
    super(node);
  }

  public GroupDeclaration getGroupDeclaration() {
    return (GroupDeclaration)this.getReferent(GroupDeclaration.class, GroupReference.GROUP_DECLARATION);
  }

  public void setGroupDeclaration(GroupDeclaration node) {
    super.setReferent(GroupReference.GROUP_DECLARATION, node);
  }

  public static GroupReference newInstance(SModel sm, boolean init) {
    return (GroupReference)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.xmlSchema.structure.GroupReference", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static GroupReference newInstance(SModel sm) {
    return GroupReference.newInstance(sm, false);
  }
}
