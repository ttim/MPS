package jetbrains.mps.vcs.changesmanager;

/*Generated by MPS */

import com.intellij.openapi.components.AbstractProjectComponent;
import jetbrains.mps.smodel.event.SModelListener;
import com.intellij.openapi.vcs.changes.ChangeListListener;
import java.util.Map;
import jetbrains.mps.smodel.SModelReference;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import java.util.HashMap;
import jetbrains.mps.reloading.ReloadListener;
import jetbrains.mps.smodel.SModelRepositoryListener;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.project.Project;
import jetbrains.mps.reloading.ClassLoaderManager;
import jetbrains.mps.smodel.GlobalSModelEventsManager;
import com.intellij.openapi.vcs.changes.ChangeListManager;
import jetbrains.mps.smodel.SModelRepository;
import jetbrains.mps.internal.collections.runtime.Sequence;
import jetbrains.mps.smodel.SModelDescriptor;
import org.jetbrains.annotations.Nullable;
import com.intellij.openapi.vcs.FileStatus;
import jetbrains.mps.smodel.SModelStereotype;
import com.intellij.openapi.vfs.VirtualFile;
import jetbrains.mps.vfs.IFile;
import jetbrains.mps.vfs.VFileSystem;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.smodel.SModel;
import jetbrains.mps.smodel.ModelAccess;
import java.io.PrintStream;
import jetbrains.mps.internal.collections.runtime.IMapping;
import jetbrains.mps.internal.collections.runtime.IWhereFilter;
import jetbrains.mps.vcs.diff.changes.Change;
import jetbrains.mps.vcs.ApplicationLevelVcsManager;
import com.intellij.openapi.vcs.changes.ChangeListAdapter;
import java.util.Collection;
import com.intellij.openapi.vcs.changes.ChangeList;
import jetbrains.mps.vcs.MPSVCSManager;
import jetbrains.mps.smodel.SModelAdapter;
import jetbrains.mps.reloading.ReloadAdapter;
import jetbrains.mps.smodel.SModelRepositoryAdapter;
import jetbrains.mps.ide.ThreadUtils;

public class ChangesManager extends AbstractProjectComponent {
  private SModelListener myGlobalModelListener = new ChangesManager.MyGlobalSModelListener();
  private ChangeListListener myChangeListListener = new ChangesManager.MyChangeListListener();
  private final Map<SModelReference, ModelChangesManager> myModelChanges = MapSequence.fromMap(new HashMap<SModelReference, ModelChangesManager>());
  private ReloadListener myReloadListener = new ChangesManager.MyReloadListener();
  private SModelRepositoryListener myModelRepositoryListener = new ChangesManager.MySModelRepositoryListener();
  private SimpleCommandQueue myCommandQueue = new SimpleCommandQueue("ChangesManager command queue");

  public ChangesManager(@NotNull Project project) {
    super(project);
  }

  public void projectOpened() {
    if (isEnabled()) {
      ClassLoaderManager.getInstance().addReloadHandler(myReloadListener);
      GlobalSModelEventsManager.getInstance().addGlobalModelListener(myGlobalModelListener);
      ChangeListManager.getInstance(myProject).addChangeListListener(myChangeListListener);
      SModelRepository.getInstance().addModelRepositoryListener(myModelRepositoryListener);

      updateLoadedModelStatuses();
    }
  }

  public void projectClosed() {
    ClassLoaderManager.getInstance().removeReloadHandler(myReloadListener);
    GlobalSModelEventsManager.getInstance().removeGlobalModelListener(myGlobalModelListener);
    ChangeListManager.getInstance(myProject).removeChangeListListener(myChangeListListener);
    SModelRepository.getInstance().removeModelRepositoryListener(myModelRepositoryListener);

    myCommandQueue.addTask(new Runnable() {
      public void run() {
        for (ModelChangesManager modelChangesManager : Sequence.fromIterable(MapSequence.fromMap(myModelChanges).values())) {
          modelChangesManager.dispose();
        }
        MapSequence.fromMap(myModelChanges).clear();
        myCommandQueue.dispose();
      }
    });
  }

  private void updateModelStatus(@NotNull final SModelDescriptor modelDescriptor, @Nullable final FileStatus fileStatus) {
    myCommandQueue.addTask(new Runnable() {
      public void run() {
        if (!(SModelStereotype.isUserModel(modelDescriptor))) {
          return;
        }
        SModelReference modelRef = modelDescriptor.getSModelReference();
        if (MapSequence.fromMap(myModelChanges).containsKey(modelRef)) {
          MapSequence.fromMap(myModelChanges).get(modelRef).update(fileStatus);
          return;
        }
        ModelChangesManager modelChangesManager = new ModelChangesManager(myProject, modelDescriptor);
        MapSequence.fromMap(myModelChanges).put(modelRef, modelChangesManager);
      }
    });
  }

  private void updateModelStatus(@Nullable VirtualFile file, @Nullable FileStatus fileStatus) {
    if (file == null) {
      return;
    }
    IFile iFile = VFileSystem.toIFile(file);
    if (iFile == null) {
      return;
    }
    SModelDescriptor modelDescriptor = SModelRepository.getInstance().findModel(iFile);
    if (modelDescriptor == null || !(modelDescriptor.isInitialized())) {
      return;
    }
    updateModelStatus(modelDescriptor, fileStatus);
  }

  public void updateLoadedModelStatuses() {
    for (SModelDescriptor md : ListSequence.fromList(SModelRepository.getInstance().getModelDescriptors())) {
      if (md.isInitialized() && SModelStereotype.isUserModel(md)) {
        updateModelStatus(md, null);
      }
    }
  }

