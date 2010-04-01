package jetbrains.mps.core.baseLanguage.constructors.sandbox.test;

/*Generated by MPS */

import java.awt.geom.Rectangle2D;
import java.awt.geom.Point2D;
import java.util.LinkedList;
import java.util.List;

public class RectangleConstructors {
  public RectangleConstructors() {
  }

  public static Rectangle2D rectConstruct(Point2D a, Point2D b) {
    Rectangle2D result = new Rectangle2D.Double();
    result.setRect(a.getX(), a.getY(), b.getX() - a.getX(), b.getY() - a.getY());
    return result;
  }

  public static Point2D pointConstructor(double a, double b) {
    Point2D.Double res = new Point2D.Double(a, b);
    return res;
  }

  public static LinkedList listConstructor(List<Integer> fds) {
    LinkedList<Integer> result = new LinkedList<Integer>(fds);
    return result;
  }
}
