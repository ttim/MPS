package jetbrains.mps.ide.actions;

/*Generated by MPS */

import jetbrains.mps.workbench.action.BaseAction;
import javax.swing.Icon;
import jetbrains.mps.util.IconUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import jetbrains.mps.ide.projectPane.favorites.FavoritesUtil;
import com.intellij.openapi.project.Project;
import jetbrains.mps.internal.collections.runtime.MapSequence;
import org.jetbrains.annotations.NotNull;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import jetbrains.mps.ide.projectPane.favorites.FavoritesProjectPane;
import com.intellij.openapi.ui.Messages;
import jetbrains.mps.ide.projectPane.favorites.MPSFavoritesManager;
import java.util.List;

public class RenameFavoritesList_Action extends BaseAction {
  private static final Icon ICON = IconUtil.getIcon("menu-replace.png");
  protected static Log log = LogFactory.getLog(RenameFavoritesList_Action.class);

  public RenameFavoritesList_Action() {
    super("Rename Favorites List", "", ICON);
    this.setIsAlwaysVisible(false);
    this.setExecuteOutsideCommand(false);
  }

  public boolean isApplicable(AnActionEvent event, final Map<String, Object> _params) {
    return FavoritesUtil.isActiveFavorites(((Project) MapSequence.fromMap(_params).get("project")));
  }

  public void doUpdate(@NotNull AnActionEvent event, final Map<String, Object> _params) {
    try {
      {
        boolean enabled = this.isApplicable(event, _params);
        this.setEnabledState(event.getPresentation(), enabled);
      }
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action doUpdate method failed. Action:" + "RenameFavoritesList", t);
      }
      this.disable(event.getPresentation());
    }
  }

  protected boolean collectActionData(AnActionEvent event, final Map<String, Object> _params) {
    if (!(super.collectActionData(event, _params))) {
      return false;
    }
    MapSequence.fromMap(_params).put("project", event.getData(PlatformDataKeys.PROJECT));
    if (MapSequence.fromMap(_params).get("project") == null) {
      return false;
    }
    return true;
  }

  public void doExecute(@NotNull final AnActionEvent event, final Map<String, Object> _params) {
    try {
      FavoritesProjectPane pane = FavoritesUtil.getCurrentPane(((Project) MapSequence.fromMap(_params).get("project")));
      String oldName = pane.getSubId();
      String newName = Messages.showInputDialog("Input favorites list new name", "New Name For Favorites List", Messages.getQuestionIcon(), oldName, null);
      if (newName == null || (newName == null || newName.length() == 0)) {
        return;
      }
      MPSFavoritesManager favoritesManager = ((Project) MapSequence.fromMap(_params).get("project")).getComponent(MPSFavoritesManager.class);
      if (favoritesManager == null) {
        return;
      }
      List<Object> objects = favoritesManager.getRoots(oldName);
      favoritesManager.addNewFavoritesList(newName);
      favoritesManager.addRoots(newName, objects);
      favoritesManager.removeFavoritesList(oldName);
    } catch (Throwable t) {
      if (log.isErrorEnabled()) {
        log.error("User's action execute method failed. Action:" + "RenameFavoritesList", t);
      }
    }
  }
}
