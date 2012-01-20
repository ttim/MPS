package jetbrains.mps.vcs.changesmanager.tree;

/*Generated by MPS */

import org.jetbrains.annotations.Nullable;
import jetbrains.mps.vcs.changesmanager.tree.features.Feature;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.ide.ui.MPSTreeNode;
import jetbrains.mps.ide.findusages.view.treeholder.treeview.UsagesTree;
import jetbrains.mps.ide.findusages.view.treeholder.tree.nodedatatypes.BaseNodeData;
import jetbrains.mps.ide.findusages.view.treeholder.tree.nodedatatypes.ModelNodeData;
import jetbrains.mps.smodel.SModelReference;
import jetbrains.mps.vcs.changesmanager.tree.features.ModelFeature;
import jetbrains.mps.ide.findusages.view.treeholder.tree.nodedatatypes.NodeNodeData;
import jetbrains.mps.smodel.SNodePointer;
import jetbrains.mps.vcs.changesmanager.tree.features.NodeFeature;
import jetbrains.mps.ide.findusages.view.treeholder.tree.DataNode;

public class UsagesTreeFeatureExtractor implements TreeNodeFeatureExtractor {
  public UsagesTreeFeatureExtractor() {
  }

  @Nullable
  public Feature getFeature(@NotNull MPSTreeNode treeNode) {
    if (treeNode instanceof UsagesTree.UsagesTreeNode) {
      BaseNodeData nodeData = check_f7pfq7_a0a0a0a(((UsagesTree.UsagesTreeNode) treeNode).getUserObject());
      if (nodeData instanceof ModelNodeData) {
        SModelReference mr = ((ModelNodeData) nodeData).getModelReference();
        if (mr != null) {
          return new ModelFeature(mr);
        }
      } else if (nodeData instanceof NodeNodeData) {
        SNodePointer np = ((NodeNodeData) nodeData).getNodePointer();
        if (np != null && np.getModelReference() != null && np.getNodeId() != null) {
          return new NodeFeature(np);
        }
      }
    }
    return null;
  }

  private static BaseNodeData check_f7pfq7_a0a0a0a(DataNode checkedDotOperand) {
    if (null != checkedDotOperand) {
      return checkedDotOperand.getData();
    }
    return null;
  }
}
