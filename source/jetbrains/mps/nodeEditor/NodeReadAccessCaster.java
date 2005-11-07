package jetbrains.mps.nodeEditor;

import jetbrains.mps.logging.Logger;
import jetbrains.mps.smodel.SNode;

import java.util.Set;
import java.util.Stack;

/**
 * Created by IntelliJ IDEA.
 * User: Cyril.Konopko
 * Date: 23.09.2005
 * Time: 21:22:56
 * To change this template use File | Settings | File Templates.
 */
public class NodeReadAccessCaster {
  private static Stack<CellBuildNodeAccessListener> myReadAccessListenerStack = new Stack<CellBuildNodeAccessListener>();
  private static CellBuildNodeAccessListener myReadAccessListener;
  private static Logger LOG = Logger.getLogger(NodeReadAccessCaster.class);
  private static Thread myThread;

  private static final Object READ_LOCK = new Object();

  public static void setNodeReadAccessListener(CellBuildNodeAccessListener listener) {
    ensureNoConcurrentAccess();
    if (myReadAccessListener == null) {
      myThread = Thread.currentThread();
    } else {
      myReadAccessListenerStack.push(myReadAccessListener);
    }
    myReadAccessListener = listener;
  }

  public static void removeNodeAccessListener() {
    ensureNoConcurrentAccess();
    if (myReadAccessListenerStack.isEmpty()) {
      myReadAccessListener = null;
      myThread = null;
      synchronized (READ_LOCK) {
        READ_LOCK.notifyAll();
//        System.out.println("-- notifyAll " + Thread.currentThread().getName());
      }
    } else {
      Set<SNode> nodesWhichChildCellDependsOn = myReadAccessListener.getNodesToDependOn();
      myReadAccessListener = myReadAccessListenerStack.pop();
      myReadAccessListener.addNodesToDependOn(nodesWhichChildCellDependsOn);
    }
  }

  public static void fireNodeReadAccessed(SNode node) {
    ensureNoConcurrentAccess();
    if (myReadAccessListener != null) myReadAccessListener.readAccess(node);
  }

  private static void ensureNoConcurrentAccess() {
    if (myThread != null) {
      if (myThread == Thread.currentThread()) return;
      try {
        synchronized (READ_LOCK) {
          while (myThread != null) {
//            System.out.println(">> in trap " + Thread.currentThread().getName());
            READ_LOCK.wait();
//            System.out.println(">> out trap " + Thread.currentThread().getName());
          }
        }
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
  }
}
