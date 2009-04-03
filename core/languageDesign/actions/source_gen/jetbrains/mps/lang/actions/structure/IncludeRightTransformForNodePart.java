package jetbrains.mps.lang.actions.structure;

/*Generated by MPS */

import jetbrains.mps.lang.actions.structure.MenuBuilderPart;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.lang.actions.structure.QueryFunction_SideTransform_NodeQuery;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.SModelUtil_new;
import jetbrains.mps.project.GlobalScope;

public class IncludeRightTransformForNodePart extends MenuBuilderPart {
  public static final String concept = "jetbrains.mps.lang.actions.structure.IncludeRightTransformForNodePart";
  public static final String NODE_BLOCK = "nodeBlock";

  public IncludeRightTransformForNodePart(SNode node) {
    super(node);
  }

  public QueryFunction_SideTransform_NodeQuery getNodeBlock() {
    return (QueryFunction_SideTransform_NodeQuery)this.getChild(QueryFunction_SideTransform_NodeQuery.class, IncludeRightTransformForNodePart.NODE_BLOCK);
  }

  public void setNodeBlock(QueryFunction_SideTransform_NodeQuery node) {
    super.setChild(IncludeRightTransformForNodePart.NODE_BLOCK, node);
  }


  public static IncludeRightTransformForNodePart newInstance(SModel sm, boolean init) {
    return (IncludeRightTransformForNodePart)SModelUtil_new.instantiateConceptDeclaration("jetbrains.mps.lang.actions.structure.IncludeRightTransformForNodePart", sm, GlobalScope.getInstance(), init).getAdapter();
  }

  public static IncludeRightTransformForNodePart newInstance(SModel sm) {
    return IncludeRightTransformForNodePart.newInstance(sm, false);
  }

}
