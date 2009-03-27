package jetbrains.mps.lang.plugin.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.baseLanguage.structure.Expression;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class InterfaceExtentionPoint extends jetbrains.mps.lang.plugin.structure.ExtentionPoint {
  public static final String concept = "jetbrains.mps.lang.plugin.structure.InterfaceExtentionPoint";
  public static final String POINT_I_D = "pointID";

  public InterfaceExtentionPoint(SNode node) {
    super(node);
  }

  public jetbrains.mps.baseLanguage.structure.Expression getPointID() {
    return (jetbrains.mps.baseLanguage.structure.Expression)this.getChild(Expression.class, InterfaceExtentionPoint.POINT_I_D);
  }

  public void setPointID(jetbrains.mps.baseLanguage.structure.Expression node) {
    super.setChild(InterfaceExtentionPoint.POINT_I_D, node);
  }


  public static InterfaceExtentionPoint newInstance(SModel sm, boolean init) {
    return (InterfaceExtentionPoint)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.plugin.structure.InterfaceExtentionPoint", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static InterfaceExtentionPoint newInstance(SModel sm) {
    return InterfaceExtentionPoint.newInstance(sm, false);
  }

}
