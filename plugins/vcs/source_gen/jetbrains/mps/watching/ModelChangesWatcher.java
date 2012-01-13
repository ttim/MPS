package jetbrains.mps.watching;

/*Generated by MPS */

import com.intellij.openapi.components.ApplicationComponent;
import jetbrains.mps.logging.Logger;
import com.intellij.util.messages.MessageBus;
import com.intellij.openapi.project.ProjectManager;
import com.intellij.openapi.vfs.VirtualFileManager;
import java.util.Set;
import java.util.HashSet;
import com.intellij.util.ui.Timer;
import com.intellij.openapi.vfs.VirtualFileManagerListener;
import com.intellij.util.messages.MessageBusConnection;
import com.intellij.openapi.vfs.newvfs.BulkFileListener;
import jetbrains.mps.make.IMakeNotificationListener;
import jetbrains.mps.make.MakeNotification;
import jetbrains.mps.make.IMakeService;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vcs.ProjectLevelVcsManager;
import com.intellij.openapi.application.ApplicationManager;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.MPSCore;
import com.intellij.openapi.application.ModalityState;
import com.intellij.openapi.vfs.VirtualFile;
import jetbrains.mps.library.ProjectLibraryManager;
import jetbrains.mps.library.Library;
import jetbrains.mps.ide.vfs.VirtualFileUtils;
import java.util.Arrays;
import jetbrains.mps.library.LibraryManager;
import java.io.File;
import com.intellij.openapi.util.io.FileUtil;
import jetbrains.mps.util.Computable;
import java.util.List;
import com.intellij.openapi.vfs.newvfs.events.VFileEvent;
import com.intellij.openapi.vfs.VfsUtil;
import com.intellij.util.Processor;
import jetbrains.mps.fileTypes.MPSFileTypesManager;
import com.intellij.openapi.application.Application;

public class ModelChangesWatcher implements ApplicationComponent {
  public static final Logger LOG = Logger.getLogger(ModelChangesWatcher.class);

  private final MessageBus myBus;
  private final ProjectManager myProjectManager;
  private final VirtualFileManager myVirtualFileManager;
  private volatile ReloadSession myReloadSession;
  private final Object myLock = new Object();
  private final Set<ModelChangesWatcher.IReloadListener> myReloadListeners = new HashSet<ModelChangesWatcher.IReloadListener>();
  private final Timer myTimer;
  private int myBans = 0;
  private final VirtualFileManagerListener myVirtualFileManagerListener = new VirtualFileManagerListener() {
    public void beforeRefreshStart(boolean async) {
      suspendTasksProcessing();
    }

    public void afterRefreshFinish(boolean async) {
      tryToResumeTasksProcessing();
    }
  };
  private MessageBusConnection myConnection;
  private BulkFileListener myBusListener = new ModelChangesWatcher.BulkFileChangesListener();
  private IMakeNotificationListener myMakeListener = new IMakeNotificationListener.Stub() {
    public void sessionOpened(MakeNotification notification) {
      suspendTasksProcessing();
    }

    public void sessionClosed(MakeNotification notification) {
      tryToResumeTasksProcessing();
    }
  };
  private IMakeService myMakeService;

  public ModelChangesWatcher(IMakeService ms, MessageBus bus, ProjectManager projectManager, VirtualFileManager virtualFileManager) {
    myMakeService = ms;
    myBus = bus;
    myVirtualFileManager = virtualFileManager;
    myProjectManager = projectManager;
    myTimer = new Timer("Model Changes Watcher", 50) {
      protected void onTimer() throws InterruptedException {
        synchronized (myLock) {
          if (myReloadSession != null) {
            doReload();
          }
        }
        myTimer.suspend();
      }
    };
    myTimer.setTakeInitialDelay(true);
    myTimer.suspend();
  }

  public void tryToResumeTasksProcessing() {
    synchronized (myLock) {
      myBans--;
      if (myBans != 0) {
        return;
      }
      if (myReloadSession == null) {
        return;
      }
      for (Project project : myProjectManager.getOpenProjects()) {
        if (project.getComponent(ProjectLevelVcsManager.class).isBackgroundVcsOperationRunning()) {
          return;
        }
      }
    }
    ApplicationManager.getApplication().executeOnPooledThread(new Runnable() {
      public void run() {
        myTimer.resume();
      }
    });
  }

  public void suspendTasksProcessing() {
    ApplicationManager.getApplication().executeOnPooledThread(new Runnable() {
      public void run() {
        myTimer.suspend();
      }
    });
    synchronized (myLock) {
      myBans++;
    }
  }

  @NonNls
  @NotNull
  public String getComponentName() {
    return "Model Changes Watcher";
  }

  public void initComponent() {
    if (MPSCore.getInstance().isTestMode()) {
      return;
    }
    myConnection = myBus.connect();
    myConnection.subscribe(VirtualFileManager.VFS_CHANGES, myBusListener);
    myVirtualFileManager.addVirtualFileManagerListener(myVirtualFileManagerListener);
    myMakeService.addListener(this.myMakeListener);
  }

  public void disposeComponent() {
    if (MPSCore.getInstance().isTestMode()) {
      return;
    }
    myMakeService.removeListener(this.myMakeListener);
    myVirtualFileManager.removeVirtualFileManagerListener(myVirtualFileManagerListener);
    myConnection.disconnect();
  }

  private void doReload() {
    final ReloadSession session = myReloadSession;
    myReloadSession = null;
    ApplicationManager.getApplication().invokeLater(new Runnable() {
      public void run() {
        session.doReload();
      }
    }, ModalityState.NON_MODAL);
  }

