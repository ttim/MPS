package jetbrains.mps.ide.devkit.actions;

/*Generated by MPS */

import jetbrains.mps.plugins.pluginparts.tool.GeneratedTool;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import jetbrains.mps.lang.structure.plugin.NodeExplorerComponent;
import javax.swing.JPanel;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindowAnchor;
import java.awt.BorderLayout;
import com.intellij.openapi.actionSystem.DefaultActionGroup;
import jetbrains.mps.workbench.tools.CloseAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import java.util.Map;
import javax.swing.JComponent;
import com.intellij.openapi.actionSystem.ActionManager;
import com.intellij.openapi.actionSystem.ActionPlaces;

public class NodeExplorer_Tool extends GeneratedTool {
  private static final Icon ICON = new ImageIcon(NodeExplorer_Tool.class.getResource("default.png"));

  private NodeExplorerComponent myNodeExplorer;
  private JPanel myPanel;

  public NodeExplorer_Tool(Project project) {
    super(project, "Node Explorer", -1, ICON, ToolWindowAnchor.BOTTOM, false);
  }

  public NodeExplorerComponent getNodeExplorer() {
    return NodeExplorer_Tool.this.myNodeExplorer;
  }

  public void init(Project project) {
    NodeExplorer_Tool.this.myNodeExplorer = new NodeExplorerComponent();
    NodeExplorer_Tool.this.myPanel = new JPanel(new BorderLayout());
    NodeExplorer_Tool.this.myPanel.add(NodeExplorer_Tool.this.myNodeExplorer.getComponent(), BorderLayout.CENTER);
    DefaultActionGroup group = new DefaultActionGroup();
    group.add(new CloseAction(NodeExplorer_Tool.this) {
      @Override
      protected void doExecute(AnActionEvent event, Map<String, Object> map) {
        super.doExecute(event, map);
        NodeExplorer_Tool.this.myNodeExplorer.clear();
      }
    });
    JComponent toolbar = ActionManager.getInstance().createActionToolbar(ActionPlaces.UNKNOWN, group, false).getComponent();
    NodeExplorer_Tool.this.myPanel.add(toolbar, BorderLayout.WEST);
  }

  public JComponent getComponent() {
    return NodeExplorer_Tool.this.myPanel;
  }
}
