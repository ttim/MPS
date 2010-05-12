package jetbrains.mps.nanoc.structure;

/*Generated by MPS */

import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class VarRef extends CExpression {
  public static final String concept = "jetbrains.mps.nanoc.structure.VarRef";
  public static final String DECLARATION = "declaration";

  public VarRef(SNode node) {
    super(node);
  }

  public VarDecl getDeclaration() {
    return (VarDecl) this.getReferent(VarDecl.class, VarRef.DECLARATION);
  }

  public void setDeclaration(VarDecl node) {
    super.setReferent(VarRef.DECLARATION, node);
  }

  public static VarRef newInstance(SModel sm, boolean init) {
    return (VarRef) SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.nanoc.structure.VarRef", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static VarRef newInstance(SModel sm) {
    return VarRef.newInstance(sm, false);
  }
}
