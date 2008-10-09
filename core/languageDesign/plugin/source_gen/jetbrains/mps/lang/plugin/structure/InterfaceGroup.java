package jetbrains.mps.lang.plugin.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.baseLanguage.structure.Expression;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class InterfaceGroup extends ActionGroupDeclaration {
  public static final String concept = "jetbrains.mps.lang.plugin.structure.InterfaceGroup";
  public static String GROUP_I_D = "groupID";

  public InterfaceGroup(SNode node) {
    super(node);
  }

  public Expression getGroupID() {
    return (Expression)this.getChild(InterfaceGroup.GROUP_I_D);
  }

  public void setGroupID(Expression node) {
    super.setChild(InterfaceGroup.GROUP_I_D, node);
  }


  public static InterfaceGroup newInstance(SModel sm, boolean init) {
    return (InterfaceGroup)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.plugin.structure.InterfaceGroup", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static InterfaceGroup newInstance(SModel sm) {
    return InterfaceGroup.newInstance(sm, false);
  }

}
