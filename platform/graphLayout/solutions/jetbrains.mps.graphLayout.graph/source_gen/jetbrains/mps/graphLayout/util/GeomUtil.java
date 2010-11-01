package jetbrains.mps.graphLayout.util;

/*Generated by MPS */

import jetbrains.mps.graphLayout.intGeom2D.Rectangle;
import jetbrains.mps.graphLayout.intGeom2D.Point;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import java.util.Map;
import jetbrains.mps.internal.collections.runtime.MapSequence;

public class GeomUtil {
  public static boolean insideOpenSegment(int end1, int end2, int mid) {
    return (mid - end1) * (mid - end2) < 0;
  }

  public static boolean insideClosedSegment(int end1, int end2, int mid) {
    return (mid - end1) * (mid - end2) <= 0;
  }

  public static Rectangle getRectangle(Point p1, Point p2) {
    int minX = Math.min(p1.x, p2.x);
    int minY = Math.min(p1.y, p2.y);
    int maxX = Math.max(p1.x, p2.x);
    int maxY = Math.max(p1.y, p2.y);
    return new Rectangle(minX, minY, maxX - minX, maxY - minY);
  }

  public static Rectangle getContainingRectangle(List<Point> points) {
    int minX = Integer.MAX_VALUE;
    int minY = Integer.MAX_VALUE;
    int maxX = Integer.MIN_VALUE;
    int maxY = Integer.MIN_VALUE;
    for (Point point : ListSequence.fromList(points)) {
      minX = Math.min(minX, point.x);
      minY = Math.min(minY, point.y);
      maxX = Math.max(maxX, point.x);
      maxY = Math.max(maxY, point.y);
    }
    return new Rectangle(minX, minY, maxX - minX, maxY - minY);
  }

  public static boolean onBorder(Point p, Rectangle rect) {
    boolean res = false;
    res |= p.x == rect.x && insideClosedSegment(rect.y, rect.y + rect.height, p.y);
    res |= p.x == rect.x + rect.width && insideClosedSegment(rect.y, rect.y + rect.height, p.y);
    res |= p.y == rect.y && insideClosedSegment(rect.x, rect.x + rect.width, p.x);
    res |= p.y == rect.y + rect.height && insideClosedSegment(rect.x, rect.x + rect.width, p.x);
    return res;
  }

  public static boolean contains(Rectangle rect, Point p) {
    return insideClosedSegment(rect.x, rect.x + rect.width, p.x) && insideClosedSegment(rect.y, rect.y + rect.height, p.y);
  }

  public static Point findOnBorder(Rectangle rect, Point p1, Point p2) {
    if (p1.x == p2.x) {
      if (insideClosedSegment(p1.y, p2.y, rect.y)) {
        return new Point(p1.x, rect.y);
      }
      if (insideClosedSegment(p1.y, p2.y, rect.y + rect.height)) {
        return new Point(p1.x, rect.y + rect.height);
      }
    }
    if (p1.y == p2.y) {
      if (insideClosedSegment(p1.x, p2.x, rect.x)) {
        return new Point(rect.x, p1.y);
      }
      if (insideClosedSegment(p1.x, p2.x, rect.x + rect.width)) {
        return new Point(rect.x + rect.width, p1.y);
      }
    }
    return null;
  }

  public static Point moveToBorder(Rectangle rect, Point b, Point e) {
    List<Point> rectPoints = ListSequence.fromList(new ArrayList<Point>());
    boolean ver = b.x == e.x;
    ListSequence.fromList(rectPoints).addElement(new Point(rect.x, rect.y));
    ListSequence.fromList(rectPoints).addElement(new Point(rect.x, rect.y + rect.height));
    ListSequence.fromList(rectPoints).addElement(new Point(rect.x + rect.width, rect.y));
    ListSequence.fromList(rectPoints).addElement(new Point(rect.x + rect.width, rect.y + rect.height));
    for (Point p : ListSequence.fromList(rectPoints)) {
      if (ver) {
        if (p.x == b.x && (p.y - b.y) * (p.y - e.y) < 0) {
          return p;
        }
      } else {
        if (p.y == b.y && (p.x - b.x) * (p.x - e.x) < 0) {
          return p;
        }
      }
    }
    return null;
  }

  public static boolean intersects(int minX, int maxX, int minY, int maxY) {
    return Math.min(maxX, maxY) >= Math.max(minX, minY);
  }

  public static Point pull(Point point, Point center, Map<Direction2D, Integer> shift) {
    int newX = point.x;
    if (point.x > center.x) {
      newX += MapSequence.fromMap(shift).get(Direction2D.RIGHT);
    }
    if (point.x < center.x) {
      newX -= MapSequence.fromMap(shift).get(Direction2D.LEFT);
    }
    int newY = point.y;
    if (point.y > center.y) {
      newY += MapSequence.fromMap(shift).get(Direction2D.UP);
    }
    if (point.y < center.y) {
      newY -= MapSequence.fromMap(shift).get(Direction2D.DOWN);
    }
    return new Point(newX, newY);
  }

  public static Direction2D getDirection(Point begin, Point end) {
    int dx = getDirection(begin.x, end.x);
    int dy = getDirection(begin.y, end.y);
    return Direction2D.getByShifts(dx, dy);
  }

  public static int getDirection(int begin, int end) {
    int direction = 0;
    if (begin > end) {
      direction = -1;
    }
    if (begin < end) {
      direction = 1;
    }
    return direction;
  }

  public static Point[] getCornerPoints(Rectangle rect) {
    Point[] points = new Point[4];
    points[0] = new Point(rect.x, rect.y);
    points[1] = new Point(rect.x, rect.y + rect.height);
    points[2] = new Point(rect.x + rect.width, rect.y + rect.height);
    points[3] = new Point(rect.x + rect.width, rect.y);
    return points;
  }

  public static int minCoord(Rectangle rect, Direction2D dir) {
    if (dir == Direction2D.RIGHT) {
      return rect.x;
    }
    if (dir == Direction2D.LEFT) {
      return rect.x + rect.width;
    }
    if (dir == Direction2D.UP) {
      return rect.y;
    }
    return rect.y + rect.height;
  }

  public static int maxCoord(Rectangle rect, Direction2D dir) {
    return minCoord(rect, dir.opposite());
  }

  public static int width(Rectangle rect, Direction2D dir) {
    if (dir.isHorizontal()) {
      return rect.width;
    } else {
      return rect.height;
    }
  }

  public static int height(Rectangle rect, Direction2D dir) {
    if (dir.isHorizontal()) {
      return rect.height;
    } else {
      return rect.width;
    }
  }

  public static boolean intersects(Rectangle rect, List<Point> polyline) {
    Point prev = null;
    for (Point cur : ListSequence.fromList(polyline)) {
      if (prev != null && rect.intersectsLine(prev, cur)) {
        return true;
      }
      prev = cur;
    }
    return false;
  }
}
