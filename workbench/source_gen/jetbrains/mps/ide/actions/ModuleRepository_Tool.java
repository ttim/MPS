package jetbrains.mps.ide.actions;

/*Generated by MPS */

import com.intellij.openapi.actionSystem.ActionManager;
import com.intellij.openapi.actionSystem.ActionPlaces;
import com.intellij.openapi.actionSystem.DefaultActionGroup;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindowAnchor;
import jetbrains.mps.ide.icons.IconManager;
import jetbrains.mps.ide.moduleRepositoryViewer.ModuleRepositoryComponent;
import jetbrains.mps.plugins.MacrosUtil;
import jetbrains.mps.plugins.pluginparts.tool.GeneratedTool;
import jetbrains.mps.workbench.tools.CloseAction;

import javax.swing.JComponent;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class ModuleRepository_Tool extends GeneratedTool {

  private ModuleRepositoryComponent myComponent;
  private JPanel myPanel;

  public ModuleRepository_Tool(Project project) {
    super(project, "Module Repository Viewer", -1, IconManager.loadIcon(MacrosUtil.expandPath("${mps_home}\\workbench\\source\\jetbrains\\mps\\ide\\projectPane\\nodes\\project.png", "jetbrains.mps.ide"), true), ToolWindowAnchor.BOTTOM, false);
  }

  public JComponent getComponent() {
    return this.myPanel;
  }

  public void init(Project project) {
    this.myComponent = new ModuleRepositoryComponent();
    this.myPanel = new JPanel(new BorderLayout());
    this.myPanel.add(this.myComponent.getComponent(), BorderLayout.CENTER);
    DefaultActionGroup group = new DefaultActionGroup();
    group.add(new CloseAction(this));
    JComponent toolbar = ActionManager.getInstance().createActionToolbar(ActionPlaces.UNKNOWN, group, false).getComponent();
    this.myPanel.add(toolbar, BorderLayout.WEST);
  }

  public void dispose() {
  }

  public void makeAvailable() {
    super.makeAvailable();
    this.myComponent.install();
  }

  @Override()
  public void makeUnavailable() {
    super.makeUnavailable();
    this.myComponent.uninstall();
  }

}
