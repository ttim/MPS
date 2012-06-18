package jetbrains.mps.ide.platform.watching;

/*Generated by MPS */

import com.intellij.openapi.components.ApplicationComponent;
import jetbrains.mps.logging.Logger;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.intellij.util.messages.MessageBus;
import com.intellij.openapi.project.ProjectManager;
import com.intellij.openapi.vfs.VirtualFileManager;
import java.util.Set;
import java.util.HashSet;
import com.intellij.util.ui.update.MergingUpdateQueue;
import com.intellij.openapi.vfs.VirtualFileManagerListener;
import com.intellij.util.messages.MessageBusConnection;
import com.intellij.openapi.vfs.newvfs.BulkFileListener;
import jetbrains.mps.make.IMakeNotificationListener;
import jetbrains.mps.make.MakeNotification;
import jetbrains.mps.make.IMakeService;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.MPSCore;
import com.intellij.util.ui.update.Update;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vcs.ProjectLevelVcsManager;
import com.intellij.openapi.progress.ProgressManager;
import com.intellij.openapi.progress.Task;
import com.intellij.openapi.progress.ProgressIndicator;
import jetbrains.mps.util.Computable;
import com.intellij.openapi.application.ApplicationManager;
import java.util.List;
import com.intellij.openapi.vfs.newvfs.events.VFileEvent;
import com.intellij.openapi.application.Application;
import jetbrains.mps.smodel.ModelAccess;
import jetbrains.mps.ide.vfs.VirtualFileUtils;
import com.intellij.openapi.vfs.newvfs.events.VFileContentChangeEvent;
import com.intellij.openapi.vfs.newvfs.events.VFileCreateEvent;
import com.intellij.openapi.vfs.newvfs.events.VFileDeleteEvent;
import com.intellij.openapi.vfs.newvfs.events.VFileCopyEvent;
import com.intellij.openapi.vfs.newvfs.events.VFileMoveEvent;

public class FSChangesWatcher implements ApplicationComponent {
  public static final Logger LOG = Logger.getLogger(FSChangesWatcher.class);
  protected static Log log = LogFactory.getLog(FSChangesWatcher.class);

  private final MessageBus myBus;
  private final ProjectManager myProjectManager;
  private final VirtualFileManager myVirtualFileManager;
  private volatile ReloadSession myReloadSession;
  private final Object myLock = new Object();
  private final Set<FSChangesWatcher.IReloadListener> myReloadListeners = new HashSet<FSChangesWatcher.IReloadListener>();
  private int myBans = 0;
  private MergingUpdateQueue myQueue = new MergingUpdateQueue("Model Changes Watcher Queue", 500, true, null, null, null, true);
  private final VirtualFileManagerListener myVirtualFileManagerListener = new VirtualFileManagerListener() {
    public void beforeRefreshStart(boolean async) {
      suspendTasksProcessing();
    }

    public void afterRefreshFinish(boolean async) {
      tryToResumeTasksProcessing();
    }
  };
  private MessageBusConnection myConnection;
  private BulkFileListener myBusListener = new FSChangesWatcher.BulkFileChangesListener();
  private IMakeNotificationListener myMakeListener = new IMakeNotificationListener.Stub() {
    public void sessionOpened(MakeNotification notification) {
      suspendTasksProcessing();
    }

    public void sessionClosed(MakeNotification notification) {
      tryToResumeTasksProcessing();
    }
  };
  private IMakeService myMakeService;

  public FSChangesWatcher(MessageBus bus, ProjectManager projectManager, VirtualFileManager virtualFileManager) {
    myBus = bus;
    myVirtualFileManager = virtualFileManager;
    myProjectManager = projectManager;
    myQueue.setRestartTimerOnAdd(true);
  }

  public void tryToResumeTasksProcessing() {
    synchronized (myLock) {
      myBans--;
      if (myBans != 0) {
        return;
      }
      myQueue.resume();
    }
  }

  public void suspendTasksProcessing() {
    synchronized (myLock) {
      myQueue.suspend();
      myBans++;
    }
  }

  @NonNls
  @NotNull
  public String getComponentName() {
    return "Model Changes Watcher";
  }

  public void initComponent() {
    initComponent(false);
  }

  public void setMakeService(IMakeService ms) {
    if (ms != null) {
      ms.addListener(myMakeListener);
    } else {
      if (myMakeService != null) {
        myMakeService.removeListener(myMakeListener);
      }
    }
    myMakeService = ms;
  }

