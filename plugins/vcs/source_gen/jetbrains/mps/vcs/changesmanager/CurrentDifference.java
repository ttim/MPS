package jetbrains.mps.vcs.changesmanager;

/*Generated by MPS */

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import jetbrains.mps.smodel.descriptor.EditableSModelDescriptor;
import jetbrains.mps.vcs.diff.ChangeSetImpl;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.project.Project;
import jetbrains.mps.baseLanguage.closures.runtime._FunctionTypes;
import jetbrains.mps.vcs.diff.changes.ModelChange;
import jetbrains.mps.internal.collections.runtime.IVisitor;
import org.jetbrains.annotations.Nullable;
import jetbrains.mps.vcs.diff.ChangeSet;

public class CurrentDifference {
  protected static Log log = LogFactory.getLog(CurrentDifference.class);

  private SimpleCommandQueue myCommandQueue;
  private EditableSModelDescriptor myModelDescriptor;
  private ChangesTracking myTracking;
  private ChangeSetImpl myChangeSet;
  private List<CurrentDifferenceListener> myListeners = ListSequence.fromList(new ArrayList<CurrentDifferenceListener>());
  private boolean myEnabled = false;

  public CurrentDifference(@NotNull Project project, @NotNull EditableSModelDescriptor modelDescriptor) {
    myCommandQueue = CurrentDifferenceRegistry.getInstance(project).getCommandQueue();
    myModelDescriptor = modelDescriptor;
    myTracking = new ChangesTracking(project, this);
  }

  public void dispose() {
    myTracking.dispose();
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

  private void fireChangeAdded(@NotNull final ModelChange change) {
    fireEvent("changeAdded", new _FunctionTypes._void_P1_E0<CurrentDifferenceListener>() {
      public void invoke(CurrentDifferenceListener listener) {
        listener.changeAdded(change);
      }
    });
  }

  private void fireChangeRemoved(@NotNull final ModelChange change) {
    fireEvent("changeRemoved", new _FunctionTypes._void_P1_E0<CurrentDifferenceListener>() {
      public void invoke(CurrentDifferenceListener listener) {
        listener.changeRemoved(change);
      }
    });
  }

  private void fireChangeUpdateStarted() {
    fireEvent("changeUpdateStarted", new _FunctionTypes._void_P1_E0<CurrentDifferenceListener>() {
      public void invoke(CurrentDifferenceListener listener) {
        listener.changeUpdateStarted();
      }
    });
  }

  private void fireChangeUpdateFinished() {
    fireEvent("changeUpdateFinished", new _FunctionTypes._void_P1_E0<CurrentDifferenceListener>() {
      public void invoke(CurrentDifferenceListener listener) {
        listener.changeUpdateFinished();
      }
    });
  }

  /*package*/ void removeChangeSet() {
    myCommandQueue.assertSoftlyIsCommandThread();
    if (myChangeSet != null) {
      fireChangeUpdateStarted();
      ListSequence.fromList(myChangeSet.getModelChanges()).visitAll(new IVisitor<ModelChange>() {
        public void visit(ModelChange ch) {
          fireChangeRemoved(ch);
        }
      });
      fireChangeUpdateFinished();
      myChangeSet = null;
    }
  }

  /*package*/ void setChangeSet(@NotNull ChangeSetImpl changeSetImpl) {
    myCommandQueue.assertSoftlyIsCommandThread();
    removeChangeSet();
    myChangeSet = changeSetImpl;
    fireChangeUpdateStarted();
    ListSequence.fromList(myChangeSet.getModelChanges()).visitAll(new IVisitor<ModelChange>() {
      public void visit(ModelChange ch) {
        fireChangeAdded(ch);
      }
    });
    fireChangeUpdateFinished();
  }

  /*package*/ EditableSModelDescriptor getModelDescriptor() {
    return myModelDescriptor;
  }

  /*package*/ ChangesTracking getChangesTracker() {
    return myTracking;
  }

  /*package*/ boolean isEnabled() {
    return myEnabled;
  }

  public void setEnabled(boolean enabled) {
    if (myEnabled != enabled) {
      myEnabled = enabled;
      if (enabled) {
        myTracking.scheduleFullUpdate();
      } else {
        myCommandQueue.addTask(new Runnable() {
          public void run() {
            setChangeSet(null);
          }
        });
      }
    }
  }

  @Nullable
  public ChangeSet getChangeSet() {
    return myChangeSet;
  }
}
