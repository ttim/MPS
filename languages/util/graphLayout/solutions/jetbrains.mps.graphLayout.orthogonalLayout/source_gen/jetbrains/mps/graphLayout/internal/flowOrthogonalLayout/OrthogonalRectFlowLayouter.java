package jetbrains.mps.graphLayout.internal.flowOrthogonalLayout;

/*Generated by MPS */

import jetbrains.mps.graphLayout.graphLayout.GraphLayout;
import jetbrains.mps.graphLayout.graph.Graph;
import java.util.Map;
import jetbrains.mps.graphLayout.graph.Node;
import jetbrains.mps.graphLayout.intGeom2D.Dimension;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import java.util.HashMap;
import jetbrains.mps.graphLayout.graph.Edge;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.graphLayout.graph.EdgesHistoryManager;
import jetbrains.mps.graphLayout.algorithms.BiconnectAugmentation;
import jetbrains.mps.graphLayout.planarGraph.EmbeddedGraph;
import jetbrains.mps.graphLayout.planarization.ShortestPathEmbeddingFinder;
import jetbrains.mps.graphLayout.planarization.PQPlanarizationFinder;
import java.util.List;
import java.util.Set;
import jetbrains.mps.graphLayout.flowOrthogonalLayout.EmbeddedGraphModifier;
import jetbrains.mps.internal.collections.runtime.Sequence;
import java.util.LinkedHashMap;
import java.util.ArrayList;
import jetbrains.mps.graphLayout.graphLayout.GraphLayoutFactory;
import jetbrains.mps.graphLayout.intGeom2D.Rectangle;
import jetbrains.mps.graphLayout.intGeom2D.Point;
import jetbrains.mps.graphLayout.planarGraph.Dart;
import jetbrains.mps.graphLayout.flowOrthogonalLayout.OrthogonalRepresentation;
import jetbrains.mps.graphLayout.intGeom2D.Direction2D;
import jetbrains.mps.internal.collections.runtime.SetSequence;
import jetbrains.mps.graphLayout.intGeom2D.GeomUtil;
import jetbrains.mps.internal.collections.runtime.backports.LinkedList;

public class OrthogonalRectFlowLayouter {
  private static int SHOW_lOG = 0;

  public OrthogonalRectFlowLayouter() {
  }