  public void initComponent(boolean force) {
    if (myConnection == null && (force || !(MPSCore.getInstance().isTestMode()))) {
      myConnection = myBus.connect();
      myConnection.subscribe(VirtualFileManager.VFS_CHANGES, myBusListener);
      myVirtualFileManager.addVirtualFileManagerListener(myVirtualFileManagerListener);
    }
  }

  public void disposeComponent() {
    if (myConnection == null) {
      return;
    }
    if (myMakeService != null) {
      myMakeService.removeListener(myMakeListener);
      myMakeService = null;
    }
    myVirtualFileManager.removeVirtualFileManagerListener(myVirtualFileManagerListener);
    myConnection.disconnect();
    myConnection = null;
  }

  private void queueReload() {
    synchronized (myLock) {
      if (myReloadSession == null) {
        return;
      }
      if (myReloadSession.isEmpty()) {
        return;
      }

      myQueue.queue(new Update(null) {
        public void run() {
          for (Project project : myProjectManager.getOpenProjects()) {
            if (project.getComponent(ProjectLevelVcsManager.class).isBackgroundVcsOperationRunning()) {
              queueReload();
              return;
            }
          }
          synchronized (myLock) {
            if (myReloadSession == null) {
              return;
            }
            final ReloadSession session = myReloadSession;
            if (session.isEmpty()) {
              return;
            }
            myReloadSession = null;
            ProgressManager.getInstance().run(new Task.Modal(null, "Reloading", false) {
              public void run(@NotNull final ProgressIndicator progressIndicator) {
                session.doReload(progressIndicator);
              }
            });
          }
        }
      });
    }
  }

  public void addReloadListener(FSChangesWatcher.IReloadListener listener) {
    synchronized (myReloadListeners) {
      myReloadListeners.add(listener);
    }
  }

  public void removeReloadListener(FSChangesWatcher.IReloadListener listener) {
    synchronized (myReloadListeners) {
      myReloadListeners.remove(listener);
    }
  }

  private Set<FSChangesWatcher.IReloadListener> getReloadListeners() {
    synchronized (myReloadListeners) {
      HashSet<FSChangesWatcher.IReloadListener> listeners = new HashSet<FSChangesWatcher.IReloadListener>();
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

  public static FSChangesWatcher instance() {
    return ApplicationManager.getApplication().getComponent(FSChangesWatcher.class);
  }

  private class BulkFileChangesListener implements BulkFileListener {
    private BulkFileChangesListener() {
    }

    public void before(List<? extends VFileEvent> events) {
    }

    public void after(final List<? extends VFileEvent> events) {
      final Application application = ApplicationManager.getApplication();
      if (application.isDisposeInProgress() || application.isDisposed()) {
        return;
      }
      synchronized (myLock) {
        if (myReloadSession == null) {
          myReloadSession = new ReloadSession(getReloadListeners());
        }
        for (final VFileEvent event : events) {
          FSChangesWatcher.LOG.debug("Got event " + event);
          processAfterEvent(event, myReloadSession);
        }
        queueReload();
      }
    }

    private void processAfterEvent(final VFileEvent event, final ReloadSession reloadSession) {
      FSChangesWatcher.LOG.debug("Process after event for " + event.getPath());
      ModelAccess.instance().runReadAction(new Runnable() {
        public void run() {
          for (EventProcessor p : reloadSession.getProcessors()) {
            if (event.getFile() == null) {
              if (log.isWarnEnabled()) {
                log.warn("event.getFile() is null. Event: " + event.getClass().getName() + "; path=" + event.getPath());
              }
              continue;
            }
            if (!(p.accepts(event.getFile()))) {
              continue;
            }

            if (VirtualFileUtils.isEventFromSave(event)) {
              continue;
            }
            if (event instanceof VFileContentChangeEvent) {
              p.processContentChanged(event.getFile());
            } else if (event instanceof VFileCreateEvent) {
              p.processCreate(event.getFile());
            } else if (event instanceof VFileDeleteEvent) {
              p.processDelete(event.getFile());
            } else if (event instanceof VFileCopyEvent) {
              p.processCreate(event.getFile());
            } else if (event instanceof VFileMoveEvent) {
              VFileMoveEvent re = (VFileMoveEvent) event;
              String name = re.getFile().getName();
              p.processDelete(event.getFile());
              p.processCreate(re.getNewParent().findChild(name));
            }
          }
        }
      });
    }
  }

  public static interface IReloadListener {
    public void reloadStarted();
    public void reloadFinished();
  }
}
