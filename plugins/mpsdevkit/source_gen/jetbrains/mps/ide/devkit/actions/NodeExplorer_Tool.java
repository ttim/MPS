package jetbrains.mps.ide.devkit.actions;

/*Generated by MPS */

import jetbrains.mps.plugins.tool.GeneratedTool;
import javax.swing.Icon;
import jetbrains.mps.util.IconUtil;
import jetbrains.mps.ide.devkit.components.NodeExplorerComponent;
import javax.swing.JPanel;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindowAnchor;
import java.awt.BorderLayout;
import com.intellij.openapi.actionSystem.DefaultActionGroup;
import jetbrains.mps.ide.tools.CloseAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import javax.swing.JComponent;
import com.intellij.openapi.actionSystem.ActionManager;
import com.intellij.openapi.actionSystem.ActionPlaces;
import java.awt.Container;

public class NodeExplorer_Tool extends GeneratedTool {
  private static final Icon ICON = IconUtil.getIcon("default.png");

  private NodeExplorerComponent myNodeExplorer;
  private JPanel myPanel;

  public NodeExplorer_Tool(Project project) {
    super(project, "Node Explorer", -1, ICON, ToolWindowAnchor.BOTTOM, false);
  }

  public void init(Project project) {
    super.init(project);
    NodeExplorer_Tool.this.myNodeExplorer = new NodeExplorerComponent();
    NodeExplorer_Tool.this.myPanel = new JPanel(new BorderLayout());
    NodeExplorer_Tool.this.myPanel.add(NodeExplorer_Tool.this.myNodeExplorer.getComponent(), BorderLayout.CENTER);
    DefaultActionGroup group = new DefaultActionGroup();
    group.add(new CloseAction(NodeExplorer_Tool.this) {
      @Override
      public void actionPerformed(AnActionEvent event) {
        super.actionPerformed(event);
        NodeExplorer_Tool.this.myNodeExplorer.clear();
      }
    });
    JComponent toolbar = ActionManager.getInstance().createActionToolbar(ActionPlaces.UNKNOWN, group, false).getComponent();
    NodeExplorer_Tool.this.myPanel.add(toolbar, BorderLayout.WEST);
  }

  public void dispose() {
    Container container = NodeExplorer_Tool.this.myPanel.getParent();
    if (container != null) {
      container.remove(NodeExplorer_Tool.this.myPanel);
    }
    NodeExplorer_Tool.this.myPanel = null;
    NodeExplorer_Tool.this.myNodeExplorer.clear();
    NodeExplorer_Tool.this.myNodeExplorer = null;
    super.dispose();
  }

  public NodeExplorerComponent getNodeExplorer() {
    return NodeExplorer_Tool.this.myNodeExplorer;
  }

  public JComponent getComponent() {
    return NodeExplorer_Tool.this.myPanel;
  }
}