  public GraphLayout doLayout(Graph graph, Map<Node, Dimension> nodeSizes) {
    Graph copy = new Graph();
    Map<Node, Node> nodeMap = MapSequence.fromMap(new HashMap<Node, Node>());
    Map<Edge, Edge> edgeMap = MapSequence.fromMap(new HashMap<Edge, Edge>());
    for (Node node : ListSequence.fromList(graph.getNodes())) {
      MapSequence.fromMap(nodeMap).put(node, copy.createNode());
    }
    for (Edge edge : ListSequence.fromList(graph.getEdges())) {
      MapSequence.fromMap(edgeMap).put(edge, copy.connect(MapSequence.fromMap(nodeMap).get(edge.getSource()), MapSequence.fromMap(nodeMap).get(edge.getTarget())));
    }
    EdgesHistoryManager historyManager = new EdgesHistoryManager(copy);
    BiconnectAugmentation.smartMakeBiconnected(copy);
    EmbeddedGraph embeddedGraph = new ShortestPathEmbeddingFinder(new PQPlanarizationFinder()).find(copy);
    Map<Edge, List<Edge>> history = MapSequence.fromMap(new HashMap<Edge, List<Edge>>());
    for (Edge edge : ListSequence.fromList(graph.getEdges())) {
      Edge copyEdge = MapSequence.fromMap(edgeMap).get(edge);
      MapSequence.fromMap(history).put(edge, historyManager.getHistory(copyEdge));
      // if copyEdge has been reverted during st-numbering in planarization step 
      if (copyEdge.getSource() != MapSequence.fromMap(nodeMap).get(edge.getSource())) {
        MapSequence.fromMap(history).put(edge, ListSequence.fromList(MapSequence.fromMap(history).get(edge)).reversedList());
      }
    }
    Map<Node, List<Node>> newNodes = MapSequence.fromMap(new HashMap<Node, List<Node>>());
    Map<Edge, Edge> replacedEdges = MapSequence.fromMap(new HashMap<Edge, Edge>());
    Set<Edge> newEdges = new EmbeddedGraphModifier(embeddedGraph).reduceNodesDegree(newNodes, replacedEdges);
    for (List<Edge> list : Sequence.fromIterable(MapSequence.fromMap(history).values())) {
      Edge first = ListSequence.fromList(list).first();
      if (MapSequence.fromMap(replacedEdges).containsKey(first)) {
        ListSequence.fromList(list).setElement(0, MapSequence.fromMap(replacedEdges).get(first));
      }
      if (ListSequence.fromList(list).count() > 1) {
        Edge last = ListSequence.fromList(list).last();
        if (MapSequence.fromMap(replacedEdges).containsKey(last)) {
          ListSequence.fromList(list).setElement(ListSequence.fromList(list).count() - 1, MapSequence.fromMap(replacedEdges).get(last));
        }
      }
    }
    Map<Node, List<Node>> nodesToSplit = MapSequence.fromMap(new LinkedHashMap<Node, List<Node>>(16, (float) 0.75, false));
    Map<Node, Dimension> copyNodeSizes = MapSequence.fromMap(new HashMap<Node, Dimension>());
    for (Node node : ListSequence.fromList(graph.getNodes())) {
      Node copyNode = MapSequence.fromMap(nodeMap).get(node);
      if (!(MapSequence.fromMap(newNodes).containsKey(copyNode))) {
        MapSequence.fromMap(nodesToSplit).put(copyNode, ListSequence.fromList(new ArrayList<Node>()));
      } else {
        MapSequence.fromMap(nodesToSplit).put(copyNode, MapSequence.fromMap(newNodes).get(copyNode));
      }
      MapSequence.fromMap(copyNodeSizes).put(copyNode, MapSequence.fromMap(nodeSizes).get(node));
    }
    GraphLayout copyLayout = getFlowLayout(embeddedGraph, newEdges, nodesToSplit, copyNodeSizes, historyManager);
    GraphLayout graphLayout = GraphLayoutFactory.createGraphLayout(graph);
    for (Node node : ListSequence.fromList(graph.getNodes())) {
      Node copyNode = MapSequence.fromMap(nodeMap).get(node);
      graphLayout.setLayoutFor(node, new Rectangle(copyLayout.getNodeLayout(copyNode)));
    }
    for (Edge graphEdge : ListSequence.fromList(graph.getEdges())) {
      List<Point> edgeLayout = ListSequence.fromList(new ArrayList<Point>());
      List<Edge> edgeHistory = MapSequence.fromMap(history).get(graphEdge);
      Node copySource = MapSequence.fromMap(nodeMap).get(graphEdge.getSource());
      Node cur;
      Node firstSource = ListSequence.fromList(edgeHistory).first().getSource();
      if (copySource == firstSource || ListSequence.fromList(MapSequence.fromMap(newNodes).get(copySource)).contains(firstSource)) {
        cur = firstSource;
      } else {
        cur = ListSequence.fromList(edgeHistory).first().getTarget();
      }
      for (Edge edge : ListSequence.fromList(edgeHistory)) {
        if (cur == edge.getSource()) {
          ListSequence.fromList(edgeLayout).addSequence(ListSequence.fromList(copyLayout.getEdgeLayout(edge)));
        } else {
          ListSequence.fromList(edgeLayout).addSequence(ListSequence.fromList(copyLayout.getEdgeLayout(edge)).reversedList());
        }
        cur = edge.getOpposite(cur);
      }
      graphLayout.setLayoutFor(graphEdge, edgeLayout);
    }
    Rectangle containingRect = graphLayout.getContainingRectangle();
    graphLayout = graphLayout.shift(20 - containingRect.x, 20 - containingRect.y);
    return graphLayout;
  }

