package jetbrains.mps.graphLayout.flowOrthogonalLayout;

/*Generated by MPS */

import jetbrains.mps.graphLayout.graph.Graph;
import jetbrains.mps.graphLayout.planarGraph.EmbeddedGraph;
import java.util.Map;
import jetbrains.mps.graphLayout.planarGraph.Dart;
import jetbrains.mps.graphLayout.intGeom2D.Direction2D;
import jetbrains.mps.graphLayout.graph.Node;
import jetbrains.mps.graphLayout.planarGraph.Face;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import java.util.HashMap;
import jetbrains.mps.graphLayout.graph.Edge;
import jetbrains.mps.internal.collections.runtime.Sequence;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.SetSequence;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import java.util.Arrays;
import jetbrains.mps.internal.collections.runtime.backports.LinkedList;
import java.util.Iterator;
import java.util.Set;
import java.util.HashSet;
import jetbrains.mps.internal.collections.runtime.ITranslator2;

public class EmbeddedGraphModifier {
  private static int SHOW_LOG = 0;

  private Graph myGraph;
  private EmbeddedGraph myEmbeddedGraph;
  private Map<Dart, Direction2D> myDartDirections;
  private Map<Node, Node[]> myCornerNodes;
  private Map<Node, Face> myNodeFaces;

  public EmbeddedGraphModifier(EmbeddedGraph embeddedGraph) {
    myGraph = embeddedGraph.getGraph();
    myEmbeddedGraph = embeddedGraph;
    myCornerNodes = MapSequence.fromMap(new HashMap<Node, Node[]>());
    myNodeFaces = MapSequence.fromMap(new HashMap<Node, Face>());
  }

  public void setDartDirections(Map<Dart, Direction2D> dartDirections) {
    myDartDirections = dartDirections;
  }

  public Map<Edge, Edge> makeRectanglesForNodes(Iterable<Node> nodesToProcess) {
    Map<Edge, Edge> modifiedEdges = MapSequence.fromMap(new HashMap<Edge, Edge>());
    for (Node node : Sequence.fromIterable(nodesToProcess)) {
      MapSequence.fromMap(myCornerNodes).put(node, new Node[4]);
      makeRectangleForSingleNode(node, modifiedEdges);
      if (SHOW_LOG > 0) {
        System.out.println("corner nodes for node " + node + ":");
        for (Direction2D dir : Direction2D.values()) {
          System.out.println(dir + " = " + MapSequence.fromMap(myCornerNodes).get(node)[dir.ordinal()]);
        }
      }
    }
    return modifiedEdges;
  }

  public Map<Edge, Edge> makeRectanglesForNodes(Map<Node, List<Node>> nodesToProcess) {
    Map<Edge, Edge> modifiedEdges = MapSequence.fromMap(new HashMap<Edge, Edge>());
    for (Node node : SetSequence.fromSet(MapSequence.fromMap(nodesToProcess).keySet())) {
      MapSequence.fromMap(myCornerNodes).put(node, new Node[4]);
      List<Node> nodes = MapSequence.fromMap(nodesToProcess).get(node);
      if ((int) ListSequence.fromList(nodes).count() == 0) {
        makeRectangleForSingleNode(node, modifiedEdges);
      } else {
        makeRectangleForSplittedNode(node, MapSequence.fromMap(nodesToProcess).get(node));
      }
      if (SHOW_LOG > 0) {
        System.out.println("corner nodes for node " + node + ":");
        for (Direction2D dir : Direction2D.values()) {
          System.out.println(dir + " = " + MapSequence.fromMap(myCornerNodes).get(node)[dir.ordinal()]);
        }
      }
    }
    return modifiedEdges;
  }

  public void makerInnerFaces() {
    for (Node node : SetSequence.fromSet(MapSequence.fromMap(myCornerNodes).keySet())) {
      makeInnerFace(node);
    }
  }

