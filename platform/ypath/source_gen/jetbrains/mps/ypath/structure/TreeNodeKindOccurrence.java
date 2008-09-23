package jetbrains.mps.ypath.structure;

/*Generated by MPS */

import jetbrains.mps.core.structure.BaseConcept;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class TreeNodeKindOccurrence extends BaseConcept {
  public static final String concept = "jetbrains.mps.ypath.structure.TreeNodeKindOccurrence";
  public static String NODE_KIND = "nodeKind";

  public TreeNodeKindOccurrence(SNode node) {
    super(node);
  }

  public TreeNodeKind getNodeKind() {
    return (TreeNodeKind)this.getReferent(TreeNodeKindOccurrence.NODE_KIND);
  }

  public void setNodeKind(TreeNodeKind node) {
    super.setReferent(TreeNodeKindOccurrence.NODE_KIND, node);
  }


  public static TreeNodeKindOccurrence newInstance(SModel sm, boolean init) {
    return (TreeNodeKindOccurrence)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.ypath.structure.TreeNodeKindOccurrence", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static TreeNodeKindOccurrence newInstance(SModel sm) {
    return TreeNodeKindOccurrence.newInstance(sm, false);
  }

}
