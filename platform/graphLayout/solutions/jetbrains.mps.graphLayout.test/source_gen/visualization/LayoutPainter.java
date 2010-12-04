package visualization;

/*Generated by MPS */

import jetbrains.mps.graphLayout.graphLayout.IGraphLayout;
import java.awt.Graphics;
import jetbrains.mps.graphLayout.graph.IGraph;
import jetbrains.mps.graphLayout.graph.IEdge;
import jetbrains.mps.graphLayout.intGeom2D.Point;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.graphLayout.graph.INode;
import jetbrains.mps.graphLayout.intGeom2D.Rectangle;

public class LayoutPainter {
  public LayoutPainter() {
  }

  public void paint(IGraphLayout layout, Graphics g) {
    IGraph graph = layout.getGraph();
    for (IEdge edge : graph.getEdges()) {
      Iterable<Point> route = layout.getEdgeLayout(edge);
      this.drawPolyline(route, g);
      g.fillOval(Sequence.fromIterable(route).first().x - 2, Sequence.fromIterable(route).first().y - 2, 4, 4);
      g.fillOval(Sequence.fromIterable(route).last().x - 2, Sequence.fromIterable(route).last().y - 2, 4, 4);
    }
    for (INode node : graph.getNodes()) {
      Rectangle rect = layout.getNodeLayout(node);
      g.drawRect(rect.x, rect.y, rect.width, rect.height);
      g.drawString(node.toString(), rect.x + 5, rect.y + 15);
    }
    for (IEdge edge : graph.getEdges()) {
      Rectangle rect = layout.getLabelLayout(edge);
      if (rect != null) {
        g.drawRect(rect.x, rect.y, rect.width, rect.height);
        g.drawString(edge.toString(), rect.x + 5, rect.y + 12);
      }
    }
  }

  protected void drawPolyline(Iterable<Point> polyline, Graphics g) {
    Point prev = null;
    for (Point point : Sequence.fromIterable(polyline)) {
      if (prev != null) {
        g.drawLine(prev.x, prev.y, point.x, point.y);
      }
      prev = point;
    }
  }
}