  private void makeInnerFace(Node node) {
    Node[] nodes = MapSequence.fromMap(myCornerNodes).get(node);
    Face face = MapSequence.fromMap(myNodeFaces).get(node);
    for (int intDir = 0; intDir < 4; intDir++) {
      Node cur = nodes[intDir];
      Node next;
      if (intDir == 3) {
        next = nodes[0];
      } else {
        next = nodes[intDir + 1];
      }
      Edge newEdge = myGraph.connect(cur, next);
      myEmbeddedGraph.splitFace(face, ListSequence.fromListAndArray(new ArrayList<Edge>(), newEdge), cur, next);
      Dart dart = myEmbeddedGraph.getSourceDart(newEdge, cur);
      MapSequence.fromMap(myDartDirections).put(dart, Direction2D.get(intDir));
      MapSequence.fromMap(myDartDirections).put(myEmbeddedGraph.getOpposite(dart), Direction2D.get(intDir).opposite());
      face = myEmbeddedGraph.getFace(dart);
    }
    MapSequence.fromMap(myNodeFaces).put(node, face);
  }

  public void makeRectangleForSplittedNode(Node node, final List<Node> nodes) {
    final Wrappers._T<Node> prev = new Wrappers._T<Node>(ListSequence.fromList(nodes).getElement(ListSequence.fromList(nodes).count() - 2));
    final Wrappers._T<Node> cur = new Wrappers._T<Node>(ListSequence.fromList(nodes).getElement(ListSequence.fromList(nodes).count() - 1));
    Edge prevToCurEdge = ListSequence.fromList(prev.value.getEdges()).findFirst(new IWhereFilter<Edge>() {
      public boolean accept(Edge edge) {
        return edge.getOpposite(prev.value) == cur.value;
      }
    });
    Map<Edge, Integer> toSplit = MapSequence.fromMap(new HashMap<Edge, Integer>());
    for (final Node next : ListSequence.fromList(nodes)) {
      Edge curToNextEdge = ListSequence.fromList(cur.value.getEdges()).findFirst(new IWhereFilter<Edge>() {
        public boolean accept(Edge edge) {
          return edge.getOpposite(cur.value) == next;
        }
      });
      Dart prevToCurDart = myEmbeddedGraph.getSourceDart(prevToCurEdge, prev.value);
      Dart curToNextDart = myEmbeddedGraph.getSourceDart(curToNextEdge, cur.value);
      if (!(MapSequence.fromMap(myNodeFaces).containsKey(node))) {
        MapSequence.fromMap(myNodeFaces).put(node, myEmbeddedGraph.getFace(prevToCurDart));
      }
      Direction2D prevToCurDir = MapSequence.fromMap(myDartDirections).get(prevToCurDart);
      Direction2D curToNextDir = MapSequence.fromMap(myDartDirections).get(curToNextDart);
      if (prevToCurDir != curToNextDir) {
        Edge curRealEdge = ListSequence.fromList(cur.value.getEdges()).findFirst(new IWhereFilter<Edge>() {
          public boolean accept(Edge edge) {
            return !(ListSequence.fromList(nodes).contains(edge.getOpposite(cur.value)));
          }
        });
        Dart curRealDart = myEmbeddedGraph.getSourceDart(curRealEdge, cur.value);
        Edge edgeToSplit;
        if (MapSequence.fromMap(myDartDirections).get(curRealDart) == prevToCurDir) {
          edgeToSplit = prevToCurEdge;
        } else {
          edgeToSplit = curToNextEdge;
        }
        if (MapSequence.fromMap(toSplit).containsKey(edgeToSplit)) {
          MapSequence.fromMap(toSplit).put(edgeToSplit, MapSequence.fromMap(toSplit).get(edgeToSplit) + 1);
        } else {
          MapSequence.fromMap(toSplit).put(edgeToSplit, 1);
        }
      }
      prev.value = cur.value;
      cur.value = next;
      prevToCurEdge = curToNextEdge;
    }
    for (Edge edge : SetSequence.fromSet(MapSequence.fromMap(toSplit).keySet())) {
      int splitNum = MapSequence.fromMap(toSplit).get(edge);
      final Wrappers._T<Edge> curEdge = new Wrappers._T<Edge>(edge);
      Direction2D curDirection = null;
      for (int i = 0; i < splitNum; i++) {
        List<Dart> toRemove = ListSequence.fromList(new ArrayList<Dart>());
        ListSequence.fromList(toRemove).addSequence(ListSequence.fromList(myEmbeddedGraph.getDarts(curEdge.value)));
        if (curDirection == null) {
          final Node curSource = curEdge.value.getSource();
          Edge realEdge = ListSequence.fromList(curSource.getEdges()).findFirst(new IWhereFilter<Edge>() {
            public boolean accept(Edge edge) {
              return !(ListSequence.fromList(nodes).contains(edge.getOpposite(curSource)));
            }
          });
          curDirection = MapSequence.fromMap(myDartDirections).get(myEmbeddedGraph.getSourceDart(realEdge, curSource)).turnClockwise(1);
        }
        List<Edge> newEdges = ListSequence.fromList(new ArrayList<Edge>());
        Node newNode = myEmbeddedGraph.splitEdge(curEdge.value, newEdges);
        Dart firstDart = ListSequence.fromList(myEmbeddedGraph.getDarts(ListSequence.fromList(newEdges).getElement(0))).findFirst(new IWhereFilter<Dart>() {
          public boolean accept(Dart dart) {
            return dart.getSource() == curEdge.value.getSource();
          }
        });
        MapSequence.fromMap(myDartDirections).put(firstDart, curDirection);
        MapSequence.fromMap(myDartDirections).put(myEmbeddedGraph.getOpposite(firstDart), curDirection.opposite());
        Dart secondDart = ListSequence.fromList(myEmbeddedGraph.getDarts(ListSequence.fromList(newEdges).getElement(1))).findFirst(new IWhereFilter<Dart>() {
          public boolean accept(Dart dart) {
            return dart.getTarget() == curEdge.value.getTarget();
          }
        });
        Direction2D nextDirection = curDirection.turnClockwise(1);
        MapSequence.fromMap(myCornerNodes).get(node)[nextDirection.ordinal()] = newNode;
        MapSequence.fromMap(myDartDirections).put(secondDart, nextDirection);
        MapSequence.fromMap(myDartDirections).put(myEmbeddedGraph.getOpposite(secondDart), nextDirection.opposite());
        for (Dart dartToRemove : ListSequence.fromList(toRemove)) {
          MapSequence.fromMap(myDartDirections).removeKey(dartToRemove);
        }
        curEdge.value = ListSequence.fromList(newEdges).getElement(1);
        curDirection = nextDirection;
      }
    }
  }

