package jetbrains.mps.graphLayout.algorithms;

/*Generated by MPS */

import java.util.Set;
import jetbrains.mps.graphLayout.graph.Node;
import java.util.List;
import java.util.Map;
import jetbrains.mps.graphLayout.graph.Edge;
import jetbrains.mps.internal.collections.runtime.SetSequence;
import java.util.LinkedHashSet;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import java.util.HashMap;
import jetbrains.mps.graphLayout.graph.Graph;

public class BiconnectedComponent {
  private Set<Node> myNodes;
  private List<BiconnectedComponent> myChildren;
  private Map<BiconnectedComponent, Edge> myBridges;
  private Map<BiconnectedComponent, Node> myCutpoints;

  private BiconnectedComponent() {
    myNodes = SetSequence.<Node>fromSet(new LinkedHashSet<Node>());
    myChildren = ListSequence.<BiconnectedComponent>fromList(new ArrayList<BiconnectedComponent>());
    myBridges = MapSequence.<BiconnectedComponent,Edge>fromMap(new HashMap<BiconnectedComponent, Edge>());
    myCutpoints = MapSequence.<BiconnectedComponent,Node>fromMap(new HashMap<BiconnectedComponent, Node>());
  }

  public void addComponent(BiconnectedComponent component, Node node) {
    ListSequence.<BiconnectedComponent>fromList(myChildren).addElement(component);
    MapSequence.<BiconnectedComponent,Node>fromMap(myCutpoints).put(component, node);
  }

  public void addComponent(BiconnectedComponent component, Edge edge) {
    ListSequence.<BiconnectedComponent>fromList(myChildren).addElement(component);
    MapSequence.<BiconnectedComponent,Edge>fromMap(myBridges).put(component, edge);
  }

  public void addNode(Node node) {
    SetSequence.fromSet(myNodes).addElement(node);
  }

  public List<BiconnectedComponent> getChildren() {
    return myChildren;
  }

  public Set<Node> getNodes() {
    return myNodes;
  }

  public Object getConnection(BiconnectedComponent child) {
    if (MapSequence.fromMap(myBridges).containsKey(child)) {
      return MapSequence.<BiconnectedComponent,Edge>fromMap(myBridges).get(child);
    } else {
      return MapSequence.<BiconnectedComponent,Node>fromMap(myCutpoints).get(child);
    }
  }

  public Node getChildCutpoint(BiconnectedComponent child) {
    if (MapSequence.fromMap(myBridges).containsKey(child)) {
      Edge bridge = MapSequence.<BiconnectedComponent,Edge>fromMap(myBridges).get(child);
      Node cutpoint = bridge.getSource();
      if (SetSequence.<Node>fromSet(getNodes()).contains(cutpoint)) {
        cutpoint = bridge.getTarget();
      }
      return cutpoint;
    } else {
      return MapSequence.<BiconnectedComponent,Node>fromMap(myCutpoints).get(child);
    }
  }

  public Node getCutpoint(BiconnectedComponent child) {
    if (MapSequence.fromMap(myBridges).containsKey(child)) {
      Edge bridge = MapSequence.<BiconnectedComponent,Edge>fromMap(myBridges).get(child);
      Node cutpoint = bridge.getSource();
      if (!(SetSequence.<Node>fromSet(getNodes()).contains(cutpoint))) {
        cutpoint = bridge.getTarget();
      }
      return cutpoint;
    } else {
      return MapSequence.<BiconnectedComponent,Node>fromMap(myCutpoints).get(child);
    }
  }

  public String toString(String prefix) {
    StringBuilder builder = new StringBuilder();
    builder.append(prefix + " C: " + getNodes() + " has " + ListSequence.<BiconnectedComponent>fromList(getChildren()).count() + " children" + "\n");
    for (BiconnectedComponent child : ListSequence.<BiconnectedComponent>fromList(getChildren())) {
      builder.append(prefix + " from " + getConnection(child) + ":\n");
      builder.append(child.toString(prefix + "  "));
    }
    return builder.toString();
  }

  public static BiconnectedComponent createTree(Graph graph) {
    BiconnectedComponent tree = new BiconnectedComponent();
    BiconnectedComponents components = new BiconnectedComponents();
    components.doDfs(graph);
    new BiconnectedComponent.TreeMaker(components.getLow(), components.getNum()).doDfs(graph, tree);
    BiconnectedComponent treeCandidate = ListSequence.<BiconnectedComponent>fromList(tree.getChildren()).first();
    if (ListSequence.<BiconnectedComponent>fromList(tree.getChildren()).count() == 1 && tree.getConnection(treeCandidate) instanceof Node) {
      tree = treeCandidate;
    }
    return tree;
  }

  private static class TreeMaker extends Dfs {
    private Map<Node, Node> myLow;
    private Map<Node, Integer> myNum;

    public TreeMaker(Map<Node, Node> low, Map<Node, Integer> num) {
      myLow = low;
      myNum = num;
    }

    public void doDfs(Graph graph, BiconnectedComponent component) {
      init(graph, Edge.Direction.BOTH);
      dfs(ListSequence.<Node>fromList(graph.getNodes()).first(), null, component);
    }

    private void dfs(Node node, Edge from, BiconnectedComponent component) {
      MapSequence.<Node,Integer>fromMap(myDfsState).put(node, DURING);
      BiconnectedComponent nextComponent = component;
      if (from != null) {
        int lowNum = MapSequence.<Node,Integer>fromMap(myNum).get(MapSequence.<Node,Node>fromMap(myLow).get(node));
        Node source = from.getOpposite(node);
        int sourceNum = MapSequence.<Node,Integer>fromMap(myNum).get(source);
        if (lowNum < sourceNum) {
          component.addNode(node);
        } else if (lowNum == sourceNum) {
          nextComponent = new BiconnectedComponent();
          nextComponent.addNode(source);
          nextComponent.addNode(node);
          component.addComponent(nextComponent, source);
        } else {
          nextComponent = new BiconnectedComponent();
          nextComponent.addNode(node);
          component.addComponent(nextComponent, from);
        }
      } else {
        component.addNode(node);
      }
      for (Edge edge : ListSequence.<Edge>fromList(node.getEdges())) {
        Node next = edge.getOpposite(node);
        if (MapSequence.<Node,Integer>fromMap(myDfsState).get(next) == BEFORE) {
          dfs(next, edge, nextComponent);
        }
      }
    }
  }
}
