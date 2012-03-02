package jetbrains.mps.debugger.java.runtime.breakpoints;

/*Generated by MPS */

import com.intellij.openapi.components.ProjectComponent;
import java.util.Map;
import jetbrains.mps.debug.api.breakpoints.IBreakpoint;
import javax.swing.Icon;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import java.util.HashMap;
import com.intellij.openapi.project.Project;
import jetbrains.mps.debug.api.BreakpointManagerComponent;
import jetbrains.mps.debug.api.breakpoints.IBreakpointListener;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.baseLanguage.closures.runtime._FunctionTypes;
import jetbrains.mps.debug.api.DebugSessionManagerComponent;
import jetbrains.mps.debug.api.AbstractDebugSession;
import jetbrains.mps.debugger.java.runtime.DebugSession;
import jetbrains.mps.cleanup.CleanupManager;
import jetbrains.mps.cleanup.CleanupListener;
import org.jetbrains.annotations.Nullable;
import jetbrains.mps.internal.collections.runtime.SetSequence;
import jetbrains.mps.debugger.api.ui.breakpoints.BreakpointsUiComponent;
import jetbrains.mps.debugger.java.runtime.execution.DebuggerCommand;
import jetbrains.mps.debugger.api.ui.icons.Icons;
import org.apache.commons.lang.StringUtils;
import org.jetbrains.annotations.NonNls;

public class BreakpointsIconCache implements ProjectComponent {
  private final Map<IBreakpoint, Icon> myCache = MapSequence.fromMap(new HashMap<IBreakpoint, Icon>());
  private final Project myProject;
  private final BreakpointManagerComponent myBreakpointManager;
  private final IBreakpointListener myBreakpointListener = new IBreakpointListener() {
    @Override
    public void breakpointEnabledStateToggled(IBreakpoint breakpoint, boolean enabled) {
      myUpdateFromCurrent.invoke();
    }
  };
  private final BreakpointManagerComponent.IBreakpointManagerListener myBreakpointsManagerListener = new BreakpointManagerComponent.IBreakpointManagerListener() {
    @Override
    public void breakpointAdded(@NotNull IBreakpoint breakpoint) {
      breakpoint.addBreakpointListener(myBreakpointListener);
      myUpdateFromCurrent.invoke();
    }

    @Override
    public void breakpointRemoved(@NotNull IBreakpoint breakpoint) {
      myUpdateFromCurrent.invoke();
      breakpoint.removeBreakpointListener(myBreakpointListener);
    }
  };
  private final _FunctionTypes._void_P0_E0 myUpdateFromCurrent = new _FunctionTypes._void_P0_E0() {
    public void invoke() {
      updateIcons(currentSession());
    }
  };
  private final DebugSessionManagerComponent.DebugSessionAdapter myDebugSessionAdapter = new DebugSessionManagerComponent.DebugSessionAdapter() {
    @Override
    public void currentSessionChanged(AbstractDebugSession session) {
      if (session instanceof DebugSession) {
        updateIcons((DebugSession) session);
      } else {
        updateIcons(null);
      }
    }

    @Override
    public void registered(AbstractDebugSession session) {
      if (session instanceof DebugSession) {
        ((DebugSession) session).getEventsProcessor().getRequestManager().addWarningsListener(myUpdateFromCurrent);
      }
    }

    @Override
    public void detached(AbstractDebugSession session) {
      if (session instanceof DebugSession) {
        ((DebugSession) session).getEventsProcessor().getRequestManager().removeWarningsListener(myUpdateFromCurrent);
      }
      myUpdateFromCurrent.invoke();
    }
  };
  private final DebugSessionManagerComponent myDebugSessionManager;

  public BreakpointsIconCache(Project project, BreakpointManagerComponent breakpointManager, DebugSessionManagerComponent debugSessionManager) {
    myProject = project;
    myBreakpointManager = breakpointManager;
    myDebugSessionManager = debugSessionManager;
  }

  public void projectOpened() {
  }

  public void projectClosed() {
  }

  public void initComponent() {
    myBreakpointManager.addChangeListener(myBreakpointsManagerListener);
    myDebugSessionManager.addDebugSessionListener(myDebugSessionAdapter);
    CleanupManager.getInstance().addCleanupListener(new CleanupListener() {
      public void performCleanup() {
        myUpdateFromCurrent.invoke();
      }
    });
  }