  public void makeRectangleForSingleNode(Node node, Map<Edge, Edge> modifiedEdges) {
    List<Direction2D> allDirections = Arrays.asList(Direction2D.values());
    List<Dart> darts = myEmbeddedGraph.getDartWithSource(node);
    Face nodeInnerFace = new Face(myGraph);
    Node firstCornerNode = myGraph.createDummyNode();
    Node curCornerNode = firstCornerNode;
    Map<Dart, Edge> edgesFromNode = MapSequence.fromMap(new HashMap<Dart, Edge>());
    List<Dart> nodeOuterDarts = ListSequence.fromList(new LinkedList<Dart>());
    for (final Direction2D dir : ListSequence.fromList(allDirections)) {
      MapSequence.fromMap(myCornerNodes).get(node)[dir.turnClockwise(1).ordinal()] = curCornerNode;
      Node nextCornerNode;
      if (dir == ListSequence.fromList(allDirections).last()) {
        nextCornerNode = firstCornerNode;
      } else {
        nextCornerNode = myGraph.createDummyNode();
      }
      Dart dirDart = ListSequence.fromList(darts).findFirst(new IWhereFilter<Dart>() {
        public boolean accept(Dart dart) {
          return MapSequence.fromMap(myDartDirections).get(dart) == dir;
        }
      });
      if (dirDart == null) {
        addToNodeFace(nodeInnerFace, myGraph.connect(curCornerNode, nextCornerNode), dir, nodeOuterDarts);
      } else {
        Node newNode = myGraph.createDummyNode();
        MapSequence.fromMap(edgesFromNode).put(dirDart, myGraph.connect(newNode, dirDart.getTarget()));
        addToNodeFace(nodeInnerFace, myGraph.connect(curCornerNode, newNode), dir, nodeOuterDarts);
        addToNodeFace(nodeInnerFace, myGraph.connect(newNode, nextCornerNode), dir, nodeOuterDarts);
      }
      curCornerNode = nextCornerNode;
    }
    Map<Dart, Edge> endEdges = MapSequence.fromMap(new HashMap<Dart, Edge>());
    for (Dart dart : ListSequence.fromList(darts)) {
      MapSequence.fromMap(modifiedEdges).put(dart.getEdge(), MapSequence.fromMap(edgesFromNode).get(dart));
      List<Dart> faceDarts = myEmbeddedGraph.getFace(dart).getDarts();
      int prevIndex = ListSequence.fromList(faceDarts).indexOf(dart) - 1;
      if (prevIndex == -1) {
        prevIndex = ListSequence.fromList(faceDarts).count() - 1;
      }
      MapSequence.fromMap(endEdges).put(dart, MapSequence.fromMap(edgesFromNode).get(myEmbeddedGraph.getOpposite(ListSequence.fromList(faceDarts).getElement(prevIndex))));
    }
    for (Dart dart : ListSequence.fromList(darts)) {
      Face face = myEmbeddedGraph.getFace(dart);
      List<Dart> faceDarts = face.getDarts();
      int dartIndex = ListSequence.fromList(faceDarts).indexOf(dart);
      int prevIndex = dartIndex - 1;
      if (prevIndex == -1) {
        prevIndex = ListSequence.fromList(faceDarts).count() - 1;
      }
      Dart prevDart = ListSequence.fromList(faceDarts).getElement(prevIndex);
      Edge startEdge = MapSequence.fromMap(edgesFromNode).get(dart);
      Edge endEdge = MapSequence.fromMap(endEdges).get(dart);
      Node start = startEdge.getSource();
      Node end = endEdge.getSource();
      List<Dart> newDarts = ListSequence.fromList(new LinkedList<Dart>());
      Iterator<Dart> dartItr = ListSequence.fromList(nodeOuterDarts).iterator();
      Dart cur;
      do {
        cur = dartItr.next();
      } while (cur.getTarget() != start);
      do {
        ListSequence.fromList(newDarts).insertElement(0, cur);
        if (!(dartItr.hasNext())) {
          dartItr = ListSequence.fromList(nodeOuterDarts).iterator();
        }
        cur = dartItr.next();
      } while (cur.getTarget() != end);
      Dart newStartDart = new Dart(startEdge, start);
      ListSequence.fromList(newDarts).addElement(newStartDart);
      MapSequence.fromMap(myDartDirections).put(newStartDart, MapSequence.fromMap(myDartDirections).get(dart));
      Dart newEndDart = new Dart(endEdge, endEdge.getTarget());
      ListSequence.fromList(newDarts).insertElement(0, newEndDart);
      MapSequence.fromMap(myDartDirections).put(newEndDart, MapSequence.fromMap(myDartDirections).get(prevDart));
      myEmbeddedGraph.removeDart(face, dart);
      face.makeEndsWith(prevDart);
      myEmbeddedGraph.removeDart(face, prevDart);
      for (Dart newDart : ListSequence.fromList(newDarts)) {
        myEmbeddedGraph.addLastDart(face, newDart);
      }
      MapSequence.fromMap(myDartDirections).removeKey(dart);
      MapSequence.fromMap(myDartDirections).removeKey(prevDart);
    }
    MapSequence.fromMap(myNodeFaces).put(node, nodeInnerFace);
    myEmbeddedGraph.addFace(nodeInnerFace);
    myGraph.deleteNode(node);
  }

