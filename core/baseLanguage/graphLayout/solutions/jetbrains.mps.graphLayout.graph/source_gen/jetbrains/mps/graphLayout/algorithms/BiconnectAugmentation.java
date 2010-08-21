package jetbrains.mps.graphLayout.algorithms;

/*Generated by MPS */

import java.util.Set;
import jetbrains.mps.graphLayout.graph.Edge;
import jetbrains.mps.graphLayout.graph.Graph;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.internal.collections.runtime.SetSequence;
import java.util.HashSet;
import java.util.List;
import jetbrains.mps.graphLayout.graph.Node;
import java.util.ArrayList;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import java.util.Map;
import jetbrains.mps.graphLayout.util.NodeMap;
import jetbrains.mps.internal.collections.runtime.MapSequence;

public class BiconnectAugmentation {
  public static Set<Edge> makeBiconnected(Graph graph) {
    return new BiconnectAugmentation.MyDfs().doDfs(graph, ListSequence.fromList(graph.getNodes()).getElement(0));
  }

  public static Set<Edge> smartMakeBiconnected(Graph graph) {
    Set<Edge> addedEdges = SetSequence.fromSet(new HashSet<Edge>());
    BiconnectedComponent root = BiconnectedComponent.createTree(graph);
    if (ListSequence.fromList(root.getChildren()).count() > 0) {
      List<Node> toConnect = ListSequence.fromList(new ArrayList<Node>());
      collectListNodes(root, toConnect, null);
      if (ListSequence.fromList(toConnect).count() == 1) {
        if (ListSequence.fromList(root.getChildren()).count() == 1) {
          ListSequence.fromList(toConnect).addElement(SetSequence.fromSet(root.getNodes()).first());
        } else {
          final Node cutpoint = root.getCutpoint(ListSequence.fromList(root.getChildren()).first());
          ListSequence.fromList(toConnect).addElement(SetSequence.fromSet(root.getNodes()).findFirst(new IWhereFilter<Node>() {
            public boolean accept(Node it) {
              return it != cutpoint;
            }
          }));
        }
      }
      Node prev = null;
      for (Node node : ListSequence.fromList(toConnect)) {
        if (prev != null) {
          SetSequence.fromSet(addedEdges).addElement(prev.addEdgeTo(node));
        }
        prev = node;
      }
    }
    return addedEdges;
  }

  private static void collectListNodes(BiconnectedComponent component, List<Node> nodes, final Node cutpoint) {
    if (ListSequence.fromList(component.getChildren()).count() == 0) {

      Set<Node> componentNodes = component.getNodes();
      if (SetSequence.fromSet(componentNodes).count() == 1) {
        ListSequence.fromList(nodes).addElement(SetSequence.fromSet(componentNodes).first());
      } else {
        ListSequence.fromList(nodes).addElement(SetSequence.fromSet(componentNodes).findFirst(new IWhereFilter<Node>() {
          public boolean accept(Node it) {
            return it != cutpoint;
          }
        }));
      }
    } else {
      for (BiconnectedComponent child : ListSequence.fromList(component.getChildren())) {
        collectListNodes(child, nodes, component.getChildCutpoint(child));
      }
    }
  }

  public static class MyDfs extends Dfs {
    private Map<Node, Node> myLow;
    private Map<Node, Integer> myNum;
    private int myCurNum;
    private Node myNewNode;
    private Node mySource;
    private Set<Node> myConnectToNew;

    public MyDfs() {
    }

    public Set<Edge> doDfs(Graph graph, Node source) {
      myLow = new NodeMap<Node>(graph);
      myNum = new NodeMap<Integer>(graph);
      myCurNum = 0;
      mySource = source;
      myConnectToNew = SetSequence.fromSet(new HashSet<Node>());
      init(graph, Edge.Direction.BOTH);
      dfs(source, null);
      Set<Edge> result = SetSequence.fromSet(new HashSet<Edge>());
      for (Node node : SetSequence.fromSet(myConnectToNew)) {
        SetSequence.fromSet(result).addElement(myNewNode.addEdgeTo(node));
      }
      return result;
    }

    @Override
    protected void preprocess(Node node, Edge from) {
      MapSequence.fromMap(myNum).put(node, myCurNum++);
      MapSequence.fromMap(myLow).put(node, node);
    }

    @Override
    protected void processEdge(Edge edge, Node source) {
      Node next = edge.getOpposite(source);
      if (MapSequence.fromMap(getDfsState()).get(next) == Dfs.DURING) {
        changeLow(source, next);
      }
    }

    @Override
    protected void postprocess(Node node, Edge from) {
      if (from != null) {
        Node prev = from.getOpposite(node);
        if (MapSequence.fromMap(myNum).get(prev) <= MapSequence.fromMap(myNum).get(MapSequence.fromMap(myLow).get(node))) {
          if (myNewNode == null) {
            createNewNode();
          }
          SetSequence.fromSet(myConnectToNew).addElement(node);
          MapSequence.fromMap(myLow).put(node, myNewNode);
        }
        changeLow(prev, MapSequence.fromMap(myLow).get(node));
      }
    }

    private void changeLow(Node node, Node newLow) {
      Node oldLow = MapSequence.fromMap(myLow).get(node);
      if (MapSequence.fromMap(myNum).get(oldLow) > MapSequence.fromMap(myNum).get(newLow)) {
        MapSequence.fromMap(myLow).put(node, newLow);
      }
    }

    public void createNewNode() {
      myNewNode = getGraph().addNode();
      MapSequence.fromMap(myNum).put(myNewNode, -1);
      SetSequence.fromSet(myConnectToNew).addElement(mySource);
    }
  }
}
