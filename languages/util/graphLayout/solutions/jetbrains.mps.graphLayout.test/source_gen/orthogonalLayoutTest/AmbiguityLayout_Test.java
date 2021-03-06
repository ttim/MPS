package orthogonalLayoutTest;

/*Generated by MPS */

import junit.framework.TestCase;
import jetbrains.mps.graphLayout.graph.Graph;
import visualization.GraphIO;
import java.util.Scanner;
import java.util.Map;
import jetbrains.mps.graphLayout.graph.Node;
import jetbrains.mps.graphLayout.intGeom2D.Dimension;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import java.util.HashMap;
import jetbrains.mps.graphLayout.graph.Edge;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.graphLayout.graphLayout.GraphLayout;
import jetbrains.mps.graphLayout.stOrthogonalLayout.RectOrthogonalLayouter;
import jetbrains.mps.graphLayout.intGeom2D.Rectangle;
import junit.framework.Assert;
import java.util.List;
import jetbrains.mps.graphLayout.intGeom2D.Point;

public class AmbiguityLayout_Test extends TestCase {
  public void test_test1() throws Exception {
    String graphString = "7 15\n  0 5\n  0 4  \n1 3  \n1 0  \n1 2  \n1 5  \n2 4  \n3 5  \n3 6  \n4 5  \n4 6  \n4 3  \n6 0  \n6 5  \n6 1\n";
    Graph graph = GraphIO.scanGraph(new Scanner(graphString));
    test(graph);
  }

  public void test_test2() throws Exception {
    String graphString = "10 15\n  0 9  \n1 6  \n2 7  \n2 0  \n3 0  \n4 2\n  5 0  \n5 6  \n5 2  \n6 2  \n7 9  \n7 5  \n8 2  \n9 5  \n9 1";
    Graph graph = GraphIO.scanGraph(new Scanner(graphString));
    test(graph);
  }

  public void test(Graph graph) {
    Map<Node, Dimension> nodeSizes = MapSequence.fromMap(new HashMap<Node, Dimension>());
    Map<Edge, Dimension> edgeSizes = MapSequence.fromMap(new HashMap<Edge, Dimension>());
    for (Node node : ListSequence.fromList(graph.getNodes())) {
      MapSequence.fromMap(nodeSizes).put(node, new Dimension(5, 5));
    }
    for (Edge edge : ListSequence.fromList(graph.getEdges())) {
      MapSequence.fromMap(edgeSizes).put(edge, new Dimension(5, 5));
    }
    GraphLayout layout = new RectOrthogonalLayouter().doLayout(graph, nodeSizes, edgeSizes);
    for (int testNum = 0; testNum < 100; testNum++) {
      GraphLayout newLayout = new RectOrthogonalLayouter().doLayout(graph, nodeSizes, edgeSizes);
      for (Node node : ListSequence.fromList(graph.getNodes())) {
        Rectangle r1 = layout.getNodeLayout(node);
        Rectangle r2 = newLayout.getNodeLayout(node);
        Assert.assertTrue(r1.x == r2.x && r1.y == r2.y && r1.width == r2.width && r1.height == r2.height);
      }
      for (Edge edge : ListSequence.fromList(graph.getEdges())) {
        List<Point> p1 = layout.getEdgeLayout(edge);
        List<Point> p2 = newLayout.getEdgeLayout(edge);
        Assert.assertTrue((int) ListSequence.fromList(p1).count() == (int) ListSequence.fromList(p2).count());
        for (int p = 0; p < ListSequence.fromList(p1).count(); p++) {
          Assert.assertTrue(ListSequence.fromList(p1).getElement(p).x == ListSequence.fromList(p2).getElement(p).x && ListSequence.fromList(p1).getElement(p).y == ListSequence.fromList(p2).getElement(p).y);
        }
        Rectangle r1 = layout.getLabelLayout(edge);
        Rectangle r2 = newLayout.getLabelLayout(edge);
        Assert.assertTrue(r1.x == r2.x && r1.y == r2.y && r1.width == r2.width && r1.height == r2.height);
      }
    }
  }
}
