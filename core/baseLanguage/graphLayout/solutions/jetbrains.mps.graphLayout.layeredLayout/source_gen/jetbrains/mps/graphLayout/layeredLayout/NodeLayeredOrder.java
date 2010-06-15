package jetbrains.mps.graphLayout.layeredLayout;

/*Generated by MPS */

import java.util.List;
import jetbrains.mps.graphLayout.graph.Node;
import jetbrains.mps.graphLayout.graph.Graph;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.internal.collections.runtime.ISelector;

public class NodeLayeredOrder {
  private List<List<Node>> myLayeredOrder;
  private Graph myGraph;

  public NodeLayeredOrder(Graph graph) {
    myGraph = graph;
    myLayeredOrder = ListSequence.fromList(new ArrayList<List<Node>>());
  }

  public void addLast(Node node, int layer) {
    if (ListSequence.fromList(myLayeredOrder).count() <= layer) {
      for (int i = ListSequence.fromList(myLayeredOrder).count(); i <= layer; i++) {
        ListSequence.fromList(myLayeredOrder).addElement(ListSequence.fromList(new ArrayList<Node>()));
      }
    }
    ListSequence.fromList(ListSequence.fromList(myLayeredOrder).getElement(layer)).addElement(node);
  }

  public void setLayer(List<Node> nodes, int layer) {
    ListSequence.fromList(myLayeredOrder).setElement(layer, nodes);
  }

  public void addLast(int index, int layer) {
    addLast(myGraph.getNode(index), layer);
  }

  public List<Node> getOrder(int layer) {
    return ListSequence.fromList(myLayeredOrder).getElement(layer);
  }

  public List<Integer> getIntOrder(int layer) {
    return ListSequence.fromList(ListSequence.fromList(myLayeredOrder).getElement(layer)).select(new ISelector<Node, Integer>() {
      public Integer select(Node it) {
        return it.getIndex();
      }
    }).toListSequence();
  }

  public int getMaxLayer() {
    return ListSequence.fromList(myLayeredOrder).count() - 1;
  }

  public Graph getGraph() {
    return this.myGraph;
  }
}