  private void addToNodeFace(Face nodeFace, Edge edge, Direction2D dir, List<Dart> outerDarts) {
    Dart innerDart = new Dart(edge, edge.getSource());
    nodeFace.addLast(innerDart);
    MapSequence.fromMap(myDartDirections).put(innerDart, dir.turnClockwise(1));
    Dart outerDart = new Dart(edge, edge.getTarget());
    MapSequence.fromMap(myDartDirections).put(outerDart, MapSequence.fromMap(myDartDirections).get(innerDart).opposite());
    ListSequence.fromList(outerDarts).addElement(outerDart);
  }

  public Set<Edge> reduceNodesDegree(Map<Node, List<Node>> nodeMap, Map<Edge, Edge> edgeMap) {
    return reduceNodesDegree(nodeMap, edgeMap, false);
  }

  public Set<Edge> reduceNodesDegree(Map<Node, List<Node>> nodeMap, Map<Edge, Edge> edgeMap, boolean splitAllNodes) {
    Set<Edge> addedEdges = SetSequence.fromSet(new HashSet<Edge>());
    List<Node> realNodes = ListSequence.fromList(new ArrayList<Node>());
    ListSequence.fromList(realNodes).addSequence(ListSequence.fromList(myGraph.getNodes()));
    for (final Node node : ListSequence.fromList(realNodes)) {
      List<Edge> edges = node.getEdges();
      if (!(splitAllNodes) && ListSequence.fromList(edges).count() <= 4) {
        continue;
      }
      List<Node> newNodes = ListSequence.fromList(new ArrayList<Node>());
      MapSequence.fromMap(nodeMap).put(node, newNodes);
      Edge firstEdge = ListSequence.fromList(edges).first();
      Dart firstDart = ListSequence.fromList(myEmbeddedGraph.getDarts(firstEdge)).findFirst(new IWhereFilter<Dart>() {
        public boolean accept(Dart dart) {
          return dart.getSource() == node;
        }
      });
      Dart curDart = firstDart;
      Node firstNewNode = myGraph.createDummyNode();
      Node curNewNode = firstNewNode;
      Edge firstNewEdge = myGraph.connect(firstNewNode, firstEdge.getOpposite(node));
      if (firstEdge.getSource() == node) {
        myGraph.removeEdge(firstEdge);
      }
      ListSequence.fromList(newNodes).addElement(firstNewNode);
      MapSequence.fromMap(edgeMap).put(firstEdge, firstNewEdge);
      Edge curNewEdge = firstNewEdge;
      Face newFace = new Face(myGraph);
      do {
        Face curFace = myEmbeddedGraph.getFace(curDart);
        List<Dart> darts = curFace.getDarts();
        int curPos = ListSequence.fromList(darts).indexOf(curDart);
        int nextPos = curPos - 1;
        if (nextPos == -1) {
          nextPos = ListSequence.fromList(darts).count() - 1;
        }
        Dart nextDart = myEmbeddedGraph.getOpposite(ListSequence.fromList(darts).getElement(nextPos));
        if (nextDart == null) {
          nextDart = firstDart;
        }
        Node oppositeNode = nextDart.getEdge().getOpposite(node);
        Node nextNewNode;
        if (nextDart == firstDart) {
          nextNewNode = firstNewNode;
        } else {
          nextNewNode = myGraph.createDummyNode();
          ListSequence.fromList(newNodes).addElement(nextNewNode);
        }
        Edge nextNewEdge;
        if (nextDart == firstDart) {
          nextNewEdge = firstNewEdge;
        } else {
          nextNewEdge = myGraph.connect(nextNewNode, oppositeNode);
          if (firstEdge.getSource() == node) {
            myGraph.removeEdge(firstEdge);
          }
          MapSequence.fromMap(edgeMap).put(nextDart.getEdge(), nextNewEdge);
        }
        Edge edgeBetweenNewNodes = myGraph.connect(curNewNode, nextNewNode);
        SetSequence.fromSet(addedEdges).addElement(edgeBetweenNewNodes);
        newFace.addLast(new Dart(edgeBetweenNewNodes, curNewNode));
        myEmbeddedGraph.setDart(curFace, nextPos, new Dart(nextNewEdge, oppositeNode));
        myEmbeddedGraph.setDart(curFace, curPos, new Dart(curNewEdge, curNewNode));
        myEmbeddedGraph.insertDart(curFace, nextPos + 1, new Dart(edgeBetweenNewNodes, nextNewNode));
        curDart = nextDart;
        curNewNode = nextNewNode;
        curNewEdge = nextNewEdge;
      } while (curDart != firstDart);
      myEmbeddedGraph.addFace(newFace);
      myGraph.deleteNode(node);
    }
    // edge has been modified two times 
    for (Edge edge : SetSequence.fromSet(MapSequence.fromMap(edgeMap).keySet())) {
      Edge newEdge = MapSequence.fromMap(edgeMap).get(edge);
      if (MapSequence.fromMap(edgeMap).containsKey(newEdge)) {
        MapSequence.fromMap(edgeMap).put(edge, MapSequence.fromMap(edgeMap).get(newEdge));
      }
    }
    return addedEdges;
  }

