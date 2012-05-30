package jetbrains.mps.vcs.diff.ui.common;

/*Generated by MPS */

import javax.swing.Icon;
import com.intellij.openapi.util.IconLoader;
import org.jetbrains.annotations.Nullable;
import jetbrains.mps.smodel.SNodeId;
import org.jetbrains.annotations.NotNull;
import jetbrains.mps.workbench.action.BaseAction;
import com.intellij.openapi.project.DumbAware;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;

public abstract class GoToNeighbourRootActions {
  private static final Icon PREVIOUS_ROOT_ICON = IconLoader.getIcon("/actions/prevfile.png");
  private static final Icon NEXT_ROOT_ICON = IconLoader.getIcon("/actions/nextfile.png");

  public GoToNeighbourRootActions() {
  }

  @Nullable
  protected abstract SNodeId getNeighbourId(boolean next);

  protected abstract void goTo(@NotNull SNodeId rootId);

  public final BaseAction previous() {
    return new GoToNeighbourRootActions.TheAction(false);
  }

  public final BaseAction next() {
    return new GoToNeighbourRootActions.TheAction(true);
  }

  private class TheAction extends BaseAction implements DumbAware {
    private boolean myNext;

    public TheAction(boolean next) {
      super("Go to " + ((next ?
        "Next" :
        "Previous"
      )) + " Root", null, (next ?
        GoToNeighbourRootActions.NEXT_ROOT_ICON :
        GoToNeighbourRootActions.PREVIOUS_ROOT_ICON
      ));
      setDisableOnNoProject(false);
      setExecuteOutsideCommand(true);
      myNext = next;
    }

    protected void doExecute(AnActionEvent event, Map<String, Object> map) {
      SNodeId neighbour = getNeighbourId(myNext);
      if (neighbour != null) {
        goTo(neighbour);
      }
    }

    @Override
    protected void doUpdate(AnActionEvent event, Map<String, Object> map) {
      event.getPresentation().setVisible(true);
      event.getPresentation().setEnabled(getNeighbourId(myNext) != null);
    }
  }
}
