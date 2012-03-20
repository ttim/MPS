package jetbrains.mps.debugger.api.ui.breakpoints;

/*Generated by MPS */

import com.intellij.openapi.actionSystem.DataProvider;
import java.util.List;
import jetbrains.mps.debug.api.breakpoints.IBreakpoint;
import jetbrains.mps.debug.api.BreakpointManagerComponent;
import java.util.ArrayList;
import java.util.Set;
import java.util.Collections;
import java.util.Comparator;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import javax.swing.JComponent;

public abstract class BreakpointsView implements DataProvider {
  private List<IBreakpoint> myBreakpointsList;
  protected final BreakpointManagerComponent myBreakpointsManager;
  private final List<BreakpointsView.BreakpointSelectionListener> mySelectionListeners = new ArrayList<BreakpointsView.BreakpointSelectionListener>();

  public BreakpointsView(BreakpointManagerComponent breakpointsManager) {
    myBreakpointsManager = breakpointsManager;
    updateBreakpoints();
  }

  public void dispose() {
  }

  protected final void updateBreakpoints() {
    myBreakpointsList = loadBreakpoints();
  }

  protected List<IBreakpoint> getBreakpointsList() {
    return myBreakpointsList;
  }

  protected List<IBreakpoint> loadBreakpoints() {
    Set<IBreakpoint> mpsBreakpoints = myBreakpointsManager.getAllIBreakpoints();
    final List<IBreakpoint> bpList = new ArrayList<IBreakpoint>(mpsBreakpoints);
    Collections.sort(bpList, new Comparator<IBreakpoint>() {
      @Override
      public int compare(IBreakpoint o1, IBreakpoint o2) {
        return (int) (o1.getCreationTime() - o2.getCreationTime());
      }
    });
    return bpList;
  }

  public void addBreakpointSelectionListener(@NotNull BreakpointsView.BreakpointSelectionListener l) {
    mySelectionListeners.add(l);
  }

  public void removeBreakpointSelectionListener(@NotNull BreakpointsView.BreakpointSelectionListener l) {
    mySelectionListeners.remove(l);
  }

  protected void fireBreakpointSelected(@Nullable IBreakpoint breakpoint) {
    for (BreakpointsView.BreakpointSelectionListener l : mySelectionListeners) {
      l.breakpointSelected(breakpoint);
    }
  }

  public void saveState() {
  }

  public abstract String getTitle();

  public abstract void update();

  public abstract JComponent getMainComponent();

  @Nullable
  public abstract IBreakpoint getSelectedBreakpoint();

  public abstract void selectBreakpoint(@Nullable IBreakpoint breakpoint);

  public static interface BreakpointSelectionListener {
    public void breakpointSelected(@Nullable IBreakpoint breakpoint);
  }
}
