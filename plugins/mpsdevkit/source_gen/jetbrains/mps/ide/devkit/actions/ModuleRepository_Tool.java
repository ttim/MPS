package jetbrains.mps.ide.devkit.actions;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.tool.GeneratedTool;
import javax.swing.Icon;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import jetbrains.mps.ide.moduleRepositoryViewer.ModuleRepositoryComponent;
import javax.swing.JPanel;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindowAnchor;
import java.awt.BorderLayout;
import com.intellij.openapi.actionSystem.DefaultActionGroup;
import jetbrains.mps.workbench.tools.CloseAction;
import javax.swing.JComponent;
import com.intellij.openapi.actionSystem.ActionManager;
import com.intellij.openapi.actionSystem.ActionPlaces;
import javax.swing.ImageIcon;
import com.intellij.openapi.util.io.StreamUtil;
import com.intellij.util.io.URLUtil;
import java.io.IOException;

public class ModuleRepository_Tool extends GeneratedTool {
  private static final Icon ICON = loadIcon();
  protected static Log log = LogFactory.getLog(ModuleRepository_Tool.class);

  private ModuleRepositoryComponent myComponent;
  private JPanel myPanel;

  public ModuleRepository_Tool(Project project) {
    super(project, "Module Repository Viewer", -1, ICON, ToolWindowAnchor.BOTTOM, false);
  }

  public void init(Project project) {
    super.init(project);
    ModuleRepository_Tool.this.myComponent = new ModuleRepositoryComponent();
    ModuleRepository_Tool.this.myPanel = new JPanel(new BorderLayout());
    ModuleRepository_Tool.this.myPanel.add(ModuleRepository_Tool.this.myComponent.getComponent(), BorderLayout.CENTER);
    DefaultActionGroup group = new DefaultActionGroup();
    group.add(new CloseAction(ModuleRepository_Tool.this));
    JComponent toolbar = ActionManager.getInstance().createActionToolbar(ActionPlaces.UNKNOWN, group, false).getComponent();
    ModuleRepository_Tool.this.myPanel.add(toolbar, BorderLayout.WEST);
  }

  public void makeAvailable() {
    super.makeAvailable();
    ModuleRepository_Tool.this.myComponent.install();
  }

  @Override
  public void makeUnavailable() {
    super.makeUnavailable();
    ModuleRepository_Tool.this.myComponent.uninstall();
  }

  public JComponent getComponent() {
    return ModuleRepository_Tool.this.myPanel;
  }

  private static Icon loadIcon() {
    try {
      return new ImageIcon(StreamUtil.loadFromStream(URLUtil.openStream(ModuleRepository_Tool.class.getResource("project.png"))));
    } catch (IOException e) {
      if (log.isWarnEnabled()) {
        log.warn("Couldn't load icon for ModuleRepository", e);
      }
      return null;
    }
  }
}
