package visualization;

/*Generated by MPS */

import jetbrains.mps.graphLayout.graphLayout.IGraphLayout;
import java.awt.Graphics;
import jetbrains.mps.graphLayout.graphLayout.ClusteredGraphLayout;
import jetbrains.mps.graphLayout.graph.ClusteredGraph;
import jetbrains.mps.graphLayout.graph.Node;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.List;
import jetbrains.mps.graphLayout.intGeom2D.Point;

public class ClusterLayoutPainter extends LayoutPainter {
  public ClusterLayoutPainter() {
  }

  @Override
  public void paint(IGraphLayout layout, Graphics g) {
    if (!(layout instanceof ClusteredGraphLayout)) {
      throw new RuntimeException("wrong usage!!!");
    }
    super.paint(layout, g);
    ClusteredGraphLayout clusteredGraphLayout = ((ClusteredGraphLayout) layout);
    ClusteredGraph graph = ((ClusteredGraph) layout.getGraph());
    for (Node cluster : ListSequence.fromList(graph.getInclusionTree().getNodes())) {
      if (graph.isLeafCluster(cluster)) {
        continue;
      }
      List<Point> borderLayout = clusteredGraphLayout.getClusterLayout(cluster);
      drawPolyline(borderLayout, g);
    }
  }
}