  public void makeRectangularFaces() {
    List<Face> faces = ListSequence.fromList(new ArrayList<Face>());
    ListSequence.fromList(faces).addSequence(ListSequence.fromList(myEmbeddedGraph.getFaces()));
    for (Face face : ListSequence.fromList(faces)) {
      if (myEmbeddedGraph.isOuterFace(face)) {
        continue;
      }
      makeFaceRectangle(face);
    }
  }

  public void makeFaceRectangle(Face face) {
    Dart badDart = null;
    List<Dart> darts = face.getDarts();
    Iterator<Dart> dartItr = ListSequence.fromList(darts).iterator();
    Dart prev = ListSequence.fromList(darts).last();
    int sum = 0;
    while (dartItr.hasNext() && badDart == null) {
      Dart cur = dartItr.next();
      int turn = MapSequence.fromMap(myDartDirections).get(prev).getTurn(MapSequence.fromMap(myDartDirections).get(cur));
      if (turn < 0) {
        badDart = prev;
        sum = turn;
      }
      prev = cur;
    }
    while (sum != 1) {
      if (!(dartItr.hasNext())) {
        dartItr = ListSequence.fromList(darts).iterator();
      }
      Dart cur = dartItr.next();
      sum += MapSequence.fromMap(myDartDirections).get(prev).getTurn(MapSequence.fromMap(myDartDirections).get(cur));
      prev = cur;
    }
    if (badDart != null) {
      List<Edge> newEdges = ListSequence.fromList(new ArrayList<Edge>());
      Dart prevOpposite = myEmbeddedGraph.getOpposite(prev);
      Node newNode = myEmbeddedGraph.splitEdge(prev.getEdge(), newEdges);
      for (Edge newEdge : ListSequence.fromList(newEdges)) {
        for (Dart newDart : ListSequence.fromList(myEmbeddedGraph.getDarts(newEdge))) {
          if (myEmbeddedGraph.getFace(newDart) == face) {
            MapSequence.fromMap(myDartDirections).put(newDart, MapSequence.fromMap(myDartDirections).get(prev));
          } else {
            MapSequence.fromMap(myDartDirections).put(newDart, MapSequence.fromMap(myDartDirections).get(prev).opposite());
          }
        }
      }
      MapSequence.fromMap(myDartDirections).removeKey(prev);
      MapSequence.fromMap(myDartDirections).removeKey(prevOpposite);
      Node badCorner = badDart.getTarget();
      Edge splitEdge = myGraph.connect(badCorner, newNode);
      List<Face> newFaces = myEmbeddedGraph.splitFace(face, ListSequence.fromListAndArray(new ArrayList<Edge>(), splitEdge), badCorner, newNode);
      for (Dart dart : ListSequence.fromList(myEmbeddedGraph.getDarts(splitEdge))) {
        if (dart.getSource() == badCorner) {
          MapSequence.fromMap(myDartDirections).put(dart, MapSequence.fromMap(myDartDirections).get(badDart));
        } else {
          MapSequence.fromMap(myDartDirections).put(dart, MapSequence.fromMap(myDartDirections).get(badDart).opposite());
        }
      }
      for (Face newFace : ListSequence.fromList(newFaces)) {
        makeFaceRectangle(newFace);
      }
    }
  }

