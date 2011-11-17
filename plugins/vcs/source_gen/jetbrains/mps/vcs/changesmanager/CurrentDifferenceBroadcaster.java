package jetbrains.mps.vcs.changesmanager;

/*Generated by MPS */

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.baseLanguage.closures.runtime._FunctionTypes;
import jetbrains.mps.vcs.diff.changes.ModelChange;

/*package*/ class CurrentDifferenceBroadcaster implements CurrentDifferenceListener {
  protected static Log log = LogFactory.getLog(CurrentDifferenceBroadcaster.class);

  private List<CurrentDifferenceListener> myListeners = ListSequence.fromList(new ArrayList<CurrentDifferenceListener>());
  private SimpleCommandQueue myCommandQueue;

  public CurrentDifferenceBroadcaster(SimpleCommandQueue commandQueue) {
    myCommandQueue = commandQueue;
  }

  public void addDifferenceListener(@NotNull CurrentDifferenceListener listener) {
    synchronized (myListeners) {
      ListSequence.fromList(myListeners).addElement(listener);
    }
  }

  public void removeDifferenceListener(@NotNull CurrentDifferenceListener listener) {
    synchronized (myListeners) {
      ListSequence.fromList(myListeners).removeElement(listener);
    }
  }

  @NotNull
  private List<CurrentDifferenceListener> copyListeners() {
    synchronized (myListeners) {
      return ListSequence.fromListWithValues(new ArrayList<CurrentDifferenceListener>(), myListeners);
    }
  }

  private void fireEvent(String name, _FunctionTypes._void_P1_E0<? super CurrentDifferenceListener> task) {
    myCommandQueue.assertSoftlyIsCommandThread();
    for (CurrentDifferenceListener listener : ListSequence.fromList(copyListeners())) {
      try {
        task.invoke(listener);
      } catch (Throwable t) {
        if (log.isErrorEnabled()) {
          log.error("Exception on firing " + name + " event", t);
        }
      }
    }
  }

  public void changeAdded(@NotNull final ModelChange change) {
    fireEvent("changeAdded", new _FunctionTypes._void_P1_E0<CurrentDifferenceListener>() {
      public void invoke(CurrentDifferenceListener listener) {
        listener.changeAdded(change);
      }
    });
  }

  public void changeRemoved(@NotNull final ModelChange change) {
    fireEvent("changeRemoved", new _FunctionTypes._void_P1_E0<CurrentDifferenceListener>() {
      public void invoke(CurrentDifferenceListener listener) {
        listener.changeRemoved(change);
      }
    });
  }

  public void changeUpdateStarted() {
    fireEvent("changeUpdateStarted", new _FunctionTypes._void_P1_E0<CurrentDifferenceListener>() {
      public void invoke(CurrentDifferenceListener listener) {
        listener.changeUpdateStarted();
      }
    });
  }

  public void changeUpdateFinished() {
    fireEvent("changeUpdateFinished", new _FunctionTypes._void_P1_E0<CurrentDifferenceListener>() {
      public void invoke(CurrentDifferenceListener listener) {
        listener.changeUpdateFinished();
      }
    });
  }
}