  private void disposeModelChangesManager(@NotNull final SModelReference modelReference) {
    myCommandQueue.addTask(new Runnable() {
      public void run() {
        if (MapSequence.fromMap(myModelChanges).containsKey(modelReference)) {
          MapSequence.fromMap(myModelChanges).get(modelReference).dispose();
          MapSequence.fromMap(myModelChanges).removeKey(modelReference);
        }
      }
    });
  }

  @NotNull
  public ModelChangesManager getModelChangesManager(@NotNull SModelDescriptor modelDescriptor) {
    myCommandQueue.assertSoftlyIsCommandThread();
    SModelReference modelRef = modelDescriptor.getSModelReference();
    if (!(MapSequence.fromMap(myModelChanges).containsKey(modelRef))) {
      MapSequence.fromMap(myModelChanges).put(modelRef, new ModelChangesManager(myProject, modelDescriptor));
    }
    return MapSequence.fromMap(myModelChanges).get(modelRef);
  }

  @NotNull
  public ModelChangesManager getModelChangesManager(@NotNull SModel model) {
    return getModelChangesManager(model.getModelDescriptor());
  }

  public void dump() {
    myCommandQueue.runTask(new Runnable() {
      public void run() {
        ModelAccess.instance().runReadAction(new Runnable() {
          public void run() {
            PrintStream out = System.out;

            for (IMapping<SModelReference, ModelChangesManager> smrMcmPair : MapSequence.fromMap(myModelChanges).where(new IWhereFilter<IMapping<SModelReference, ModelChangesManager>>() {
              public boolean accept(IMapping<SModelReference, ModelChangesManager> m) {
                return !(ListSequence.fromList(m.value().getChangeList()).isEmpty());
              }
            })) {
              out.println("==" + smrMcmPair.key() + "==");

              for (Change change : ListSequence.fromList(smrMcmPair.value().getChangeList())) {
                out.println(change);
              }

              out.println();
            }
            out.println();
            out.println("==Unchanged models==");
            for (IMapping<SModelReference, ModelChangesManager> smrMcmPair : MapSequence.fromMap(myModelChanges).where(new IWhereFilter<IMapping<SModelReference, ModelChangesManager>>() {
              public boolean accept(IMapping<SModelReference, ModelChangesManager> m) {
                return ListSequence.fromList(m.value().getChangeList()).isEmpty() && m.value().isEnabled();
              }
            })) {
              out.println("- " + smrMcmPair.key());
            }
            out.println();
            out.println(MapSequence.fromMap(myModelChanges).where(new IWhereFilter<IMapping<SModelReference, ModelChangesManager>>() {
              public boolean accept(IMapping<SModelReference, ModelChangesManager> m) {
                return ListSequence.fromList(m.value().getChangeList()).isEmpty() && !(m.value().isEnabled());
              }
            }).count() + " disabled models");
          }
        });
      }
    });
  }

  @NotNull
  public SimpleCommandQueue getCommandQueue() {
    return myCommandQueue;
  }

  public static ChangesManager getInstance(Project project) {
    return project.getComponent(ChangesManager.class);
  }

  public static boolean isEnabled() {
    return ApplicationLevelVcsManager.instance().getSettings().isChangesManagerEnabled();
  }

  private class MyChangeListListener extends ChangeListAdapter {
    public MyChangeListListener() {
    }

    private void processChanges(Collection<com.intellij.openapi.vcs.changes.Change> changes) {
      for (com.intellij.openapi.vcs.changes.Change change : Sequence.fromIterable(changes)) {
        updateModelStatus(change.getVirtualFile(), change.getFileStatus());
      }
    }

    @Override
    public void changesAdded(Collection<com.intellij.openapi.vcs.changes.Change> changes, ChangeList toList) {
      processChanges(changes);
    }

    @Override
    public void changesRemoved(Collection<com.intellij.openapi.vcs.changes.Change> changes, ChangeList fromList) {
      for (com.intellij.openapi.vcs.changes.Change change : Sequence.fromIterable(changes)) {
        updateModelStatus(change.getVirtualFile(), null);
      }
    }

    @Override
    public void changesMoved(Collection<com.intellij.openapi.vcs.changes.Change> changes, ChangeList fromList, ChangeList toList) {
      processChanges(changes);
    }

    @Override
    public void unchangedFileStatusChanged() {
      for (VirtualFile virtualFile : ListSequence.fromList(MPSVCSManager.getInstance(myProject).getUnversionedFilesFromChangeListManager())) {
        updateModelStatus(virtualFile, null);
      }
    }
  }

  private class MyGlobalSModelListener extends SModelAdapter {
    public MyGlobalSModelListener() {
    }

    @Override
    public void modelReplaced(SModelDescriptor md) {
      updateModelStatus(md, null);
    }

    @Override
    public void modelInitialized(SModelDescriptor md) {
      updateModelStatus(md, null);
    }
  }

  private class MyReloadListener extends ReloadAdapter {
    public MyReloadListener() {
    }

    @Override
    public void onAfterReload() {
      updateLoadedModelStatuses();
    }
  }

  private class MySModelRepositoryListener extends SModelRepositoryAdapter {
    public MySModelRepositoryListener() {
    }

    @Override
    public void beforeModelRemoved(final SModelDescriptor descriptor) {
      ThreadUtils.runInUIThreadNoWait(new Runnable() {
        public void run() {
          if (SModelStereotype.isUserModel(descriptor)) {
            disposeModelChangesManager(descriptor.getSModelReference());
          }
        }
      });
    }
  }
}