  public Set<VirtualFile> getSignificantRoots() {
    Set<VirtualFile> roots = new HashSet<VirtualFile>();
    for (Project p : myProjectManager.getOpenProjects()) {
      roots.add(p.getBaseDir());
      ProjectLibraryManager projectLibraryManager = p.getComponent(ProjectLibraryManager.class);
      if (projectLibraryManager != null) {
        for (Library lib : projectLibraryManager.getUILibraries()) {
          VirtualFile file = VirtualFileUtils.getVirtualFile(lib.getPath());
          if (file != null) {
            roots.add(file);
          }
        }
      }
      ProjectLevelVcsManager manager = ProjectLevelVcsManager.getInstance(p);
      if (manager != null) {
        roots.addAll(Arrays.asList(manager.getAllVersionedRoots()));
      }
    }
    LibraryManager libraryManager = LibraryManager.getInstance();
    for (Library lib : libraryManager.getUILibraries()) {
      VirtualFile file = VirtualFileUtils.getVirtualFile(lib.getPath());
      if (file != null) {
        roots.add(file);
      }
    }
    return roots;
  }

  private boolean isUnderSignificantRoots(File file) {
    for (VirtualFile f : getSignificantRoots()) {
      if (FileUtil.isAncestor(VirtualFileUtils.toFile(f), file, false)) {
        return true;
      }
    }
    return false;
  }

  public void addReloadListener(ModelChangesWatcher.IReloadListener listener) {
    synchronized (myReloadListeners) {
      myReloadListeners.add(listener);
    }
  }

  public void removeReloadListener(ModelChangesWatcher.IReloadListener listener) {
    synchronized (myReloadListeners) {
      myReloadListeners.remove(listener);
    }
  }

  private Set<ModelChangesWatcher.IReloadListener> getReloadListeners() {
    synchronized (myReloadListeners) {
      HashSet<ModelChangesWatcher.IReloadListener> listeners = new HashSet<ModelChangesWatcher.IReloadListener>();
      listeners.addAll(myReloadListeners);
      return listeners;
    }
  }

  public <T> T executeUnderBlockedReload(Computable<T> computable) {
    try {
      suspendTasksProcessing();
      return computable.compute();
    } finally {
      tryToResumeTasksProcessing();
    }
  }

  public static ModelChangesWatcher instance() {
    return ApplicationManager.getApplication().getComponent(ModelChangesWatcher.class);
  }

  private class BulkFileChangesListener implements BulkFileListener {
    private BulkFileChangesListener() {
    }

    public void before(List<? extends VFileEvent> events) {
      synchronized (myLock) {
        if (myReloadSession == null) {
          myReloadSession = new ReloadSession(getReloadListeners());
        }
        final ReloadSession reloadSession = myReloadSession;
        for (final VFileEvent event : events) {
          String filePath = event.getPath();
          VirtualFile file = event.getFile();
          if (file == null) {
            continue;
          }
          if (file.isDirectory() && file.exists() && (file.getChildren() != null) && file.isInLocalFileSystem()) {
            if (isUnderSignificantRoots(VirtualFileUtils.toFile(file))) {
              VfsUtil.processFilesRecursively(file, new Processor<VirtualFile>() {
                public boolean process(VirtualFile file) {
                  processBeforeEvent(new VFileEventDecorator(event, file.getPath()), file.getPath(), reloadSession);
                  return true;
                }
              });
            }
          } else
          if (!(file.isDirectory())) {
            processBeforeEvent(event, filePath, reloadSession);
          }
        }
      }
    }

    private void processBeforeEvent(VFileEvent event, String filePath, ReloadSession reloadSession) {
      if (MPSFileTypesManager.instance().isModelFile(filePath)) {
        ModelChangesWatcher.LOG.debug("Process before event for " + filePath);
        BeforeModelEventProcessor.getInstance().process(event, reloadSession);
      } else
      if (MPSFileTypesManager.instance().isModuleFile(filePath)) {
        ModelChangesWatcher.LOG.debug("Process before event for " + filePath);
        BeforeModuleEventProcessor.getInstance().process(event, reloadSession);
      }
    }

    public void after(final List<? extends VFileEvent> events) {
      final Application application = ApplicationManager.getApplication();
      if (application.isDisposeInProgress() || application.isDisposed()) {
        return;
      }
      boolean resume = false;
      synchronized (myLock) {
        if (myReloadSession == null) {
          myReloadSession = new ReloadSession(getReloadListeners());
        }
        for (final VFileEvent event : events) {
          String path = event.getPath();
          ModelChangesWatcher.LOG.debug("Got event " + event);
          File file = new File(path);
          if (file.isDirectory() && file.exists() && (file.listFiles() != null)) {
            if (isUnderSignificantRoots(file)) {
              FileUtil.processFilesRecursively(file, new Processor<File>() {
                public boolean process(File file) {
                  processAfterEvent(file.getAbsolutePath(), new VFileEventDecorator(event, file.getAbsolutePath()), myReloadSession);
                  return true;
                }
              });
            }
          }
          processAfterEvent(path, event, myReloadSession);
        }
        if (myBans == 0) {
          resume = true;
        }
      }
      if (resume) {
        ApplicationManager.getApplication().executeOnPooledThread(new Runnable() {
          public void run() {
            myTimer.resume();
          }
        });
      }
    }

    private void processAfterEvent(String filePath, VFileEvent event, ReloadSession reloadSession) {
      ModelChangesWatcher.LOG.debug("Process after event for " + filePath);
      ModelFileProcessor.getInstance().process(event, reloadSession);
      if (MPSFileTypesManager.instance().isModuleFile(filePath)) {
        ModelChangesWatcher.LOG.debug("Process after event for " + filePath);
        ModuleFileProcessor.getInstance().process(event, reloadSession);
      }
    }
  }

  public static interface IReloadListener {
    public void reloadStarted();
    public void reloadFinished();
  }
}
