package jetbrains.mps.graphLayout.planarGraph;

/*Generated by MPS */

import java.util.List;
import java.util.Map;
import jetbrains.mps.graphLayout.graph.Edge;
import jetbrains.mps.graphLayout.graph.Graph;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import java.util.HashMap;
import java.util.LinkedHashMap;
import jetbrains.mps.graphLayout.graph.Node;
import jetbrains.mps.internal.collections.runtime.ISelector;
import java.util.Set;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;

public class EmbeddedGraph {
  private List<Face> myFaces;
  private Map<Edge, List<Face>> myAdjacentFacesMap;
  private Map<Dart, Face> myDartsToFacesMap;
  private Map<Edge, List<Dart>> myEdgeDarts;
  private Graph myGraph;
  private Face myOuterFace;
  private Map<Edge, List<Edge>> myEdgesHistory;

  public EmbeddedGraph(Graph graph) {
    myFaces = ListSequence.fromList(new ArrayList<Face>());
    myAdjacentFacesMap = MapSequence.fromMap(new HashMap<Edge, List<Face>>());
    myEdgesHistory = MapSequence.fromMap(new HashMap<Edge, List<Edge>>());
    myDartsToFacesMap = MapSequence.fromMap(new HashMap<Dart, Face>());
    myEdgeDarts = MapSequence.fromMap(new LinkedHashMap<Edge, List<Dart>>(16, (float) 0.75, false));
    myGraph = graph;
  }

  public Face findContainingFace(List<Node> nodes) {
    Face containingFace = null;
    for (Face face : ListSequence.fromList(getFaces())) {
      if (face.contains(nodes)) {
        if (isOuterFace(face)) {
          containingFace = face;
        } else {
          return face;
        }
      }
    }
    return containingFace;
  }

  public Face getFaceToTheRight(Edge edge) {
    List<Dart> darts = getDarts(edge);
    for (Dart dart : ListSequence.fromList(darts)) {
      if (dart.getSource() == edge.getTarget()) {
        return getFace(dart);
      }
    }
    return null;
  }

  public Face getFaceToTheLeft(Edge edge) {
    List<Dart> darts = getDarts(edge);
    for (Dart dart : ListSequence.fromList(darts)) {
      if (dart.getSource() == edge.getSource()) {
        return getFace(dart);
      }
    }
    return null;
  }

  public Node splitEdge(Edge edge) {
    return splitEdge(edge, ListSequence.fromList(new ArrayList<Edge>()));
  }

  public Node splitEdge(Edge edge, List<Edge> newEdges) {
    Graph originalGraph = this.getGraph();
    Node newNode = originalGraph.addDummyNode();
    edge.removeFromGraph();
    ListSequence.fromList(newEdges).addElement(edge.getSource().addEdgeTo(newNode));
    ListSequence.fromList(newEdges).addElement(newNode.addEdgeTo(edge.getTarget()));
    MapSequence.fromMap(myEdgesHistory).put(edge, newEdges);
    List<Face> facesToProcess = ListSequence.fromList(new ArrayList<Face>());
    ListSequence.fromList(facesToProcess).addSequence(ListSequence.fromList(getAdjacentFaces(edge)));
    for (Face face : ListSequence.fromList(facesToProcess)) {
      List<Dart> darts = face.getDarts();
      int pos = 0;
      while (ListSequence.fromList(darts).getElement(pos).getEdge() != edge) {
        pos++;
      }
      Dart dartToReplace = ListSequence.fromList(darts).getElement(pos);
      for (Edge newEdge : ListSequence.fromList(newEdges)) {
        if (ListSequence.fromList(newEdge.getAdjacentNodes()).contains(dartToReplace.getSource())) {
          this.setDart(face, pos, new Dart(newEdge, dartToReplace.getSource()));
        }
      }
      for (Edge newEdge : ListSequence.fromList(newEdges)) {
        if (ListSequence.fromList(newEdge.getAdjacentNodes()).contains(dartToReplace.getTarget())) {
          this.insertDart(face, pos + 1, new Dart(newEdge, newNode));
        }
      }
    }
    return newNode;
  }

  public List<Face> splitFace(Face face, List<Edge> path, Node start, Node end) {
    Graph originalGraph = this.getGraph();
    Face faceSToE = new Face(originalGraph);
    Face faceEToS = new Face(originalGraph);
    List<Dart> darts = face.getDarts();
    int posStart = -1;
    int posEnd = -1;
    for (int i = 0; i < ListSequence.fromList(darts).count(); i++) {
      Dart cur = ListSequence.fromList(darts).getElement(i);
      if (cur.getSource() == start) {
        posStart = i;
      }
      if (cur.getSource() == end) {
        posEnd = i;
      }
    }
    Face succ;
    Face split;
    int begSucc;
    int endSucc;
    if (posEnd > posStart) {
      succ = faceEToS;
      split = faceSToE;
      begSucc = posStart;
      endSucc = posEnd;
    } else {
      succ = faceSToE;
      split = faceEToS;
      begSucc = posEnd;
      endSucc = posStart;
    }
    for (int i = begSucc; i < endSucc; i++) {
      succ.addLast(ListSequence.fromList(darts).getElement(i));
    }
    for (int i = endSucc; i < ListSequence.fromList(darts).count(); i++) {
      split.addLast(ListSequence.fromList(darts).getElement(i));
    }
    for (int i = 0; i < begSucc; i++) {
      split.addLast(ListSequence.fromList(darts).getElement(i));
    }
    Node cur = start;
    for (Edge edge : ListSequence.fromList(path)) {
      faceSToE.addLast(new Dart(edge, cur));
      cur = edge.getOpposite(cur);
    }
    cur = end;
    for (Edge edge : ListSequence.fromList(path).reversedList()) {
      faceEToS.addLast(new Dart(edge, cur));
      cur = edge.getOpposite(cur);
    }
    this.removeFace(face);
    addFace(faceEToS);
    addFace(faceSToE);
    if (this.isOuterFace(face)) {
      this.setOuterFace(split);
    }
    return ListSequence.fromListAndArray(new ArrayList<Face>(), faceSToE, faceEToS);
  }

