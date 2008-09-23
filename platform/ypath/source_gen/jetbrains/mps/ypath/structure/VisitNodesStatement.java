package jetbrains.mps.ypath.structure;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.structure.Statement;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class VisitNodesStatement extends Statement {
  public static final String concept = "jetbrains.mps.ypath.structure.VisitNodesStatement";
  public static String VISIT_BLOCK = "visitBlock";

  public VisitNodesStatement(SNode node) {
    super(node);
  }

  public VisitBlock getVisitBlock() {
    return (VisitBlock)this.getChild(VisitNodesStatement.VISIT_BLOCK);
  }

  public void setVisitBlock(VisitBlock node) {
    super.setChild(VisitNodesStatement.VISIT_BLOCK, node);
  }


  public static VisitNodesStatement newInstance(SModel sm, boolean init) {
    return (VisitNodesStatement)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.ypath.structure.VisitNodesStatement", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static VisitNodesStatement newInstance(SModel sm) {
    return VisitNodesStatement.newInstance(sm, false);
  }

}
