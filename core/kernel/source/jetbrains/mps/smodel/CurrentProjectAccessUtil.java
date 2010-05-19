package jetbrains.mps.smodel;

import com.intellij.ide.DataManager;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.IdeFrame;
import com.intellij.openapi.wm.ex.WindowManagerEx;
import com.intellij.util.ui.UIUtil;

import java.awt.Component;
import java.awt.Window;

/**
 * This class is a sort of hack used to get proper project instance from currently
 * active UI component. It's always better geting proper project instance from the
 * context of model command execution.
 * <p/>
 * In over words: avoid using this class!
 */
class CurrentProjectAccessUtil {

  static Project getProjectFromUI() {
    // This code is for performance reasons
    // The method is called very often, so getting data from DataContext
    // seems to be too time-consuming to use here
    //
    // [AS] Loos like this code is not called so frequently anymore. Leaving it here
    // and using dataContext as a fallback solution for getting project because there
    // was a number of problems with getting project from currently focused component.
    Window window = WindowManagerEx.getInstanceEx().getMostRecentFocusedWindow();
    Component parent = UIUtil.findUltimateParent(window);
    if (parent instanceof IdeFrame) {
      Project project = ((IdeFrame) parent).getProject();
      if (project != null) {
        return project;
      }
    }
    DataContext dataContext = DataManager.getInstance().getDataContext();
    return PlatformDataKeys.PROJECT.getData(dataContext);
  }
}