  public void disposeComponent() {
    myDebugSessionManager.removeDebugSessionListener(myDebugSessionAdapter);
    myBreakpointManager.removeChangeListener(myBreakpointsManagerListener);
  }

  @Nullable
  private DebugSession currentSession() {
    AbstractDebugSession session = myProject.getComponent(DebugSessionManagerComponent.class).getDebugSessionByCurrentTab();
    if (session instanceof DebugSession) {
      return (DebugSession) session;
    }
    return null;
  }

  public void updateIcons(@Nullable final DebugSession session) {
    final _FunctionTypes._void_P0_E0 update = new _FunctionTypes._void_P0_E0() {
      public void invoke() {
        synchronized (myCache) {
          MapSequence.fromMap(myCache).clear();
          for (IBreakpoint breakpoint : SetSequence.fromSet(myBreakpointManager.getAllIBreakpoints())) {
            if (breakpoint instanceof JavaBreakpoint) {
              JavaBreakpoint javaBreakpoint = (JavaBreakpoint) breakpoint;
              Icon icon = getIconInternal(javaBreakpoint, session);
              MapSequence.fromMap(myCache).put(javaBreakpoint, icon);
            }
          }
        }

        BreakpointsUiComponent.getInstance(myProject).repaintBreakpoints();
      }
    };
    if (session != null) {
      session.getEventsProcessor().getManagerThread().invoke(new DebuggerCommand() {
        protected void action() throws Exception {
          update.invoke();
        }
      });
    } else {
      update.invoke();
    }
  }

  public Icon getIcon(@NotNull JavaBreakpoint breakpoint, @Nullable AbstractDebugSession session) {
    if (session != null && session.isMute()) {
      return Icons.MUTED_BREAKPOINT;
    }
    synchronized (myCache) {
      return MapSequence.fromMap(myCache).get(breakpoint);
    }
  }

  private Icon getIconInternal(JavaBreakpoint breakpoint, @Nullable DebugSession session) {
    String warning = (session == null ?
      null :
      session.getEventsProcessor().getRequestManager().getWarning(breakpoint)
    );
    switch (breakpoint.getKind()) {
      case EXCEPTION_BREAKPOINT:
        return (breakpoint.isEnabled() ?
          jetbrains.mps.debugger.java.runtime.ui.Icons.EXCEPTION_BREAKPOINT :
          jetbrains.mps.debugger.java.runtime.ui.Icons.DISABLED_EXCEPTION_BREAKPOINT
        );
      case LINE_BREAKPOINT:
        return (breakpoint.isValid() && StringUtils.isEmpty(warning) ?
          ((breakpoint.isEnabled() ?
            Icons.BREAKPOINT :
            Icons.DISABLED_BREAKPOINT
          )) :
          Icons.INV_BREAKPOINT
        );
      case METHOD_BREAKPOINT:
        return (breakpoint.isValid() && StringUtils.isEmpty(warning) ?
          ((breakpoint.isEnabled() ?
            jetbrains.mps.debugger.java.runtime.ui.Icons.METHOD_BREAKPOINT :
            jetbrains.mps.debugger.java.runtime.ui.Icons.DISABLED_METHOD_BREAKPOINT
          )) :
          jetbrains.mps.debugger.java.runtime.ui.Icons.INVALID_METHOD_BREAKPOINT
        );
      case FIELD_BREAKPOINT:
        return (breakpoint.isValid() && StringUtils.isEmpty(warning) ?
          ((breakpoint.isEnabled() ?
            jetbrains.mps.debugger.java.runtime.ui.Icons.FIELD_BREAKPOINT :
            jetbrains.mps.debugger.java.runtime.ui.Icons.DISABLED_FIELD_BREAKPOINT
          )) :
          jetbrains.mps.debugger.java.runtime.ui.Icons.INVALID_FIELD_BREAKPOINT
        );
      default:
    }
    return null;
  }

  public IBreakpointListener getBreakpointListener() {
    return myBreakpointListener;
  }

  @NonNls
  @NotNull
  public String getComponentName() {
    return "Breakpoints Icon Cache";
  }

  public static BreakpointsIconCache getInstance(Project project) {
    return project.getComponent(BreakpointsIconCache.class);
  }
}