  public void addFace(Face face) {
    ListSequence.fromList(myFaces).addElement(face);
    for (Dart dart : ListSequence.fromList(face.getDarts())) {
      adjustDart(dart, face);
    }
  }

  private void adjustDart(Dart dart, Face face) {
    MapSequence.fromMap(myDartsToFacesMap).put(dart, face);
    Edge edge = dart.getEdge();
    if (!(MapSequence.fromMap(myEdgeDarts).containsKey(edge))) {
      MapSequence.fromMap(myEdgeDarts).put(edge, ListSequence.fromList(new ArrayList<Dart>()));
    }
    ListSequence.fromList(MapSequence.fromMap(myEdgeDarts).get(edge)).addElement(dart);
  }

  public void removeFace(Face face) {
    ListSequence.fromList(myFaces).removeElement(face);
    for (Dart dart : ListSequence.fromList(face.getDarts())) {
      unadjustDart(dart);
    }
  }

  private void unadjustDart(Dart dart) {
    MapSequence.fromMap(myDartsToFacesMap).removeKey(dart);
    Edge edge = dart.getEdge();
    ListSequence.fromList(MapSequence.fromMap(myEdgeDarts).get(edge)).removeElement(dart);
    if (ListSequence.fromList(MapSequence.fromMap(myEdgeDarts).get(edge)).count() == 0) {
      MapSequence.fromMap(myEdgeDarts).removeKey(edge);
    }
  }

  public void setDart(Face face, int pos, Dart dart) {
    Dart oldDart = ListSequence.fromList(face.getDarts()).getElement(pos);
    unadjustDart(oldDart);
    ListSequence.fromList(face.getDarts()).setElement(pos, dart);
    adjustDart(dart, face);

  }

  public void insertDart(Face face, int pos, Dart dart) {
    ListSequence.fromList(face.getDarts()).insertElement(pos, dart);
    adjustDart(dart, face);
  }

  public void addFirstDart(Face face, Dart dart) {
    insertDart(face, 0, dart);
  }

  public void addLastDart(Face face, Dart dart) {
    insertDart(face, ListSequence.fromList(face.getDarts()).count(), dart);
  }

  public List<Face> getFaces() {
    return this.myFaces;
  }

  public List<Face> getAdjacentFaces(Edge edge) {
    List<Face> faces = ListSequence.fromList(new ArrayList<Face>());
    ListSequence.fromList(faces).addSequence(ListSequence.fromList(getDarts(edge)).select(new ISelector<Dart, Face>() {
      public Face select(Dart dart) {
        return getFace(dart);
      }
    }));
    if (ListSequence.fromList(faces).count() == 0) {
      return null;
    }
    return faces;
  }

  public Set<Edge> getEdges() {
    return MapSequence.fromMap(myEdgeDarts).keySet();
  }

  public List<Dart> getDarts(Edge edge) {
    return MapSequence.fromMap(myEdgeDarts).get(edge);
  }

  public Dart getOpposite(final Dart dart) {
    return ListSequence.fromList(getDarts(dart.getEdge())).findFirst(new IWhereFilter<Dart>() {
      public boolean accept(Dart it) {
        return it != dart;
      }
    });
  }

  public Face getFace(Dart dart) {
    return MapSequence.fromMap(myDartsToFacesMap).get(dart);
  }

  public Graph getGraph() {
    return this.myGraph;
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    for (Face face : ListSequence.fromList(myFaces)) {
      builder.append(face + "\n");
    }
    builder.append("outer face has num: " + ListSequence.fromList(myFaces).indexOf(myOuterFace));
    return builder.toString();
  }

  public Face getOuterFace() {
    return this.myOuterFace;
  }

  public void setOuterFace(Face outerFace) {
    this.myOuterFace = outerFace;
  }

  public boolean isOuterFace(Face face) {
    return face == myOuterFace;
  }

  public Map<Edge, List<Edge>> getEdgesHistory() {
    return myEdgesHistory;
  }

  public void setEdgesHistory(Edge edge, List<Edge> newEdges) {
    MapSequence.fromMap(myEdgesHistory).put(edge, newEdges);
  }

  public List<Edge> findFullHistory(Edge edge) {
    List<Edge> fullHistory = ListSequence.fromList(new ArrayList<Edge>());
    List<Edge> history = MapSequence.fromMap(myEdgesHistory).get(edge);
    if (history == null) {
      ListSequence.fromList(fullHistory).addElement(edge);
    } else {
      for (Edge newEdge : ListSequence.fromList(history)) {
        ListSequence.fromList(fullHistory).addSequence(ListSequence.fromList(findFullHistory(newEdge)));
      }
    }
    if (!(ListSequence.fromList(ListSequence.fromList(fullHistory).first().getAdjacentNodes()).contains(edge.getSource()))) {
      fullHistory = ListSequence.fromList(fullHistory).reversedList();
    }
    return fullHistory;
  }
}