  public void connectSpecialNodes(Iterable<Node> specialNodes) {
    // can be used only if all faces are rectangular 
    List<Face> oldFaces = ListSequence.fromList(new ArrayList<Face>());
    ListSequence.fromList(oldFaces).addSequence(ListSequence.fromList(myEmbeddedGraph.getFaces()));
    ListSequence.fromList(oldFaces).removeElement(myEmbeddedGraph.getOuterFace());
    for (Face face : ListSequence.fromList(oldFaces)) {
      connectSpecialNodesInFace(face, specialNodes);
    }
  }

  private void connectSpecialNodesInFace(Face face, Iterable<Node> specialNodes) {
    List<Dart> darts = face.getDarts();
    Direction2D prevDir = MapSequence.fromMap(myDartDirections).get(ListSequence.fromList(darts).last());
    Node node = null;
    Direction2D dir = null;
    Dart dartToSplit = null;
    for (Dart dart : ListSequence.fromList(darts)) {
      node = dart.getSource();
      dir = MapSequence.fromMap(myDartDirections).get(dart);
      if (Sequence.fromIterable(specialNodes).contains(node) && prevDir == dir) {
        Direction2D opposite = MapSequence.fromMap(myDartDirections).get(dart).opposite();
        List<Dart> oppositeDarts = getDirectionDarts(face, opposite);
        if ((int) ListSequence.fromList(oppositeDarts).count() == 1) {
          dartToSplit = ListSequence.fromList(oppositeDarts).first();
          break;
        }
      }
      prevDir = dir;
    }
    if (dartToSplit != null) {
      Edge edgeToSplit = dartToSplit.getEdge();
      for (Dart dart : ListSequence.fromList(myEmbeddedGraph.getDarts(edgeToSplit))) {
        MapSequence.fromMap(myDartDirections).removeKey(dart);
      }
      List<Edge> newEdges = ListSequence.fromList(new ArrayList<Edge>());
      Node newNode = myEmbeddedGraph.splitEdge(edgeToSplit, newEdges);
      for (Dart dart : ListSequence.fromList(newEdges).translate(new ITranslator2<Edge, Dart>() {
        public Iterable<Dart> translate(Edge it) {
          return myEmbeddedGraph.getDarts(it);
        }
      })) {
        if (myEmbeddedGraph.getFace(dart) == face) {
          MapSequence.fromMap(myDartDirections).put(dart, dir.opposite());
        } else {
          MapSequence.fromMap(myDartDirections).put(dart, dir);
        }
      }
      Edge splittingEdge = myGraph.connect(node, newNode);
      List<Face> newFaces = myEmbeddedGraph.splitFace(face, ListSequence.fromListAndArray(new ArrayList<Edge>(), splittingEdge), node, newNode);
      for (Dart dart : ListSequence.fromList(myEmbeddedGraph.getDarts(splittingEdge))) {
        if (dart.getSource() == node) {
          MapSequence.fromMap(myDartDirections).put(dart, dir.turnClockwise(1));
        } else {
          MapSequence.fromMap(myDartDirections).put(dart, dir.turnClockwise(1).opposite());
        }
      }
      for (Face newFace : ListSequence.fromList(newFaces)) {
        connectSpecialNodesInFace(newFace, specialNodes);
      }
    }
  }

