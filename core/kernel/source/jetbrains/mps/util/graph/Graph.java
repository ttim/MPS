package jetbrains.mps.util.graph;

import jetbrains.mps.util.Pair;

import java.util.*;
import java.awt.Rectangle;

/**
 * Created by IntelliJ IDEA.
 * User: Cyril.Konopko
 * Date: 07.07.2006
 * Time: 19:51:21
 * To change this template use File | Settings | File Templates.
 */
public class Graph implements IGraph {
  Set<IEdge> myEdges = new HashSet<IEdge>();
  Set<IVertex> myVertices = new HashSet<IVertex>();
  Map<Pair<IVertex, IVertex>, IEdge> myVerticesToConnectingEdges = new HashMap<Pair<IVertex, IVertex>, IEdge>();

  public Set<IEdge> getEdges() {
    return new HashSet<IEdge>(myEdges);
  }

  public Set<IVertex> getVertices() {
    return new HashSet<IVertex>(myVertices);
  }

  public void addVertex(IVertex vertex) {
    myVertices.add(vertex);
  }

  public boolean connect(IVertex vertex1, IVertex vertex2) {
    if (!myVertices.contains(vertex1)) return false;
    if (!myVertices.contains(vertex2)) return false;
    boolean connected = isConnected(vertex1, vertex2);
    IEdge connectingEdge;
    if (connected) return false;
    connectingEdge = new Edge(vertex1, vertex2);
    myEdges.add(connectingEdge);
    myVerticesToConnectingEdges.put(new Pair<IVertex, IVertex>(vertex1, vertex2), connectingEdge);
    myVerticesToConnectingEdges.put(new Pair<IVertex, IVertex>(vertex2, vertex1), connectingEdge);
    return true;
  }

  public boolean isConnected(IVertex vertex1, IVertex vertex2) {
    IEdge connectingEdge = myVerticesToConnectingEdges.get(new Pair<IVertex, IVertex>(vertex1, vertex2));
    return connectingEdge != null;
  }


  public Pair<Integer, Integer> getBaricenter() {
    double x = 0;
    double y = 0;
    for (IVertex vertex : myVertices) {
      x = x + vertex.getX();
      y = y + vertex.getY();
    }
    int bcx = (int) x / myVertices.size();
    int bcy = (int) y / myVertices.size();
    return new Pair<Integer, Integer>(bcx,bcy);
  }

  public int getVerticesCount() {
    return myVertices.size();
  }

  public int getEdgesCount() {
    return myEdges.size();
  }

  public void move(int deltaX, int deltaY) {
    for (IVertex vertex : myVertices) {
      vertex.setCoords(vertex.getX() + deltaX, vertex.getY() + deltaY);
    }
  }

  public Rectangle getFramingRectangle() {
    double minx = 0;
    double miny = 0;
    double maxx = 0;
    double maxy = 0;
    boolean first = true;
    for (IVertex vertex : myVertices) {
      if (first) {
        minx = vertex.getX();
        maxx = vertex.getX();
        miny = vertex.getY();
        maxy = vertex.getY();
        first = false;
      } else {
        minx = Math.min(minx, vertex.getX());
        maxx = Math.max(maxx, vertex.getX());
        miny = Math.min(miny, vertex.getY());
        maxy = Math.max(maxy, vertex.getY());
      }
    }
    int x = (int) Math.round(minx);
    int y = (int) Math.round(miny);
    int width = (int) Math.round(maxx - minx);
    int height = (int) Math.round(maxy - miny);
    return new Rectangle(x, y, width, height);
  }

  public void setUpperLeftCorner(int x, int y) {
    Rectangle rect = getFramingRectangle();
    move(x - rect.x, y - rect.y);
  }
}
