package jetbrains.mps.ide.actions;

/*Generated by MPS */

import jetbrains.mps.plugins.actions.GeneratedActionGroup;
import jetbrains.mps.plugins.actions.LabelledAnchor;
import jetbrains.mps.logging.Logger;
import com.intellij.openapi.actionSystem.ex.ActionManagerEx;
import com.intellij.openapi.extensions.PluginId;

public class FavoritesPopup_ActionGroup extends GeneratedActionGroup {
  private static Logger LOG = Logger.getLogger(FavoritesPopup_ActionGroup.class);
  public static final String ID = "jetbrains.mps.ide.actions.FavoritesPopup_ActionGroup";
  public static final String LABEL_ID_addToFavorites = ID + "addToFavorites";

  public FavoritesPopup_ActionGroup() {
    super("Add to Favorites", ID);
    this.setIsInternal(false);
    this.setPopup(false);
    try {
      {
        LabelledAnchor action = new LabelledAnchor(FavoritesPopup_ActionGroup.LABEL_ID_addToFavorites);
        ActionManagerEx manager = ActionManagerEx.getInstanceEx();
        manager.registerAction(action.getId(), action, PluginId.getId("jetbrains.mps.ide"));
        FavoritesPopup_ActionGroup.this.addAction(action);
      }
      FavoritesPopup_ActionGroup.this.addSeparator();
      FavoritesPopup_ActionGroup.this.addAction("jetbrains.mps.ide.actions.AddToNewFavoritesList_Action");
    } catch (Throwable t) {
      LOG.error("User group error", t);
    }
  }
}
