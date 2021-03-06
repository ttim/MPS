package jetbrains.mps.vcs.changesmanager.tree.features;

/*Generated by MPS */

import org.jetbrains.annotations.NotNull;
import jetbrains.mps.smodel.SNodePointer;

public abstract class NodeAggregationFeature extends AbstractNodeFeature {
  protected NodeAggregationFeature(@NotNull SNodePointer nodePointer) {
    super(nodePointer);
  }

  @NotNull
  public Feature getParent() {
    return new NodeFeature(getNodePointer());
  }
}
