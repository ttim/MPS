package jetbrains.mps.vcs.changesmanager;

/*Generated by MPS */

import com.intellij.openapi.components.AbstractProjectComponent;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.ArrayList;
import java.util.Map;
import jetbrains.mps.smodel.SNodePointer;
import com.intellij.openapi.vcs.FileStatus;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import java.util.HashMap;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.project.Project;
import jetbrains.mps.smodel.SNode;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.smodel.SModelDescriptor;
import jetbrains.mps.smodel.SModelRepository;
import jetbrains.mps.smodel.descriptor.EditableSModelDescriptor;
import org.jetbrains.annotations.Nullable;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;

public class OldRootNodeFileStatusManager extends AbstractProjectComponent {
  protected static Log log = LogFactory.getLog(OldRootNodeFileStatusManager.class);

  private OldChangesManager myChangesManager;
  private final List<OldNodeFileStatusListener> myNodeFileStatusListeners = ListSequence.fromList(new ArrayList<OldNodeFileStatusListener>());
  private final Map<SNodePointer, FileStatus> myFileStatusMap = MapSequence.fromMap(new HashMap<SNodePointer, FileStatus>());

  public OldRootNodeFileStatusManager(@NotNull Project project, @NotNull OldChangesManager changesManager) {
    super(project);
    myChangesManager = changesManager;
  }

  public void projectOpened() {
  }

  public void projectClosed() {
    ListSequence.fromList(myNodeFileStatusListeners).clear();
    MapSequence.fromMap(myFileStatusMap).clear();
  }

  public void addNodeFileStatusListener(@NotNull OldNodeFileStatusListener listener) {
    synchronized (myNodeFileStatusListeners) {
      ListSequence.fromList(myNodeFileStatusListeners).addElement(listener);
    }
  }

  public void removeNodeFileStatusListener(@NotNull OldNodeFileStatusListener listener) {
    synchronized (myNodeFileStatusListeners) {
      ListSequence.fromList(myNodeFileStatusListeners).removeElement(listener);
    }
  }

  public void nodeFileStatusChanged(@NotNull final SNode node) {
    myChangesManager.getCommandQueue().runTask(new Runnable() {
      public void run() {
        final Wrappers._T<SNodePointer> nodePointer = new Wrappers._T<SNodePointer>();
        ModelAccess.instance().runReadAction(new Runnable() {
          public void run() {
            nodePointer.value = new SNodePointer(node);
          }
        });
        calcStatus(nodePointer.value);
        ModelAccess.instance().runReadInEDT(new Runnable() {
          public void run() {
            for (OldNodeFileStatusListener listener : ListSequence.fromListWithValues(new ArrayList<OldNodeFileStatusListener>(), myNodeFileStatusListeners)) {
              try {
                listener.fileStatusChanged(node);
              } catch (Throwable t) {
                if (log.isErrorEnabled()) {
                  log.error("Exception on firing fileStatusChanged event", t);
                }
              }
            }
          }
        });
      }
    });
  }

  private void calcStatus(@NotNull final SNodePointer root) {
    final Wrappers._T<FileStatus> status = new Wrappers._T<FileStatus>(null);
    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        SModelDescriptor modelDescriptor = SModelRepository.getInstance().getModelDescriptor(root.getModelReference());
        if (modelDescriptor instanceof EditableSModelDescriptor) {
          OldModelChangesManager modelChangesManager = myChangesManager.getModelChangesManager((EditableSModelDescriptor) modelDescriptor);
          if (modelChangesManager != null) {
            if (modelChangesManager.isAddedNode(root)) {
              if (modelChangesManager.isNewModel()) {
                status.value = modelChangesManager.getFileStatus();
              } else {
                status.value = FileStatus.ADDED;
              }
            } else if (modelChangesManager.isChangedRootNode(root)) {
              status.value = FileStatus.MODIFIED;
            } else {
              status.value = FileStatus.NOT_CHANGED;
            }
          }
        }
      }
    });
    synchronized (myFileStatusMap) {
      MapSequence.fromMap(myFileStatusMap).put(root, status.value);
    }
  }

  @Nullable
  public FileStatus getStatus(@NotNull final SNode root) {
    final Wrappers._T<SNodePointer> nodePointer = new Wrappers._T<SNodePointer>();
    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        nodePointer.value = new SNodePointer(root);
        myChangesManager.getCommandQueue().runTask(new Runnable() {
          public void run() {
            final Wrappers._T<SModelDescriptor> modelDescriptor = new Wrappers._T<SModelDescriptor>(null);
            ModelAccess.instance().runReadAction(new Runnable() {
              public void run() {
                if (!(root.isDisposed() || SNodeOperations.getModel(root).isDisposed())) {
                  modelDescriptor.value = SNodeOperations.getModel(root).getModelDescriptor();
                }
              }
            });
            if (modelDescriptor.value instanceof EditableSModelDescriptor) {
              OldModelChangesManager modelChangesManager = myChangesManager.getModelChangesManager((EditableSModelDescriptor) modelDescriptor.value);
              modelChangesManager.setEnabled(true);
            }
          }
        });
      }
    });
    synchronized (myFileStatusMap) {
      return MapSequence.fromMap(myFileStatusMap).get(nodePointer.value);
    }
  }

  public static OldRootNodeFileStatusManager getInstance(Project project) {
    return project.getComponent(OldRootNodeFileStatusManager.class);
  }
}
