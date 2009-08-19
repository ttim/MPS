package jetbrains.mps.xmlSchema.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class GroupDeclaration extends Declaration {
  public static final String concept = "jetbrains.mps.xmlSchema.structure.GroupDeclaration";
  public static final String GROUP_NAME = "groupName";
  public static final String GROUP_EXPRESSION = "groupExpression";

  public GroupDeclaration(SNode node) {
    super(node);
  }

  public String getGroupName() {
    return this.getProperty(GroupDeclaration.GROUP_NAME);
  }

  public void setGroupName(String value) {
    this.setProperty(GroupDeclaration.GROUP_NAME, value);
  }

  public GroupExpression getGroupExpression() {
    return (GroupExpression)this.getChild(GroupExpression.class, GroupDeclaration.GROUP_EXPRESSION);
  }

  public void setGroupExpression(GroupExpression node) {
    super.setChild(GroupDeclaration.GROUP_EXPRESSION, node);
  }

  public static GroupDeclaration newInstance(SModel sm, boolean init) {
    return (GroupDeclaration)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.xmlSchema.structure.GroupDeclaration", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static GroupDeclaration newInstance(SModel sm) {
    return GroupDeclaration.newInstance(sm, false);
  }
}