  public GraphLayout getFlowLayout(EmbeddedGraph embeddedGraph, Set<Edge> edgesToBeStraight, Map<Node, List<Node>> nodeMap, Map<Node, Dimension> nodeSizes, EdgesHistoryManager historyManager) {
    EmbeddedGraphModifier modifier = new EmbeddedGraphModifier(embeddedGraph);
    Graph graph = embeddedGraph.getGraph();
    List<Edge> oldEdges = ListSequence.fromList(new ArrayList<Edge>());
    ListSequence.fromList(oldEdges).addSequence(ListSequence.fromList(graph.getEdges()));
    Map<Dart, Integer> bends = MapSequence.fromMap(new HashMap<Dart, Integer>());
    Map<Dart, Integer> angles = MapSequence.fromMap(new HashMap<Dart, Integer>());
    OrthogonalRepresentation.getRepresentation(embeddedGraph, edgesToBeStraight, bends, angles);
    if (OrthogonalRectFlowLayouter.SHOW_lOG > 0) {
      System.out.println("bends:");
      System.out.println(bends);
    }
    OrthogonalRepresentation.replaceBendsByNodes(embeddedGraph, bends, angles);
    Map<Dart, Direction2D> directions = OrthogonalRepresentation.getDirections(embeddedGraph, angles);
    modifier.setDartDirections(directions);
    Map<Edge, Edge> modifiedEdges = modifier.makeRectanglesForNodes(nodeMap);
    for (Edge edge : SetSequence.fromSet(MapSequence.fromMap(modifiedEdges).keySet())) {
      Edge newEdge = MapSequence.fromMap(modifiedEdges).get(edge);
      if (MapSequence.fromMap(modifiedEdges).containsKey(newEdge)) {
        MapSequence.fromMap(modifiedEdges).put(edge, MapSequence.fromMap(modifiedEdges).get(newEdge));
      }
    }
    modifier.makeRectangularFaces();
    modifier.makerInnerFaces();
    Map<Edge, Integer> nodeBorderLengths = MapSequence.fromMap(new HashMap<Edge, Integer>());
    for (Node node : SetSequence.fromSet(MapSequence.fromMap(nodeMap).keySet())) {
      for (Dart dart : ListSequence.fromList(modifier.getNodeFace(node).getDarts())) {
        Edge edge = dart.getEdge();
        if (MapSequence.fromMap(directions).get(dart).isHorizontal()) {
          MapSequence.fromMap(nodeBorderLengths).put(edge, MapSequence.fromMap(nodeSizes).get(node).width);
        } else {
          MapSequence.fromMap(nodeBorderLengths).put(edge, MapSequence.fromMap(nodeSizes).get(node).height);
        }
      }
    }
    Map<Edge, Integer> lengths = new EdgeLengthComputer().compute(embeddedGraph, directions, nodeBorderLengths);
    Map<Node, Point> coordinates = new CoordinatePlacer(embeddedGraph, lengths, directions).getCoordinates();
    GraphLayout nodesLayout = GraphLayoutFactory.createGraphLayout(graph);
    for (Node node : SetSequence.fromSet(MapSequence.fromMap(nodeMap).keySet())) {
      Node[] corners = modifier.getCornerNodes(node);
      Rectangle rect = GeomUtil.getRectangle(MapSequence.fromMap(coordinates).get(corners[0]), MapSequence.fromMap(coordinates).get(corners[2]));
      nodesLayout.setLayoutFor(node, rect);
    }
    for (Edge edge : ListSequence.fromList(oldEdges)) {
      List<Edge> history = ListSequence.fromList(new LinkedList<Edge>());
      for (Edge historyEdge : ListSequence.fromList(historyManager.getHistory(edge))) {
        if (MapSequence.fromMap(modifiedEdges).containsKey(historyEdge)) {
          ListSequence.fromList(history).addElement(MapSequence.fromMap(modifiedEdges).get(historyEdge));
        } else {
          ListSequence.fromList(history).addElement(historyEdge);
        }
      }
      List<Point> edgeLayout = ListSequence.fromList(new ArrayList<Point>());
      Node cur = ListSequence.fromList(history).first().getSource();
      ListSequence.fromList(edgeLayout).addElement(MapSequence.fromMap(coordinates).get(cur));
      for (Edge historyEdge : ListSequence.fromList(history)) {
        Node next = historyEdge.getOpposite(cur);
        ListSequence.fromList(edgeLayout).addElement(MapSequence.fromMap(coordinates).get(next));
        cur = next;
      }
      nodesLayout.setLayoutFor(edge, edgeLayout);
    }
    return nodesLayout;
  }
}
