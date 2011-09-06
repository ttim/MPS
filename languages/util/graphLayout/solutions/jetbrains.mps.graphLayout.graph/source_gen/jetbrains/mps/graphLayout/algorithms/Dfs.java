package jetbrains.mps.graphLayout.algorithms;

/*Generated by MPS */

import jetbrains.mps.graphLayout.graph.Graph;
import jetbrains.mps.graphLayout.graph.Edge;
import java.util.Map;
import jetbrains.mps.graphLayout.graph.Node;
import jetbrains.mps.baseLanguage.closures.runtime._FunctionTypes;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import jetbrains.mps.graphLayout.util.NodeMap;

public abstract class Dfs {
  public static int BEFORE = 0;
  public static int DURING = 1;
  public static int AFTER = 2;

  private Graph myGraph;
  private Edge.Direction myDirection;
  protected Map<Node, Integer> myDfsState;
  private _FunctionTypes._return_P1_E0<? extends Boolean, ? super Edge> myEdgeFilter;

  public Dfs() {
  }

  public void doDfs(Graph graph) {
    doDfs(graph, Edge.Direction.FRONT);
  }

  public void doDfs(Graph graph, Edge.Direction direction) {
    doDfs(graph, direction, new _FunctionTypes._return_P1_E0<Boolean, Edge>() {
      public Boolean invoke(Edge edge) {
        return true;
      }
    });
  }

  public void doDfs(Graph graph, Edge.Direction direction, _FunctionTypes._return_P1_E0<? extends Boolean, ? super Edge> edgeFilter) {
    this.init(graph, direction, edgeFilter);
    for (Node node : ListSequence.fromList(myGraph.getNodes())) {
      if (MapSequence.fromMap(myDfsState).get(node) == BEFORE) {
        preprocessRoot(node);
        dfs(node, null);
        postprocessRoot(node);
      }
    }
  }

  public void init(Graph graph, Edge.Direction direction) {
    init(graph, direction, new _FunctionTypes._return_P1_E0<Boolean, Edge>() {
      public Boolean invoke(Edge edge) {
        return true;
      }
    });
  }

  public void init(Graph graph, Edge.Direction direction, _FunctionTypes._return_P1_E0<? extends Boolean, ? super Edge> edgeFilter) {
    myGraph = graph;
    myEdgeFilter = edgeFilter;
    myDfsState = new NodeMap<Integer>(graph);
    myDirection = direction;
    for (Node node : ListSequence.fromList(myGraph.getNodes())) {
      MapSequence.fromMap(myDfsState).put(node, BEFORE);
    }
  }

  protected void dfs(Node node, Edge from) {
    MapSequence.fromMap(myDfsState).put(node, DURING);
    preprocess(node, from);
    for (Edge edge : ListSequence.fromList(node.getEdges(myDirection)).where(myEdgeFilter)) {
      if (edge != from) {
        processEdge(edge, node);
        Node target = edge.getOpposite(node);
        if (MapSequence.fromMap(myDfsState).get(target) == BEFORE) {
          dfs(target, edge);
        }
      }
    }
    postprocess(node, from);
    MapSequence.fromMap(myDfsState).put(node, AFTER);
  }

  protected void preprocessRoot(Node root) {
  }

  protected void postprocessRoot(Node root) {
  }

  protected void preprocess(Node node, Edge from) {
  }

  protected void processEdge(Edge edge, Node source) {
  }

  protected void postprocess(Node node, Edge from) {
  }

  protected Map<Node, Integer> getDfsState() {
    return this.myDfsState;
  }

  public Graph getGraph() {
    return myGraph;
  }
}
