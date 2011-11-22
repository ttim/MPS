package jetbrains.mps.vcs.changesmanager;

/*Generated by MPS */

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.intellij.openapi.project.Project;
import jetbrains.mps.smodel.descriptor.EditableSModelDescriptor;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.vfs.IFile;
import com.intellij.openapi.vfs.VirtualFile;
import jetbrains.mps.ide.vfs.VirtualFileUtils;
import com.intellij.openapi.vcs.impl.VcsFileStatusProvider;
import com.intellij.openapi.vcs.ProjectLevelVcsManager;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.baseLanguage.closures.runtime.Wrappers;
import com.intellij.openapi.vcs.FileStatus;
import jetbrains.mps.smodel.persistence.def.ModelPersistence;
import jetbrains.mps.smodel.persistence.def.ModelReadException;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.vcs.diff.ChangeSet;
import jetbrains.mps.vcs.diff.ChangeSetBuilder;
import jetbrains.mps.vcs.diff.ChangeSetImpl;
import jetbrains.mps.smodel.SModelAdapter;
import jetbrains.mps.smodel.event.SModelCommandListener;
import java.util.List;
import jetbrains.mps.smodel.event.SModelEvent;

public class ChangesTracking {
  protected static Log log = LogFactory.getLog(ChangesTracking.class);

  private Project myProject;
  private CurrentDifference myDifference;
  private SimpleCommandQueue myQueue;
  private EditableSModelDescriptor myModelDescriptor;
  private ChangesTracking.MyModelListener myModelListener = new ChangesTracking.MyModelListener();
  private ChangesTracking.MyCommandListener myCommandListener = new ChangesTracking.MyCommandListener();
  private boolean myDisposed = false;

  public ChangesTracking(@NotNull Project project, @NotNull CurrentDifference difference) {
    myDifference = difference;
    myProject = project;
    myModelDescriptor = myDifference.getModelDescriptor();
    myQueue = CurrentDifferenceRegistry.getInstance(project).getCommandQueue();
    synchronized (this) {
      myModelDescriptor.addModelListener(myModelListener);
      myModelDescriptor.addModelCommandListener(myCommandListener);
    }
  }

  /*package*/ void scheduleFullUpdate() {
    myQueue.addTask(new Runnable() {
      public void run() {
        update();
      }
    });
  }

  private void update() {
    myQueue.assertSoftlyIsCommandThread();
    if (!(myDifference.isEnabled())) {
      return;
    }
    myDifference.removeChangeSet();

    IFile modelFile = myModelDescriptor.getModelFile();
    if (modelFile == null || !(modelFile.exists())) {
      return;
    }
    VirtualFile modelVFile = VirtualFileUtils.getVirtualFile(modelFile);

    assert myProject.getComponent(VcsFileStatusProvider.class) != null;

    if (modelVFile == null || myProject.getComponent(ProjectLevelVcsManager.class).getVcsFor(modelVFile) == null) {
      return;
    }

    final SModel currentModel = myModelDescriptor.getSModel();
    final Wrappers._T<SModel> baseVersionModel = new Wrappers._T<SModel>(null);
    FileStatus status = myProject.getComponent(VcsFileStatusProvider.class).getFileStatus(modelVFile);
    if (FileStatus.NOT_CHANGED == status) {
      return;
    }
    if (BaseVersionUtil.isAddedFileStatus(status)) {
      baseVersionModel.value = new SModel(currentModel.getSModelReference());
    } else {
      String content = BaseVersionUtil.getBaseVersionContent(modelVFile, myProject);
      if (content == null && status != FileStatus.NOT_CHANGED && !(BaseVersionUtil.isAddedFileStatus(status))) {
        if (log.isErrorEnabled()) {
          log.error("Base version content is null while file status is " + status);
        }
      }
      if (content == null) {
        return;
      }
      try {
        baseVersionModel.value = ModelPersistence.readModel(content, false);
      } catch (ModelReadException e) {
        if (log.isWarnEnabled()) {
          log.warn("", e);
        }
        return;
      }
    }
    ModelAccess.instance().runReadAction(new Runnable() {
      public void run() {
        ChangeSet changeSet = ChangeSetBuilder.buildChangeSet(baseVersionModel.value, currentModel, true);
        myDifference.setChangeSet((ChangeSetImpl) changeSet);
      }
    });
  }

  public void dispose() {
    synchronized (this) {
      if (!(myDisposed)) {
        myDisposed = true;
        myModelDescriptor.removeModelListener(myModelListener);
      }
    }
  }

  public class MyModelListener extends SModelAdapter {
    public MyModelListener() {
    }
  }

  public class MyCommandListener implements SModelCommandListener {
    private MyCommandListener() {
    }

    public void eventsHappenedInCommand(List<SModelEvent> list) {
      // TODO this is temporary 
      scheduleFullUpdate();
    }
  }
}
