package jetbrains.mps.vcs.changesmanager.tree;

/*Generated by MPS */

import org.jetbrains.annotations.Nullable;
import jetbrains.mps.vcs.changesmanager.tree.features.Feature;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.ide.ui.MPSTreeNode;

public interface TreeNodeFeatureExtractor {
  @Nullable
  public Feature getFeature(@NotNull MPSTreeNode treeNode);
}