  private List<Dart> getDirectionDarts(Face face, Direction2D direction) {
    List<Dart> directionDarts = ListSequence.fromList(new LinkedList<Dart>());
    List<Dart> darts = face.getDarts();
    Iterator<Dart> dartItr = ListSequence.fromList(darts).iterator();
    Dart cur = dartItr.next();
    while (dartItr.hasNext() && MapSequence.fromMap(myDartDirections).get(cur) != direction) {
      cur = dartItr.next();
    }
    while (MapSequence.fromMap(myDartDirections).get(cur) == direction) {
      ListSequence.fromList(directionDarts).addElement(cur);
      if (!(dartItr.hasNext())) {
        dartItr = ListSequence.fromList(darts).iterator();
      }
      cur = dartItr.next();
    }
    return directionDarts;
  }

  public EmbeddedGraph getEmbeddedGraph() {
    return myEmbeddedGraph;
  }

  public Map<Dart, Direction2D> getDartDirections() {
    return myDartDirections;
  }

  public Face getNodeFace(Node node) {
    return MapSequence.fromMap(myNodeFaces).get(node);
  }

  public Node[] getCornerNodes(Node node) {
    return MapSequence.fromMap(myCornerNodes).get(node);
  }

  public Map<Node, Face> getNodeFaces() {
    return myNodeFaces;
  }
}
