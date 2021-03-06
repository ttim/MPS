package jetbrains.mps.plugin;

/*Generated by MPS */

import com.intellij.openapi.wm.StatusBarWidget;
import jetbrains.mps.logging.Logger;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.StatusBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.intellij.openapi.application.ApplicationManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import com.intellij.util.Consumer;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import jetbrains.mps.ide.ThreadUtils;
import javax.swing.SwingUtilities;
import jetbrains.mps.plugin.icons.Icons;
import javax.swing.Timer;

public class PluginStateWidget implements StatusBarWidget, StatusBarWidget.IconPresentation {
  private static Logger LOG = Logger.getLogger(PluginStateWidget.class);
  private static final int INITIAL_DELAY = 4000;
  private static final int CRITICAL_DELAY = 16000;
  private static final double DELAY_MUL = 2.0;
  private static final Object LOCK = new Object();

  private final Project myProject;
  private PluginStateWidget.MyTimer myTimer;
  private PluginStateWidget.State myState = PluginStateWidget.State.TRYING_TO_CONNECT;
  private StatusBar myStatusBar;

  public PluginStateWidget(Project project) {
    myProject = project;
    myTimer = new PluginStateWidget.MyTimer(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        ApplicationManager.getApplication().executeOnPooledThread(new Runnable() {
          public void run() {
            tick();
          }
        });
      }
    });
  }

  public void install(@NotNull StatusBar bar) {
    myStatusBar = bar;
    myTimer.start();
  }

  @Nullable
  public Consumer<MouseEvent> getClickConsumer() {
    return new Consumer<MouseEvent>() {
      public void consume(MouseEvent event) {
        if (myState == PluginStateWidget.State.DISCONNECTED) {
          setNewState(PluginStateWidget.State.TRYING_TO_CONNECT);
          myTimer.setNewDelay(PluginStateWidget.INITIAL_DELAY);
        }
      }
    };
  }

  @Nullable
  public StatusBarWidget.WidgetPresentation getPresentation(@NotNull StatusBarWidget.PlatformType type) {
    return this;
  }

  public void dispose() {
    if (myTimer.isRunning()) {
      myTimer.stop();
    }
  }

  @Nullable
  public String getTooltipText() {
    return myState.getHelpText();
  }

  @NotNull
  public Icon getIcon() {
    return myState.getIcon();
  }

  @NotNull
  public String ID() {
    return "MpsPluginStateMonitor";
  }

  private void tick() {
    LOG.assertLog(!(ThreadUtils.isEventDispatchThread()), "You should not do this in EDT");
    synchronized (LOCK) {
      if (myState == PluginStateWidget.State.CONNECTED) {
        if (isConnected()) {
          if (canOperate()) {
            return;
          } else {
            setNewState(PluginStateWidget.State.CONNECTED_BAD_PROJECT);
          }
        } else {
          setNewState(PluginStateWidget.State.TRYING_TO_CONNECT);
        }
      } else
      if (myState == PluginStateWidget.State.CONNECTED_BAD_PROJECT) {
        if (isConnected()) {
          if (canOperate()) {
            setNewState(PluginStateWidget.State.CONNECTED);
          } else {
            return;
          }
        } else {
          setNewState(PluginStateWidget.State.TRYING_TO_CONNECT);
        }
      } else
      if (myState == PluginStateWidget.State.DISCONNECTED) {
        if (MPSPlugin.getInstance().openConnectionPresent()) {
          if (isConnected()) {
            if (canOperate()) {
              setNewState(PluginStateWidget.State.CONNECTED);
            } else {
              setNewState(PluginStateWidget.State.CONNECTED_BAD_PROJECT);
            }
          }
        }
      } else
      if (myState == PluginStateWidget.State.TRYING_TO_CONNECT) {
        if (isConnected()) {
          if (canOperate()) {
            setNewState(PluginStateWidget.State.CONNECTED);
          } else {
            setNewState(PluginStateWidget.State.CONNECTED_BAD_PROJECT);
          }
        } else {
          int newDelay = (int) (myTimer.getDelay() * DELAY_MUL);
          if (newDelay <= CRITICAL_DELAY) {
            myTimer.setNewDelay(newDelay);
          } else {
            setNewState(PluginStateWidget.State.DISCONNECTED);
          }
        }
      }
    }
  }

  private void setNewState(PluginStateWidget.State state) {
    assert myState != state : "myState: " + myState.getHelpText() + "; state: " + state.getHelpText();
    myState = state;
    myTimer.setNewDelay(state.getDefaultDelay());
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        myStatusBar.updateWidget(ID());
      }
    });
  }

  private boolean isConnected() {
    return MPSPlugin.getInstance().isIDEAPresent();
  }

  private boolean canOperate() {
    return MPSPlugin.getInstance().getProjectHandler(myProject) != null;
  }

  private static   enum State {
    DISCONNECTED(Icons.DISCONNECTED, "Not connected to IDEA. Click to reconnect.", PluginStateWidget.INITIAL_DELAY),
    TRYING_TO_CONNECT(Icons.TRYING_TO_CONNECT, "Connecting to IDEA...", PluginStateWidget.INITIAL_DELAY),
    CONNECTED_BAD_PROJECT(Icons.CONNECTED_ERRORS, "Connected to IDEA, Project does not match", PluginStateWidget.CRITICAL_DELAY),
    CONNECTED(Icons.CONNECTED, "Connected to IDEA", PluginStateWidget.INITIAL_DELAY);

    private Icon myIcon;
    private String myHelpText;
    private int myDefaultDelay;

    State(Icon icon, String helpText, int defaultDelay) {
      myIcon = icon;
      myHelpText = helpText;
      myDefaultDelay = defaultDelay;
    }

    public Icon getIcon() {
      return myIcon;
    }

    public String getHelpText() {
      return myHelpText;
    }

    public int getDefaultDelay() {
      return myDefaultDelay;
    }
  }

  private static class MyTimer extends Timer {
    public MyTimer(ActionListener listener) {
      super(PluginStateWidget.INITIAL_DELAY, listener);
    }

    public void setNewDelay(int delay) {
      setDelay(delay);
      setInitialDelay(delay);
      restart();
    }
  }
}
